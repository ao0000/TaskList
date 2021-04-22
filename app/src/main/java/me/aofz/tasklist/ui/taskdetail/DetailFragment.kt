package me.aofz.tasklist.ui.taskdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.wada811.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import me.aofz.tasklist.R
import me.aofz.tasklist.databinding.DetailFragmentBinding
import me.aofz.tasklist.model.Task

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.detail_fragment) {

    private val binding: DetailFragmentBinding by viewBinding(DetailFragmentBinding::bind)

    private val detailViewModel: DetailViewModel by viewModels()

    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = detailViewModel
        setUpTask()
        setUpDeleteButton()
    }

    private fun setUpDeleteButton() {
        detailViewModel.deleteButtonClicked.observe(
            viewLifecycleOwner,
            Observer {
                findNavController().popBackStack()
            }
        )
    }

    private fun setUpTask() {
        val initialTask: Task = args.receivedTask
        detailViewModel.setUpTask(initialTask)
    }
}