package com.example.compose.storybook.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StorybookViewModel : ViewModel() {

    /**
     * MutableLiveData and LiveData values:
     *
     * The ViewModel uses _mutableLiveData vals for values the app wants to store and observe.
     * Per Google standards, these should be private backing values for corresponding
     * public LiveData values, which any Activity, Fragment, etc. can observe.
     */

    /*****************************
     * Button
     */
    private var buttonClickCount = 0
    // This is bound to a TextView in fragment_button.xml
    val buttonClickCountString = MutableLiveData("")

    /**
     * Called from inside ComposeButton.onClick{}
     */
    fun onComposeButtonClicked() {
        buttonClickCountString.value = "ViewModel: Click count = ${++buttonClickCount}"
    }

    /*****************************
     * TextInput
     */
    private val _textValue = MutableLiveData("")
    val textValue: LiveData<String> = _textValue

    fun setTextValue(text: String) {
        _textValue.value = text
    }

    /*****************************
     * Checkbox
     */
    private var checkboxClickCount = 0

    // This is bound to a TextView in fragment_button.xml
    val checkboxClickCountString = MutableLiveData("")

    /**
     * Toggle the checkbox. All observers will receive the changed
     * value. Composable observers will recompose.
     */
    fun onCheckboxClicked() {
        checkboxClickCountString.value =
            "ViewModel: Click count = ${++checkboxClickCount}"
    }

    /*****************************
     * Labeled Checkbox
     */
    private var checkboxWithLablClickCount = 0

    // This is bound to a TextView in fragment_button.xml
    val checkboxWithLabelClickCountString = MutableLiveData("")

    fun onLabeledCheckboxClicked() {
        checkboxWithLabelClickCountString.value =
            "ViewModel: Click count = ${++checkboxWithLablClickCount}"
    }

    /*****************************
     * Switch
     */

    private var switchToggleCount = 0
    // This is bound to a TextView in fragment_button.xml
    val switchToggleCountString = MutableLiveData("")

    /**
     * Toggle the switch. All observers will receive the changed
     * value.
     */
    fun onSwitchToggled() {
        switchToggleCountString.value =
            "ViewModel: Toggle count = ${++switchToggleCount}"
    }

    /*****************************
     * SwitchWithLabel
     */

    private var switchWithLabelToggleCount = 0
    // This is bound to a TextView in fragment_button.xml
    val switchWithLabelToggleCountString = MutableLiveData("")

    /**
     * Toggle the switch. All observers will receive the changed
     * value.
     */
    fun onSwitchWithLabelToggled() {
        switchWithLabelToggleCountString.value =
            "ViewModel: Toggle count = ${++switchWithLabelToggleCount}"
    }
}


