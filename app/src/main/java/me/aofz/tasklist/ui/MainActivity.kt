package me.aofz.tasklist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import github.com.st235.lib_expandablebottombar.navigation.ExpandableBottomBarNavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import me.aofz.tasklist.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.nav_Host_fragment)
        ExpandableBottomBarNavigationUI.setupWithNavController(bottom_bar, navController)
    }
}