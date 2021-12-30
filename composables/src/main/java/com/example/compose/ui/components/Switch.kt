package com.example.compose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun CustomSwitch(
    isChecked: Boolean = true,   // observable state
    onCheckedChange: (Boolean) -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch (
            checked = isChecked,  // isChecked is an observable state
            onCheckedChange = onCheckedChange,
            enabled = true,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Cyan
            ),
        )
    }
}