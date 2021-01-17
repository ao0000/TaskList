package me.aofz.tasklist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
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

        binding.addButton.setOnClickListener{
            it.findNavController().popBackStack()
        }

        return binding.root
    }
}