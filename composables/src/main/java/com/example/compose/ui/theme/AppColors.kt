package com.dmytroshuba.customthemedemo.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.example.compose.ui.theme.AppThemeColors
import com.example.compose.utils.colors

class AppColors(
    primary: Color,
    textPrimary: Color,
    textSecondary: Color,
    background: Color,
    error: Color,
    switchBackgroundColor: Color,
    switchBorderColor: Color,
    switchBoxShadowColor: Color,
    switchLeverBackground: Color,
    isLight: Boolean
) {
    var primary by mutableStateOf(primary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var error by mutableStateOf(error)
        private set
    var background by mutableStateOf(background)
        private set
    var isLight by mutableStateOf(isLight)
        internal set
    var switchBackgroundColor by mutableStateOf(switchBackgroundColor)
        internal set
    var switchBorderColor by mutableStateOf(switchBorderColor)
        internal set
    var switchBoxShadowColor by mutableStateOf(switchBoxShadowColor)
        internal set
    var switchLeverBackground by mutableStateOf(switchLeverBackground)
        internal set
//    val SwitchCheckedBackgroundColor = Color(0x00000000)
//    val SwitchCheckedBorderColor = Color(0xff24bc98)
//    val SwitchCheckedBoxShadowColor = Color(0x00000000)
//    val SwitchCheckedDisabledBackgroundColor = Color(0x00000000)
//    val SwitchCheckedDisabledBorderColor = Color(0xffd1cccc)
//    val SwitchCheckedDisabledBoxShadowColor = Color(0x00000000)
//    val SwitchCheckedDisabledLeverBackground = Color(0xffd1cccc)
//    val SwitchCheckedFocusBackgroundColor = Color(0xffd6fff0)
//    val SwitchCheckedFocusBorderColor = Color(0xff4258ff)
//    val SwitchCheckedFocusBoxShadowColor = Color(0x00000000)
//    val SwitchCheckedFocusLeverBackground = Color(0xff24bc98)
//    val SwitchCheckedLeverBackground = Color(0xff24bc98)
//    val SwitchCheckedPressedBackgroundColor = Color(0xffd6fff0)
//    val SwitchCheckedPressedBorderColor = Color(0xff24bc98)
//    val SwitchCheckedPressedBoxShadowColor = Color(0x00000000)
//    val SwitchCheckedPressedLeverBackground = Color(0xff24bc98)
//    val SwitchDisabledBackgroundColor = Color(0x00000000)
//    val SwitchDisabledBorderColor = Color(0xffd1cccc)
//    val SwitchDisabledBoxShadowColor = Color(0x00000000)
//    val SwitchDisabledLeverBackground = Color(0xffd1cccc)
//    val SwitchFocusBackgroundColor = Color(0xfff2f2f2)
//    val SwitchFocusBorderColor = Color(0xff4258ff)
//    val SwitchFocusBoxShadowColor = Color(0x00000000)
//    val SwitchFocusLeverBackground = Color(0xffb8b2b2)
//    val SwitchLeverBackground = Color(0xffb8b2b2)
//    val SwitchPressedBackgroundColor = Color(0xfff2f2f2)

    fun copy(
        primary: Color = this.primary,
        textPrimary: Color = this.textPrimary,
        textSecondary: Color = this.textSecondary,
        error: Color = this.error,
        background: Color = this.background,
        switchBackgroundColor: Color = this.switchBackgroundColor,
        switchBorderColor: Color = this.switchBorderColor,
        switchBoxShadowColor: Color = this.switchBoxShadowColor,
        switchLeverBackground: Color = this.switchLeverBackground,
        isLight: Boolean = this.isLight,
    ): AppColors = AppColors(
        primary,
        textPrimary,
        textSecondary,
        error,
        background,
        switchBackgroundColor,
        switchBorderColor,
        switchBoxShadowColor,
        switchLeverBackground,
        isLight
    )

    fun updateColorsFrom(other: AppColors) {
        primary = other.primary
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        background = other.background
        switchBackgroundColor  = other.switchBackgroundColor
        switchBorderColor = other.switchBorderColor
        switchBoxShadowColor = other.switchBoxShadowColor
        switchLeverBackground = other.switchLeverBackground
        error = other.error
    }
}

private val colorLightPrimary = Color(0xFFFFB400)
private val colorLightTextPrimary = Color(0xFF000000)
private val colorLightTextSecondary = Color(0xFF6C727A)
private val colorLightBackground = Color(0xFFFFFFFF)
private val colorLightError = Color(0xFFD62222)

private val colorDarkPrimary = Color(0xFF0037FF)
private val colorDarkTextPrimary = Color(0xFFFAFAFA)
private val colorDarkTextSecondary = Color(0xFF6C727A)
private val colorDarkBackground = Color(0xFF090A0A)
private val colorDarkError = Color(0xFFD62222)

fun lightColors(
    primary: Color = colorLightPrimary,
    textPrimary: Color = colorLightTextPrimary,
    textSecondary: Color = colorLightTextSecondary,
    background: Color = colorLightBackground,
    error: Color = colorLightError,
    switchBackgroundColor: Color = colors.SwitchBackgroundColor,
    switchBorderColor: Color = colors.SwitchBorderColor,
    switchBoxShadowColor: Color  = colors.SwitchBoxShadowColor,
    switchLeverBackground: Color  = colors.SwitchLeverBackground,
): AppColors = AppColors(
    primary = primary,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    background = background,
    error = error,
    switchBackgroundColor = switchBackgroundColor,
    switchBorderColor = switchBorderColor,
    switchBoxShadowColor = switchBoxShadowColor,
    switchLeverBackground = switchLeverBackground,
    isLight = true
)

fun darkColors(
    primary: Color = colorDarkPrimary,
    textPrimary: Color = colorDarkTextPrimary,
    textSecondary: Color = colorDarkTextSecondary,
    background: Color = colorDarkBackground,
    error: Color = colorDarkError,
    switchBackgroundColor: Color = AppThemeColors.SwitchBackgroundColor,
    switchBorderColor: Color = AppThemeColors.SwitchBorderColor,
    switchBoxShadowColor: Color  = AppThemeColors.SwitchBoxShadowColor,
    switchBoxLeverBackground: Color  = AppThemeColors.SwitchLeverBackground,
): AppColors = AppColors(
    primary = primary,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    background = background,
    error = error,
    switchBackgroundColor = switchBackgroundColor,
    switchBorderColor = switchBorderColor,
    switchBoxShadowColor = switchBoxShadowColor,
    switchLeverBackground = switchBoxLeverBackground,
    isLight = false
)

val LocalColors = staticCompositionLocalOf { darkColors() }
