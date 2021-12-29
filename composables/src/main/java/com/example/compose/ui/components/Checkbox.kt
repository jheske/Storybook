package com.example.compose.ui.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CustomSimpleCheckbox() {
    val isChecked = remember { mutableStateOf(false) }

    Checkbox(checked = isChecked.value, onCheckedChange = { isChecked.value = it })
}

/**
 * Checkbox with Text label to its Right/End
 */
@Composable
fun CustomLabeledCheckbox(
    checked: Boolean = true,   // The value when this Component is first created.
    onCheckedChange: (Boolean) -> Unit = {},
) {
    val isChecked = remember { mutableStateOf(checked) }

    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { checked ->
                Log.d("Check::", checked.toString())
                isChecked.value = checked

                if (checked) {
                    Log.d("Checkbox","OnCheckedChanged")
                }
            },
//            onCheckedChange = { checked ->
//                isChecked.value = checked
//            },
            enabled = true,
            colors = CheckboxDefaults.colors(Color.Green)
        )
        Text(text = "Labeled Check Box")
    }
}

@Preview
@Composable
fun CheckboxesPreview() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            CustomSimpleCheckbox()
            Spacer(modifier = Modifier.height(16.dp))
            CustomLabeledCheckbox(
                checked = false,
                onCheckedChange = {}
            )
        }
    }
}
