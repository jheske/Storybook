package com.example.compose.storybook.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.compose.storybook.R
import com.example.compose.storybook.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navGraph = navController.graph)
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration)
    }

    fun showAppTitleAndIcon(show: Boolean = true, title: String="") {
        if (show) {
            binding.titleTextView.visibility = View.VISIBLE
            binding.appLogoImageView.visibility = View.VISIBLE
        } else {
            binding.titleTextView.visibility = View.GONE
            binding.appLogoImageView.visibility = View.GONE
        }
        // This is the Navigation toolbar title that shows up next to the Up button
        // on inner pages.
        binding.toolbar.title = title
    }
}