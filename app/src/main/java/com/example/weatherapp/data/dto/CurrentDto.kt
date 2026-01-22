package com.example.weatherapp.data.dto

import com.google.gson.annotations.SerializedName

data class CurrentDto(
    @SerializedName("time")
    val time: String,

    @SerializedName("temperature_2m")
    val temperature: Double,

    @SerializedName("weathercode")
    val weatherCode: Int,

    @SerializedName("wind_speed_10m")
    val windSpeed: Double
)
