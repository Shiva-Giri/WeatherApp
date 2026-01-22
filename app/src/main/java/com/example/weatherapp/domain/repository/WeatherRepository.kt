package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.HourlyForecast

interface WeatherRepository {

    suspend fun getWeather():
            Result<Pair<CurrentWeather, List<HourlyForecast>>>
}