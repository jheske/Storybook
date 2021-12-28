package com.example.compose.storybook.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StorybookViewModel: ViewModel() {

    // _onCustomButtonClicked is the private backing value for
    // the public onCustomButtonClicked. Th
    // Any Activity or Fragment can observe onCustomButtonClicked
    // and respond to changes (eg., ButtonFragment.setupObservers()).
    private val _onCustomButtonClicked = MutableLiveData(false)
    val onCustomButtonClicked = _onCustomButtonClicked

    fun clickCustomButton() {
        // ButtonActivity observes this change.
        _onCustomButtonClicked.value = true
    }
}