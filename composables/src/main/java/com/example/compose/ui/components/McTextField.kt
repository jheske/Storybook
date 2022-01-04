package com.example.compose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.ui.theme.AppTheme
import com.example.compose.ui.theme.McTextFieldColorInterface

/**
 *
 * Google's TextFieldDefaults.textFieldColors:
 *
 * textColor = textColor,
 * disabledTextColor = disabledTextColor,
 * cursorColor = cursorColor,
 * errorCursorColor = errorCursorColor,
 * focusedIndicatorColor = focusedBorderColor,
 * unfocusedIndicatorColor = unfocusedBorderColor,
 * errorIndicatorColor = errorBorderColor,
 * disabledIndicatorColor = disabledBorderColor,
 * leadingIconColor = leadingIconColor,
 * disabledLeadingIconColor = disabledLeadingIconColor,
 * errorLeadingIconColor = errorLeadingIconColor,
 * trailingIconColor = trailingIconColor,
 * disabledTrailingIconColor = disabledTrailingIconColor,
 * errorTrailingIconColor = errorTrailingIconColor,
 * backgroundColor = backgroundColor,
 * focusedLabelColor = focusedLabelColor,
 * unfocusedLabelColor = unfocusedLabelColor,
 * disabledLabelColor = disabledLabelColor,
 * errorLabelColor = errorLabelColor,
 * placeholderColor = placeholderColor,
 * disabledPlaceholderColor = disabledPlaceholderColor
 *
 * McTextField colors:
 *
 * inputActionIconColor,
 * inputBackgroundColor,
 * inputBorderColor,
 * inputBoxShadowColor,
 * inputIconColor,
 * inputLabelColor,
 * inputPlaceholderColor,
 * inputTextColor,
 * inputDisabledIconColor,
 * inputDisabledLabelColor,
 * inputDisabledPlaceholderColor,
 * inputDisabledTextColor,
 *
 */
@Composable
fun McTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    placeholder: String = "",
    caption: String = "",
    maxLines: Int = 1,
    kind: McTextFieldKind = McTextFieldKind.NORMAL,
    leadingIcon: McTextFieldLeadingIcon = McTextFieldLeadingIcon.NONE
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
//        McTextFieldThemed(
//            value, onValueChange, placeholder, caption,
//        )

        McTextFieldOutlined(
            value = value, onValueChange = onValueChange
        )
    }
}

@Composable
fun McTextFieldThemed(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    placeholder: String = "",
    caption: String = "",
    maxLines: Int = 1,
    kind: McTextFieldKind = McTextFieldKind.NORMAL,
    leadingIcon: McTextFieldLeadingIcon = McTextFieldLeadingIcon.NONE
) {
    var text by remember { mutableStateOf(value) }

    // TODO Integrate design system custom Theme colors, dimens, typography, etc.
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { newValue ->
                text = newValue
                onValueChange.invoke(text)
            },
            modifier = Modifier.padding(bottom = 50.dp),
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Ascii),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = AppTheme.colors.inputTextColor,
                disabledTextColor = AppTheme.colors.inputDisabledTextColor,
                backgroundColor = AppTheme.colors.inputBackgroundColor,
                focusedLabelColor = AppTheme.colors.inputFocusedLabelColor,
                unfocusedLabelColor = AppTheme.colors.inputUnfocusedLabelColor,
                disabledLabelColor = AppTheme.colors.inputDisabledLabelColor,
                errorLabelColor = AppTheme.colors.inputTextColor,
                placeholderColor = AppTheme.colors.inputPlaceholderColor,
                disabledPlaceholderColor = AppTheme.colors.inputDisabledPlaceholderColor,
            )
        )
    }
}

@Composable
fun McTextFieldOutlined(
    value: String,
    onValueChange: (String) -> Unit,
) {
    var text by remember { mutableStateOf(value) }

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        ConstraintLayoutTextField(
            value, onValueChange,
        )
        //       Text(text = "label")
//        OutlinedTextField(
//            value = text,
//            onValueChange = { newValue ->
//                text = newValue
//                onValueChange.invoke(text)
//            },
//            modifier = Modifier.height(100.dp),
//            label = {
//            },
//            leadingIcon = {
//                Icon(
//                    modifier = Modifier.offset(y = (-20).dp),
//                    imageVector = Icons.Filled.Search,
//                    contentDescription = null
//                )
//            },
//
//            placeholder = { Text(text = "placeholder") },
//            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Ascii),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                textColor = AppTheme.colors.inputTextColor,
//                disabledTextColor = AppTheme.colors.inputDisabledTextColor,
//                backgroundColor = AppTheme.colors.inputBackgroundColor,
//                focusedLabelColor = AppTheme.colors.inputFocusedLabelColor,
//                unfocusedLabelColor = AppTheme.colors.inputUnfocusedLabelColor,
//                disabledLabelColor = AppTheme.colors.inputDisabledLabelColor,
//                errorLabelColor = AppTheme.colors.inputTextColor,
//                placeholderColor = AppTheme.colors.inputPlaceholderColor,
//                disabledPlaceholderColor = AppTheme.colors.inputDisabledPlaceholderColor,
//            )
//        )
    }
}

