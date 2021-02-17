package me.aofz.tasklist.ui.tasklist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.wada811.viewbinding.viewBinding
import com.xwray.groupie.*
import dagger.hilt.android.AndroidEntryPoint
import me.aofz.tasklist.R
import me.aofz.tasklist.databinding.ListFragmentBinding
import me.aofz.tasklist.ext.hideKeyboard
import me.aofz.tasklist.ui.tasklist.item.TaskItem

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.list_fragment) {

    private val listFragmentBinding by viewBinding(ListFragmentBinding::bind)
    private val listViewModel by viewModels<ListViewModel>()

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private val taskSection = Section()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listFragmentBinding.viewModel = listViewModel
        hideKeyboard()

        groupAdapter.apply {
            setOnItemClickListener(onItemClickListener)
        }

        listFragmentBinding.listRecyclerView.apply {
            this.adapter = groupAdapter
            ItemTouchHelper(touchCallback).attachToRecyclerView(this)
        }
        observeList()
    }

    private val onItemClickListener = OnItemClickListener { item, _ ->
        val taskItem = item as TaskItem
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(taskItem.task)
        findNavController().navigate(action)
    }

    private fun observeList() {
        listViewModel.allTask.observe(viewLifecycleOwner, Observer {
            it?.let {
                val listInSection = mutableListOf<Group>()
                it.forEach {
                    listInSection.add(TaskItem(it))
                }
                taskSection.update(listInSection)
                groupAdapter.update(listOf(taskSection))
            }
        })
    }

    private val touchCallback: TouchCallback by lazy {
        object : TouchCallback() {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun isItemViewSwipeEnabled(): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = groupAdapter.getItem(viewHolder.adapterPosition) as TaskItem
                listViewModel.deleteTask(item.task)
                taskSection.remove(item)
            }
        }
    }

}
