package com.reachplc.interview.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.reachplc.interview.R
import com.reachplc.interview.adapters.RecyclerViewAdapter
import com.reachplc.interview.data.remote.ProductsResponse
import com.reachplc.interview.databinding.FragmentListBinding


class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var viewModel: ListViewModel
    private lateinit var binding: FragmentListBinding
    private val recyclerViewAdapter = RecyclerViewAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        binding = FragmentListBinding.bind(view)

        observeViewModel()

        binding.itemRecyclerViewList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = recyclerViewAdapter
        }
    }


    private fun observeViewModel() {
        viewModel.getBeautyProducts()
        viewModel.beautyProducts.observe(viewLifecycleOwner) {
            it?.let {
                binding.itemRecyclerViewList.visibility = View.VISIBLE
                recyclerViewAdapter.updateList(it)
            }
            recyclerViewAdapter.setOnItemClickListener {
                val extras = FragmentNavigatorExtras(binding.itemRecyclerViewList to "image_big")
                val action = ListFragmentDirections.actionFragmentListToDetailFragment(it)
                findNavController().navigate(action,extras)
                Toast.makeText(requireContext(), "You've clicked ${it.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}