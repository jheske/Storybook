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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
                checkedThumbColor = Color.Cyan
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