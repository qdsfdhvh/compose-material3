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
package androidx.compose.material3.tokens

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

internal object ShapeTokens {
    val CornerExtraLarge = RoundedCornerShape(28.0.dp)
    val CornerExtraLargeTop =
        RoundedCornerShape(
            topStart = 28.0.dp,
            topEnd = 28.0.dp,
            bottomEnd = 0.0.dp,
            bottomStart = 0.0.dp
        )
    val CornerExtraSmall = RoundedCornerShape(4.0.dp)
    val CornerExtraSmallTop = RoundedCornerShape(
        topStart = 4.0.dp,
        topEnd = 4.0.dp,
        bottomEnd = 0.0.dp,
        bottomStart = 0.0.dp
    )
    val CornerFull = CircleShape
    val CornerLarge = RoundedCornerShape(16.0.dp)
    val CornerLargeEnd =
        RoundedCornerShape(
            topStart = 0.0.dp,
            topEnd = 16.0.dp,
            bottomEnd = 16.0.dp,
            bottomStart = 0.0.dp
        )
    val CornerLargeTop =
        RoundedCornerShape(
            topStart = 16.0.dp,
            topEnd = 16.0.dp,
            bottomEnd = 0.0.dp,
            bottomStart = 0.0.dp
        )
    val CornerMedium = RoundedCornerShape(12.0.dp)
    val CornerNone = RectangleShape
    val CornerSmall = RoundedCornerShape(8.0.dp)
}
