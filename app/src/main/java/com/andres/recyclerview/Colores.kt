package com.andres.recyclerview

sealed class Colores(var isSelected:Boolean = true) {
    object c1 : Colores()
    object c2 : Colores()
    object c3 : Colores()
    object c4 : Colores()
    object c5 : Colores()
}