package com.example.weatherapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.domain.model.CurrentWeather

@Composable
fun CurrentWeatherHeader(
    currentWeather: CurrentWeather
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Text(
            text = weatherIcon(currentWeather.weatherCode),
            fontSize = 48.sp
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "${currentWeather.temperatureCelsius.toInt()}°C",
                style = MaterialTheme.typography.displayMedium
            )

            Text(
                text = weatherDescription(currentWeather.weatherCode),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
