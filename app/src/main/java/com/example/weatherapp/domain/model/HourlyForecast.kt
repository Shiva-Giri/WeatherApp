package com.example.weatherapp.domain.model

import java.time.LocalDateTime

data class HourlyForecast(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val windSpeedKmh: Double,
    val weatherCode: Int
)