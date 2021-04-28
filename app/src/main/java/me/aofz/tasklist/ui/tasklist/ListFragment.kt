package me.aofz.tasklist.ui.tasklist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.wada811.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import me.aofz.tasklist.R
import me.aofz.tasklist.databinding.ListFragmentBinding
import me.aofz.tasklist.ext.hideKeyboard
import me.aofz.tasklist.model.Task
import me.aofz.tasklist.ui.tasklist.adapter.ListAdapter
import me.aofz.tasklist.ui.tasklist.adapter.TaskViewHolder

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.list_fragment) {

    private val binding: ListFragmentBinding by viewBinding(ListFragmentBinding::bind)

    private val viewModel: ListViewModel by viewModels()

    private val adapter = ListAdapter(this::listItemClicked)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            listRecyclerView.adapter = adapter
            initSwiped(listRecyclerView)
        }

        hideKeyboard()
        observeList()
    }

    private fun observeList() {
        lifecycleScope.launchWhenStarted {
            viewModel.allTask.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun initSwiped(recyclerView: RecyclerView) {
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
                    taskViewHolder.value?.let { task ->
                        viewModel.deleteTask(task)
                    }
                }
            }
        ).attachToRecyclerView(recyclerView)
    }

    private fun listItemClicked(item: Task) {
        val action: NavDirections = ListFragmentDirections.actionListFragmentToDetailFragment(item)
        findNavController().navigate(action)
    }
}
