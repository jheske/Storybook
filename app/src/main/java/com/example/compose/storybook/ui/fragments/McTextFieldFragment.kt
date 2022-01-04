package com.example.compose.storybook.ui.fragments

import android.os.Bundle
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
import com.example.compose.storybook.databinding.FragmentMcTextFieldBinding
import com.example.compose.storybook.databinding.FragmentTextFieldBinding
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.MainActivity
import com.example.compose.ui.components.*
import com.example.compose.ui.components.McTextField
import com.example.udemy.compose.firstapp.ui.theme.StorybookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class McTextFieldFragment : AppBaseFragment() {
    lateinit var binding: FragmentMcTextFieldBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMcTextFieldBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showMcTextField()
    }

    private fun showMcTextField() {
        val mcTextField = binding.mcTextField

        mcTextField.setContent {
            McTextField(
                value = viewModel.userName,
                onValueChange = { username ->
                    viewModel.updateUserName(username)
                },
                label = "Label",
                placeholder = "Placeholder",
                caption = "Caption",
                leadingIcon = McTextFieldLeadingIcon.PERSON,
            )
        }
    }

    override fun setupAppBar(showAppTitleAndIcon: Boolean, title: String) {
        (requireActivity() as MainActivity).showAppTitleAndIcon(
            false,
            getString(R.string.mctext_field)
        )
    }
}


