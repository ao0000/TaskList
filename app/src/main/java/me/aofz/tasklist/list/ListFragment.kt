package me.aofz.tasklist.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.ActivityNavigator
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import me.aofz.tasklist.R
import me.aofz.tasklist.database.Task
import me.aofz.tasklist.databinding.ListFragmentBinding
import me.aofz.tasklist.detail.DetailViewModelFactory
import me.aofz.tasklist.repository.TaskRepository

class ListFragment : Fragment() {

    private lateinit var binding: ListFragmentBinding
    private val viewmodel by viewModels<ListViewModel>{
        val application = requireNotNull(this.activity).application
        val taskRepository = TaskRepository.getInstance(application)
        ListViewModelFactory(taskRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ListFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        val listRecyclerAdapter = ListRecyclerAdapter(this@ListFragment::onClick)
        binding.taskRecyclerView.adapter = listRecyclerAdapter


        viewmodel.allTask.observe(viewLifecycleOwner, Observer {
            listRecyclerAdapter.setData(it)
        })



        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }


        return binding.root
    }

    private fun onClick(view: View, position: Int){
        viewmodel.navigateToDetailfragment(view,position)
    }
}
