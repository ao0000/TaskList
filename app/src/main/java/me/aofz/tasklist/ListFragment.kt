package me.aofz.tasklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import me.aofz.tasklist.databinding.ListFragmentBinding

class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = ListFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        binding.addButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return binding.root
    }
}
