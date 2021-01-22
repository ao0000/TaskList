package me.aofz.tasklist.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import me.aofz.tasklist.databinding.DetailFragmentBinding
import me.aofz.tasklist.getViewModelFactory

class DetailFragment : Fragment() {

    private lateinit var binding: DetailFragmentBinding
    private val viewmodel by viewModels<DetailViewModel> { getViewModelFactory() }
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val content = args.TaskContent


        val binding = DetailFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        binding.apply {
            binding.titleText.text = content.title
            binding.descriptionText.text = content.description
        }

        binding.deleteButton.setOnClickListener {
            viewmodel.deleteTask(content)
            findNavController().popBackStack()
        }

        return binding.root
    }
}