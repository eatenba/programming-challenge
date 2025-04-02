package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.services.CSVService;
import de.bcxp.challenge.model.CountryEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CountryEntryControllerTests {

    @Test
    @DisplayName("Invalid constructor test")
    void constructCountryControllerWhenParameterNullTest(){
        //Arrange & Act
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new CountryEntryController(null),
                "Expected working constructor to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains("Parameter cannot be null."));
    }

    @Test
    @DisplayName("Valid constructor test")
    void constructCountryControllerWhenParameterOKTest(){
        //Arrange
        CSVService<CountryEntry> csvService = new CSVService<>("temp", ',', CountryEntry.class);

        //Act
        CountryEntryController countryEntryController = new CountryEntryController(csvService);

        //Assert
        assertEquals(csvService, countryEntryController.countryEntryIService);
    }

    @Test
    @DisplayName("Get densest populated country from provided sample data.")
    void getDensestPopulatedCountryWithGivenCSVTest() {
        //Arrange
        CountryEntryController countryEntryController = new CountryEntryController(new CSVService<>("src/main/resources/de/bcxp/challenge/countries.csv", ';', CountryEntry.class));

        //Act
        String result = countryEntryController.getDensestPopulatedCountry();

        //Assert
        assertEquals("Malta", result);
    }

    @Test
    @DisplayName("Compute densest populated country when parameter bad.")
    void computeDensestPopulatedAreaWhenInputParameterBadTest (){
        //Arrange
        CSVService<CountryEntry> csvService = new CSVService<>("src/main/resources/de/bcxp/challenge/countries.csv", ';', CountryEntry.class);
        CountryEntryController countryEntryController = new CountryEntryController(csvService);

        //Act
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> countryEntryController.computeDensestPopulatedArea(null),
                "Expected working constructor to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains("Parameter should not be null."));
    }

    @Test
    @DisplayName("Compute densest populated country when parameter bad.")
    void computeDensestPopulatedAreaWhenInputParameterEmptyTest (){
        //Arrange
        CSVService<CountryEntry> csvService = new CSVService<>("src/main/resources/de/bcxp/challenge/countries.csv", ';', CountryEntry.class);
        CountryEntryController countryEntryController = new CountryEntryController(csvService);

        //Act
        String result = countryEntryController.computeDensestPopulatedArea(new ArrayList<>());

        //Assert
        assertNull(result);
    }

    @Test
    @DisplayName("Compute densest populated country from provided sample data.")
    void computeDensestPopulatedAreaWhenInputOKTest (){
       //Arrange
       CSVService<CountryEntry> csvService = new CSVService<>("src/main/resources/de/bcxp/challenge/countries.csv", ';', CountryEntry.class);
       CountryEntryController countryEntryController = new CountryEntryController(csvService);

       //Act
       String result = countryEntryController.computeDensestPopulatedArea(csvService.getEntries());

       //Assert
       assertEquals("Malta", result);
   }

}
