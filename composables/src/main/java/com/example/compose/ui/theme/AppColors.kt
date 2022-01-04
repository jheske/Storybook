package com.dmytroshuba.customthemedemo.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.example.compose.utils.colors

class AppColors(
    inputActionIconColor: Color,
    inputBackgroundColor: Color,
    inputBorderColor: Color,
    inputBoxShadowColor: Color,
    inputIconColor: Color,
    inputFocusedLabelColor: Color,
    inputUnfocusedLabelColor: Color,
    inputPlaceholderColor: Color,
    inputTextColor: Color,
    inputDisabledIconColor: Color,
    inputDisabledLabelColor: Color,
    inputDisabledPlaceholderColor: Color,
    inputDisabledTextColor: Color,
    switchBackgroundColor: Color,
    switchBorderColor: Color,
    switchBoxShadowColor: Color,
    switchLeverBackground: Color,
    isLight: Boolean
) {
    var inputActionIconColor by mutableStateOf(inputActionIconColor)
        internal set
    var inputBackgroundColor by mutableStateOf(inputBackgroundColor)
        internal set
    var inputBorderColor by mutableStateOf(inputBorderColor)
        internal set
    var inputBoxShadowColor by mutableStateOf(inputBoxShadowColor)
        internal set
    var inputIconColor by mutableStateOf(inputIconColor)
        internal set
    var inputFocusedLabelColor by mutableStateOf(inputFocusedLabelColor)
        internal set
    var inputUnfocusedLabelColor by mutableStateOf(inputUnfocusedLabelColor)
        internal set
    var inputPlaceholderColor by mutableStateOf(inputPlaceholderColor)
        internal set
    var inputTextColor by mutableStateOf(inputTextColor)
        internal set
    var inputDisabledIconColor by mutableStateOf(inputDisabledIconColor)
        internal set
    var inputDisabledLabelColor by mutableStateOf(inputDisabledLabelColor)
        internal set
    var inputDisabledPlaceholderColor by mutableStateOf(inputDisabledPlaceholderColor)
        internal set
    var inputDisabledTextColor by mutableStateOf(inputDisabledTextColor)
        internal set

    var switchBackgroundColor by mutableStateOf(switchBackgroundColor)
        internal set
    var switchBorderColor by mutableStateOf(switchBorderColor)
        internal set
    var switchBoxShadowColor by mutableStateOf(switchBoxShadowColor)
        internal set
    var switchLeverBackground by mutableStateOf(switchLeverBackground)
        internal set
    var isLight by mutableStateOf(isLight)
        internal set
    
    fun copy(
        inputActionIconColor: Color = this.inputActionIconColor,
        inputBackgroundColor: Color = this.inputBackgroundColor,
        inputBorderColor: Color = this.inputBorderColor,
        inputBoxShadowColor: Color = this.inputBoxShadowColor,
        inputIconColor: Color = this.inputIconColor,
        inputFocusedLabelColor: Color = this.inputFocusedLabelColor,
        inputUnfocusedLabelColor: Color = this.inputUnfocusedLabelColor,
        inputPlaceholderColor: Color = this.inputPlaceholderColor,
        inputTextColor: Color = this.inputTextColor, 
        inputDisabledIconColor: Color = this.inputDisabledIconColor,
        inputDisabledLabelColor: Color = this.inputDisabledLabelColor,
        inputDisabledPlaceholderColor: Color = this.inputDisabledPlaceholderColor,
        inputDisabledTextColor: Color = this.inputDisabledTextColor, 
        switchBackgroundColor: Color = this.switchBackgroundColor,
        switchBorderColor: Color = this.switchBorderColor,
        switchBoxShadowColor: Color = this.switchBoxShadowColor,
        switchLeverBackground: Color = this.switchLeverBackground,
        isLight: Boolean = this.isLight,
    ): AppColors = AppColors(
        inputActionIconColor,
        inputBackgroundColor,
        inputBorderColor,
        inputBoxShadowColor,
        inputIconColor,
        inputFocusedLabelColor,
        inputUnfocusedLabelColor,
        inputPlaceholderColor,
        inputTextColor,
        inputDisabledIconColor,
        inputDisabledLabelColor,
        inputDisabledPlaceholderColor,
        inputDisabledTextColor,
        switchBackgroundColor,
        switchBorderColor,
        switchBoxShadowColor,
        switchLeverBackground,
        isLight
    )

    fun updateColorsFrom(other: AppColors) {
        inputActionIconColor = other.inputActionIconColor
        inputBackgroundColor = other.inputBackgroundColor
        inputBorderColor = other.inputBorderColor
        inputBoxShadowColor = other.inputBoxShadowColor
        inputIconColor = other.inputIconColor
        inputFocusedLabelColor = other.inputFocusedLabelColor
        inputUnfocusedLabelColor = other.inputUnfocusedLabelColor
        inputPlaceholderColor = other.inputPlaceholderColor
        inputTextColor = other.inputTextColor
        inputDisabledIconColor = other.inputDisabledIconColor
        inputDisabledLabelColor = other.inputDisabledLabelColor
        inputDisabledPlaceholderColor = other.inputDisabledPlaceholderColor
        inputDisabledTextColor = other.inputDisabledTextColor
        switchBackgroundColor = other.switchBackgroundColor
        switchBorderColor = other.switchBorderColor
        switchBoxShadowColor = other.switchBoxShadowColor
        switchLeverBackground = other.switchLeverBackground
    }
}

