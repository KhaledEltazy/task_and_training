package com.android.taskandtraining.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.taskandtraining.adapter.MyAdapter
import com.android.taskandtraining.databinding.FragmentThreeSelectiveBinding
import com.android.taskandtraining.single_responsibility.Countries
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ThreeSelectiveFragment : Fragment() {
    lateinit var binding : FragmentThreeSelectiveBinding


    @Inject
    lateinit var myAdapter : MyAdapter

    @Inject
    lateinit var countries : Countries


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeSelectiveBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(countries.getCountries)
        myAdapter.itemSelected = {item,view->
            Toast.makeText(requireContext(),"you selected $item", Toast.LENGTH_SHORT).show()
        }

        myAdapter.addBtnSelected ={
            Toast.makeText(requireContext(),"you selected add Button", Toast.LENGTH_SHORT).show()
        }

        myAdapter.deleteBtnSelected ={
            Toast.makeText(requireContext(),"you selected delete Button", Toast.LENGTH_SHORT).show()
        }

        myAdapter.favBtnSelected ={
            Toast.makeText(requireContext(),"you selected favourite Button", Toast.LENGTH_SHORT).show()
        }

    }

    private fun setRecyclerView(list: List<String>) {
        myAdapter.setData(list,true,true,true)
        myAdapter.itemSelected = { item, view ->
            Toast.makeText(view.context, "Clicked on $item", Toast.LENGTH_SHORT).show()
        }
        binding.listItemRv.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        }
    }
}