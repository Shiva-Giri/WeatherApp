package com.example.weatherapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.domain.model.HourlyForecast
import java.time.format.DateTimeFormatter

@Composable
fun HourlyForecastItem(
    forecast: HourlyForecast
) {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = forecast.time.format(formatter))
            Text(text = weatherIcon(forecast.weatherCode))
            Text(text = "${forecast.temperatureCelsius.toInt()}°C")
            Text(text = "Wind ${forecast.windSpeedKmh.toInt()} km/h")
        }
        HorizontalDivider()
    }
}
