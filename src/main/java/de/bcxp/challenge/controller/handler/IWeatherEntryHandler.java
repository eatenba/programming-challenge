package de.bcxp.challenge.controller.handler;

import de.bcxp.challenge.model.WeatherEntry;

/**
 * Implement this interface for your own data handling method.
 * TODO:
 * - State further needed methods for handling weather data in the future.
 */
public interface IWeatherEntryHandler {
    public WeatherEntry getWeatherEntry();
    public WeatherEntry getWeatherEntries();
}
