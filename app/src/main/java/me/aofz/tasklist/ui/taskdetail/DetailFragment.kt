package me.aofz.tasklist.ui.taskdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import me.aofz.tasklist.databinding.DetailFragmentBinding
import me.aofz.tasklist.ext.getViewModelFactory

class DetailFragment : Fragment() {

    private lateinit var detailFragmentBinding: DetailFragmentBinding
    private val detailViewModel by viewModels<DetailViewModel> { getViewModelFactory() }
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailFragmentBinding = DetailFragmentBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            viewModel = detailViewModel
        }
        return detailFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTask()
        setUpDeleteButton()
    }

    private fun setUpDeleteButton() {
        detailViewModel.taskDeleted.observe(viewLifecycleOwner, Observer {
            findNavController().popBackStack()
        })
    }

    private fun setUpTask() {
        val initialTask = args.receivedTask
        detailViewModel.setUpTask(initialTask)
    }
}