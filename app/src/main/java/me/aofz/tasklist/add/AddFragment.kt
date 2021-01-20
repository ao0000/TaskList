package me.aofz.tasklist.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import me.aofz.tasklist.databinding.AddFragmentBinding

class AddFragment : Fragment() {

    private lateinit var binding: AddFragmentBinding
    private val viewmodel by viewModels<AddViewModel>()

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
            findNavController().popBackStack()
        }

        return binding.root
    }
}