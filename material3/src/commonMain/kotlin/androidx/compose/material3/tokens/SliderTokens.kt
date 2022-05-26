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

internal object SliderTokens {
    val ActiveTrackColor = ColorSchemeKeyTokens.Primary
    val ActiveTrackHeight = 6.0.dp
    val ActiveTrackShape = ShapeKeyTokens.CornerFull
    val DisabledActiveTrackColor = ColorSchemeKeyTokens.OnSurface
    const val DisabledActiveTrackOpacity = 0.38f
    val DisabledHandleColor = ColorSchemeKeyTokens.OnSurface
    val DisabledHandleElevation = ElevationTokens.Level0
    const val DisabledHandleOpacity = 0.38f
    val DisabledInactiveTrackColor = ColorSchemeKeyTokens.OnSurface
    const val DisabledInactiveTrackOpacity = 0.12f
    val FocusHandleColor = ColorSchemeKeyTokens.Primary
    val HandleColor = ColorSchemeKeyTokens.Primary
    val HandleElevation = ElevationTokens.Level1
    val HandleHeight = 20.0.dp
    val HandleShape = ShapeKeyTokens.CornerFull
    val HandleWidth = 20.0.dp
    val HoverHandleColor = ColorSchemeKeyTokens.Primary
    val InactiveTrackColor = ColorSchemeKeyTokens.SurfaceVariant
    val InactiveTrackHeight = 4.0.dp
    val InactiveTrackShape = ShapeKeyTokens.CornerFull
    val LabelContainerColor = ColorSchemeKeyTokens.Primary
    val LabelContainerElevation = ElevationTokens.Level0
    val LabelContainerHeight = 28.0.dp
    val LabelTextColor = ColorSchemeKeyTokens.OnPrimary
    val LabelTextFont = TypographyKeyTokens.LabelMedium
    val PressedHandleColor = ColorSchemeKeyTokens.Primary
    val StateLayerSize = 40.0.dp
    val TrackElevation = ElevationTokens.Level0
    val OverlapHandleOutlineColor = ColorSchemeKeyTokens.OnPrimary
    val OverlapHandleOutlineWidth = 1.0.dp
    val TickMarksActiveContainerColor = ColorSchemeKeyTokens.OnPrimary
    const val TickMarksActiveContainerOpacity = 0.38f
    val TickMarksContainerShape = ShapeKeyTokens.CornerFull
    val TickMarksContainerSize = 2.0.dp
    val TickMarksDisabledContainerColor = ColorSchemeKeyTokens.OnSurface
    const val TickMarksDisabledContainerOpacity = 0.38f
    val TickMarksInactiveContainerColor = ColorSchemeKeyTokens.OnSurfaceVariant
    const val TickMarksInactiveContainerOpacity = 0.38f
}
