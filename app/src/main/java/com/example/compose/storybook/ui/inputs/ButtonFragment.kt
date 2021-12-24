package com.example.compose.storybook.ui.inputs

import android.widget.Toast
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import android.os.Bundle
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.compose.storybook.R
import com.example.compose.storybook.databinding.FragmentButtonBinding
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.MainActivity
import com.example.udemy.compose.firstapp.ui.theme.StorybookTheme
import com.google.android.material.composethemeadapter.MdcTheme

class ButtonFragment : AppBaseFragment() {
    lateinit var binding: FragmentButtonBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentButtonBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val greeting = binding.composeButton

        greeting.setContent {
            StorybookTheme { // or AppCompatTheme or CustomTheme
                //Greeting()
                CustomButton(
                    onClick = {
                        Toast.makeText(requireContext(), "Button!", Toast.LENGTH_LONG).show()
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

