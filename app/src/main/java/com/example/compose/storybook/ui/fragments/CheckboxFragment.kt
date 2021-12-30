package com.example.compose.storybook.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.*
import com.example.compose.storybook.R
import com.example.compose.storybook.databinding.FragmentCheckboxBinding
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.MainActivity
import com.example.udemy.compose.firstapp.ui.theme.StorybookTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
// composables module imports
import com.example.compose.ui.components.ComposeCheckbox
import com.example.compose.ui.components.ComposeCheckboxWithLabel

@AndroidEntryPoint
class CheckboxFragment : AppBaseFragment() {
    lateinit var binding: FragmentCheckboxBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCheckboxBinding.inflate(inflater)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this   // Required for xml data bindings
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkbox = binding.composeCheckbox
        val checkboxWithLabel = binding.composeCheckboxWithLabel

        checkbox.setContent {
            StorybookTheme { // or AppCompatTheme or CustomTheme
                Column(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.material_medium)),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    ComposeCheckbox(
                        isChecked = false,
                        onCheckedChange = { isChecked ->
                            if (isChecked) {
                                Toast.makeText(requireContext(),"Checkbox is checked!",
                                    Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(requireContext(),"Checkbox is unchecked!",
                                    Toast.LENGTH_SHORT).show()
                            }
                            viewModel.onCheckboxClicked()
                        }
                    )
                }
            }
        }

        checkboxWithLabel.setContent {
            StorybookTheme { // or AppCompatTheme or CustomTheme
                Column(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.material_medium)),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    ComposeCheckboxWithLabel(
                        isChecked = false,
                        onCheckedChange = { isChecked ->
                            if (isChecked) {
                                Toast.makeText(requireContext(),"Checkbox is checked!",
                                    Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(requireContext(),"Checkbox is unchecked!",
                                    Toast.LENGTH_SHORT).show()
                            }
                            viewModel.onLabeledCheckboxClicked()
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
}



