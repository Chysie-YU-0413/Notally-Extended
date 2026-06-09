package com.notally.extended.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.notally.extended.databinding.ErrorBinding
import com.notally.extended.image.ImageError

class ErrorVH(private val binding: ErrorBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(error: ImageError) {
        binding.Name.text = error.name
        binding.Description.text = error.description
    }
}
