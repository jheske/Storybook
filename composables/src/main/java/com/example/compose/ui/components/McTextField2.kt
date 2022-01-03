package com.example.compose.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.McTextFieldColorInterface

@Composable
fun McTextField2(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,

    label: String = "",
    placeholder: String = "",
    caption: String = "",
    maxLines: Int = 1,

    kind: McTextFieldKind = McTextFieldKind.NORMAL,
    appearance: McTextFieldAppearance = McTextFieldAppearance.NORMAL,

    leadingIcon: McTextFieldLeadingIcon = McTextFieldLeadingIcon.NONE,
    contentType: McTextFieldContentType = McTextFieldContentType.NORMAL,

    textStyle: TextStyle = McTextFieldDefaults.TextStyle,
    colors: McTextFieldColorInterface = McTextFieldDefaults.mcTextFieldColors(),

    indicatorWidth: Dp = 1.dp, // TODO default value?
    shape: Shape = RoundedCornerShape(4.dp), // TODO default value?

    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),

    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    var text by remember { mutableStateOf(value) }

    // TODO Integrate design system custom Theme colors, dimens, typography, etc.
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = text,
            onValueChange = {newValue ->
                text = newValue
                onValueChange.invoke(text)
            },
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
           // keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        )
    }
}