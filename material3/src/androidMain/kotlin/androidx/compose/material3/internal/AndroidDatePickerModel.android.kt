/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.compose.material3.internal

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.CalendarDate
import androidx.compose.material3.CalendarModel
import androidx.compose.material3.CalendarMonth
import androidx.compose.material3.DaysInWeek
import androidx.compose.material3.ExperimentalMaterial3Api
import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.format.TextStyle
import java.time.temporal.WeekFields
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

/**
 * Creates a [CalendarModel] to be used by the date picker.
 */
@ExperimentalMaterial3Api
internal fun createDefaultCalendarModel(): CalendarModel {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        CalendarModelImpl()
    } else {
        LegacyCalendarModelImpl()
    }
}

/**
 * A [CalendarModel] implementation for API < 26.
 */
@OptIn(ExperimentalMaterial3Api::class)
internal class LegacyCalendarModelImpl : CalendarModel {

    override val today
        get(): CalendarDate {
            val systemCalendar = Calendar.getInstance()
            systemCalendar[Calendar.HOUR_OF_DAY] = 0
            systemCalendar[Calendar.MINUTE] = 0
            systemCalendar[Calendar.SECOND] = 0
            systemCalendar[Calendar.MILLISECOND] = 0
            val utcOffset =
                systemCalendar.get(Calendar.ZONE_OFFSET) + systemCalendar.get(Calendar.DST_OFFSET)
            return CalendarDate(
                year = systemCalendar[Calendar.YEAR],
                month = systemCalendar[Calendar.MONTH] + 1,
                dayOfMonth = systemCalendar[Calendar.DAY_OF_MONTH],
                utcTimeMillis = systemCalendar.timeInMillis + utcOffset
            )
        }

    override val firstDayOfWeek: Int = dayInISO8601(Calendar.getInstance().firstDayOfWeek)

    override val weekdayNames: List<Pair<String, String>> = buildList {
        val weekdays = DateFormatSymbols(Locale.getDefault()).weekdays
        val shortWeekdays = DateFormatSymbols(Locale.getDefault()).shortWeekdays
        // Skip the first item, as it's empty, and the second item, as it represents Sunday while it
        // should be last according to ISO-8601.
        weekdays.drop(2).forEachIndexed { index, day ->
            add(Pair(day, shortWeekdays[index + 2]))
        }
        // Add Sunday to the end.
        add(Pair(weekdays[1], shortWeekdays[1]))
    }

    override fun getDate(timeInMillis: Long): CalendarDate {
        val calendar = Calendar.getInstance(utcTimeZone)
        calendar.timeInMillis = timeInMillis
        return CalendarDate(
            year = calendar[Calendar.YEAR],
            month = calendar[Calendar.MONTH] + 1,
            dayOfMonth = calendar[Calendar.DAY_OF_MONTH],
            utcTimeMillis = timeInMillis
        )
    }

    override fun getMonth(timeInMillis: Long): CalendarMonth {
        val firstDayCalendar = Calendar.getInstance(utcTimeZone)
        firstDayCalendar.timeInMillis = timeInMillis
        firstDayCalendar[Calendar.DAY_OF_MONTH] = 1
        return getMonth(firstDayCalendar)
    }

    override fun getMonth(date: CalendarDate): CalendarMonth {
        return getMonth(date.year, date.month)
    }

    override fun getMonth(year: Int, month: Int): CalendarMonth {
        val firstDayCalendar = Calendar.getInstance(utcTimeZone)
        firstDayCalendar.clear()
        firstDayCalendar[Calendar.YEAR] = year
        firstDayCalendar[Calendar.MONTH] = month - 1
        firstDayCalendar[Calendar.DAY_OF_MONTH] = 1
        return getMonth(firstDayCalendar)
    }

    override fun getDayOfWeek(date: CalendarDate): Int {
        return dayInISO8601(date.toCalendar(TimeZone.getDefault())[Calendar.DAY_OF_WEEK])
    }

    override fun plusMonths(from: CalendarMonth, addedMonthsCount: Int): CalendarMonth {
        if (addedMonthsCount <= 0) return from

        val laterMonth = from.toCalendar()
        laterMonth.add(Calendar.MONTH, addedMonthsCount)
        return getMonth(laterMonth)
    }

