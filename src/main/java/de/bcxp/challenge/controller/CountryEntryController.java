package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.services.IService;
import de.bcxp.challenge.model.CountryEntry;

import java.util.List;

import static de.bcxp.challenge.controller.handler.CountryEntryHandler.getCountryEntryPopulationDensity;
import static de.bcxp.challenge.controller.handler.CountryEntryHandler.isContenderPopulationDensityHigher;

public class CountryEntryController {

    protected IService<CountryEntry> countryEntryIService;

    /**
     * Default constructor should be given an instantiated IHander object.
     * @param countryEntryIService: Param cannot be null, else a IllegalArgumentException is thrown.
     */
    public CountryEntryController(IService<CountryEntry> countryEntryIService) {
        if(countryEntryIService == null){
            throw new IllegalArgumentException("Parameter cannot be null.");
        }
        this.countryEntryIService = countryEntryIService;
    }

    /**
     * Use this function to get the densest populated area provided in the source data.
     * @return Name of the densest populated area.
     */
    public String getDensestPopulatedCountry(){
        return computeDensestPopulatedArea(countryEntryIService.getEntries());
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
}
