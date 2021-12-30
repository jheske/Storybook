package com.example.compose.storybook.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.livedata.observeAsState
import com.example.compose.storybook.R
import com.example.compose.storybook.databinding.FragmentCheckboxBinding
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.MainActivity
import com.example.udemy.compose.firstapp.ui.theme.StorybookTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
// composables module imports
import com.example.compose.ui.components.ComposeCheckbox
import com.example.compose.ui.components.ComposeLabeledCheckbox

@AndroidEntryPoint
class CheckboxFragment : AppBaseFragment() {
    lateinit var binding: FragmentCheckboxBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCheckboxBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkbox = binding.composeCheckbox
        val checkboxWithLabel = binding.composeCheckboxWithLabel

        checkbox.setContent {
            StorybookTheme { // or AppCompatTheme or CustomTheme
                // !!!!WARNING: You have to manually add
                //
                //        import androidx.compose.runtime.getValue
                //
                // or observeAsStates won't compile!!!!
                Column(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.material_medium)),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    /**
                     * StorybookViewModel uses LiveDatas for observing changes to the checkbox states,
                     * which is typical for legacy apps, but can't be used with Composables.
                     * To use a LiveData, pass it to the Composable as an observableState.
                     * The Composable will observe obersevableState and recompose when
                     * the user clicks on the checkbox.
                     */
                    val isCheckboxCheckedObservable by viewModel.isComposeCheckboxChecked
                        .observeAsState(false)

                    ComposeCheckbox(
                        isChecked = isCheckboxCheckedObservable,
                        onCheckedChange = {
                            viewModel.checkComposeCheckbox()
                        }
                    )
                }
            }
        }

        checkboxWithLabel.setContent {
            StorybookTheme { // or AppCompatTheme or CustomTheme
                // !!!!WARNING: You have to manually add
                //
                //        import androidx.compose.runtime.getValue
                //
                // or observeAsStates won't compile!!!!
                Column(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.material_medium)),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    /**
                     * StorybookViewModel uses LiveDatas for observing changes to the checkbox states,
                     * which is typical for legacy apps, but can't be used with Composables.
                     * To use a LiveData, pass it to the Composable as an observableState.
                     * The Composable will observe obersevableState and recompose when
                     * the user clicks on the checkbox.
                     */
                    val isLabeledCheckboxCheckedObservable by viewModel.isComposeLabeledCheckboxChecked
                        .observeAsState(false)

                    ComposeLabeledCheckbox(
                        isChecked = isLabeledCheckboxCheckedObservable,
                        onCheckedChange = {
                            viewModel.checkComposeLabeledCheckbox()
                        }
                    )
                }
            }
        }
    }

    override fun setupAppBar(showAppTitleAndIcon: Boolean, title: String) {
        (requireActivity() as MainActivity).showAppTitleAndIcon(
            false,
            getString(R.string.checkbox)
        )
    }

    override fun setupObservers() {
        viewModel.isComposeCheckboxChecked.observe(viewLifecycleOwner, { isChecked ->
            if (isChecked) {
                Toast.makeText(requireContext(), "Checkbox is checked!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Checkbox is unchecked!", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}



