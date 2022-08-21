package com.syoon.shoppi.ui.productdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.syoon.shoppi.databinding.ItemProductDetailBinding
import com.syoon.shoppi.model.Description
import com.syoon.shoppi.model.Product

class ProductDetailAdapter : ListAdapter<Description, ProductDetailAdapter.DescriptionViewHolder>(ProductDetailDiffCallback()) {

    private lateinit var binding: ItemProductDetailBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionViewHolder {
        binding = ItemProductDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DescriptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DescriptionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class DescriptionViewHolder(private val binding: ItemProductDetailBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(descriptions: Description) {
            binding.imageUrl = descriptions.imageUrl
            binding.executePendingBindings()
        }
    }
}

class ProductDetailDiffCallback : DiffUtil.ItemCallback<Description>() {
    override fun areItemsTheSame(oldItem: Description, newItem: Description): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Description, newItem: Description): Boolean {
        return oldItem == newItem
    }

}