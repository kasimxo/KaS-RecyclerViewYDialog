package com.andres.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

    private lateinit var rV: RecyclerView
    private lateinit var btn: Button

    private lateinit var colorsAdapter: ColorsAdapter
    private lateinit var colorsViewHolder: ColorsViewHolder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        initUI()
        initListeners()
    }

    private fun initComponents() {
        rV = findViewById<RecyclerView>(R.id.recyclerView)
        btn = findViewById<Button>(R.id.cambiarColor)
    }

    private fun initUI() {
        colorsAdapter = ColorsAdapter(colores)
        rV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rV.adapter = colorsAdapter
    }

    private fun initListeners() {
        //Aqui meteremos el boton de cambiar color
        //Abrirá un dialog que permitirá seleccionar uno de los 5 recicler view y cambiarle el color
    }
}