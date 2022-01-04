package com.example.compose.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.example.compose.ui.components.McTextFieldDefaults.CaptionHorizontalPadding
import com.example.compose.ui.components.McTextFieldDefaults.CaptionVerticalPadding
import com.example.compose.ui.components.McTextFieldDefaults.HorizontalIconPadding
import com.example.compose.ui.components.McTextFieldDefaults.IconDefaultSizeModifier
import com.example.compose.ui.components.McTextFieldDefaults.LabelHorizontalPadding
import com.example.compose.ui.components.McTextFieldDefaults.LabelId
import com.example.compose.ui.components.McTextFieldDefaults.LabelVerticalPadding
import com.example.compose.ui.components.McTextFieldDefaults.LeadingId
import com.example.compose.ui.components.McTextFieldDefaults.MinHeight
import com.example.compose.ui.components.McTextFieldDefaults.MinWidth
import com.example.compose.ui.components.McTextFieldDefaults.OutlinedTextFieldInnerPadding
import com.example.compose.ui.components.McTextFieldDefaults.OutlinedTextFieldTopPadding
import com.example.compose.ui.components.McTextFieldDefaults.PlaceholderId
import com.example.compose.ui.components.McTextFieldDefaults.TextFieldHorizontalPadding
import com.example.compose.ui.components.McTextFieldDefaults.TextFieldId
import com.example.compose.ui.components.McTextFieldDefaults.TextFieldPadding
import com.example.compose.ui.components.McTextFieldDefaults.TextFieldVerticalPadding
import com.example.compose.ui.components.McTextFieldDefaults.TrailingId
import com.example.compose.ui.theme.McTextFieldColorInterface
import com.example.compose.ui.theme.McTextFieldColors
import kotlin.math.max
import kotlin.math.roundToInt


enum class McTextFieldKind {
    NORMAL, DISABLED, ERROR
}

enum class McTextFieldAppearance {
    NORMAL, FILLED, FOCUSED
}

enum class McTextFieldLeadingIcon {
    NONE, PERSON
}

enum class McTextFieldContentType {
    NORMAL, PASSWORD, READONLY, CHAR_COUNT
}


/**
 * Contains the default values used by [McTextField]
 */
object McTextFieldDefaults {
    /**
     * The default min width applied for a [McTextField]
     * Note that you can override it by applying Modifier.heightIn directly on a text field.
     */
    val MinHeight = 56.dp

    /**
     * The default min width applied for a [McTextField]
     * Note that you can override it by applying Modifier.widthIn directly on a text field.
     */
    val MinWidth = 280.dp

    /**
     * The default opacity used for a [McTextField]'s leading and
     * trailing icons color. poop
     */
    //    const val IconOpacity = 0.54f

    /**
     * The default opacity used for a [McTextField]'s background color.
     */
    //    const val BackgroundOpacity = 0.12f

    // Filled text field uses 42% opacity to meet the contrast requirements for accessibility reasons
    /**
     * The default opacity used for a [McTextField]'s indicator line color when text field is
     * not focused.
     */
    //    const val UnfocusedIndicatorLineOpacity = 0.42f

    const val TextFieldId = "TextField"
    const val PlaceholderId = "Hint"
    const val LabelId = "Label"
    const val LeadingId = "Leading"
    const val TrailingId = "Trailing"

    const val AnimationDuration = 0
    private const val PlaceholderAnimationDuration = 0
    private const val PlaceholderAnimationDelayOrDuration = 0

    //    internal val IndicatorUnfocusedWidth = 1.dp
    //    internal val IndicatorFocusedWidth = 2.dp
    internal val LabelVerticalPadding = 0.dp
    internal val LabelHorizontalPadding = 8.dp
    internal val TextFieldVerticalPadding = 4.dp
    internal val TextFieldHorizontalPadding = 6.dp
    internal val CaptionVerticalPadding = 0.dp
    internal val CaptionHorizontalPadding = 8.dp
    internal val TextFieldPadding = 12.dp // If this is any smaller than 12 it crashes! Why?
    internal val HorizontalIconPadding = 8.dp
    internal val IconDefaultSizeModifier = Modifier.defaultMinSize(48.dp, 48.dp)

