package com.example.compose.storybook.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.compose.storybook.R
import com.example.compose.storybook.databinding.FragmentTextFieldBinding
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.MainActivity
import com.example.compose.ui.components.ComposeTextInput
import com.example.udemy.compose.firstapp.ui.theme.StorybookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TextFieldFragment : AppBaseFragment() {
    lateinit var binding: FragmentTextFieldBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTextFieldBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val composeTextField = binding.composeTextField
        val composeNumericTextField = binding.composeNumericTextField

        composeTextField.setContent {
            StorybookTheme { // or AppCompatTheme or CustomTheme
                Column(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.material_medium)),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    ComposeTextInput(
                        value = "Initial Text",
                        onValueChange = { text ->
                            viewModel.setTextValue(text)
                        },
                        /**
                         * KeyboardType.Ascii (default)
                         * KeyboardType.Text
                         * KeyboardType.Number
                         * KeyboardType.Password
                         * KeyboardType.NumberPassword
                         * KeyboardType.Email
                         * KeyboardType.Uri
                         */
                        keyboardType = KeyboardType.Text
                    )
                }
            }
        }

        composeNumericTextField.setContent {
            StorybookTheme { // or AppCompatTheme or CustomTheme
                Column(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.material_medium)),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    ComposeTextInput(
                        value = "0",
                        onValueChange = { text ->
                            viewModel.setTextValue(text)
                        },
                        keyboardType = KeyboardType.Number
                    )
                }
            }
        }
    }

    override fun setupAppBar(showAppTitleAndIcon: Boolean, title: String) {
        (requireActivity() as MainActivity).showAppTitleAndIcon(
            false,
            getString(R.string.text_field)
        )
    }
}


