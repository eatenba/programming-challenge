package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.handler.IHandler;
import de.bcxp.challenge.model.WeatherEntry;

import java.util.List;

public class WeatherController {

    private final IHandler<WeatherEntry> weatherEntryIHandler;

    public WeatherController(IHandler<WeatherEntry> weatherEntryIHandler) {
        this.weatherEntryIHandler = weatherEntryIHandler;
    }

    public int getSmallestTemperatureSpread(){
        List<WeatherEntry> weatherEntries = weatherEntryIHandler.getEntries();
        return computeSmallestTemperatureSpread(weatherEntries);
    }

    protected int computeSmallestTemperatureSpread(List<WeatherEntry> weatherEntries){
        int smallestSpread = Integer.MAX_VALUE;
        int smallestSpreadDay = -1;
        for (int i=0; i<weatherEntries.size(); i++){
            WeatherEntry currentEntry = weatherEntries.get(i);
            int daySpread = currentEntry.getMaximumTemperature() - currentEntry.getMinimumTemperature();
            if(isSpreadSmaller(smallestSpread, daySpread)){
                smallestSpread = daySpread;
                smallestSpreadDay = currentEntry.getDay();
            }
        }
        return smallestSpreadDay;
    }

    /**
     * Function computes if a spread is smaller than another.
     * @param currentSmallestSpread Current spread.
     * @param contenderSmallestSpread Spread to be checked against current spread.
     * @return True if contenderSpread is smaller, else False.
     */
    protected static boolean isSpreadSmaller(int currentSmallestSpread, int contenderSmallestSpread){
        return currentSmallestSpread > contenderSmallestSpread;
    }
}
