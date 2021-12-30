package com.example.compose.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun ComposeTextInput(
    textValue: String,    // observable state
    onValueChanged: (String) -> Unit = {}
) {
    // TODO Integrate design system custom Theme colors, dimens, typography, etc.
    Column(Modifier.padding(16.dp)) {
        TextField(
            value = textValue,    // observable state
            onValueChange = onValueChanged,
            label = { Text(text = "Label") },
            placeholder = { Text(text = "Placeholder") }
        )
    }
}

@Composable
fun ComposeNumericTextInput(
    textValue: String,    // observable state
    onValueChange: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf(textValue)
    }

    // TODO Integrate design system custom Theme colors, dimens, typography, etc.
    Column(Modifier.padding(16.dp)) {
        TextField(
            value = text,    // observable
            onValueChange = { value ->
                text = value.filter { it.isDigit() }
                onValueChange.invoke(text)
            },
            label = { Text(text = "Label") },
            placeholder = { Text(text = "Placeholder") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        )
    }
}
