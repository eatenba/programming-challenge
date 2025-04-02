package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.handler.IHandler;
import de.bcxp.challenge.model.CountryEntry;

import java.util.List;

public final class CountryController {

    private final IHandler<CountryEntry> countryEntryIHandler;

    public CountryController(IHandler<CountryEntry> countryEntryIHandler) {
        this.countryEntryIHandler = countryEntryIHandler;
    }

    public String getDensestPopulatedCountry(){
        List<CountryEntry> countryEntries = countryEntryIHandler.getEntries();
        return computeDensestPopulatedArea(countryEntries);
    }

    protected String computeDensestPopulatedArea(List<CountryEntry> countryEntries){
        double densestPopulation = Double.MIN_VALUE;
        String densestPopulatedArea = null;
        for (int i=0; i<countryEntries.size(); i++){
            CountryEntry currentEntry = countryEntries.get(i);
            if(isContenderPopulationDensityHigher(densestPopulation, getCountryEntryPopulationDensity(currentEntry))){
                densestPopulation = getCountryEntryPopulationDensity(currentEntry);
                densestPopulatedArea = currentEntry.getName();
            }
        }
        return densestPopulatedArea;
    }

    protected boolean isContenderPopulationDensityHigher(double currentHighestPopulation, double contenderPopulation){
        return currentHighestPopulation < contenderPopulation;
    }

    protected double getCountryEntryPopulationDensity(CountryEntry countryEntry){
        if(countryEntry.getArea() == 0){
            return 0;
        } else {
            return countryEntry.getPopulation() / countryEntry.getArea();
        }
    }
}
