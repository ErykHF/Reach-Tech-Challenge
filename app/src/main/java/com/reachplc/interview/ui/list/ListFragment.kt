package com.reachplc.interview.ui.list

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.wifi.WifiManager
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.reachplc.interview.R
import com.reachplc.interview.adapters.RecyclerViewAdapter
import com.reachplc.interview.databinding.FragmentListBinding
import com.reachplc.interview.networkutils.ConnectionLiveData


class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var viewModel: ListViewModel
    private lateinit var binding: FragmentListBinding
    private val recyclerViewAdapter = RecyclerViewAdapter()
    private lateinit var connectionLiveData: ConnectionLiveData


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        binding = FragmentListBinding.bind(view)
        setHasOptionsMenu(true)
        connectionLiveData = ConnectionLiveData(requireActivity())

        setupRecyclerView()
        observeViewModel()
        clickToNavigateToDetails()
    }


    private fun setupRecyclerView() {
        binding.itemRecyclerViewList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = recyclerViewAdapter
        }
    }


    private fun observeViewModel() {
        connectionLiveData.observe(viewLifecycleOwner) { isNetworkAvailable ->

            if (isNetworkAvailable == true) {
                viewModel.getBeautyProducts()

            } else if (isNetworkAvailable == false) {
                noInternetSnackBar()
            }

            viewModel.beautyProducts.observe(viewLifecycleOwner) {
                it?.let {
                    binding.itemRecyclerViewList.visibility = View.VISIBLE
                    recyclerViewAdapter.updateList(it)
                }
            }
        }
    }

    private fun noInternetSnackBar() {
        val snack: Snackbar =
            Snackbar.make(requireView(), "No internet connection", Snackbar.LENGTH_LONG)
        snack.setTextColor(Color.CYAN)
        snack.setActionTextColor(Color.GREEN)
        snack.setBackgroundTint(Color.BLACK)
        snack.setAction("Connect"){

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val panelIntent = Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY)
                startActivityForResult(panelIntent, 0)
            } else {

                (this.context?.applicationContext
                    ?.getSystemService(Context.WIFI_SERVICE) as? WifiManager)?.apply {
                    isWifiEnabled = true /*or false*/
                }
            }
        }
        snack.show()
    }

    private fun clickToNavigateToDetails() {
        recyclerViewAdapter.setOnItemClickListener {
            val action = ListFragmentDirections.actionFragmentListToDetailFragment(it)
            findNavController().navigate(action)
        }
    }
}