    /*
    This padding is used to allow label not overlap with the content above it. This 8.dp will work
    for default cases when developers do not override the label's font size. If they do, they will
    need to add additional padding themselves
    */
    internal val OutlinedTextFieldTopPadding = 0.dp
    internal val OutlinedTextFieldInnerPadding = 4.dp

    // TODO Use the right font and colors
    internal val TextStyle = TextStyle(
        color = Color.Black, // TODO
        background = Color.Unspecified,
        fontSize = 16.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Monospace,
        textAlign = TextAlign.Start
    )

    internal val CaptionStyle = TextStyle(
        color = Color.Black, // TODO
        background = Color.Unspecified,
        fontSize = 12.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Monospace,
        textAlign = TextAlign.Start
    )

    internal val LabelStyle = TextStyle(
        color = Color.Black, // TODO
        background = Color.Unspecified,
        fontSize = 14.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Monospace,
        textAlign = TextAlign.Start
    )

    internal val PlaceholderStyle = TextStyle(
        color = Color.Black, // TODO
        background = Color.Unspecified,
        fontSize = 14.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Monospace,
        textAlign = TextAlign.Start
    )

    /**
     * Creates a [TextFieldColors] that represents the default input text, background and content
     * (including label, placeholder, leading and trailing icons) colors used in a [McTextField].
     */
    @Composable
    fun mcTextFieldColors() : McTextFieldColorInterface {
        return McTextFieldColors()
    }

}

/**
 * Borrowed from androidx.compose.material.TextFieldImpl
 * and androidx.compose.material.OutlinedTextFieldLayout
 */
@Composable
fun McTextFieldOriginal(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,

    label: String? = null,
    placeholder: String? = null,
    caption: String? = null,
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
    val labelSize = remember { mutableStateOf(Size.Zero) }
    val labelProgress: Float = 1f // TODO this is for animation. Should it be 1f for none?

    val isError = (kind == McTextFieldKind.ERROR)
    val isEnabled = (kind != McTextFieldKind.DISABLED)
    val isFocused by interactionSource.collectIsFocusedAsState()

    // If color is not provided via the text style, use content color as a default
    val textColor = textStyle.color.takeOrElse {
        colors.textColor(kind, appearance, false).value
    }
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))

    //=== Icons ===
    val leading: @Composable (() -> Unit)? = when(leadingIcon){
        McTextFieldLeadingIcon.NONE -> null
        McTextFieldLeadingIcon.PERSON -> McIcons.person
    }

    var pwdMask by remember { mutableStateOf(visualTransformation)}
    var pwdKeyboard by remember { mutableStateOf(keyboardOptions)}
    var pwdIsVisible by remember { mutableStateOf(contentType != McTextFieldContentType.PASSWORD) }

    if( !pwdIsVisible ){
        pwdMask = PasswordVisualTransformation()
        pwdKeyboard = KeyboardOptions(keyboardType = KeyboardType.Password)
    }

    val trailing: @Composable (() -> Unit)? = when(contentType){
        McTextFieldContentType.NORMAL -> null
        McTextFieldContentType.READONLY -> McIcons.locked
        McTextFieldContentType.CHAR_COUNT -> null // TODO implement
        McTextFieldContentType.PASSWORD -> { { PasswordIcon(pwdIsVisible) {
            pwdIsVisible = !pwdIsVisible
            pwdMask = if(!pwdIsVisible) PasswordVisualTransformation() else visualTransformation
            pwdKeyboard = if(!pwdIsVisible) KeyboardOptions(keyboardType = KeyboardType.Password) else keyboardOptions
        } } } // I have no idea why this needs so many {{}}, but it does.
    }


    //=== Compose ===
    Column() {
        if (label != null ) {
            BasicText(
                text = label.uppercase(),
                style = McTextFieldDefaults.LabelStyle,
                modifier = Modifier.padding(vertical = LabelVerticalPadding, horizontal = LabelHorizontalPadding)
            )
        }

        BasicTextField(
            value = value,
            modifier = modifier
                .padding(
                    vertical = TextFieldVerticalPadding,
                    horizontal = TextFieldHorizontalPadding
                )
                .then(
                    if (label != null) {
                        Modifier.padding(top = OutlinedTextFieldTopPadding)
                    } else {
                        Modifier
                    }
                )
                .defaultMinSize(
                    minWidth = MinWidth,
                    minHeight = MinHeight,
                ),
            onValueChange = onValueChange,
            enabled = isEnabled,
            readOnly = contentType == McTextFieldContentType.READONLY,
            textStyle = mergedTextStyle,
            singleLine = maxLines <= 1,
            maxLines = maxLines,
            cursorBrush = SolidColor(colors.cursorColor(kind, appearance, false).value),
            visualTransformation = pwdMask,
            keyboardOptions = pwdKeyboard,
            keyboardActions = keyboardActions,
            interactionSource = interactionSource,
            decorationBox = @Composable { coreTextField ->
                // places leading icon, input field, label, placeholder, trailing icon
                IconsWithTextFieldLayout(
                    value = value,
                    textField = coreTextField,
                    leading = leading,
                    trailing = trailing,
                    showTrailingCount = contentType == McTextFieldContentType.CHAR_COUNT,
                    singleLine = maxLines <= 1,
                    leadingColor = colors.leadingIconColor(kind, appearance, false).value,
                    trailingColor = colors.trailingIconColor(kind, appearance, false).value,
                    onLabelMeasured = {
                        val labelWidth = it.width * labelProgress
                        val labelHeight = it.height * labelProgress
                        if (labelSize.value.width != labelWidth ||
                            labelSize.value.height != labelHeight
                        ) {
                            labelSize.value = Size(labelWidth, labelHeight)
                        }
                    },
                    animationProgress = labelProgress,
                    placeholder = placeholder,
                    label = null, // We place our own label above
                    shape = shape,
                    borderWidth = indicatorWidth,
                    borderColor = colors.borderColor(kind, appearance, false).value,
                    labelSize = labelSize.value
                )
            }
        )

        if (caption != null ) {
            BasicText(
                text = caption,
                style = McTextFieldDefaults.CaptionStyle,
                modifier = Modifier.padding(vertical = CaptionVerticalPadding, horizontal = CaptionHorizontalPadding)
            )
        }
    }
}


