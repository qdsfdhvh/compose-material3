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

internal object OutlinedButtonTokens {
    val ContainerHeight = 40.0.dp
    val ContainerShape = ShapeKeyTokens.CornerFull
    val DisabledLabelTextColor = ColorSchemeKeyTokens.OnSurface
    const val DisabledLabelTextOpacity = 0.38f
    val DisabledOutlineColor = ColorSchemeKeyTokens.OnSurface
    const val DisabledOutlineOpacity = 0.12f
    val FocusLabelTextColor = ColorSchemeKeyTokens.Primary
    val FocusOutlineColor = ColorSchemeKeyTokens.Primary
    val HoverLabelTextColor = ColorSchemeKeyTokens.Primary
    val HoverOutlineColor = ColorSchemeKeyTokens.Outline
    val LabelTextColor = ColorSchemeKeyTokens.Primary
    val LabelTextFont = TypographyKeyTokens.LabelLarge
    val OutlineColor = ColorSchemeKeyTokens.Outline
    val OutlineWidth = 1.0.dp
    val PressedLabelTextColor = ColorSchemeKeyTokens.Primary
    val PressedOutlineColor = ColorSchemeKeyTokens.Outline
    val DisabledIconColor = ColorSchemeKeyTokens.OnSurface
    const val DisabledIconOpacity = 0.38f
    val FocusIconColor = ColorSchemeKeyTokens.Primary
    val HoverIconColor = ColorSchemeKeyTokens.Primary
    val IconColor = ColorSchemeKeyTokens.Primary
    val IconSize = 18.0.dp
    val PressedIconColor = ColorSchemeKeyTokens.Primary
}
