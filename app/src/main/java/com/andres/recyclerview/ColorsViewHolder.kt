package com.andres.recyclerview

import android.content.res.ColorStateList
import android.graphics.Color
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
                viewContainer.setBackgroundColor(opacidadColor(0,color))
                texto.setText("V 1\nOpacity 20%")
            }
            1 -> {
                viewContainer.setBackgroundColor(opacidadColor(1,color))
                texto.setText("V 2\nOpacity 35%")
            }
            2 -> {
                viewContainer.setBackgroundColor(opacidadColor(2,color))
                texto.setText("V 3\nOpacity 50%")
            }
            3 -> {
                viewContainer.setBackgroundColor(opacidadColor(3,color))
                texto.setText("V 4\nOpacity 65%")
            }
            4 -> {
                viewContainer.setBackgroundColor(opacidadColor(4,color))
                texto.setText("V 5\nOpacity 80%")
            }
        }



    }

    fun opacidadColor(pos: Int, color: Int) : Int{
        var cadena = Integer.toHexString(color).substring(2);


        when(pos){
            0 -> cadena = "#20"+cadena
            1 -> cadena = "#35"+cadena
            2 -> cadena = "#50"+cadena
            3 -> cadena = "#65"+cadena
            4 -> cadena = "#80"+cadena
        }


        texto.setText(cadena)

        return Color.parseColor(cadena)
    }
}