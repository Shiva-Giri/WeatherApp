package com.example.weatherapp.data.remote

import com.example.weatherapp.data.dto.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMeteoApi {

    @GET("v1/forecast")
    suspend fun getForecast(
        @Query("latitude") latitude: Double = 52.52,
        @Query("longitude") longitude: Double = 13.41,
        @Query("hourly") hourly: String =
            "temperature_2m,weathercode,relative_humidity_2m,wind_speed_10m"
    ): WeatherResponseDto
}