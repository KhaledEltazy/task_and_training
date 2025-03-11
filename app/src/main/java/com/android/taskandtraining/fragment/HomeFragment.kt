package com.android.taskandtraining.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.android.taskandtraining.R
import com.android.taskandtraining.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            threeSelectiveBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_threeSelectiveFragment)
            }

            twoSelectiveBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_twoSelectiveFragment)
            }

            emptySelectiveBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_emptyFragment)
            }
        }
    }
}