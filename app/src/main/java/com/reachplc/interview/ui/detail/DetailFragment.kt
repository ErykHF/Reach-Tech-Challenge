package com.reachplc.interview.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.reachplc.interview.R
import com.reachplc.interview.databinding.FragmentDetailBinding
import com.reachplc.interview.utils.Util
import com.reachplc.interview.utils.Util.loadImage

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args: DetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        val progressDrawable = Util.getProgressDrawable(requireContext())

        binding = FragmentDetailBinding.bind(view)

        binding.nameTv.text = args.beautyArgs.name
        binding.photoImage.loadImage(args.beautyArgs.image, progressDrawable)
        binding.descriptionTv.text = args.beautyArgs.description
        binding.priceTv.text = getString(R.string.price_string, args.beautyArgs.price.toString())


//        viewModel.isProductSaved(args.beautyArgs)

        if (viewModel.isProductSaved()) {
            binding.button.text = "Saved"
            Log.d("TAG", "isProductSaved: ${viewModel.isProductSaved()}")

        } else {
            binding.button.text = "Save"
        }

        binding.toolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }

        binding.button.setOnClickListener {
            viewModel.saveProduct(args.beautyArgs.name)
            binding.button.text = "saved"
        }

        binding.buttonDelete.setOnClickListener {
            viewModel.deleteProduct()
            binding.button.text = "save"

        }

    }
}