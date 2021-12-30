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
    private var buttonClickCounter = 0
    // This is bound to a TextView in fragment_button.xml
    val buttonClickCounterString = MutableLiveData("")

    /**
     * Called from inside ComposeButton.onClick{}
     */
    fun onComposeButtonClicked() {
        buttonClickCounterString.value = "ViewModel: Button click counter = ${buttonClickCounter++}"
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
    private val _isComposeCheckboxChecked = MutableLiveData(false)
    val isComposeCheckboxChecked: LiveData<Boolean> = _isComposeCheckboxChecked

    /**
     * Toggle the checkbox. All observers will receive the changed
     * value. Composable observers will recompose.
     */
    fun checkComposeCheckbox() {
        // LiveDatas are nullable. If null, default to false.
        val isChecked = _isComposeCheckboxChecked.value ?: false

        _isComposeCheckboxChecked.value = !isChecked
    }


    /*****************************
     * Labeled Checkbox
     */
    private val _isComposeLabeledCheckboxChecked = MutableLiveData(false)
    val isComposeLabeledCheckboxChecked: LiveData<Boolean> = _isComposeLabeledCheckboxChecked

    fun checkComposeLabeledCheckbox() {
        // LiveDatas are nullable. If null, default to false.
        val isChecked = _isComposeLabeledCheckboxChecked.value ?: false

        _isComposeLabeledCheckboxChecked.value = !isChecked
    }

    /*****************************
     * Switch
     */
    private val _isComposeSwitchChecked = MutableLiveData(false)
    val isComposeSwitchChecked: LiveData<Boolean> = _isComposeSwitchChecked

    /**
     * Toggle the switch. All observers will receive the changed
     * value. Composable observers will recompose.
     */
    fun checkComposeSwitch() {
        // LiveDatas are nullable. If null, default to false.
        val isChecked = _isComposeSwitchChecked.value ?: false

        _isComposeSwitchChecked.value = !isChecked
    }
}


