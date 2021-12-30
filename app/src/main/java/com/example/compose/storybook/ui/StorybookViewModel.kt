package com.example.compose.storybook.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StorybookViewModel : ViewModel() {

    /**
     * MutableLiveData and LiveData values:
     *
     * The ViewModel uses _mutableLiveData vals for values the app wants to store and observe.
     * Per Google standards, these should be private. Each one serves as a backing value for
     * a publicly visible liveData value, which any Activity, Fragment, etc. can observe.
     *
     * Example:
     *
     * _onCustomButtonClicked is the private backing value for
     * the public onCustomButtonClicked.
     * Any ButtonFragment observes onCustomButtonClicked.
     * and respond to changes (see ButtonFragment.setupObservers()).
     */
    private val _onCustomButtonClicked = MutableLiveData(false)
    val onCustomButtonClicked = _onCustomButtonClicked

    // Checkbox
    private val _isCustomCheckboxChecked = MutableLiveData(false)
    val isCustomCheckboxChecked = _isCustomCheckboxChecked

    // Labeled Checkbox
    private val _isCustomLabeledCheckboxChecked = MutableLiveData(false)
    val isCustomLabeledCheckboxChecked = _isCustomLabeledCheckboxChecked

    // Switch
    private val _isCustomSwitchChecked = MutableLiveData(false)
    val isCustomSwitchChecked = _isCustomSwitchChecked

    /**
     * ButtonActivity observes _onCustomButtonClicked
     * and calls this function when uses clicks the button.
     */
    fun clickCustomButton() {
        _onCustomButtonClicked.value = true
    }

    /**
     * Toggle the checkbox. All observers will receive the changed
     * value. Composable observers will recompose.
     */
    fun checkCustomCheckbox() {
        // LiveDatas are nullable. If null, default to false.
        val isChecked = _isCustomCheckboxChecked.value ?: false

        _isCustomCheckboxChecked.value = !isChecked
    }

    fun checkCustomLabeledCheckbox() {
        // LiveDatas are nullable. If null, default to false.
        val isChecked = _isCustomLabeledCheckboxChecked.value ?: false

        _isCustomLabeledCheckboxChecked.value = !isChecked
    }

    /**
     * Toggle the switch. All observers will receive the changed
     * value. Composable observers will recompose.
     */
    fun checkCustomSwitch() {
        // LiveDatas are nullable. If null, default to false.
        val isChecked = _isCustomSwitchChecked.value ?: false

        _isCustomSwitchChecked.value = !isChecked
    }
}