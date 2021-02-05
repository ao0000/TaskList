package me.aofz.tasklist.ui.taskdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.wada811.viewbinding.viewBinding
import me.aofz.tasklist.R
import me.aofz.tasklist.databinding.DetailFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : Fragment(R.layout.detail_fragment) {

    private val detailFragmentBinding by viewBinding(DetailFragmentBinding::bind)
    private val detailViewModel by viewModel<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailFragmentBinding.viewModel = detailViewModel
        setUpTask()
        setUpDeleteButton()
    }

    private fun setUpDeleteButton() {
        detailViewModel.deleteButtonClicked.observe(viewLifecycleOwner, Observer {
            findNavController().popBackStack()
        })
    }

    private fun setUpTask() {
        val initialTask = args.receivedTask
        detailViewModel.setUpTask(initialTask)
    }
}