package com.example.compose.ui.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.compose.ui.components.McTextFieldAppearance
import com.example.compose.ui.components.McTextFieldDefaults.AnimationDuration
import com.example.compose.ui.components.McTextFieldKind
import com.example.compose.utils.colors

/**
 * Maps our Figma colors into sets of detault arguments for
 */
data class McTextFieldColorSet(
    val textColor: Color = colors.InputTextColor,
    val placeholderColor: Color = colors.InputPlaceholderColor,
    val labelColor: Color = Color.Black, // TODO Unspecified in figma
    val backgroundColor: Color = colors.InputBackgroundColor,
    val leadingIconColor: Color = colors.InputIconColor,
    val trailingIconColor: Color = colors.InputActionIconColor,
    val cursorColor: Color = Color.Black, // TODO Unspecified in figma
    val borderColor: Color = Color.Black, // TODO Unspecified in figma
    val shadowColor: Color = Color.Black // TODO Unspecified in figma
)

private val normalColors = McTextFieldColorSet()

private val normalFilledColors = McTextFieldColorSet(
    textColor = colors.InputFocusTextColor,
    placeholderColor = colors.InputFocusPlaceholderColor,
    labelColor = colors.InputFocusLabelColor,
    backgroundColor = colors.InputFocusBackgroundColor,
    leadingIconColor = colors.InputFocusIconColor,
    trailingIconColor = colors.InputFocusActionIconColor,
    cursorColor = Color.Black, // TODO Unspecified in figma
    borderColor = colors.InputFocusBorderColor,
    shadowColor = colors.InputFocusBoxShadowColor
    )

private val normalFocusColors = McTextFieldColorSet(
    textColor = colors.InputFilledTextColor,
    placeholderColor = colors.InputFilledPlaceholderColor,
    labelColor = colors.InputFilledLabelColor,
    backgroundColor = colors.InputFilledBackgroundColor,
    leadingIconColor = colors.InputFilledIconColor,
    trailingIconColor = colors.InputFilledActionIconColor,
    cursorColor = Color.Black, // TODO Unspecified in figma
    borderColor = colors.InputFilledBorderColor,
    shadowColor = colors.InputFilledBoxShadowColor
)

private val disabledColors = McTextFieldColorSet(
    textColor = colors.InputDisabledTextColor,
    placeholderColor = colors.InputDisabledPlaceholderColor,
    labelColor = colors.InputDisabledLabelColor,
    backgroundColor = colors.InputDisabledBackgroundColor,
    leadingIconColor = colors.InputDisabledIconColor,
    trailingIconColor = colors.InputDisabledActionIconColor,
    cursorColor = Color.Black, // TODO Unspecified in figma
    borderColor = colors.InputDisabledBorderColor,
    shadowColor = colors.InputDisabledBoxShadowColor
)

private val disabledFilledColors = McTextFieldColorSet(
    textColor = colors.InputDisabledFilledTextColor,
    placeholderColor = colors.InputDisabledFilledPlaceholderColor,
    labelColor = colors.InputDisabledFilledLabelColor,
    backgroundColor = colors.InputDisabledFilledBackgroundColor,
    leadingIconColor = colors.InputDisabledFilledIconColor,
    trailingIconColor = colors.InputDisabledFilledActionIconColor,
    cursorColor = Color.Black, // TODO Unspecified in figma
    borderColor = colors.InputDisabledFilledBorderColor,
    shadowColor = colors.InputDisabledFilledBoxShadowColor
)

private val errorColors = McTextFieldColorSet(
    textColor = colors.InputErrorTextColor,
    placeholderColor = colors.InputErrorPlaceholderColor,
    labelColor = colors.InputErrorLabelColor,
    backgroundColor = colors.InputErrorBackgroundColor,
    leadingIconColor = colors.InputErrorIconColor,
    trailingIconColor = colors.InputErrorActionIconColor,
    cursorColor = Color.Black, // TODO Unspecified in figma
    borderColor = colors.InputErrorBorderColor,
    shadowColor = colors.InputErrorBoxShadowColor
)

private val errorFilledColors = McTextFieldColorSet(
    textColor = colors.InputErrorFilledTextColor,
    placeholderColor = colors.InputErrorFilledPlaceholderColor,
    labelColor = colors.InputErrorFilledLabelColor,
    backgroundColor = colors.InputErrorFilledBackgroundColor,
    leadingIconColor = colors.InputErrorFilledIconColor,
    trailingIconColor = colors.InputErrorFilledActionIconColor,
    cursorColor = Color.Black, // TODO Unspecified in figma
    borderColor = colors.InputErrorFilledBorderColor,
    shadowColor = colors.InputErrorFilledBoxShadowColor
)

