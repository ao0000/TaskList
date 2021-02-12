package me.aofz.tasklist.ui.tasklist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.wada811.viewbinding.viewBinding
import com.xwray.groupie.*
import dagger.hilt.android.AndroidEntryPoint
import me.aofz.tasklist.R
import me.aofz.tasklist.databinding.ListFragmentBinding
import me.aofz.tasklist.ui.tasklist.item.TaskItem

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.list_fragment) {

    private val listFragmentBinding by viewBinding(ListFragmentBinding::bind)
    private val listViewModel by viewModels<ListViewModel>()

    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listFragmentBinding.viewModel = listViewModel
        setUpRecyclerAdapter()
        setUpAddButton()
    }

    private fun setUpAddButton() {
        listViewModel.addButtonClicked.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().navigate(R.id.action_listFragment_to_addFragment)
            }
        })
    }

    private fun setUpRecyclerAdapter() {
        listFragmentBinding.listRecyclerView.adapter = adapter
        adapter.setOnItemClickListener { item, view ->
            val taskItem = item as TaskItem
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(taskItem.task)
            findNavController().navigate(action)
        }

        listViewModel.allTask.observe(viewLifecycleOwner, Observer {
            it?.let { taskList ->
                adapter.update(mutableListOf<Group>().apply {
                    taskList.forEach {
                        add(TaskItem(it))
                    }
                })
            }
        })

    }


}
