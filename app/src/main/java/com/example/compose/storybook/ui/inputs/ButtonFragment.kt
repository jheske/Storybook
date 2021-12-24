package com.example.compose.storybook.ui.inputs

import android.widget.Toast
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import android.os.Bundle
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.compose.storybook.R
import com.example.compose.storybook.databinding.FragmentButtonBinding
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.MainActivity
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

        val greeting = binding.greeting

        greeting.setContent {
            MdcTheme { // or AppCompatTheme
                //Greeting()
                CustomButton(
                    onClick = {
                        Toast.makeText(requireContext(), "Button!", Toast.LENGTH_LONG).show()
                    },
                    shape = RoundedCornerShape(20.dp),
                    text = "Button!",
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
    ) {
        Text(text = "This is a button!")
    }
}

@Composable
private fun Greeting() {
    Text(
        text = stringResource(R.string.app_name),
        style = MaterialTheme.typography.h5,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.material_small))
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}
