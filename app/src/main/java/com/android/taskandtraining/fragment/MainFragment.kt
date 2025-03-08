package com.android.taskandtraining.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.taskandtraining.adapter.MyAdapter
import com.android.taskandtraining.databinding.FragmentMainBinding
import com.android.taskandtraining.single_responsibility.Cities
import com.android.taskandtraining.single_responsibility.Continents
import com.android.taskandtraining.single_responsibility.Countries


class MainFragment : Fragment() {
    lateinit var binding : FragmentMainBinding
    lateinit var myAdapter : MyAdapter
    val countries = Countries()
    val cities = Cities()
    val continents = Continents()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(countries.getCountries)

        binding.apply {
            countriesBtn.setOnClickListener {
                setRecyclerView(countries.getCountries)
            }
            citiesBtn.setOnClickListener {
                setRecyclerView(cities.getCities)
            }
            continentsBtn.setOnClickListener {
                setRecyclerView(continents.getContinents)
            }
        }

    }

    private fun setRecyclerView(list: List<String>) {
        myAdapter = MyAdapter(list)
        myAdapter.itemSelected = { item, view ->
            Toast.makeText(view.context, "Clicked on $item", Toast.LENGTH_SHORT).show()
        }
        binding.listItemRv.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        }
    }
}