package com.methodius.drinks.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.methodius.drinks.R
import com.methodius.drinks.model.DrinkModel
import com.squareup.picasso.Picasso

class DrinksAdapter(private val list: List<DrinkModel>): RecyclerView.Adapter<DrinksAdapter.DrinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.drink_item, parent, false)

        return DrinkViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.drinkName.text = list[position].name
        Picasso.get().load(list[position].image).into(holder.drinkImage);
    }

    override fun getItemCount() = list.size

    class DrinkViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val drinkName: TextView = itemView.findViewById(R.id.drink_name)
        val drinkImage: ImageView = itemView.findViewById(R.id.drink_image)
    }
}