/**
 * Layout of the leading and trailing icons, the text field, label and placeholder in [McTextField].
 * It doesn't use Row to position the icons and middle part because label should not be
 * positioned in the middle part.
\ */
@Composable
private fun IconsWithTextFieldLayout(
    value: TextFieldValue,
    textField: @Composable () -> Unit,
    placeholder: String?,
    label: @Composable (() -> Unit)?,
    leading: @Composable (() -> Unit)?,
    trailing: @Composable (() -> Unit)?,
    showTrailingCount: Boolean = false,
    singleLine: Boolean,
    leadingColor: Color,
    trailingColor: Color,
    animationProgress: Float,
    onLabelMeasured: (Size) -> Unit,
    shape: Shape,
    borderWidth: Dp,
    borderColor: Color,
    labelSize: Size,
) {
    Layout(
        content = {
            // We use additional box here to place an outlined cutout border as a sibling after the
            // rest of UI. This allows us to use Modifier.border to draw an outline on top of the
            // text field. We can't use the border modifier directly on the IconsWithTextFieldLayout
            // as we also need to do the clipping (to form the cutout) which should not affect
            // the rest of text field UI
            Box(
                Modifier
                    .layoutId("border")
                    .outlinedBorder(shape, borderWidth, borderColor, labelSize)
            )

            if (leading != null) {
                Box(
                    modifier = Modifier
                        .layoutId(LeadingId)
                        .then(IconDefaultSizeModifier),
                    contentAlignment = Alignment.Center
                ) {
                    Decoration(
                        contentColor = leadingColor,
                        content = leading
                    )
                }
            }

            if (trailing != null) {
                Box(
                    modifier = Modifier
                        .layoutId(TrailingId)
                        .then(IconDefaultSizeModifier),
                    contentAlignment = Alignment.Center
                ) {
                    Decoration(
                        contentColor = trailingColor,
                        content = trailing
                    )
                }
            }

            val charCount = value.text.count()
            if (showTrailingCount) {
                Box(
                    modifier = Modifier
                        .layoutId(TrailingId)
                        .then(IconDefaultSizeModifier),
                    contentAlignment = Alignment.Center
                ) {
                    Decoration(
                        contentColor = trailingColor,
                        content = { BasicText(text = charCount.toString()) }
                    )
                }
            }

            val paddingToIcon = TextFieldPadding - HorizontalIconPadding
            val padding = Modifier.padding(
                start = if (leading != null) paddingToIcon else TextFieldPadding,
                end = if (trailing != null) paddingToIcon else TextFieldPadding
            )
            if (placeholder != null && charCount == 0) {
                BasicText(
                    text = placeholder,
                    style = McTextFieldDefaults.PlaceholderStyle,
                    modifier = Modifier
                        .layoutId(PlaceholderId)
                        .then(padding))
            }

            Box(
                modifier = Modifier
                    .layoutId(TextFieldId)
                    .then(padding),
                propagateMinConstraints = true
            ) {
                textField()
            }

            if (label != null) {
                Box(modifier = Modifier.layoutId(LabelId)) { label() }
            }
        }
    ) { measurables, incomingConstraints ->
        // used to calculate the constraints for measuring elements that will be placed in a row
        var occupiedSpaceHorizontally = 0
        val bottomPadding = TextFieldPadding.roundToPx()

        // measure leading icon
        val constraints = incomingConstraints.copy(minWidth = 0, minHeight = 0)
        val leadingPlaceable = measurables.find { it.layoutId == LeadingId }?.measure(constraints)
        occupiedSpaceHorizontally += widthOrZero(
            leadingPlaceable
        )

        // measure trailing icon
        val trailingPlaceable = measurables.find { it.layoutId == TrailingId }
            ?.measure(constraints.offset(horizontal = -occupiedSpaceHorizontally))
        occupiedSpaceHorizontally += widthOrZero(trailingPlaceable)

        // measure label
        val labelConstraints = constraints.offset(
            horizontal = -occupiedSpaceHorizontally,
            vertical = -bottomPadding
        )
        val labelPlaceable = measurables.find { it.layoutId == LabelId }?.measure(labelConstraints)
        labelPlaceable?.let {onLabelMeasured(Size(it.width.toFloat(), it.height.toFloat()))}

        // measure text field
        // on top we offset either by default padding or by label's half height if its too big
        // minWidth must not be set to 0 due to how foundation TextField treats zero minWidth
        val topPadding = max(heightOrZero(labelPlaceable) / 2, bottomPadding)
        val textConstraints = incomingConstraints.offset(
            horizontal = -occupiedSpaceHorizontally,
            vertical = -bottomPadding - topPadding
        ).copy(minHeight = 0)
        val textFieldPlaceable = measurables.first { it.layoutId == TextFieldId }.measure(textConstraints)

        // measure placeholder
        val placeholderConstraints = textConstraints.copy(minWidth = 0)
        val placeholderPlaceable =
            measurables.find { it.layoutId == PlaceholderId }?.measure(placeholderConstraints)

        val width =
            calculateWidth(
                leadingPlaceable,
                trailingPlaceable,
                textFieldPlaceable,
                labelPlaceable,
                placeholderPlaceable,
                incomingConstraints
            )
        val height =
            calculateHeight(
                leadingPlaceable,
                trailingPlaceable,
                textFieldPlaceable,
                labelPlaceable,
                placeholderPlaceable,
                incomingConstraints,
                density
            )

        val borderPlaceable = measurables.first { it.layoutId == "border" }.measure(
            Constraints(
                minWidth = if (width != Constraints.Infinity) width else 0,
                maxWidth = width,
                minHeight = if (height != Constraints.Infinity) height else 0,
                maxHeight = height
            )
        )
        layout(width, height) {
            place(
                height,
                width,
                leadingPlaceable,
                trailingPlaceable,
                textFieldPlaceable,
                labelPlaceable,
                placeholderPlaceable,
                borderPlaceable,
                animationProgress,
                singleLine,
                density
            )
        }
    }
}



