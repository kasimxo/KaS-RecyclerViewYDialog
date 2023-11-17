package com.andres.recyclerview

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ColorsViewHolder (view: View) : RecyclerView.ViewHolder(view){
    private val viewContainer: CardView = view.findViewById(R.id.verticalCard)
    private val texto: TextView = view.findViewById(R.id.textoVerticales)
    fun render(colores: Colores, position: Int, color: Int) {
        //viewContainer.setBackgroundColor(color)
        viewContainer.setBackgroundColor( color)

        when(position) {
            0 -> {
                viewContainer.alpha = 0.2F
                viewContainer.setBackgroundColor( color)
                texto.setText("V 1\nOpacidad 20%")
            }
            1 -> {
                viewContainer.alpha = 0.35F
                viewContainer.setBackgroundColor( color)
                texto.setText("V 2\nOpacidad 35%")
            }
            2 -> {
                viewContainer.alpha = 0.5F
                viewContainer.setBackgroundColor( color)
                texto.setText("V 3\nOpacidad 50%")
            }
            3 -> {
                viewContainer.alpha = 0.65F
                viewContainer.setBackgroundColor( color)
                texto.setText("V 4\nOpacidad 65%")
            }
            4 -> {
                viewContainer.alpha = 0.8F
                viewContainer.setBackgroundColor(color)
                texto.setText("V 5\nOpacidad 80%")
            }
        }



    }
}