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

    private lateinit var listFragmentBinding: ListFragmentBinding

    private val listViewModel by viewModels<ListViewModel> { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listFragmentBinding = ListFragmentBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            viewModel = listViewModel
        }
        return listFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerAdapter()
        listViewModel.addButtonClicked.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().navigate(R.id.action_listFragment_to_addFragment)
            }
        })
    }

    private fun setUpRecyclerAdapter() {
        val listRecyclerAdapter = ListRecyclerAdapter(this@ListFragment::onClick)
        listFragmentBinding.listRecyclerView.adapter = listRecyclerAdapter
        subscribeUI(listRecyclerAdapter)
    }

    private fun subscribeUI(adapter: ListRecyclerAdapter) {
        listViewModel.allTask.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
    }

    private fun onClick(view: View, task: Task) {
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(task)
        findNavController().navigate(action)
    }

}
