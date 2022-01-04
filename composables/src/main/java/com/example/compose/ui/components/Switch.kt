package com.example.compose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.AppTheme

/**
 * Google's SwitchDefault colors
 * checkedThumbColor - the color used for the thumb when enabled and checked
 * checkedTrackColor - the color used for the track when enabled and checked
 * checkedTrackAlpha - the alpha applied to checkedTrackColor and disabledCheckedTrackColor
 * uncheckedThumbColor - the color used for the thumb when enabled and unchecked
 * uncheckedTrackColor - the color used for the track when enabled and unchecked
 * uncheckedTrackAlpha - the alpha applied to uncheckedTrackColor and disabledUncheckedTrackColor
 * disabledCheckedThumbColor - the color used for the thumb when disabled and checked
 * disabledCheckedTrackColor - the color used for the track when disabled and checked
 * disabledUncheckedThumbColor - the color used for the thumb when disabled and unchecked
 * disabledUncheckedTrackColor - the color used for the track when disabled and unchecked
 */
@Composable
fun ComposeSwitch(
    isChecked: Boolean = true,   // observable state
    onCheckedChange: (Boolean) -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState = remember { mutableStateOf(isChecked) }

        Switch(
            checked = checkedState.value,  // isChecked is an observable state
            onCheckedChange = {
                checkedState.value = it
                onCheckedChange.invoke(it)
            },
            enabled = true,

            colors = SwitchDefaults.colors(
                uncheckedThumbColor = AppTheme.colors.switchLeverBackground,
                uncheckedTrackColor = AppTheme.colors.switchBackgroundColor,
                checkedThumbColor = AppTheme.colors.switchLeverBackground,
                checkedTrackColor = AppTheme.colors.switchBackgroundColor
            ),
        )
    }
}

@Composable
fun ComposeSwitchWithLabel(
    isChecked: Boolean = true,
    onCheckedChange: (Boolean) -> Unit = {},
    text: String = "Label"
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ComposeSwitch(
            isChecked = isChecked,
            onCheckedChange = onCheckedChange,
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}