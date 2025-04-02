package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.services.IService;
import de.bcxp.challenge.model.WeatherEntry;

import java.util.List;

import static de.bcxp.challenge.controller.handler.WeatherEntryHandler.getWeatherEntryDaySpread;
import static de.bcxp.challenge.controller.handler.WeatherEntryHandler.isContenderSpreadSmaller;

public class WeatherEntryController {

    protected IService<WeatherEntry> weatherEntryIService;

    /**
     * Default constructor should be given an instantiated IHander object.
     * @param weatherEntryIService: Param cannot be null, else a IllegalArgumentException is thrown.
     */
    public WeatherEntryController(IService<WeatherEntry> weatherEntryIService) {
        if(weatherEntryIService == null){
            throw new IllegalArgumentException("Parameter cannot be null.");
        }
        this.weatherEntryIService = weatherEntryIService;
    }

    /**
     * Use this function to get the smallest temperature spread day provided in the source data.
     * @return Day of the smallest temperature spread.
     */
    public int getSmallestTemperatureSpread(){
        List<WeatherEntry> weatherEntries = weatherEntryIService.getEntries();
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
}
