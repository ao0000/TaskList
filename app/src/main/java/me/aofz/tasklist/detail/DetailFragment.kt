package me.aofz.tasklist.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import me.aofz.tasklist.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DetailFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }
}