package com.notally.extended.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.notally.extended.databinding.RecyclerColorBinding
import com.notally.extended.miscellaneous.Operations
import com.notally.extended.recyclerview.ItemListener
import com.notally.extended.room.Color

class ColorVH(private val binding: RecyclerColorBinding, listener: ItemListener) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            listener.onClick(adapterPosition)
        }
    }

    fun bind(color: Color) {
        val value = Operations.extractColor(color, binding.root.context)
        binding.root.setCardBackgroundColor(value)
    }
}
