package com.example.weatherapp.data.dto

import com.google.gson.annotations.SerializedName

data class HourlyDto (

    @SerializedName("time")
    val time: List<String>,

    @SerializedName("temperature_2m")
    val temperature: List<Double>,

    @SerializedName("weathercode")
    val weatherCode: List<Int>,

    @SerializedName("wind_speed_10m")
    val windSpeed: List<Double>
)