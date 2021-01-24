package me.aofz.tasklist.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import me.aofz.tasklist.databinding.DetailFragmentBinding
import me.aofz.tasklist.ext.getViewModelFactory

class DetailFragment : Fragment() {

    private lateinit var binding: DetailFragmentBinding
    private val viewmodel by viewModels<DetailViewModel> { getViewModelFactory() }
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DetailFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        val task = args.taskContent

        binding.apply {
            binding.titleText.text = task.title
            binding.descriptionText.text = task.description
        }

        binding.deleteButton.setOnClickListener {
            viewmodel.deleteTask(task)
            findNavController().popBackStack()
        }

        return binding.root
    }
}