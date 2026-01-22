package com.example.weatherapp.di

import com.example.weatherapp.data.mapper.WeatherMapper
import com.example.weatherapp.data.remote.OpenMeteoApi
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.ui.WeatherViewModelFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {

    private const val BASE_URL = "https://api.open-meteo.com/"

    // --- Logging ---
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    // --- Network ---
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val openMeteoApi: OpenMeteoApi by lazy {
        retrofit.create(OpenMeteoApi::class.java)
    }

    // --- ViewModel factory ---
    fun provideWeatherViewModelFactory(): WeatherViewModelFactory {
        return WeatherViewModelFactory(weatherRepository)
    }

    // --- Mapper ---
    private val weatherMapper: WeatherMapper by lazy {
        WeatherMapper()
    }
    // --- Repository ---
    private val weatherRepository: WeatherRepository by lazy {
        WeatherRepositoryImpl(
            api = openMeteoApi,
            mapper = weatherMapper
        )
    }


}