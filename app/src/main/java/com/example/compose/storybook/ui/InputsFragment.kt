package com.example.compose.storybook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.compose.storybook.databinding.FragmentInputsBinding
import com.example.compose.storybook.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputsFragment: Fragment() {

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

    fun setupClickListeners() {
        binding.buttonButton.setOnClickListener {
            findNavController().navigate(InputsFragmentDirections.actionInputsFragmentToButtonsFragment())
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