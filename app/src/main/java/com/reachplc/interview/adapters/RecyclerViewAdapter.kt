package com.reachplc.interview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.reachplc.interview.R
import com.reachplc.interview.data.remote.Product
import com.reachplc.interview.data.remote.ProductsResponse
import com.reachplc.interview.databinding.FragmentItemBinding
import com.reachplc.interview.ui.list.ListFragmentDirections
import com.reachplc.interview.utils.Util.getProgressDrawable
import com.reachplc.interview.utils.Util.loadImage

class RecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var productList = ArrayList<Product>()

    fun updateList(listOfProducts: List<Product>) {
        productList.clear()
        productList.addAll(listOfProducts)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val products = productList[position]
        holder.bind(products)

        holder.itemView.apply {

            setOnClickListener {
                onItemClickListener?.let {
                    it(products)
                }
            }
        }

    }

    override fun getItemCount() = productList.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val productImage = binding.productImage
        private val productName = binding.productNameText
        private val progressDrawable = getProgressDrawable(itemView.context)

        fun bind(beautyData: Product) {
            val photoUri = beautyData.image
            productName.text = beautyData.name
            productImage.loadImage(photoUri, progressDrawable)
        }
    }


    private var onItemClickListener: ((Product) -> Unit)? = null

    fun setOnItemClickListener(listener: (Product) -> Unit) {
        onItemClickListener = listener
    }
}
