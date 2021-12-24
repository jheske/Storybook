package com.example.compose.storybook.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class AppBaseFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAppBar()
    }

    abstract fun setupAppBar(
        showAppTitleAndIcon: Boolean = true,
        title: String = ""
    )
}