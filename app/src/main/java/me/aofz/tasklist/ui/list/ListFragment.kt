package me.aofz.tasklist.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import me.aofz.tasklist.R
import me.aofz.tasklist.databinding.ListFragmentBinding
import me.aofz.tasklist.ext.getViewModelFactory
import me.aofz.tasklist.model.Task

class ListFragment : Fragment() {

    private lateinit var binding: ListFragmentBinding

    private val viewmodel by viewModels<ListViewModel> { getViewModelFactory() }

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
        subscribeUI(listRecyclerAdapter)

        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }


        return binding.root
    }

    private fun subscribeUI(adapter: ListRecyclerAdapter) {
        viewmodel.allTask.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    private fun onClick(view: View, task: Task) {
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(task)
        findNavController().navigate(action)
    }

}
