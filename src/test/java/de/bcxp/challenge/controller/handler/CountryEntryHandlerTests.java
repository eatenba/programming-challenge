package de.bcxp.challenge.controller.handler;

import de.bcxp.challenge.model.CountryEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryEntryHandlerTests {


    @Test
    @DisplayName("Check if return of density compare is correct when contender is denser test")
    void isContenderPopulationDensityHigherWhenContenderDensityIsHigherTest() {
        //Arrange
        double currentPopulationDensity = 2.0;
        double contenderPopulationDensity = 3.0;

        //Act
        boolean result = CountryEntryHandler.isContenderPopulationDensityHigher(currentPopulationDensity, contenderPopulationDensity);

        //Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Check if return of density compare is correct when contender is less denser test")
    void isContenderPopulationDensityHigherWhenContenderDensityIsLowerTest() {
        //Arrange
        double currentPopulationDensity = 2.0;
        double contenderPopulationDensity = 1.0;

        //Act
        boolean result = CountryEntryHandler.isContenderPopulationDensityHigher(currentPopulationDensity, contenderPopulationDensity);

        //Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Compute population density of a valid CountryEntry.")
    void getCountryEntryPopulationDensityWhenInputOKTest (){
        //Arrange
        CountryEntry countryEntry = new CountryEntry();
        countryEntry.setPopulation(100);
        countryEntry.setArea(100);

        //Act
        double result = CountryEntryHandler.getCountryEntryPopulationDensity(countryEntry);

        //Assert
        assertEquals(1.0, result);
    }

    @Test
    @DisplayName("Compute population density of a invalid CountryEntry. E.g. area is set to 0.")
    void getCountryEntryPopulationDensityWhenInputBADTest (){
        //Arrange
        CountryEntry countryEntry = new CountryEntry();
        countryEntry.setPopulation(100);
        countryEntry.setArea(0);

        //Act
        double result = CountryEntryHandler.getCountryEntryPopulationDensity(countryEntry);

        //Assert
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Compute population density when input null.")
    void getCountryEntryPopulationDensityWhenInputNullTest (){
        //Arrange

        //Act
        double result = CountryEntryHandler.getCountryEntryPopulationDensity(null);

        //Assert
        assertEquals(0, result);
    }
}