    override fun minusMonths(from: CalendarMonth, subtractedMonthsCount: Int): CalendarMonth {
        if (subtractedMonthsCount <= 0) return from

        val earlierMonth = from.toCalendar()
        earlierMonth.add(Calendar.MONTH, -subtractedMonthsCount)
        return getMonth(earlierMonth)
    }

    override fun format(month: CalendarMonth, pattern: String): String {
        val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
        dateFormat.timeZone = utcTimeZone
        dateFormat.isLenient = false
        return dateFormat.format(month.toCalendar().timeInMillis)
    }

    override fun format(date: CalendarDate, pattern: String): String {
        val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
        dateFormat.timeZone = utcTimeZone
        dateFormat.isLenient = false
        return dateFormat.format(date.toCalendar(utcTimeZone).timeInMillis)
    }

    override fun parse(date: String, pattern: String): CalendarDate? {
        val dateFormat = SimpleDateFormat(pattern)
        dateFormat.timeZone = utcTimeZone
        dateFormat.isLenient = false
        return try {
            val parsedDate = dateFormat.parse(date) ?: return null
            val calendar = Calendar.getInstance(utcTimeZone)
            calendar.time = parsedDate
            CalendarDate(
                year = calendar[Calendar.YEAR],
                month = calendar[Calendar.MONTH] + 1,
                dayOfMonth = calendar[Calendar.DAY_OF_MONTH],
                utcTimeMillis = calendar.timeInMillis
            )
        } catch (pe: ParseException) {
            null
        }
    }

    /**
     * Returns a given [Calendar] day number as a day representation under ISO-8601, where the first
     * day is defined as Monday.
     */
    private fun dayInISO8601(day: Int): Int {
        val shiftedDay = (day + 6) % 7
        return if (shiftedDay == 0) return /* Sunday */ 7 else shiftedDay
    }

    private fun getMonth(firstDayCalendar: Calendar): CalendarMonth {
        val difference = dayInISO8601(firstDayCalendar[Calendar.DAY_OF_WEEK]) - firstDayOfWeek
        val daysFromStartOfWeekToFirstOfMonth = if (difference < 0) {
            difference + DaysInWeek
        } else {
            difference
        }
        return CalendarMonth(
            year = firstDayCalendar[Calendar.YEAR],
            month = firstDayCalendar[Calendar.MONTH] + 1,
            numberOfDays = firstDayCalendar.getActualMaximum(Calendar.DAY_OF_MONTH),
            daysFromStartOfWeekToFirstOfMonth = daysFromStartOfWeekToFirstOfMonth,
            startUtcTimeMillis = firstDayCalendar.timeInMillis
        )
    }

    private fun CalendarMonth.toCalendar(): Calendar {
        val calendar = Calendar.getInstance(utcTimeZone)
        calendar.timeInMillis = this.startUtcTimeMillis
        return calendar
    }

    private fun CalendarDate.toCalendar(timeZone: TimeZone): Calendar {
        val calendar = Calendar.getInstance(timeZone)
        calendar.clear()
        calendar[Calendar.YEAR] = this.year
        calendar[Calendar.MONTH] = this.month - 1
        calendar[Calendar.DAY_OF_MONTH] = this.dayOfMonth
        return calendar
    }

    private var utcTimeZone = TimeZone.getTimeZone("UTC")
}

/**
 * A [CalendarModel] implementation for API >= 26.
 */
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
internal class CalendarModelImpl : CalendarModel {

    override val today
        get(): CalendarDate {
            val systemLocalDate = LocalDate.now()
            return CalendarDate(
                year = systemLocalDate.year,
                month = systemLocalDate.monthValue,
                dayOfMonth = systemLocalDate.dayOfMonth,
                utcTimeMillis = systemLocalDate.atTime(LocalTime.MIDNIGHT)
                    .atZone(utcTimeZoneId).toInstant().toEpochMilli()
            )
        }

    override val firstDayOfWeek: Int = WeekFields.of(Locale.getDefault()).firstDayOfWeek.value

