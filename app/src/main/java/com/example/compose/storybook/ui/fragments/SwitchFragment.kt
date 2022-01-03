package com.example.compose.storybook.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.*
import com.example.compose.storybook.R
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.MainActivity
import com.example.udemy.compose.firstapp.ui.theme.StorybookTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.compose.storybook.databinding.FragmentSwitchBinding
// composables module imports
import com.example.compose.ui.components.ComposeSwitch
import com.example.compose.ui.components.ComposeSwitchWithLabel

@AndroidEntryPoint
class SwitchFragment : AppBaseFragment() {
    lateinit var binding: FragmentSwitchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSwitchBinding.inflate(inflater)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val switch = binding.composeSwitch
        val switchWithLabel = binding.composeSwitchWithLabel

        switch.setContent {
            StorybookTheme { // or AppCompatTheme or CustomTheme
                Column(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.material_medium)),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    ComposeSwitch(
                        isChecked = true,
                        onCheckedChange = { isChecked ->
                            if (isChecked) {
                                Toast.makeText(
                                    requireContext(), "Switch is ON!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Toast.makeText(
                                    requireContext(), "Switch is OFF!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            viewModel.onSwitchToggled(isChecked)
                        }
                    )
                }
            }
        }

        switchWithLabel.setContent {
            StorybookTheme { // or AppCompatTheme or CustomTheme
                Column(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.material_medium)),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    ComposeSwitchWithLabel(
                        isChecked = false,
                        onCheckedChange = { isChecked ->
                            if (isChecked) {
                                Toast.makeText(
                                    requireContext(), "Switch is ON!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Toast.makeText(
                                    requireContext(), "Switch is OFF!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            viewModel.onSwitchWithLabelToggled()
                        }
                    )
                }
            }
        }
    }

    override fun setupAppBar(showAppTitleAndIcon: Boolean, title: String) {
        (requireActivity() as MainActivity).showAppTitleAndIcon(
            false,
            getString(R.string.toggle_switch)
        )
    }
}



