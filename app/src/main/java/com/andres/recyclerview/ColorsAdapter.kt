package com.andres.recyclerview

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ColorsAdapter(var colores: List<Colores>, var color: Int) : RecyclerView.Adapter<ColorsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.colorview, parent, false)
        return ColorsViewHolder(view)

    }

    override fun getItemCount(): Int {
        return colores.size
    }
    override fun onBindViewHolder(holder: ColorsViewHolder, position: Int) {
        holder.render(colores[position], position, color)

    }
}