package com.example.myapplication.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val textoTopic: Int,
    val cantidad: Int,
    @DrawableRes val imagenTopic: Int
)