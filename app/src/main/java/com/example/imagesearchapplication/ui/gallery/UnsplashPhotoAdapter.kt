package com.example.imagesearchapplication.ui.gallery

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.imagesearchapplication.R
import com.example.imagesearchapplication.data.UnsplashPhoto
import com.example.imagesearchapplication.databinding.ItemUnsplashRowBinding

class UnsplashPhotoAdapter :
    PagingDataAdapter<UnsplashPhoto, UnsplashPhotoAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            ItemUnsplashRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }


    class PhotoViewHolder(
        private val binding: ItemUnsplashRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: UnsplashPhoto) {
            binding.apply {
                Glide.with(itemView)
                    .load(photo.urls.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(com.google.android.material.R.drawable.mtrl_ic_error)
                    .into(imageView)
                textViewUserName.text = photo.user.username

            }
        }
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<UnsplashPhoto>() {
            override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: UnsplashPhoto,
                newItem: UnsplashPhoto
            ): Boolean =
                oldItem == newItem
        }
    }
}