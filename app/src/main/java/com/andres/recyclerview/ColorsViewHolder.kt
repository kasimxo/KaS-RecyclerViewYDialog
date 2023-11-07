package com.andres.recyclerview

import android.content.res.ColorStateList
import android.view.View
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ColorsViewHolder (view: View) : RecyclerView.ViewHolder(view){
    private val viewContainer: View = view.findViewById(R.id.verticalCard)
    fun render(colores: Colores, position: Int) {

        when(position) {
            0 -> viewContainer.alpha = 0.2F
            1 -> viewContainer.alpha = 0.35F
            2 -> viewContainer.alpha = 0.5F
            3 -> viewContainer.alpha = 0.65F
            4 -> viewContainer.alpha = 0.8F
        }



    }
}