fun lightColors(
    inputActionIconColor: Color = colors.InputActionIconColor,
    inputBackgroundColor: Color = colors.InputBackgroundColor,
    inputBorderColor: Color = colors.InputBorderColor,
    inputBoxShadowColor: Color = colors.InputBoxShadowColor,
    inputIconColor: Color = colors.InputIconColor,
    inputFocusedLabelColor: Color = colors.InputFocusLabelColor,
    inputUnfocusedLabelColor: Color = colors.InputLabelColor,
    inputPlaceholderColor: Color = colors.InputPlaceholderColor,
    inputTextColor: Color = colors.InputTextColor,
    inputDisabledIconColor: Color = colors.InputDisabledIconColor,
    inputDisabledLabelColor: Color = colors.InputDisabledLabelColor,
    inputDisabledPlaceholderColor: Color = colors.InputDisabledPlaceholderColor,
    inputDisabledTextColor: Color = colors.InputDisabledTextColor, 
    switchBackgroundColor: Color = colors.SwitchBackgroundColor,
    switchBorderColor: Color = colors.SwitchBorderColor,
    switchBoxShadowColor: Color = colors.SwitchBoxShadowColor,
    switchLeverBackground: Color = colors.SwitchLeverBackground,
): AppColors = AppColors(
    inputActionIconColor = inputActionIconColor,
    inputBackgroundColor = inputBackgroundColor,
    inputBorderColor = inputBorderColor,
    inputBoxShadowColor = inputBoxShadowColor,
    inputIconColor = inputIconColor,
    inputFocusedLabelColor = inputFocusedLabelColor,
    inputUnfocusedLabelColor = inputUnfocusedLabelColor,
    inputPlaceholderColor = inputPlaceholderColor,
    inputTextColor = inputTextColor,
    inputDisabledIconColor = inputDisabledIconColor,
    inputDisabledLabelColor = inputDisabledLabelColor,
    inputDisabledPlaceholderColor = inputDisabledPlaceholderColor,
    inputDisabledTextColor = inputDisabledTextColor,
    switchBackgroundColor = switchBackgroundColor,
    switchBorderColor = switchBorderColor,
    switchBoxShadowColor = switchBoxShadowColor,
    switchLeverBackground = switchLeverBackground,
    isLight = true
)

fun darkColors(
    inputActionIconColor: Color = colors.InputActionIconColor,
    inputBackgroundColor: Color = colors.InputBackgroundColor,
    inputBorderColor: Color = colors.InputBorderColor,
    inputBoxShadowColor: Color = colors.InputBoxShadowColor,
    inputIconColor: Color = colors.InputIconColor,
    inputFocusedLabelColor: Color = colors.InputFocusLabelColor,
    inputUnfocusedLabelColor: Color = colors.InputLabelColor,
    inputPlaceholderColor: Color = colors.InputPlaceholderColor,
    inputTextColor: Color = colors.InputTextColor,
    inputDisabledIconColor: Color = colors.InputDisabledIconColor,
    inputDisabledLabelColor: Color = colors.InputDisabledLabelColor,
    inputDisabledPlaceholderColor: Color = colors.InputDisabledPlaceholderColor,
    inputDisabledTextColor: Color = colors.InputDisabledTextColor,
    switchBackgroundColor: Color = colors.SwitchBackgroundColor,
    switchBorderColor: Color = colors.SwitchBorderColor,
    switchBoxShadowColor: Color = colors.SwitchBoxShadowColor,
    switchBoxLeverBackground: Color = colors.SwitchLeverBackground,
): AppColors = AppColors(
    inputActionIconColor = inputActionIconColor,
    inputBackgroundColor = inputBackgroundColor,
    inputBorderColor = inputBorderColor,
    inputBoxShadowColor = inputBoxShadowColor,
    inputIconColor = inputIconColor,
    inputFocusedLabelColor = inputFocusedLabelColor,
    inputUnfocusedLabelColor = inputUnfocusedLabelColor,
    inputPlaceholderColor = inputPlaceholderColor,
    inputDisabledIconColor = inputDisabledIconColor,
    inputDisabledLabelColor = inputDisabledLabelColor,
    inputDisabledPlaceholderColor = inputDisabledPlaceholderColor,
    inputDisabledTextColor = inputDisabledTextColor,
    inputTextColor = inputTextColor,
    switchBackgroundColor = switchBackgroundColor,
    switchBorderColor = switchBorderColor,
    switchBoxShadowColor = switchBoxShadowColor,
    switchLeverBackground = switchBoxLeverBackground,
    isLight = false
)

val LocalColors = staticCompositionLocalOf { darkColors() }
