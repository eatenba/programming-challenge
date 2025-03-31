package de.bcxp.challenge.controller.handler;

import de.bcxp.challenge.model.WeatherEntry;

import java.util.List;

/**
 * Implement this interface for your own data handling method.
 * TODO:
 * - State further needed methods for handling weather data in the future.
 */
public interface IWeatherEntryHandler {
    public List<WeatherEntry> getWeatherEntries();
}
