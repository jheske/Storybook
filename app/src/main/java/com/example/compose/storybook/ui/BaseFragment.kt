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
        setupObservers()
    }

    abstract fun setupAppBar(
        showAppTitleAndIcon: Boolean = true,
        title: String = ""
    )

    /**
     * A typical View's-based app will observe and respond to changes to LiveData values
     * in a ViewModel.
     *
     * Most custom components will have associated LiveData values in
     * StorybookViewModel. Use this function to set up observers.
     * If there aren't any, just add a placeholder to the Fragment:
     *
     *   override fun setupObservers() { /** NO OP **/ }
     */
    abstract fun setupObservers()
}