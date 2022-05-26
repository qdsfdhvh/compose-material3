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

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

internal object PrimaryNavigationTabTokens {
    val ActiveIndicatorColor = ColorSchemeKeyTokens.Primary
    val ActiveIndicatorHeight = 3.0.dp
    val ActiveIndicatorShape = RoundedCornerShape(3.0.dp)
    val ContainerColor = ColorSchemeKeyTokens.Surface
    val ContainerElevation = ElevationTokens.Level0
    val ContainerHeight = 48.0.dp
    val ContainerShape = ShapeKeyTokens.CornerNone
    val DividerColor = ColorSchemeKeyTokens.SurfaceVariant
    val DividerHeight = 1.0.dp
    val ActiveFocusIconColor = ColorSchemeKeyTokens.Primary
    val ActiveHoverIconColor = ColorSchemeKeyTokens.Primary
    val ActiveIconColor = ColorSchemeKeyTokens.Primary
    val ActivePressedIconColor = ColorSchemeKeyTokens.Primary
    val IconAndLabelTextContainerHeight = 64.0.dp
    val IconSize = 24.0.dp
    val InactiveFocusIconColor = ColorSchemeKeyTokens.OnSurface
    val InactiveHoverIconColor = ColorSchemeKeyTokens.OnSurface
    val InactiveIconColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val InactivePressedIconColor = ColorSchemeKeyTokens.OnSurface
    val ActiveFocusLabelTextColor = ColorSchemeKeyTokens.Primary
    val ActiveHoverLabelTextColor = ColorSchemeKeyTokens.Primary
    val ActiveLabelTextColor = ColorSchemeKeyTokens.Primary
    val ActivePressedLabelTextColor = ColorSchemeKeyTokens.Primary
    val InactiveFocusLabelTextColor = ColorSchemeKeyTokens.OnSurface
    val InactiveHoverLabelTextColor = ColorSchemeKeyTokens.OnSurface
    val InactiveLabelTextColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val InactivePressedLabelTextColor = ColorSchemeKeyTokens.OnSurface
    val LabelTextFont = TypographyKeyTokens.TitleSmall
}