private val errorFocusColors = McTextFieldColorSet(
    textColor = colors.InputErrorFocusTextColor,
    placeholderColor = colors.InputErrorFocusPlaceholderColor,
    labelColor = colors.InputErrorFocusLabelColor,
    backgroundColor = colors.InputErrorFocusBackgroundColor,
    leadingIconColor = colors.InputErrorFocusIconColor,
    trailingIconColor = colors.InputErrorFocusActionIconColor,
    cursorColor = Color.Black, // TODO Unspecified in figma
    borderColor = colors.InputErrorFocusBorderColor,
    shadowColor = colors.InputErrorFocusBoxShadowColor
)



/**
 * Represents the colors of the input text, background and content (including label, placeholder,
 * leading, char count and trailing icons) used in a text field in different states.
 */
@Stable
interface McTextFieldColorInterface {
    /**
     * Represents the color used for the input text of this text field.
     */
    @Composable
    fun textColor(
        kind: McTextFieldKind,
        appearance: McTextFieldAppearance,
        animate: Boolean
    ): State<Color>

    /**
     * Represents the background color for this text field.
     */
    @Composable
    fun backgroundColor(
        kind: McTextFieldKind,
        appearance: McTextFieldAppearance,
        animate: Boolean
    ): State<Color>

    /**
     * Represents the color used for the placeholder of this text field.
     */
    @Composable
    fun placeholderColor(
        kind: McTextFieldKind,
        appearance: McTextFieldAppearance,
        animate: Boolean
    ): State<Color>

    /**
     * Represents the color used for the label of this text field.
     */
    @Composable
    fun labelColor(
        kind: McTextFieldKind,
        appearance: McTextFieldAppearance,
        animate: Boolean
    ): State<Color>

    /**
     * Represents the color used for the leading icon of this text field.
     */
    @Composable
    fun leadingIconColor(
        kind: McTextFieldKind,
        appearance: McTextFieldAppearance,
        animate: Boolean
    ): State<Color>

    /**
     * Represents the color used for the trailing icon of this text field.
     */
    @Composable
    fun trailingIconColor(
        kind: McTextFieldKind,
        appearance: McTextFieldAppearance,
        animate: Boolean
    ): State<Color>

    /**
     * Represents the color used for the border indicator of this text field.
     */
    @Composable
    fun borderColor(
        kind: McTextFieldKind,
        appearance: McTextFieldAppearance,
        animate: Boolean
    ): State<Color>

    /**
     * Represents the color used for the cursor of this text field.
     */
    @Composable
    fun cursorColor(
        kind: McTextFieldKind,
        appearance: McTextFieldAppearance,
        animate: Boolean
    ): State<Color>

    /**
     * Represents the color used for the shadow under this text field.
     */
    @Composable
    fun shadowColor(
        kind: McTextFieldKind,
        appearance: McTextFieldAppearance,
        animate: Boolean
    ): State<Color>
}


