package me.aofz.tasklist.ui.addtask

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import me.aofz.tasklist.databinding.AddFragmentBinding
import com.wada811.viewbinding.viewBinding
import me.aofz.tasklist.R
import org.koin.android.viewmodel.ext.android.viewModel

class AddFragment : Fragment(R.layout.add_fragment) {

    private val addFragmentBinding by viewBinding(AddFragmentBinding::bind)
    private val addViewModel by viewModel<AddViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFragmentBinding.viewModel = addViewModel
        setUpDecideButton()
    }

    private fun setUpDecideButton() {
        addViewModel.decideButtonClicked.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().popBackStack()
            }
        })
    }
}