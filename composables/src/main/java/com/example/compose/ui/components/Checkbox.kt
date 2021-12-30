package com.example.compose.ui.components

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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.composables.R


/**
 * This one doesn't use LiveData.
 * It's useful for testing.
 */
@Composable
fun SimpleCheckbox(
    checked: Boolean = true,
) {
    val isChecked = remember { mutableStateOf(checked) }

    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { isChecked.value = it }
    )
}

/**
 * Checkbox with Text label to its Right/End
 *
 * isChecked is passed in as an observable state so the
 * Checkbox will recompose when the user clicks it.
 */
@Composable
fun ComposeCheckbox(
    isChecked: Boolean = true,   // observable state
    onCheckedChange: (Boolean) -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,  // isChecked is an observable state
            onCheckedChange = onCheckedChange,
            enabled = true,
            colors = CheckboxDefaults.colors(Color.Green)
        )
    }
}

@Composable
fun ComposeLabeledCheckbox(
    isChecked: Boolean = true,   // observable state
    onCheckedChange: (Boolean) -> Unit = {},
    text: String = "Label"
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ComposeCheckbox(
            isChecked = isChecked,  // observable state
            onCheckedChange = onCheckedChange,
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 4.dp)
        )
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
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            ComposeCheckbox()
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.material_large)))
            ComposeLabeledCheckbox(
                //checked = false,
                onCheckedChange = {}
            )
        }
    }
}
