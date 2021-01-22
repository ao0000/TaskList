package me.aofz.tasklist.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import me.aofz.tasklist.database.Task
import me.aofz.tasklist.databinding.AddFragmentBinding
import me.aofz.tasklist.repository.TaskRepository

class AddFragment : Fragment() {

    private lateinit var binding: AddFragmentBinding
    private val viewmodel by viewModels<AddViewModel>{
        val application = requireNotNull(this.activity).application
        val taskRepository = TaskRepository.getInstance(application)
        AddViewModelFractory(taskRepository)
    }

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

        binding.decideButton.setOnClickListener {
//
            val task = Task(
                title = binding.titleEdit.text.toString(),
                description = binding.descriptionEdit.text.toString()
            )
            viewmodel.addTask(task)
            findNavController().popBackStack()
        }

        return binding.root
    }
}