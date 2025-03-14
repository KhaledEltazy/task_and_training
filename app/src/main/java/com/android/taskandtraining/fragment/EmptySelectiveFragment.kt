package com.android.taskandtraining.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.taskandtraining.adapter.MyAdapter
import com.android.taskandtraining.databinding.FragmentEmptySelectiveBinding
import com.android.taskandtraining.single_responsibility.Countries
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EmptySelectiveFragment : Fragment() {
    lateinit var binding : FragmentEmptySelectiveBinding

    @Inject
    lateinit var myAdapter : MyAdapter

    @Inject
    lateinit var countries : Countries

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmptySelectiveBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(countries.getCountries)
        myAdapter.itemSelected = {item,view->
            Toast.makeText(requireContext(),"you select $item",Toast.LENGTH_SHORT).show()
        }



    }

    private fun setRecyclerView(list: List<String>) {
        myAdapter.setData(list,false,false,false)
        myAdapter.itemSelected = { item, view ->
            Toast.makeText(view.context, "Clicked on $item", Toast.LENGTH_SHORT).show()
        }
        binding.listItemRv3.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        }
    }
}