internal fun widthOrZero(placeable: Placeable?) = placeable?.width ?: 0
internal fun heightOrZero(placeable: Placeable?) = placeable?.height ?: 0

/**
 * Calculate the width of the [McTextField] given all elements that should be
 * placed inside
 */
private fun calculateWidth(
    leadingPlaceable: Placeable?,
    trailingPlaceable: Placeable?,
    textFieldPlaceable: Placeable,
    labelPlaceable: Placeable?,
    placeholderPlaceable: Placeable?,
    constraints: Constraints
): Int {
    val middleSection = maxOf(
        textFieldPlaceable.width,
        widthOrZero(labelPlaceable),
        widthOrZero(placeholderPlaceable)
    )
    val wrappedWidth =
        widthOrZero(leadingPlaceable) + middleSection + widthOrZero(
            trailingPlaceable
        )
    return max(wrappedWidth, constraints.minWidth)
}

/**
 * Calculate the height of the [McTextField] given all elements that should be
 * placed inside
 */
private fun calculateHeight(
    leadingPlaceable: Placeable?,
    trailingPlaceable: Placeable?,
    textFieldPlaceable: Placeable,
    labelPlaceable: Placeable?,
    placeholderPlaceable: Placeable?,
    constraints: Constraints,
    density: Float
): Int {
    // middle section is defined as a height of the text field or placeholder ( whichever is
    // taller) plus 16.dp or half height of the label if it is taller, given that the label
    // is vertically centered to the top edge of the resulting text field's container
    val inputFieldHeight = max(
        textFieldPlaceable.height,
        heightOrZero(placeholderPlaceable)
    )
    val topBottomPadding = TextFieldPadding.value * density
    val middleSectionHeight = inputFieldHeight + topBottomPadding + max(
        topBottomPadding,
        heightOrZero(labelPlaceable) / 2f
    )
    return max(
        constraints.minHeight,
        maxOf(
            heightOrZero(leadingPlaceable),
            heightOrZero(trailingPlaceable),
            middleSectionHeight.roundToInt()
        )
    )
}

