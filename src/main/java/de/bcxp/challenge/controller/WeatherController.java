package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.handler.IHandler;
import de.bcxp.challenge.model.WeatherEntry;

import java.util.List;

public final class WeatherController {

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
            if(isContenderSpreadSmaller(smallestSpread, getWeatherEntryDaySpread(currentEntry))){
                smallestSpread = getWeatherEntryDaySpread(currentEntry);
                smallestSpreadDay = currentEntry.getDay();
            }
        }
        return smallestSpreadDay;
    }

    protected static int getWeatherEntryDaySpread(WeatherEntry weatherEntry){
        return weatherEntry.getMaximumTemperature() - weatherEntry.getMinimumTemperature();
    }

    protected static boolean isContenderSpreadSmaller(int currentSpread, int contenderSpread){
        return currentSpread > contenderSpread;
    }
}
