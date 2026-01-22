# Weather App

## Overview
A single-screen Android application that displays the current weather
and a 24-hour forecast for Berlin using the Open-Meteo API.

## Tech Stack
- Kotlin
- Jetpack Compose
- MVVM Architecture
- Retrofit
- Coroutines & Flow

## Architecture
The app follows MVVM with a clear separation between:
- UI
- Domain
- Data layers

The API returns column-oriented data, which is mapped into
domain models before reaching the UI.

## Data Mapping Strategy
Open-Meteo returns parallel arrays for hourly data.
These arrays are safely zipped by index into a list of
HourlyForecast domain objects.

## State Management
The UI observes a StateFlow exposed by the ViewModel and
renders Loading, Success, or Error states.

## Error Handling
- Network failures are caught and displayed
- A retry button allows re-fetching data
- The app does not crash when offline

## Notes
- Time is displayed in 24-hour format (HH:mm)
- Weather data is based on hourly index 0 as "current"
- Metric units are used


