package com.example.compose.storybook.ui.fragments

import android.widget.Toast
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.compose.composables.ComposeButton
import com.example.compose.storybook.R
import com.example.compose.storybook.databinding.FragmentButtonBinding
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.MainActivity
import com.example.udemy.compose.firstapp.ui.theme.StorybookTheme

class ButtonFragment : AppBaseFragment() {
    lateinit var binding: FragmentButtonBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentButtonBinding.inflate(inflater)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this    // required for fragment_button data bindings
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val composeButton = binding.composeButton

        composeButton.setContent {
            StorybookTheme { // or AppCompatTheme or CustomTheme
                ComposeButton(
                    onClick = {
                        // Most apps use ViewModels
                        // onClick() can call functions inside the viewModel.
                        // Activities and Fragments "observe" LiveData values changes.
                        // See setupObservers() below.
                        viewModel.onComposeButtonClicked()
                        Toast.makeText(requireContext(), "ComposeButton!", Toast.LENGTH_SHORT).show()
                    },
                    shape = RoundedCornerShape(20.dp),
                    text = stringResource(id = R.string.compose_button),
                )
            }
        }
    }

    override fun setupAppBar(showAppTitleAndIcon: Boolean, title: String) {
        (requireActivity() as MainActivity).showAppTitleAndIcon(
            false,
            getString(R.string.button)
        )
    }

    override fun setupObservers() {
//        viewModel.onComposeButtonClicked.observe(viewLifecycleOwner) { buttonClicked ->
//            if (buttonClicked) {
//                Toast.makeText(requireContext(), "ViewModel observer!", Toast.LENGTH_SHORT).show()
//            }
//        }
    }
}


