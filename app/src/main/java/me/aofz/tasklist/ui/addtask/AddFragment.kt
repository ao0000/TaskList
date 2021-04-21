package me.aofz.tasklist.ui.addtask

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.wada811.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import me.aofz.tasklist.R
import me.aofz.tasklist.databinding.AddFragmentBinding

@AndroidEntryPoint
class AddFragment : Fragment(R.layout.add_fragment) {

    private val binding: AddFragmentBinding by viewBinding(AddFragmentBinding::bind)
    private val viewModel: AddViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        setUpDecideButton()
    }

    private fun setUpDecideButton() {
        viewModel.decideButtonClicked.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().popBackStack()
            }
        })
    }
}