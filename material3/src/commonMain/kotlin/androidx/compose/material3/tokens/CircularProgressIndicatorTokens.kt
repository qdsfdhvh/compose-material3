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

import androidx.compose.ui.unit.dp

internal object CircularProgressIndicatorTokens {
    val ActiveIndicatorColor = ColorSchemeKeyTokens.Primary
    val ActiveShape = ShapeTokens.CornerNone
    val ActiveIndicatorWidth = 4.0.dp
    val FourColorActiveIndicatorFourColor = ColorSchemeKeyTokens.TertiaryContainer
    val FourColorActiveIndicatorOneColor = ColorSchemeKeyTokens.Primary
    val FourColorActiveIndicatorThreeColor = ColorSchemeKeyTokens.Tertiary
    val FourColorActiveIndicatorTwoColor = ColorSchemeKeyTokens.PrimaryContainer
    val Size = 48.0.dp
}
