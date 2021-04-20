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
import dagger.hilt.android.AndroidEntryPoint
import me.aofz.tasklist.R
import me.aofz.tasklist.databinding.ListFragmentBinding
import me.aofz.tasklist.ext.hideKeyboard
import me.aofz.tasklist.model.Task

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.list_fragment) {

    private val listFragmentBinding by viewBinding(ListFragmentBinding::bind)
    private val listViewModel by viewModels<ListViewModel>()

    private val adapter = TaskListAdapter { item: Task ->
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(item)
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listFragmentBinding.lifecycleOwner = viewLifecycleOwner
        listFragmentBinding.viewModel = listViewModel
        hideKeyboard()

        listFragmentBinding.listRecyclerView.adapter = adapter
        initSwiped()
        observeList()
    }

    private fun observeList() {
        listViewModel.allTask.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
    }


    private fun initSwiped() {
        ItemTouchHelper(
            object : ItemTouchHelper.Callback() {
                override fun getMovementFlags(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder
                ): Int = makeMovementFlags(
                    0,
                    ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
                )

                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean = false

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val taskViewHolder: TaskViewHolder = viewHolder as TaskViewHolder
                    taskViewHolder.value?.let {
                        listViewModel.deleteTask(it)
                    }
                }
            }
        ).attachToRecyclerView(listFragmentBinding.listRecyclerView)
    }

}
