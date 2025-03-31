package de.bcxp.challenge.model;

/**
 * Basic model class for WeatherEntries.
 * MAYBE: Add expected units to variable names once known.
 */
public class WeatherEntry {
    private int day;
    private int maximumTemperature;
    private int minimumTemperature;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(int maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    public int getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(int minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }
}
