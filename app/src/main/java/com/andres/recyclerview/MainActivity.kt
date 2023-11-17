package com.andres.recyclerview

import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    public val colores = listOf<Colores>(
        Colores.c1,
        Colores.c2,
        Colores.c3,
        Colores.c4,
        Colores.c5
    )



    public var color: Int = Color.BLUE;
    private lateinit var rV: RecyclerView
    private lateinit var btn: Button

    private lateinit var colorsAdapter: ColorsAdapter
    private lateinit var colorsViewHolder: ColorsViewHolder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        color = ContextCompat.getColor( this,R.color.verde);
        initComponents()
        initUI()
        initListeners()
    }

    private fun initComponents() {
        rV = findViewById<RecyclerView>(R.id.recyclerView)
        btn = findViewById<Button>(R.id.cambiarColor)
    }

    private fun initUI() {
        colorsAdapter = ColorsAdapter(colores, color)
        rV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rV.adapter = colorsAdapter
    }

    private fun initListeners() {
        //Aqui meteremos el boton de cambiar color
        //Abrirá un dialog que permitirá seleccionar uno de los 5 recicler view y cambiarle el color
        btn.setOnClickListener { showDialogCambiarColor() }
    }

    private fun showDialogCambiarColor() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_cambiar_color)

        val btnAplicar: Button = dialog.findViewById(R.id.btnAplicar)
        val rgColores: RadioGroup = dialog.findViewById(R.id.rgColores)
        val rgSelector: RadioGroup = dialog.findViewById(R.id.selector)
        var colorSelecionado: RadioButton
        var selectorSeleccionado: RadioButton
        dialog.show()
        btnAplicar.setOnClickListener {

            colorSelecionado = dialog.findViewById<RadioButton>(rgColores.checkedRadioButtonId)
            selectorSeleccionado = dialog.findViewById<RadioButton>(rgSelector.checkedRadioButtonId)

            when(selectorSeleccionado.text) {
                "Fondo" -> cambiarFondo(aplicarColor(colorSelecionado))
                "V 1" -> cambiarVerticales(colorSelecionado,0)
                "V 2" -> cambiarVerticales(colorSelecionado,1)
                "V 3" -> cambiarVerticales(colorSelecionado,2)
                "V 4" -> cambiarVerticales(colorSelecionado,3)
                "V 5" -> cambiarVerticales(colorSelecionado,4)
                "H 1" -> cambiarHorizontal(1, aplicarColor(colorSelecionado))
                "H 2" -> cambiarHorizontal(2, aplicarColor(colorSelecionado))
                "H 3" -> cambiarHorizontal(3, aplicarColor(colorSelecionado))
            }
            dialog.hide()


        }
    }

    private fun cambiarHorizontal(numero: Int, color: Int) {
        when(numero) {
            1 -> findViewById<CardView>(R.id.h1).setCardBackgroundColor(color)
            2 ->findViewById<CardView>(R.id.h2).setCardBackgroundColor(color)
            3 ->findViewById<CardView>(R.id.h3).setCardBackgroundColor(color)
        }
    }

    private fun cambiarVerticales(colorSelecionado: RadioButton, pos: Int) {
        color = aplicarColor(colorSelecionado)
        colorsAdapter.color = color
        colorsAdapter.notifyItemChanged(pos)

    }
    private fun cambiarFondo(color: Int) {
        findViewById<ConstraintLayout>(R.id.FondoCL).setBackgroundColor(color)
    }

    private fun aplicarColor(RadioButtonSelected: RadioButton) : Int {
        when(RadioButtonSelected.text){
            "Blanco" -> return ContextCompat.getColor(this, R.color.blanco);
            "Rojo" -> return ContextCompat.getColor(this, R.color.rojo);
            "Naranja" -> return ContextCompat.getColor(this, R.color.naranja);
            "Amarillo" -> return ContextCompat.getColor(this, R.color.amarillo);
            "Verde" -> return ContextCompat.getColor(this, R.color.verde);
            "Cian" -> return ContextCompat.getColor(this, R.color.cian);
            "Azul" -> return ContextCompat.getColor(this, R.color.azul);
            "Violeta" -> return ContextCompat.getColor(this, R.color.violeta);
            "Negro" -> return ContextCompat.getColor(this, R.color.negro);
        }
        return ContextCompat.getColor(this, R.color.blancoRoto);
    }
}