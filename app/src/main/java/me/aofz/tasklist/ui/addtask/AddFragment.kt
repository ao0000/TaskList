package me.aofz.tasklist.ui.addtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import me.aofz.tasklist.databinding.AddFragmentBinding
import me.aofz.tasklist.ext.getViewModelFactory

class AddFragment : Fragment() {

    private lateinit var addFragmentBinding: AddFragmentBinding
    private val addViewModel by viewModels<AddViewModel> { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addFragmentBinding = AddFragmentBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            viewModel = addViewModel
        }
        return addFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpDecideButton()
    }

    private fun setUpDecideButton() {
        addViewModel.updateTask.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().popBackStack()
            }
        })
    }
}