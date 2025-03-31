package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.handler.CSVEntryHandler;
import de.bcxp.challenge.model.CountryEntry;
import de.bcxp.challenge.model.WeatherEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryControllerTests {

    @Test
    @DisplayName("Input of valid CSV should return list of String arrays. Exemplary generic class set to WeatherEntry")
    void getHighestPopulatedAreaWithGivenCSVTest() {
        //Arrange
        CountryController countryController = new CountryController(new CSVEntryHandler<>("src/main/resources/de/bcxp/challenge/countries.csv", ';', CountryEntry.class));

        //Act
        String result = countryController.getHighestPopulatedCountry();

        //Assert
        assertEquals("Test", result);
    }

}
