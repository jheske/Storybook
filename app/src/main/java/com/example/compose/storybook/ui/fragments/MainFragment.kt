package com.example.compose.storybook.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.compose.storybook.databinding.FragmentMainBinding
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : AppBaseFragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    override fun setupAppBar(showAppTitleAndIcon: Boolean, title: String) {
        (requireActivity() as MainActivity).showAppTitleAndIcon()
    }

    override fun setupObservers() {
        /** NO OP **/
    }

    private fun setupClickListeners() {
        binding.gettingStartedButton.setOnClickListener {

        }
        binding.helperClassesButton.setOnClickListener {

        }
        binding.surfacesButton.setOnClickListener {

        }
        binding.alertsButton.setOnClickListener {

        }
        binding.gettingStartedButton.setOnClickListener {

        }
        binding.contentButton.setOnClickListener {

        }
        binding.inputsButton.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToInputsFragment())
        }
        binding.navigationButton.setOnClickListener {

        }
        binding.progressButton.setOnClickListener {

        }
    }
}