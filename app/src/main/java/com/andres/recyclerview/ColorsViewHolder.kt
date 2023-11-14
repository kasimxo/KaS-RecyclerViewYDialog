package com.andres.recyclerview

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.view.View
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ColorsViewHolder (view: View) : RecyclerView.ViewHolder(view){
    private val viewContainer: View = view.findViewById(R.id.verticalCard)
    fun render(colores: Colores, position: Int, color: Int) {
        //viewContainer.setBackgroundColor(color)
        viewContainer.setBackgroundColor( color)

        when(position) {
            0 -> {
                viewContainer.alpha = 0.2F
                viewContainer.setBackgroundColor( color)
            }
            1 -> {
                viewContainer.alpha = 0.35F
                viewContainer.setBackgroundColor( color)
            }
            2 -> {
                viewContainer.alpha = 0.5F
                viewContainer.setBackgroundColor( color)
            }
            3 -> {
                viewContainer.alpha = 0.65F
                viewContainer.setBackgroundColor( color)
            }
            4 -> {
                viewContainer.alpha = 0.8F
                viewContainer.setBackgroundColor(color)
            }
        }



    }
}