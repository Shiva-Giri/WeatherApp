package com.example.weatherapp.ui.components

fun weatherDescription(code: Int): String =
    when (code) {
        0 -> "Clear Sky"
        in 1..3 -> "Cloudy"
        in 45..48 -> "Fog"
        in 51..57 -> "Drizzle"
        in 61..67 -> "Rain"
        in 71..77 -> "Snow"
        in 80..82 -> "Rain Showers"
        in 95..99 -> "Thunderstorm"
        else -> "Unknown"
    }

fun weatherIcon(code: Int): String =
    when (code) {
        0 -> "☀️"
        in 1..3 -> "⛅"
        in 45..48 -> "🌫️"
        in 51..67 -> "🌧️"
        in 71..77 -> "❄️"
        in 80..82 -> "🌦️"
        in 95..99 -> "⛈️"
        else -> "❓"
    }