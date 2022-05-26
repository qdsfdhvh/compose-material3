/*
 *  Mask-Android
 *
 *  Copyright (C) 2022  DimensionDev and Contributors
 *
 *  This file is part of Mask X.
 *
 *  Mask-Android is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Mask-Android is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with Mask-Android.  If not, see <http://www.gnu.org/licenses/>.
 */
package androidx.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable

@Immutable
@kotlin.jvm.JvmInline
internal value class Strings private constructor(@Suppress("unused") private val value: Int) {
    companion object {
        val NavigationMenu = Strings(0)
        val CloseDrawer = Strings(1)
        val CloseSheet = Strings(2)
        val DefaultErrorMessage = Strings(3)
        val ExposedDropdownMenu = Strings(4)
        val SliderRangeStart = Strings(5)
        val SliderRangeEnd = Strings(6)
    }
}

@Composable
internal expect fun getString(string: Strings): String