/**
 * Places the provided text field, placeholder, label, optional leading and trailing icons inside
 * the [McTextField]
 */
private fun Placeable.PlacementScope.place(
    height: Int,
    width: Int,
    leadingPlaceable: Placeable?,
    trailingPlaceable: Placeable?,
    textFieldPlaceable: Placeable,
    labelPlaceable: Placeable?,
    placeholderPlaceable: Placeable?,
    borderPlaceable: Placeable,
    animationProgress: Float,
    singleLine: Boolean,
    density: Float
) {
    val topBottomPadding = (TextFieldPadding.value * density).roundToInt()
    val iconPadding = HorizontalIconPadding.value * density

    // placed center vertically and to the start edge horizontally
    leadingPlaceable?.placeRelative(
        0,
        Alignment.CenterVertically.align(leadingPlaceable.height, height)
    )

    // placed center vertically and to the end edge horizontally
    trailingPlaceable?.placeRelative(
        width - trailingPlaceable.width,
        Alignment.CenterVertically.align(trailingPlaceable.height, height)
    )

    // label position is animated
    // in single line text field label is centered vertically before animation starts
    labelPlaceable?.let {
        val startPositionY = if (singleLine) {
            Alignment.CenterVertically.align(it.height, height)
        } else {
            topBottomPadding
        }
        val positionY = startPositionY * (1 - animationProgress) - (it.height / 2) * animationProgress
        val positionX = (
                if (leadingPlaceable == null) {
                    0f
                } else {
                    (widthOrZero(leadingPlaceable) - iconPadding) * (1 - animationProgress)
                }
                ).roundToInt() + topBottomPadding
        it.placeRelative(positionX, positionY.roundToInt())
    }

    // placed center vertically and after the leading icon horizontally if single line text field
    // placed to the top with padding for multi line text field
    val textVerticalPosition = if (singleLine) {
        Alignment.CenterVertically.align(textFieldPlaceable.height, height)
    } else {
        topBottomPadding
    }
    textFieldPlaceable.placeRelative(widthOrZero(leadingPlaceable), textVerticalPosition)

    // placed similar to the input text above
    placeholderPlaceable?.let {
        val placeholderVerticalPosition = if (singleLine) {
            Alignment.CenterVertically.align(it.height, height)
        } else {
            topBottomPadding
        }
        it.placeRelative(widthOrZero(leadingPlaceable), placeholderVerticalPosition)
    }

    // place border
    borderPlaceable.place(IntOffset.Zero)
}

