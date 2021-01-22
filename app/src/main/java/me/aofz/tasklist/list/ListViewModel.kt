package me.aofz.tasklist.list

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController

class ListViewModel : ViewModel() {

    fun navigateToDetailfragment(view: View, position: Int) {
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(position)
        view.findNavController().navigate(action)
    }
}