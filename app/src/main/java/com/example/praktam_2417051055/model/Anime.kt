package com.example.praktam_2417051055.model

import androidx.annotation.DrawableRes

data class Anime(
    val title: String,
    val rating: Double,
    val episodes: Int,
    val season: String,
    val year: Int,
    @DrawableRes val imageRes: Int
)
