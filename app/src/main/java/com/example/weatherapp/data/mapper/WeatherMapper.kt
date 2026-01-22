package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.dto.WeatherResponseDto
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.HourlyForecast
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.min

class WeatherMapper {

    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    fun mapToCurrentWeather(dto: WeatherResponseDto): CurrentWeather {
        val hourly = dto.hourly

        return CurrentWeather(
            temperatureCelsius = hourly.temperature.first(),
            weatherCode = hourly.weatherCode.first()
        )
    }

    fun mapToHourlyForecasts(dto: WeatherResponseDto): List<HourlyForecast> {
        val hourly = dto.hourly


        /* Prevents:
           IndexOutOfBoundsException
           App crashes on malformed API response
          */
        val size = minOf(
            hourly.time.size,
            hourly.temperature.size,
            hourly.weatherCode.size,
            hourly.windSpeed.size
        )

        return (0 until min(size, 24)).map { index ->
            HourlyForecast(
                time = LocalDateTime.parse(hourly.time[index], formatter),
                temperatureCelsius = hourly.temperature[index],
                windSpeedKmh = hourly.windSpeed[index],
                weatherCode = hourly.weatherCode[index]
            )
        }
    }
}