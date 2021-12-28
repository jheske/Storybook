package com.example.compose.storybook.ui.fragments

import android.widget.Toast
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.example.compose.storybook.R
import com.example.compose.storybook.databinding.FragmentButtonBinding
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.activities.MainActivity
import com.example.compose.storybook.ui.StorybookViewModel
import com.example.udemy.compose.firstapp.ui.theme.StorybookTheme

class ButtonFragment : AppBaseFragment() {
    lateinit var binding: FragmentButtonBinding
    val viewModel by viewModels<StorybookViewModel>()

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
        setupObservers()

        composeButton.setContent {
            StorybookTheme { // or AppCompatTheme or CustomTheme
                CustomButton(
                    onClick = {
                        // Most apps use ViewModels
                        // The button should call a function inside the viewModel.
                        // The viewModel will probably do some stuff, then set a LiveData (equivalent
                        // to Compose's MutableStates).
                        // Activities and Fragments "observe" LiveData values for changes.
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

    /**
     * A typical View's-based app will observe and respond to changes to LiveData values
     * in the ViewModel.
     */
    private fun setupObservers() {
        viewModel.onCustomButtonClicked.observe(viewLifecycleOwner, { buttonClicked ->
            if (buttonClicked  ) {
                Toast.makeText(requireContext(), "Button!", Toast.LENGTH_SHORT ).show()
            }
        })
    }
}

@Composable
private fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    text: String = ""
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        contentPadding = PaddingValues(
            horizontal = dimensionResource(id = R.dimen.compose_button_padding_horizontal),
            vertical = dimensionResource(id = R.dimen.compose_button_padding_vertical)
        )
    ) {
        Text(text = text)
    }
}

