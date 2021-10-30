package com.reachplc.interview.ui.detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.transition.Transition
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.reachplc.interview.R
import com.reachplc.interview.databinding.FragmentDetailBinding
import com.reachplc.interview.utils.Util
import com.reachplc.interview.utils.Util.loadImage

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args: DetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentDetailBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressDrawable = Util.getProgressDrawable(requireContext())

        binding = FragmentDetailBinding.bind(view)

        binding.nameTv.text = args.beautyArgs.name
        binding.photoImage.loadImage(args.beautyArgs.image, progressDrawable)
        binding.descriptionTv.text = args.beautyArgs.description
        binding.priceTv.text = getString(R.string.price_string, args.beautyArgs.price.toString())
    }
}