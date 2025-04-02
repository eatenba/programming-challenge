package de.bcxp.challenge.controller.handler;

import de.bcxp.challenge.model.WeatherEntry;

public class WeatherEntryHandler {

    /**
     * Function computes the temperature spread of a WeatherEntry.
     * Spread = MaximumumTemperature-MinimumTemperature
     * @param weatherEntry WeatherEntry to be computed. Note that input cannot be null.
     * @return Computed temperature spread in int. Returns 0 when input is false.
     */
    public static int getWeatherEntryDaySpread(WeatherEntry weatherEntry){
        if(weatherEntry == null){
            return 0;
        } else {
            return weatherEntry.getMaximumTemperature() - weatherEntry.getMinimumTemperature();
        }
    }

    /**
     * Function compares the temperature spread of two days.
     * Spreads are in int format.
     * @param currentSpread Temperature spread of the current lowest temperature spread day.
     * @param contenderSpread Temperature spread of contending day.
     * @return True if contender spread is smaller. Else false.
     */
    public static boolean isContenderSpreadSmaller(int currentSpread, int contenderSpread){
        return currentSpread > contenderSpread;
    }

}
