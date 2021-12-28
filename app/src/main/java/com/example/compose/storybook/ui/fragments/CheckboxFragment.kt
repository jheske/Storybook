package com.example.compose.storybook.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose.storybook.R
import com.example.compose.storybook.databinding.FragmentCheckboxBinding
import com.example.compose.storybook.ui.AppBaseFragment
import com.example.compose.storybook.ui.activities.MainActivity
import com.example.udemy.compose.firstapp.ui.theme.StorybookTheme

class CheckboxFragment : AppBaseFragment() {
    lateinit var binding: FragmentCheckboxBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCheckboxBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val greeting = binding.composeCheckboxWithLabel

        greeting.setContent {
            StorybookTheme { // or AppCompatTheme or CustomTheme
                CustomCheckbox()
            }
        }
    }

    override fun setupAppBar(showAppTitleAndIcon: Boolean, title: String) {
        (requireActivity() as MainActivity).showAppTitleAndIcon(
            false,
            getString(R.string.checkbox)
        )
    }
}

@Composable
private fun CustomCheckbox(
) {
    Row(modifier = Modifier.padding(8.dp)) {
        //val isChecked = remember { mutableStateOf(false) }

//        Checkbox(
//            checked = true,
//            onCheckedChange = { },
//            enabled = true,
//            colors = CheckboxDefaults.colors(Color.Green)
//        )
        Text(
            text = "Check Box with Label",
            style = MaterialTheme.typography.h4.copy(
                Color.Black
            ),)
    }
}

