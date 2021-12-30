package com.example.compose.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource

@Composable
fun ComposeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    text: String = ""
) {
    // TODO Integrate design system custom Theme colors, dimens, typography, etc.
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        // TODO Dimens should come from the Theme
        contentPadding = PaddingValues(
            horizontal = dimensionResource(id = R.dimen.compose_button_padding_horizontal),
            vertical = dimensionResource(id = R.dimen.compose_button_padding_vertical)
        )
    ) {
        Text(text = text)
    }
}
