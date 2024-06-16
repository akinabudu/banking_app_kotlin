package com.example.bankingapp

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun getGradient(startColor: Color, endColor: Color):Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor,endColor)
    )
}