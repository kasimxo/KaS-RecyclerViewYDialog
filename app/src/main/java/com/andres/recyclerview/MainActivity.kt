package com.andres.recyclerview

import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
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
        var selecionado: RadioButton = dialog.findViewById<RadioButton>(rgColores.checkedRadioButtonId)
        dialog.show()
        btnAplicar.setOnClickListener {
            selecionado = dialog.findViewById<RadioButton>(rgColores.checkedRadioButtonId)
            color = aplicarColor(selecionado)
            dialog.hide()
            colorsAdapter.color = color
            colorsAdapter.notifyDataSetChanged()
        }
    }

    private fun aplicarColor(RadioButtonSelected: RadioButton) : Int {
        var colorSeleccionado: Int = ContextCompat.getColor(this, R.color.naranja);
        btn.text = RadioButtonSelected.text
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
        return ContextCompat.getColor(this, R.color.blanco);
    }
}