/**
 * Draws an outlined border with label cutout
 */
private fun Modifier.outlinedBorder(
    shape: Shape,
    borderWidth: Dp,
    borderColor: Color,
    labelSize: Size
) = this
    //.outlineCutout(labelSize)
    .border(
        width = borderWidth,
        color = borderColor,
        shape = shape
    )

private fun Modifier.outlineCutout(labelSize: Size) =
    this.drawWithContent {
        val labelWidth = labelSize.width
        if (labelWidth > 0f) {
            val innerPadding = OutlinedTextFieldInnerPadding.toPx()
            val leftLtr = TextFieldPadding.toPx() - innerPadding
            val rightLtr = leftLtr + labelWidth + 2 * innerPadding
            val left = when (layoutDirection) {
                LayoutDirection.Ltr -> leftLtr
                LayoutDirection.Rtl -> size.width - rightLtr
            }
            val right = when (layoutDirection) {
                LayoutDirection.Ltr -> rightLtr
                LayoutDirection.Rtl -> size.width - leftLtr
            }
            val labelHeight = labelSize.height
            // using label height as a cutout area to make sure that no hairline artifacts are
            // left when we clip the border
            clipRect(left, -labelHeight / 2, right, labelHeight / 2, ClipOp.Difference) {
                this@drawWithContent.drawContent()
            }
        } else {
            this@drawWithContent.drawContent()
        }
    }


/**
 * Set content color, typography and emphasis for [content] composable
 */
@Composable
internal fun Decoration(
    contentColor: Color,
    typography: TextStyle? = null,
    contentAlpha: Float? = null,
    content: @Composable () -> Unit
) {
    val colorAndEmphasis: @Composable () -> Unit = @Composable {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            if (contentAlpha != null) {
                CompositionLocalProvider(
                    LocalContentAlpha provides contentAlpha,
                    content = content
                )
            } else {
                CompositionLocalProvider(
                    LocalContentAlpha provides contentColor.alpha,
                    content = content
                )
            }
        }
    }
    if (typography != null) ProvideTextStyle(typography, colorAndEmphasis) else colorAndEmphasis()
}


/**
 * CompositionLocal containing the preferred content color for a given position in the hierarchy.
 * This typically represents the `on` color for a color.
 *
 * This color should be used for any typography / iconography, to ensure that the color of these
 * adjusts when the background color changes. For example, on a dark background, text should be
 * light, and on a light background, text should be dark.
 *
 * Defaults to [Color.Black] if no color has been explicitly set.
 */
val LocalContentColor = compositionLocalOf { Color.Black }


/**
 * CompositionLocal containing the preferred content alpha for a given position in the hierarchy.
 * This alpha is used for text and iconography to emphasize / de-emphasize
 * different parts of a component. See the Material guide on
 * [Text Legibility](https://material.io/design/color/text-legibility.html) for more information on
 * alpha levels used by text and iconography.
 */
val LocalContentAlpha = compositionLocalOf { 1f }


/**
 * CompositionLocal containing the preferred [TextStyle] that will be used by text components by
 * default. To set the value for this CompositionLocal, see [ProvideTextStyle] which will merge any
 * missing [TextStyle] properties with the existing [TextStyle] set in this CompositionLocal.
 *
 * @see ProvideTextStyle
 */
val LocalTextStyle = compositionLocalOf(structuralEqualityPolicy()) { TextStyle.Default }

/**
 * This function is used to set the current value of [LocalTextStyle], merging the given style
 * with the current style values for any missing attributes. Any text components included in
 * this component's [content] will be styled with this style unless styled explicitly.
 *
 * @see LocalTextStyle
 */
@Composable
fun ProvideTextStyle(value: TextStyle, content: @Composable () -> Unit) {
    val mergedStyle = LocalTextStyle.current.merge(value)
    CompositionLocalProvider(LocalTextStyle provides mergedStyle, content = content)
}
