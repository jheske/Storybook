package com.example.compose.storybook.ui.inputs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.compose.storybook.R
import com.example.compose.storybook.databinding.FragmentInputsBinding
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputsFragment : AppBaseFragment() {

    lateinit var binding: FragmentInputsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInputsBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    override fun setupAppBar(showAppTitleAndIcon: Boolean, title: String) {
        (requireActivity() as MainActivity).showAppTitleAndIcon(
            false,
            getString(R.string.inputs)
        )
    }

    private fun setupClickListeners() {
        binding.buttonButton.setOnClickListener {
            findNavController().navigate(InputsFragmentDirections.actionInputsFragmentToButtonFragment())
        }
        binding.checkboxButton.setOnClickListener {

        }
        binding.dropdownButton.setOnClickListener {

        }
        binding.inputButton.setOnClickListener {

        }
        binding.phoneputButton.setOnClickListener {

        }
        binding.pinputButton.setOnClickListener {

        }
        binding.radioButton.setOnClickListener {

        }
        binding.toggleSwitchButton.setOnClickListener {

        }
        binding.textareaButton.setOnClickListener {

        }
    }
}