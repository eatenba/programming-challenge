package de.bcxp.challenge.controller.handler;

import de.bcxp.challenge.model.CountryEntry;

public class CountryEntryHandler {

    /**
     * Function compares the population density of two densities.
     * Densities are in double format.
     * @param currentHighestPopulation Density of current highest populated area.
     * @param contenderPopulation Density of contending area.
     * @return True if contender area is denser populated. Else false.
     */
    public static boolean isContenderPopulationDensityHigher(double currentHighestPopulation, double contenderPopulation){
        return currentHighestPopulation < contenderPopulation;
    }

    /**
     * Function computes the population density of a CountryEntry.
     * Density = Population/Area.
     * @param countryEntry Country entry to be computed. Note that area cannot be zero.
     * @return Computed density in double. Returns 0 when zero division occurs.
     */
    public static double getCountryEntryPopulationDensity(CountryEntry countryEntry){
        if(countryEntry == null || countryEntry.getArea() == 0){
            return 0;
        } else {
            return countryEntry.getPopulation() / countryEntry.getArea();
        }
    }

}
