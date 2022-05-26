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

internal object BadgeTokens {
    val Color = ColorSchemeKeyTokens.Error
    val LargeColor = ColorSchemeKeyTokens.Error
    val LargeLabelTextColor = ColorSchemeKeyTokens.OnError
    val LargeLabelTextFont = TypographyKeyTokens.LabelSmall
    val LargeShape = ShapeKeyTokens.CornerFull
    val LargeSize = 16.0.dp
    val Shape = ShapeKeyTokens.CornerFull
    val Size = 6.0.dp
}
