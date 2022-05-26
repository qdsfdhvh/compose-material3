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

internal object SuggestionChipTokens {
    val ContainerHeight = 32.0.dp
    val ContainerShape = ShapeKeyTokens.CornerSmall
    val ContainerSurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint
    val DisabledLabelTextColor = ColorSchemeKeyTokens.OnSurface
    const val DisabledLabelTextOpacity = 0.38f
    val DraggedContainerElevation = ElevationTokens.Level4
    val DraggedLabelTextColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val ElevatedContainerColor = ColorSchemeKeyTokens.Surface
    val ElevatedContainerElevation = ElevationTokens.Level1
    val ElevatedDisabledContainerColor = ColorSchemeKeyTokens.OnSurface
    val ElevatedDisabledContainerElevation = ElevationTokens.Level0
    const val ElevatedDisabledContainerOpacity = 0.12f
    val ElevatedFocusContainerElevation = ElevationTokens.Level1
    val ElevatedHoverContainerElevation = ElevationTokens.Level2
    val ElevatedPressedContainerElevation = ElevationTokens.Level1
    val FlatContainerElevation = ElevationTokens.Level0
    val FlatDisabledOutlineColor = ColorSchemeKeyTokens.OnSurface
    const val FlatDisabledOutlineOpacity = 0.12f
    val FlatFocusOutlineColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val FlatOutlineColor = ColorSchemeKeyTokens.Outline
    val FlatOutlineWidth = 1.0.dp
    val FocusLabelTextColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val HoverLabelTextColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val LabelTextColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val LabelTextFont = TypographyKeyTokens.LabelLarge
    val PressedLabelTextColor = ColorSchemeKeyTokens.OnSurfaceVariant
}
