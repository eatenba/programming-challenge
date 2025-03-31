package de.bcxp.challenge.model;

/**
 * Basic model class for WeatherEntries.
 * MAYBE: Add expected units to variable names once known.
 */
public class WeatherEntry {
    private int day;
    private int maximumTemperature;
    private int minimumTemperature;
    private int averageTemperature;
    private double averageDewPoint;
    private int maximumPrecepationInOneHourDuringDay;
    private int persiannDynamicInfraredRainRate;
    private double averageWindSpeed;
    private int windDirection;
    private int maximumWindSpeed;
    private double skyCover;
    private int maximumRelativeHumidity;
    private int minimumRelativeHumidity;
    private double averageSeaLevelPressure;

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

    public int getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(int averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public double getAverageDewPoint() {
        return averageDewPoint;
    }

    public void setAverageDewPoint(double averageDewPoint) {
        this.averageDewPoint = averageDewPoint;
    }

    public int getMaximumPrecepationInOneHourDuringDay() {
        return maximumPrecepationInOneHourDuringDay;
    }

    public void setMaximumPrecepationInOneHourDuringDay(int maximumPrecepationInOneHourDuringDay) {
        this.maximumPrecepationInOneHourDuringDay = maximumPrecepationInOneHourDuringDay;
    }

    public int getPersiannDynamicInfraredRainRate() {
        return persiannDynamicInfraredRainRate;
    }

    public void setPersiannDynamicInfraredRainRate(int persiannDynamicInfraredRainRate) {
        this.persiannDynamicInfraredRainRate = persiannDynamicInfraredRainRate;
    }

    public double getAverageWindSpeed() {
        return averageWindSpeed;
    }

    public void setAverageWindSpeed(double averageWindSpeed) {
        this.averageWindSpeed = averageWindSpeed;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public int getMaximumWindSpeed() {
        return maximumWindSpeed;
    }

    public void setMaximumWindSpeed(int maximumWindSpeed) {
        this.maximumWindSpeed = maximumWindSpeed;
    }

    public double getSkyCover() {
        return skyCover;
    }

    public void setSkyCover(double skyCover) {
        this.skyCover = skyCover;
    }

    public int getMaximumRelativeHumidity() {
        return maximumRelativeHumidity;
    }

    public void setMaximumRelativeHumidity(int maximumRelativeHumidity) {
        this.maximumRelativeHumidity = maximumRelativeHumidity;
    }

    public int getMinimumRelativeHumidity() {
        return minimumRelativeHumidity;
    }

    public void setMinimumRelativeHumidity(int minimumRelativeHumidity) {
        this.minimumRelativeHumidity = minimumRelativeHumidity;
    }

    public double getAverageSeaLevelPressure() {
        return averageSeaLevelPressure;
    }

    public void setAverageSeaLevelPressure(double averageSeaLevelPressure) {
        this.averageSeaLevelPressure = averageSeaLevelPressure;
    }
}
