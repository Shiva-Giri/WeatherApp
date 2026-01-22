package com.example.weatherapp.data.dto

import com.google.gson.annotations.SerializedName

data class WeatherResponseDto(

    @SerializedName("current")
    val current: CurrentDto,

    @SerializedName("hourly")
    val hourly: HourlyDto
)