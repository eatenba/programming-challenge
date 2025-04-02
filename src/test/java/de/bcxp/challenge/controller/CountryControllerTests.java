package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.handler.CSVEntryHandler;
import de.bcxp.challenge.model.CountryEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CountryControllerTests {

    @Test
    @DisplayName("Invalid constructor test")
    void constructCountryControllerWhenParameterNullTest(){
        //Arrange & Act
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new CountryController(null),
                "Expected working constructor to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains("Parameter cannot be null."));
    }

    @Test
    @DisplayName("Valid constructor test")
    void constructCountryControllerWhenParameterOKTest(){
        //Arrange
        CSVEntryHandler<CountryEntry> csvEntryHandler = new CSVEntryHandler<>("temp", ',', CountryEntry.class);

        //Act
        CountryController countryController = new CountryController(csvEntryHandler);

        //Assert
        assertEquals(csvEntryHandler, countryController.countryEntryIHandler);
    }

    @Test
    @DisplayName("Get densest populated country from provided sample data.")
    void getDensestPopulatedCountryWithGivenCSVTest() {
        //Arrange
        CountryController countryController = new CountryController(new CSVEntryHandler<>("src/main/resources/de/bcxp/challenge/countries.csv", ';', CountryEntry.class));

        //Act
        String result = countryController.getDensestPopulatedCountry();

        //Assert
        assertEquals("Malta", result);
    }

    @Test
    @DisplayName("Compute densest populated country when parameter bad.")
    void computeDensestPopulatedAreaWhenInputParameterBadTest (){
        //Arrange
        CSVEntryHandler<CountryEntry> csvEntryHandler = new CSVEntryHandler<>("src/main/resources/de/bcxp/challenge/countries.csv", ';', CountryEntry.class);
        CountryController countryController = new CountryController(csvEntryHandler);

        //Act
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> countryController.computeDensestPopulatedArea(null),
                "Expected working constructor to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains("Parameter should not be null."));
    }

    @Test
    @DisplayName("Compute densest populated country when parameter bad.")
    void computeDensestPopulatedAreaWhenInputParameterEmptyTest (){
        //Arrange
        CSVEntryHandler<CountryEntry> csvEntryHandler = new CSVEntryHandler<>("src/main/resources/de/bcxp/challenge/countries.csv", ';', CountryEntry.class);
        CountryController countryController = new CountryController(csvEntryHandler);

        //Act
        String result = countryController.computeDensestPopulatedArea(new ArrayList<>());

        //Assert
        assertNull(result);
    }

    @Test
    @DisplayName("Check if return of density compare is correct when contender is denser test")
    void isContenderPopulationDensityHigherWhenContenderDensityIsHigherTest() {
        //Arrange
        double currentPopulationDensity = 2.0;
        double contenderPopulationDensity = 3.0;

        //Act
        boolean result = CountryController.isContenderPopulationDensityHigher(currentPopulationDensity, contenderPopulationDensity);

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
        boolean result = CountryController.isContenderPopulationDensityHigher(currentPopulationDensity, contenderPopulationDensity);

        //Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Compute densest populated country from provided sample data.")
    void computeDensestPopulatedAreaWhenInputOKTest (){
       //Arrange
       CSVEntryHandler<CountryEntry> csvEntryHandler = new CSVEntryHandler<>("src/main/resources/de/bcxp/challenge/countries.csv", ';', CountryEntry.class);
       CountryController countryController = new CountryController(csvEntryHandler);

       //Act
       String result = countryController.computeDensestPopulatedArea(csvEntryHandler.getEntries());

       //Assert
       assertEquals("Malta", result);
   }

    @Test
    @DisplayName("Compute population density of a valid CountryEntry.")
    void getCountryEntryPopulationDensityWhenInputOKTest (){
        //Arrange
        CountryEntry countryEntry = new CountryEntry();
        countryEntry.setPopulation(100);
        countryEntry.setArea(100);

        //Act
        double result = CountryController.getCountryEntryPopulationDensity(countryEntry);

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
        double result = CountryController.getCountryEntryPopulationDensity(countryEntry);

        //Assert
        assertEquals(0, result);
    }

}
