package com.example.compose.storybook.ui.fragments

import android.widget.Toast
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.example.compose.composables.CustomButton
import com.example.compose.storybook.R
import com.example.compose.storybook.databinding.FragmentButtonBinding
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.MainActivity
import com.example.compose.storybook.ui.StorybookViewModel
import com.example.udemy.compose.firstapp.ui.theme.StorybookTheme

class ButtonFragment : AppBaseFragment() {
    lateinit var binding: FragmentButtonBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentButtonBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val composeButton = binding.composeButton

        // Start observing ViewModel values.
        //setupObservers()

        composeButton.setContent {
            StorybookTheme { // or AppCompatTheme or CustomTheme
                CustomButton(
                    onClick = {
                        // Most apps use ViewModels
                        // onClick() should call a function inside the viewModel.
                        // The ViewModel will probably do some stuff, then set a LiveData (equivalent
                        // to Compose's MutableStates).
                        // Activities and Fragments "observe" LiveData values changes.
                        // See setupObservers() below.
                        viewModel.clickCustomButton()
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
        viewModel.onCustomButtonClicked.observe(viewLifecycleOwner, { buttonClicked ->
            if (buttonClicked) {
                Toast.makeText(requireContext(), "Button!", Toast.LENGTH_SHORT ).show()
            }
        })
    }
}


