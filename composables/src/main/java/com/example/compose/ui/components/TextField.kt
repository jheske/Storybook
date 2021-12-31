package com.example.compose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType

/**
 * A Basic TextField.
 * Field validation will require additional onValueChange logic.
 */
@Composable
fun ComposeTextInput(
    value: String,
    onValueChange: (String) -> Unit = {},
    label: String = "Label",
    placeholder: String = "Placeholder",
    keyboardType: KeyboardType = KeyboardType.Ascii
) {
    var text by remember { mutableStateOf(value) }

    // TODO Integrate design system custom Theme colors, dimens, typography, etc.
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = text,
            onValueChange = {textValue ->
                text = textValue
                onValueChange.invoke(text)
            },
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        )
    }
}
