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
package androidx.compose.material3

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.tokens.StateTokens
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

// TODO: Create a sample androidx.compose.material3.samples.MaterialThemeSample
// TODO(b/197880751) Update to link M3 Material Theming page (i.e. a <a href="https://material
//  .io/design/material-theming/overview.html" class="external" target="_blank">Material
//  Theming</a> M3 equivalent).
/**
 * Material Theming refers to the customization of your Material Design app to better reflect your
 * product’s brand.
 *
 * Material components such as [Button] and [Checkbox] use values provided here when retrieving
 * default values.
 *
 * All values may be set by providing this component with the [colorScheme][ColorScheme],
 * [typography][Typography] attributes. Use this to configure the overall
 * theme of elements within this MaterialTheme.
 *
 * Any values that are not set will inherit the current value from the theme, falling back to the
 * defaults if there is no parent MaterialTheme. This allows using a MaterialTheme at the top
 * of your application, and then separate MaterialTheme(s) for different screens / parts of your
 * UI, overriding only the parts of the theme definition that need to change.
 *
 * @param colorScheme A complete definition of the Material Color theme for this hierarchy
 * @param typography A set of text styles to be used as this hierarchy's typography system
 * @param shapes A set of corner shapes to be used as this hierarchy's shape system
 */
@Composable
fun MaterialTheme(
    colorScheme: ColorScheme = MaterialTheme.colorScheme,
    shapes: Shapes = MaterialTheme.shapes,
    typography: Typography = MaterialTheme.typography,
    content: @Composable () -> Unit
) {
    val rememberedColorScheme = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colorScheme]
        // provided, and overwrite the values set in it.
        colorScheme.copy()
    }.apply {
        updateColorSchemeFrom(colorScheme)
    }
    val rippleIndication = rememberRipple()
    val selectionColors = rememberTextSelectionColors(rememberedColorScheme)
    CompositionLocalProvider(
        LocalColorScheme provides rememberedColorScheme,
        LocalIndication provides rippleIndication,
        LocalRippleTheme provides MaterialRippleTheme,
        LocalShapes provides shapes,
        LocalTextSelectionColors provides selectionColors,
        LocalTypography provides typography,
    ) {
        ProvideTextStyle(value = typography.bodyLarge, content = content)
    }
}

/**
 * Contains functions to access the current theme values provided at the call site's position in
 * the hierarchy.
 */
object MaterialTheme {
    /**
     * Retrieves the current [ColorScheme] at the call site's position in the hierarchy.
     */
    val colorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current

    /**
     * Retrieves the current [Typography] at the call site's position in the hierarchy.
     */
    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    /**
     * Retrieves the current [Shapes] at the call site's position in the hierarchy.
     */
    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}

@Immutable
private object MaterialRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = LocalContentColor.current

    @Composable
    override fun rippleAlpha() = DefaultRippleAlpha
}

private val DefaultRippleAlpha = RippleAlpha(
    pressedAlpha = StateTokens.PressedStateLayerOpacity,
    focusedAlpha = StateTokens.FocusStateLayerOpacity,
    draggedAlpha = StateTokens.DraggedStateLayerOpacity,
    hoveredAlpha = StateTokens.HoverStateLayerOpacity
)

@Composable
/*@VisibleForTesting*/
internal fun rememberTextSelectionColors(colorScheme: ColorScheme): TextSelectionColors {
    val primaryColor = colorScheme.primary
    return remember(primaryColor) {
        TextSelectionColors(
            handleColor = primaryColor,
            backgroundColor = primaryColor.copy(alpha = TextSelectionBackgroundOpacity),
        )
    }
}

/*@VisibleForTesting*/
internal const val TextSelectionBackgroundOpacity = 0.4f
