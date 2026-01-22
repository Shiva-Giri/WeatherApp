package com.example.weatherapp.data.repository

import com.example.weatherapp.data.mapper.WeatherMapper
import com.example.weatherapp.data.remote.OpenMeteoApi
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.HourlyForecast
import com.example.weatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val api: OpenMeteoApi,
    private val mapper: WeatherMapper
) : WeatherRepository {

    override suspend fun getWeather():
            Result<Pair<CurrentWeather, List<HourlyForecast>>> {

        return runCatching {
            val response = api.getForecast()

            val current = mapper.mapToCurrentWeather(response)
            val hourly = mapper.mapToHourlyForecasts(response)

            current to hourly
        }
    }
}