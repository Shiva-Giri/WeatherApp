package com.example.weatherapp.data.dto

import com.google.gson.annotations.SerializedName

data class WeatherResponseDto (
    @SerializedName("hourly")
    val hourly: HourlyDto
)