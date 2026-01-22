package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.dto.WeatherResponseDto
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.HourlyForecast
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeatherMapper {


    fun mapToCurrentWeather(dto: WeatherResponseDto): CurrentWeather {
//        val hourly = dto.hourly
//
//        return CurrentWeather(
//            temperatureCelsius = hourly.temperature.first(),
//            weatherCode = hourly.weatherCode.first()
//        )

        val current = dto.current

        return CurrentWeather(
            temperatureCelsius = current.temperature,
            weatherCode = current.weatherCode
        )
    }
    fun mapToHourlyForecasts(dto: WeatherResponseDto): List<HourlyForecast> {
        val hourly = dto.hourly
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

        val safeSize = minOf(
            hourly.time.size,
            hourly.temperature.size,
            hourly.weatherCode.size,
            hourly.windSpeed.size
        )

        // Parse API current time (NOT device time)
        val apiCurrentTime = LocalDateTime.parse(dto.current.time, formatter)

        // Map all hourly entries first
        val allForecasts = (0 until safeSize).map { index ->
            HourlyForecast(
                time = LocalDateTime.parse(hourly.time[index], formatter),
                temperatureCelsius = hourly.temperature[index],
                windSpeedKmh = hourly.windSpeed[index],
                weatherCode = hourly.weatherCode[index]
            )
        }

        // Find where "current time" fits in hourly timeline
        val startIndex = allForecasts.indexOfFirst {
            !it.time.isBefore(apiCurrentTime)
        }.takeIf { it >= 0 } ?: 0

        // Return the NEXT 24 HOURS from current time
        return allForecasts
            .drop(startIndex)
            .take(24)
    }

}