package com.methodius.drinks.adapters

import android.R.id.checkbox
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.methodius.drinks.R
import com.methodius.drinks.model.FilterModel


class FiltersAdapter(private val list: List<FilterModel>, val but: Button): RecyclerView.Adapter<FiltersAdapter.FilterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.filter_item, parent, false)

        return FilterViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.filterName.text = list[position].category

        holder.filterCheck.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener(){
            compoundButton: CompoundButton, b: Boolean ->
                Log.d("logs", holder.filterName.text.toString())

        })
    }

    override fun getItemCount() = list.size

    class FilterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val filterName: TextView = itemView.findViewById(R.id.filter_name)
        val filterCheck: CheckBox = itemView.findViewById(R.id.filter_check)
    }
}