    override val weekdayNames: List<Pair<String, String>> =
        // This will start with Monday as the first day, according to ISO-8601.
        with(Locale.getDefault()) {
            DayOfWeek.values().map {
                it.getDisplayName(
                    TextStyle.FULL,
                    /* locale = */ this
                ) to it.getDisplayName(
                    TextStyle.NARROW,
                    /* locale = */ this
                )
            }
        }

    override fun getDate(timeInMillis: Long): CalendarDate {
        val localDate =
            Instant.ofEpochMilli(timeInMillis).atZone(utcTimeZoneId).toLocalDate()
        return CalendarDate(
            year = localDate.year,
            month = localDate.monthValue,
            dayOfMonth = localDate.dayOfMonth,
            utcTimeMillis = timeInMillis
        )
    }

    override fun getMonth(timeInMillis: Long): CalendarMonth {
        return getMonth(
            Instant.ofEpochMilli(timeInMillis).atZone(utcTimeZoneId).toLocalDate()
        )
    }

    override fun getMonth(date: CalendarDate): CalendarMonth {
        return getMonth(LocalDate.of(date.year, date.month, 1))
    }

    override fun getMonth(year: Int, month: Int): CalendarMonth {
        return getMonth(LocalDate.of(year, month, 1))
    }

    override fun getDayOfWeek(date: CalendarDate): Int {
        return date.toLocalDate().dayOfWeek.value
    }

    override fun plusMonths(from: CalendarMonth, addedMonthsCount: Int): CalendarMonth {
        if (addedMonthsCount <= 0) return from

        val firstDayLocalDate = from.toLocalDate()
        val laterMonth = firstDayLocalDate.plusMonths(addedMonthsCount.toLong())
        return getMonth(laterMonth)
    }

    override fun minusMonths(from: CalendarMonth, subtractedMonthsCount: Int): CalendarMonth {
        if (subtractedMonthsCount <= 0) return from

        val firstDayLocalDate = from.toLocalDate()
        val earlierMonth = firstDayLocalDate.minusMonths(subtractedMonthsCount.toLong())
        return getMonth(earlierMonth)
    }

    override fun format(month: CalendarMonth, pattern: String): String {
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern(pattern)
        return month.toLocalDate().format(formatter)
    }

    override fun format(date: CalendarDate, pattern: String): String {
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern(pattern)
        return date.toLocalDate().format(formatter)
    }

    override fun parse(date: String, pattern: String): CalendarDate? {
        // TODO: A DateTimeFormatter can be reused.
        val formatter = DateTimeFormatter.ofPattern(pattern)
        return try {
            val localDate = LocalDate.parse(date, formatter)
            CalendarDate(
                year = localDate.year,
                month = localDate.month.value,
                dayOfMonth = localDate.dayOfMonth,
                utcTimeMillis = localDate.atTime(LocalTime.MIDNIGHT)
                    .atZone(utcTimeZoneId).toInstant().toEpochMilli()
            )
        } catch (pe: DateTimeParseException) {
            null
        }
    }

    private fun getMonth(firstDayLocalDate: LocalDate): CalendarMonth {
        val difference = firstDayLocalDate.dayOfWeek.value - firstDayOfWeek
        val daysFromStartOfWeekToFirstOfMonth = if (difference < 0) {
            difference + DaysInWeek
        } else {
            difference
        }
        val firstDayEpochMillis =
            firstDayLocalDate.atTime(LocalTime.MIDNIGHT).atZone(utcTimeZoneId).toInstant()
                .toEpochMilli()
        return CalendarMonth(
            year = firstDayLocalDate.year,
            month = firstDayLocalDate.monthValue,
            numberOfDays = firstDayLocalDate.lengthOfMonth(),
            daysFromStartOfWeekToFirstOfMonth = daysFromStartOfWeekToFirstOfMonth,
            startUtcTimeMillis = firstDayEpochMillis
        )
    }

    private fun CalendarMonth.toLocalDate(): LocalDate {
        return Instant.ofEpochMilli(startUtcTimeMillis).atZone(utcTimeZoneId).toLocalDate()
    }

    private fun CalendarDate.toLocalDate(): LocalDate {
        return LocalDate.of(
            this.year,
            this.month,
            this.dayOfMonth
        )
    }

    private val utcTimeZoneId = ZoneId.of("UTC")
}