@Composable
fun ConstraintLayoutTextField(
    value: String,
    onValueChange: (String) -> Unit,
) {
    var text by remember { mutableStateOf(value) }
    val totalChars = 100
    var charCount = totalChars

    ConstraintLayout(modifier = Modifier.size(280.dp)) {
        val (textFieldLabel, textField, charCounterText) = createRefs()

        Text(text = "label",
            modifier = Modifier
                .constrainAs(textFieldLabel) {}
        )

        OutlinedTextField(
            value = text,
            onValueChange = { newValue ->
                text = newValue
                charCount = totalChars - text.count()
                if (charCount > 3) {
                    
                }
                onValueChange.invoke(text)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .constrainAs(textField) {
                    top.linkTo(textFieldLabel.bottom)
                    start.linkTo(textFieldLabel.start)
                },
            label = {
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.offset(y = (-20).dp),
                    imageVector = Icons.Filled.Search,
                    contentDescription = null
                )
            },
            placeholder = { Text(text = "placeholder") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Ascii),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = AppTheme.colors.inputTextColor,
                disabledTextColor = AppTheme.colors.inputDisabledTextColor,
                backgroundColor = AppTheme.colors.inputBackgroundColor,
                focusedLabelColor = AppTheme.colors.inputFocusedLabelColor,
                unfocusedLabelColor = AppTheme.colors.inputUnfocusedLabelColor,
                disabledLabelColor = AppTheme.colors.inputDisabledLabelColor,
                errorLabelColor = AppTheme.colors.inputTextColor,
                placeholderColor = AppTheme.colors.inputPlaceholderColor,
                disabledPlaceholderColor = AppTheme.colors.inputDisabledPlaceholderColor,
            )
        )

        Text(text = "Chars remaining = $charCount",
            modifier = Modifier
                .padding(end = 12.dp, bottom = 12.dp)
                .constrainAs(charCounterText) {
                    bottom.linkTo(textField.bottom)
                    end.linkTo(textField.end)
                })
    }
}

@Composable
fun ConstraintLayoutDemo() {
    ConstraintLayout(modifier = Modifier.size(200.dp)) {
        val (redBox, blueBox, yellowBox, text) = createRefs()

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Red)
            .constrainAs(redBox) {})

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .constrainAs(blueBox) {
                top.linkTo(redBox.bottom)
                start.linkTo(redBox.end)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(yellowBox) {
                bottom.linkTo(blueBox.bottom)
                start.linkTo(blueBox.end, 20.dp)
            })

        Text("Hello World", modifier = Modifier.constrainAs(text) {
            top.linkTo(parent.top)
            start.linkTo(yellowBox.start)
        })

    }
}

@Preview
@Composable
fun McTextInputPreview(
) {

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "label")
        OutlinedTextField(
            value = "text",
            onValueChange = { newValue ->

            },
            modifier = Modifier.height(100.dp),
            label = {
            },

            leadingIcon = {
                Icon(
                    modifier = Modifier.offset(y = -20.dp),
                    imageVector = Icons.Filled.Search, contentDescription = null
                )
            },

            placeholder = { Text(text = "placeholder") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Ascii),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = AppTheme.colors.inputTextColor,
                disabledTextColor = AppTheme.colors.inputDisabledTextColor,
                backgroundColor = AppTheme.colors.inputBackgroundColor,
                focusedLabelColor = AppTheme.colors.inputFocusedLabelColor,
                unfocusedLabelColor = AppTheme.colors.inputUnfocusedLabelColor,
                disabledLabelColor = AppTheme.colors.inputDisabledLabelColor,
                errorLabelColor = AppTheme.colors.inputTextColor,
                placeholderColor = AppTheme.colors.inputPlaceholderColor,
                disabledPlaceholderColor = AppTheme.colors.inputDisabledPlaceholderColor,
            )
        )
    }
}