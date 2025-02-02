package com.fermers_marketplace.fermers.presentation.fragments.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aghajari.zoomhelper.ZoomHelper
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.model.AdvertModel

class AdvertHomeAdapter(private val items: List<AdvertModel>) :
    RecyclerView.Adapter<AdvertHomeAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewHome: ImageView = itemView.findViewById(R.id.iv_item)
        val descriptionTextViewHome: TextView = itemView.findViewById(R.id.tv_description)
        val priceTextViewHome: TextView = itemView.findViewById(R.id.tv_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_advert_chosen, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.imageViewHome.setImageResource(item.imageResource)
        holder.descriptionTextViewHome.text = item.description
        holder.priceTextViewHome.text = item.price

        ZoomHelper.addZoomableView(holder.imageViewHome)
    }

    override fun getItemCount(): Int = items.size

}