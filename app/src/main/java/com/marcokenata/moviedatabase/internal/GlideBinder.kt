package com.marcokenata.moviedatabase.internal

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.marcokenata.moviedatabase.data.network.imgUrl

class GlideBinder {
    companion object {
        @BindingAdapter("cardViewImage")
        @JvmStatic
        fun loadImage(imageView: ImageView, backdropPath: String?) {
            Glide.with(imageView.context)
                .load(imgUrl+backdropPath)
                .into(imageView)
        }
    }
}