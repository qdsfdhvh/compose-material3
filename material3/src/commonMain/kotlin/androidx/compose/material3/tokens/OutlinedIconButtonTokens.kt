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

internal object OutlinedIconButtonTokens {
    val ContainerShape = ShapeKeyTokens.CornerFull
    val ContainerSize = 40.0.dp
    val DisabledColor = ColorSchemeKeyTokens.OnSurface
    const val DisabledOpacity = 0.38f
    val DisabledOutlineColor = ColorSchemeKeyTokens.OnSurface
    const val DisabledOutlineOpacity = 0.12f
    val Size = 24.0.dp
    val SelectedContainerColor = ColorSchemeKeyTokens.InverseSurface
    val SelectedFocusColor = ColorSchemeKeyTokens.InverseOnSurface
    val SelectedHoverColor = ColorSchemeKeyTokens.InverseOnSurface
    val SelectedColor = ColorSchemeKeyTokens.InverseOnSurface
    val SelectedPressedColor = ColorSchemeKeyTokens.InverseOnSurface
    val UnselectedFocusColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val UnselectedHoverColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val UnselectedColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val UnselectedOutlineColor = ColorSchemeKeyTokens.Outline
    val UnselectedOutlineWidth = 1.0.dp
    val UnselectedPressedColor = ColorSchemeKeyTokens.OnSurface
}
