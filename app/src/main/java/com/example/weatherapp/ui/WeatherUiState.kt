package com.example.weatherapp.ui

import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.HourlyForecast

sealed interface WeatherUiState {
    object Loading : WeatherUiState

    data class Success(
        val currentWeather: CurrentWeather,
        val hourlyForecasts: List<HourlyForecast>
    ) : WeatherUiState

    data class Error(
        val message: String
    ) : WeatherUiState
}