package com.example.compose.storybook.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.livedata.observeAsState
import com.example.compose.storybook.R
import com.example.compose.storybook.databinding.FragmentCheckboxBinding
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.MainActivity
import com.example.udemy.compose.firstapp.ui.theme.StorybookTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.getValue
// Composables module
import com.example.compose.ui.components.CustomLabeledCheckbox


@AndroidEntryPoint
class CheckboxFragment : AppBaseFragment() {
    lateinit var binding: FragmentCheckboxBinding
    lateinit var toast: Toast

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
                // or observeAsState won't work!!!!
                val isCheckedObservable by viewModel.checkboxIsSelected.observeAsState(false)

                CustomLabeledCheckbox(
                    isChecked = isCheckedObservable,
                    onCheckedChange = {
                        viewModel.checkCustomCheckbox()
                    }
                )
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
        viewModel.onCustomButtonClicked.observe(viewLifecycleOwner, { buttonClicked ->
            if (buttonClicked) {
                Toast.makeText(requireContext(), "Button!", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.checkboxIsSelected.observe(viewLifecycleOwner, { checkboxChecked ->
            if (checkboxChecked) {
                Toast.makeText(requireContext(), "Checkbox is checked!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Checkbox is unchecked!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}


