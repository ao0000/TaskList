package me.aofz.tasklist.ui.addtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import me.aofz.tasklist.databinding.AddFragmentBinding
import me.aofz.tasklist.ext.getViewModelFactory

class AddFragment : Fragment() {

    private lateinit var binding: AddFragmentBinding
    private val addViewModel by viewModels<AddViewModel> { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        binding.viewmodel = addViewModel

        binding.decideButton.setOnClickListener {
            addViewModel.addTask()
            findNavController().popBackStack()
        }

        return binding.root
    }
}