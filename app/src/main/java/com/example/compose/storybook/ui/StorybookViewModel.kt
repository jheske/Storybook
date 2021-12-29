package com.example.compose.storybook.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel

class StorybookViewModel : ViewModel() {

    /**
     * _onCustomButtonClicked is the private backing value for
     * the public onCustomButtonClicked.
     * Any Activity, Fragment, etc. can observe onCustomButtonClicked.
     * and respond to changes (eg., ButtonFragment.setupObservers()).
     */
    private val _onCustomButtonClicked = MutableLiveData(false)
    val onCustomButtonClicked = _onCustomButtonClicked

    private val _checkboxIsSelected = MutableLiveData(false)
    val checkboxIsSelected = _checkboxIsSelected

    private val _onCustomCheckboxChecked = MutableLiveData(false)
    val onCustomCustomCheckboxChecked = _onCustomCheckboxChecked

    val list: LiveData<MutableList<String>> = MutableLiveData(mutableListOf("Ana", "Are", "Mere"))


    // ButtonActivity observes _onCustomButtonClicked and calls this function.
    fun clickCustomButton() {
        _onCustomButtonClicked.value = true
    }

    /**
     * Toggle the checkbox.
     */
    fun checkCustomCheckbox() {
        // LiveDatas are nullable. If null, default to false.
        val isChecked = _onCustomCheckboxChecked.value ?: false

        _onCustomCheckboxChecked.value = !isChecked
    }
}