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

    /*****************************
     * Button
     */
    private val _onComposeButtonClicked = MutableLiveData(false)
    val onComposeButtonClicked = _onComposeButtonClicked

    /**
     * ButtonActivity observes _onComposeButtonClicked
     * and calls this function when uses clicks the button.
     */
    fun clickComposeButton() {
        _onComposeButtonClicked.value = true
    }

    /*****************************
     * TextInput
     */
    private val _textValue = MutableLiveData("")
    val textValue = _textValue

    fun setTextValue(text: String) {
        _textValue.value = text
    }

    /*****************************
     * Checkbox
     */
    private val _isComposeCheckboxChecked = MutableLiveData(false)
    val isComposeCheckboxChecked = _isComposeCheckboxChecked

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
    val isComposeLabeledCheckboxChecked = _isComposeLabeledCheckboxChecked

    fun checkComposeLabeledCheckbox() {
        // LiveDatas are nullable. If null, default to false.
        val isChecked = _isComposeLabeledCheckboxChecked.value ?: false

        _isComposeLabeledCheckboxChecked.value = !isChecked
    }

    /*****************************
     * Switch
     */
    private val _isComposeSwitchChecked = MutableLiveData(false)
    val isComposeSwitchChecked = _isComposeSwitchChecked

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


