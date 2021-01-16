package me.aofz.tasklist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.aofz.tasklist.databinding.AddFragmentBinding

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = AddFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }
}