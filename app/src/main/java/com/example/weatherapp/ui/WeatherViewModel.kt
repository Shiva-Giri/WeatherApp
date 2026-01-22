package com.example.weatherapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel (
    private val repository: WeatherRepository
) : ViewModel(){
    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    init {
        fetchWeather()
    }

    fun fetchWeather() {
        _uiState.value = WeatherUiState.Loading

        viewModelScope.launch {
            val currentResult = repository.getCurrentWeather()
            val hourlyResult = repository.getHourlyForecast()

            if (currentResult.isSuccess && hourlyResult.isSuccess) {
                _uiState.value = WeatherUiState.Success(
                    currentWeather = currentResult.getOrThrow(),
                    hourlyForecasts = hourlyResult.getOrThrow()
                )
            } else {
                _uiState.value = WeatherUiState.Error(
                    message = "Unable to load weather data. Please try again."
                )
            }
        }
    }
}