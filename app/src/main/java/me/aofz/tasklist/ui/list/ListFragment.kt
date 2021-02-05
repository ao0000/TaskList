package me.aofz.tasklist.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.wada811.viewbinding.viewBinding
import me.aofz.tasklist.R
import me.aofz.tasklist.databinding.ListFragmentBinding
import me.aofz.tasklist.model.Task
import org.koin.android.viewmodel.ext.android.viewModel

class ListFragment : Fragment(R.layout.list_fragment) {

    private val listFragmentBinding by viewBinding(ListFragmentBinding::bind)
    private val listViewModel by viewModel<ListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listFragmentBinding.viewModel = listViewModel
        setUpRecyclerAdapter()
        listViewModel.addButtonClicked.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().navigate(R.id.action_listFragment_to_addFragment)
            }
        })
    }

    private fun setUpRecyclerAdapter() {
        val listRecyclerAdapter = ListRecyclerAdapter(this::onClick)
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
