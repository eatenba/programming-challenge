package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.handler.CSVEntryHandler;
import de.bcxp.challenge.model.WeatherEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherControllerTests {

    @Test
    @DisplayName("Input of valid CSV should return list of String arrays. Exemplary generic class set to WeatherEntry")
    void getSmallestSpreadWithGivenCSVTest() {
        //Arrange
        WeatherController weatherController = new WeatherController(new CSVEntryHandler<>("src/main/resources/de/bcxp/challenge/weather.csv", ',', WeatherEntry.class));

        //Act
        int resultDay = weatherController.getSmallestTemperatureSpread();

        //Assert
        assertEquals(resultDay, 14);
    }

    @Test
    @DisplayName("Input of valid CSV should return list of String arrays. Exemplary generic class set to WeatherEntry")
    void isSpreadSmallerWhenSpreadIsSmallerTest() {
        //Arrange
        int currentSpread = 2;
        int contenderSpread = 1;

        //Act
        boolean result = WeatherController.isSpreadSmaller(currentSpread, contenderSpread);

        //Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Input of valid CSV should return list of String arrays. Exemplary generic class set to WeatherEntry")
    void isSpreadSmallerWhenSpreadIsNotSmallerTest() {
        //Arrange
        int currentSpread = 2;
        int contenderSpread = 3;

        //Act
        boolean result = WeatherController.isSpreadSmaller(currentSpread, contenderSpread);

        //Assert
        assertFalse(result);
    }
}
