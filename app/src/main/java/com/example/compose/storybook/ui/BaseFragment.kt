package com.example.compose.storybook.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

abstract class AppBaseFragment : Fragment() {
    val viewModel by viewModels<StorybookViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAppBar()
    }

    abstract fun setupAppBar(
        showAppTitleAndIcon: Boolean = true,
        title: String = ""
    )
}