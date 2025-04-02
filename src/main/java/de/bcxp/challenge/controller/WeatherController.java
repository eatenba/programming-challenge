package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.handler.IHandler;
import de.bcxp.challenge.model.WeatherEntry;

import java.util.List;

public class WeatherController {

    protected IHandler<WeatherEntry> weatherEntryIHandler;

    /**
     * Default constructor should be given an instantiated IHander object.
     * @param weatherEntryIHandler: Param cannot be null, else a IllegalArgumentException is thrown.
     */
    public WeatherController(IHandler<WeatherEntry> weatherEntryIHandler) {
        if(weatherEntryIHandler == null){
            throw new IllegalArgumentException("Parameter cannot be null.");
        }
        this.weatherEntryIHandler = weatherEntryIHandler;
    }

    /**
     * Use this function to get the smallest temperature spread day provided in the source data.
     * @return Day of the smallest temperature spread.
     */
    public int getSmallestTemperatureSpread(){
        List<WeatherEntry> weatherEntries = weatherEntryIHandler.getEntries();
        return computeSmallestTemperatureSpread(weatherEntries);
    }

    /**
     * Function computes the day with the smallest temperature spread out of a list of WeatherEntries.
     * @param weatherEntries List of WeatherEntry objects to be computed.
     * @return Day with the smallest temperature spread.
     */
    protected int computeSmallestTemperatureSpread(List<WeatherEntry> weatherEntries){
        if(weatherEntries == null){
            throw new IllegalArgumentException("Parameter should not be null.");
        }
        int smallestSpread = Integer.MAX_VALUE;
        int smallestSpreadDay = -1;
        for (int i=0; i<weatherEntries.size(); i++){
            WeatherEntry currentEntry = weatherEntries.get(i);
            if(isContenderSpreadSmaller(smallestSpread, getWeatherEntryDaySpread(currentEntry))){
                smallestSpread = getWeatherEntryDaySpread(currentEntry);
                smallestSpreadDay = currentEntry.getDay();
            }
        }
        return smallestSpreadDay;
    }

    /**
     * Function computes the temperature spread of a WeatherEntry.
     * Spread = MaximumumTemperature-MinimumTemperature
     * @param weatherEntry WeatherEntry to be computed. Note that input cannot be null.
     * @return Computed temperature spread in int. Returns 0 when input is false.
     */
    protected static int getWeatherEntryDaySpread(WeatherEntry weatherEntry){
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
    protected static boolean isContenderSpreadSmaller(int currentSpread, int contenderSpread){
        return currentSpread > contenderSpread;
    }
}
