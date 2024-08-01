package com.fermers_marketplace.fermers.presentation.fragments.chosen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.model.AdvertModel
import com.fermers_marketplace.fermers.databinding.ItemAdvertBinding

class AdvertAdapter(
    private val items: MutableList<AdvertModel>
) : RecyclerView.Adapter<AdvertAdapter.AdvertViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertViewHolder {
        val binding = ItemAdvertBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdvertViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdvertViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class AdvertViewHolder(private val binding: ItemAdvertBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AdvertModel) {
            binding.apply {
                tvPrice.text = item.price
                tvDescription.text = item.description
                ivItem.setImageResource(item.imageResource)

                updateFavoriteIcon(item.isFavorite)

                btnFavorite.setOnClickListener {
                    item.isFavorite = !item.isFavorite
                    updateFavoriteIcon(item.isFavorite)
                }
            }
        }

        private fun updateFavoriteIcon(isFavorite: Boolean) {
            binding.btnFavorite.setImageResource(
                if (isFavorite) R.drawable.baseline_favorite_24
                else R.drawable.baseline_favorite_border_24
            )
        }
    }

}