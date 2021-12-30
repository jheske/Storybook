package com.example.compose.storybook.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import com.example.compose.ui.components.CustomCheckbox
// composables module imports
import com.example.compose.ui.components.CustomLabeledCheckbox


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

        val checkboxWithLabel = binding.composeCheckboxWithLabel

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
                    val isCheckboxCheckedObservable by viewModel.isCustomCheckboxChecked
                        .observeAsState(false)

                    val isLabeledCheckboxCheckedObservable by viewModel.isCustomLabeledCheckboxChecked
                        .observeAsState(false)

                    // CustomCheckbox and heading
                    Text(
                        text = "CustomCheckbox",
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(
                        modifier = Modifier.height(dimensionResource(id = R.dimen.material_medium))
                    )
                    CustomCheckbox(
                        isChecked = isCheckboxCheckedObservable,
                        onCheckedChange = {
                            viewModel.checkCustomCheckbox()
                        }
                    )

                    Spacer(
                        modifier = Modifier.height(dimensionResource(id = R.dimen.material_large))
                    )

                    // CustomLabeledCheckbox and heading
                    Text(
                        text = "CustomLabeledCheckbox",
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(
                        modifier = Modifier.height(dimensionResource(id = R.dimen.material_medium))
                    )
                    CustomLabeledCheckbox(
                        isChecked = isLabeledCheckboxCheckedObservable,
                        onCheckedChange = {
                            viewModel.checkCustomLabeledCheckbox()
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
        viewModel.isCustomCheckboxChecked.observe(viewLifecycleOwner, { isChecked ->
            if (isChecked) {
                Toast.makeText(requireContext(), "Checkbox is checked!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Checkbox is unchecked!", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}



