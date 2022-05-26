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

internal object ElevatedCardTokens {
    val ContainerColor = ColorSchemeKeyTokens.Surface
    val ContainerElevation = ElevationTokens.Level1
    val ContainerShape = ShapeKeyTokens.CornerMedium
    val ContainerSurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint
    val DisabledContainerColor = ColorSchemeKeyTokens.Surface
    val DisabledContainerElevation = ElevationTokens.Level1
    const val DisabledContainerOpacity = 0.38f
    val DraggedContainerElevation = ElevationTokens.Level4
    val FocusContainerElevation = ElevationTokens.Level1
    val HoverContainerElevation = ElevationTokens.Level2
    val IconColor = ColorSchemeKeyTokens.Primary
    val IconSize = 24.0.dp
    val PressedContainerElevation = ElevationTokens.Level1
}
