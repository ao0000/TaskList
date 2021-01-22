package me.aofz.tasklist.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.ActivityNavigator
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import me.aofz.tasklist.R
import me.aofz.tasklist.database.Task
import me.aofz.tasklist.databinding.ListFragmentBinding

class ListFragment : Fragment() {

    private lateinit var binding: ListFragmentBinding
    private val viewmodel by viewModels<ListViewModel>()

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

        binding.taskRecyclerView.also {
            // tmp data
            val data =
                listOf<Task>(Task(id = 0, title = "sampleTitle", description = "sampleDescription"))

            it.adapter = ListRecyclerAdapter(data, this@ListFragment::onItemClick)
        }

        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return binding.root
    }

    private fun onItemClick(view: View, position: Int) {
        viewmodel.navigateToDetailfragment(view, position)
    }

}
