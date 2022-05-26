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

internal object IconButtonTokens {
    val DisabledIconColor = ColorSchemeKeyTokens.OnSurface
    const val DisabledIconOpacity = 0.38f
    val IconSize = 24.0.dp
    val SelectedFocusIconColor = ColorSchemeKeyTokens.Primary
    val SelectedHoverIconColor = ColorSchemeKeyTokens.Primary
    val SelectedIconColor = ColorSchemeKeyTokens.Primary
    val SelectedPressedIconColor = ColorSchemeKeyTokens.Primary
    val StateLayerShape = ShapeKeyTokens.CornerFull
    val StateLayerSize = 40.0.dp
    val UnselectedFocusIconColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val UnselectedHoverIconColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val UnselectedIconColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val UnselectedPressedIconColor = ColorSchemeKeyTokens.OnSurfaceVariant
}
