package com.notally.extended.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.notally.extended.databinding.RecyclerHeaderBinding
import com.notally.extended.room.Header

class HeaderVH(private val binding: RecyclerHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

    init {
        val params = binding.root.layoutParams
        if (params is StaggeredGridLayoutManager.LayoutParams) {
            params.isFullSpan = true
        }
    }

    fun bind(header: Header) {
        binding.root.text = header.label
    }
}