@Immutable
class McTextFieldColors(
    val normal: McTextFieldColorSet = normalColors,
    val normalFilled: McTextFieldColorSet = normalFilledColors,
    val normalFocus: McTextFieldColorSet = normalFocusColors,
    val disabled: McTextFieldColorSet = disabledColors,
    val disabledFilled: McTextFieldColorSet = disabledFilledColors,
    val error: McTextFieldColorSet = errorColors,
    val errorFilled: McTextFieldColorSet = errorFilledColors,
    val errorFocus: McTextFieldColorSet = errorFocusColors
): McTextFieldColorInterface  {

    @Composable
    override fun textColor(kind: McTextFieldKind, appearance: McTextFieldAppearance, animate: Boolean): State<Color>{
        val newColor = colorsFor(kind = kind, appearance = appearance).textColor
        return updateColorState(newColor = newColor, animate = animate)
    }

    @Composable
    override fun placeholderColor(kind: McTextFieldKind, appearance: McTextFieldAppearance, animate: Boolean): State<Color>{
        val newColor = colorsFor(kind = kind, appearance = appearance).placeholderColor
        return updateColorState(newColor = newColor, animate = animate)
    }

    @Composable
    override fun labelColor(kind: McTextFieldKind, appearance: McTextFieldAppearance, animate: Boolean): State<Color>{
        val newColor = colorsFor(kind = kind, appearance = appearance).labelColor
        return updateColorState(newColor = newColor, animate = animate)
    }

    @Composable
    override fun backgroundColor(kind: McTextFieldKind, appearance: McTextFieldAppearance, animate: Boolean): State<Color>{
        val newColor = colorsFor(kind = kind, appearance = appearance).backgroundColor
        return updateColorState(newColor = newColor, animate = animate)
    }

    @Composable
    override fun leadingIconColor(kind: McTextFieldKind, appearance: McTextFieldAppearance, animate: Boolean): State<Color>{
        val newColor = colorsFor(kind = kind, appearance = appearance).leadingIconColor
        return updateColorState(newColor = newColor, animate = animate)
    }

    @Composable
    override fun trailingIconColor(kind: McTextFieldKind, appearance: McTextFieldAppearance, animate: Boolean): State<Color>{
        val newColor = colorsFor(kind = kind, appearance = appearance).trailingIconColor
        return updateColorState(newColor = newColor, animate = animate)
    }

    @Composable
    override fun cursorColor(kind: McTextFieldKind, appearance: McTextFieldAppearance, animate: Boolean): State<Color>{
        val newColor = colorsFor(kind = kind, appearance = appearance).cursorColor
        return updateColorState(newColor = newColor, animate = animate)
    }

    @Composable
    override fun borderColor(kind: McTextFieldKind, appearance: McTextFieldAppearance, animate: Boolean): State<Color>{
        val newColor = colorsFor(kind = kind, appearance = appearance).borderColor
        return updateColorState(newColor = newColor, animate = animate)
    }

    @Composable
    override fun shadowColor(kind: McTextFieldKind, appearance: McTextFieldAppearance, animate: Boolean): State<Color>{
        val newColor = colorsFor(kind = kind, appearance = appearance).shadowColor
        return updateColorState(newColor = newColor, animate = animate)
    }

    //=== Private Helpers ===
    private fun colorsFor(kind: McTextFieldKind, appearance: McTextFieldAppearance): McTextFieldColorSet {
        return when( kind ){
            McTextFieldKind.NORMAL -> {
                when( appearance ) {
                    McTextFieldAppearance.NORMAL -> normal
                    McTextFieldAppearance.FILLED -> normalFilled
                    McTextFieldAppearance.FOCUSED -> normalFocus
                }
            }
            McTextFieldKind.DISABLED -> {
                when( appearance ) {
                    McTextFieldAppearance.NORMAL -> disabled
                    McTextFieldAppearance.FILLED -> disabledFilled
                    McTextFieldAppearance.FOCUSED -> disabled // No such appearance
                }
            }
            McTextFieldKind.ERROR -> {
                when( appearance ) {
                    McTextFieldAppearance.NORMAL -> error
                    McTextFieldAppearance.FILLED -> errorFilled
                    McTextFieldAppearance.FOCUSED -> errorFocus
                }
            }
        }
    }

    @Composable
    private fun updateColorState( newColor: Color, animate: Boolean): State<Color>{
        return if( animate )
            animateColorAsState(newColor, tween(durationMillis = AnimationDuration))
        else
            rememberUpdatedState(newColor)
    }

    // TODO Do we really need these?
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (other == null || this::class != other::class) return false
//
//        other as DefaultMcTextFieldColors
//
//        if (textColor != other.textColor) return false
//        if (disabledTextColor != other.disabledTextColor) return false
//        if (cursorColor != other.cursorColor) return false
//        if (errorCursorColor != other.errorCursorColor) return false
//        if (focusedBorderColor != other.focusedBorderColor) return false
//        if (unfocusedBorderColor != other.unfocusedBorderColor) return false
//        if (errorBorderColor != other.errorBorderColor) return false
//        if (disabledBorderColor != other.disabledBorderColor) return false
//        if (leadingIconColor != other.leadingIconColor) return false
//        if (disabledLeadingIconColor != other.disabledLeadingIconColor) return false
//        if (errorLeadingIconColor != other.errorLeadingIconColor) return false
//        if (trailingIconColor != other.trailingIconColor) return false
//        if (disabledTrailingIconColor != other.disabledTrailingIconColor) return false
//        if (errorTrailingIconColor != other.errorTrailingIconColor) return false
//        if (backgroundColor != other.backgroundColor) return false
//        if (focusedLabelColor != other.focusedLabelColor) return false
//        if (unfocusedLabelColor != other.unfocusedLabelColor) return false
//        if (disabledLabelColor != other.disabledLabelColor) return false
//        if (errorLabelColor != other.errorLabelColor) return false
//        if (placeholderColor != other.placeholderColor) return false
//        if (disabledPlaceholderColor != other.disabledPlaceholderColor) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = textColor.hashCode()
//        result = 31 * result + disabledTextColor.hashCode()
//        result = 31 * result + cursorColor.hashCode()
//        result = 31 * result + errorCursorColor.hashCode()
//        result = 31 * result + focusedBorderColor.hashCode()
//        result = 31 * result + unfocusedBorderColor.hashCode()
//        result = 31 * result + errorBorderColor.hashCode()
//        result = 31 * result + disabledBorderColor.hashCode()
//        result = 31 * result + leadingIconColor.hashCode()
//        result = 31 * result + disabledLeadingIconColor.hashCode()
//        result = 31 * result + errorLeadingIconColor.hashCode()
//        result = 31 * result + trailingIconColor.hashCode()
//        result = 31 * result + disabledTrailingIconColor.hashCode()
//        result = 31 * result + errorTrailingIconColor.hashCode()
//        result = 31 * result + backgroundColor.hashCode()
//        result = 31 * result + focusedLabelColor.hashCode()
//        result = 31 * result + unfocusedLabelColor.hashCode()
//        result = 31 * result + disabledLabelColor.hashCode()
//        result = 31 * result + errorLabelColor.hashCode()
//        result = 31 * result + placeholderColor.hashCode()
//        result = 31 * result + disabledPlaceholderColor.hashCode()
//        return result
//    }
}


