package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.handler.IHandler;
import de.bcxp.challenge.model.CountryEntry;

import java.util.List;

public class CountryController {

    protected IHandler<CountryEntry> countryEntryIHandler;

    /**
     * Default constructor should be given an instantiated IHander object.
     * @param countryEntryIHandler: Param cannot be null, else a IllegalArgumentException is thrown.
     */
    public CountryController(IHandler<CountryEntry> countryEntryIHandler) {
        if(countryEntryIHandler == null){
            throw new IllegalArgumentException("Parameter cannot be null.");
        }
        this.countryEntryIHandler = countryEntryIHandler;
    }

    /**
     * Use this function to get the densest populated area provided in the source data.
     * @return Name of the densest populated area.
     */
    public String getDensestPopulatedCountry(){
        return computeDensestPopulatedArea(countryEntryIHandler.getEntries());
    }

    /**
     * Function computes the densest populated country out of a list of CountryEntries.
     * @param countryEntries List of CountryEntry objects to be computed.
     * @return Name of the densest populated country.
     */
    protected String computeDensestPopulatedArea(List<CountryEntry> countryEntries){
        if(countryEntries == null){
            throw new IllegalArgumentException("Parameter should not be null.");
        }
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

    /**
     * Function compares the population density of two densities.
     * Densities are in double format.
     * @param currentHighestPopulation Density of current highest populated area.
     * @param contenderPopulation Density of contending area.
     * @return True if contender area is denser populated. Else false.
     */
    protected static boolean isContenderPopulationDensityHigher(double currentHighestPopulation, double contenderPopulation){
        return currentHighestPopulation < contenderPopulation;
    }

    /**
     * Function computes the population density of a CountryEntry.
     * Density = Population/Area.
     * @param countryEntry Country entry to be computed. Note that area cannot be zero.
     * @return Computed density in double. Returns 0 when zero division occurs.
     */
    protected static double getCountryEntryPopulationDensity(CountryEntry countryEntry){
        if(countryEntry == null || countryEntry.getArea() == 0){
            return 0;
        } else {
            return countryEntry.getPopulation() / countryEntry.getArea();
        }
    }
}
