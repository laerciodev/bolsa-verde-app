package com.example.bolsaverde

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val companyNameTextView: TextView = itemView.findViewById(R.id.company_name_text_view)
    private val companyPriceTextView: TextView = itemView.findViewById(R.id.company_price_text_view)
    private val logoCompany: ImageView = itemView.findViewById(R.id.company_logo)

    fun bind(item: Company) {
        companyNameTextView.text = item.name
        companyPriceTextView.text = "Preço: R$ ${item.price},00"
        logoCompany.setImageResource(item.image)
    }
}

