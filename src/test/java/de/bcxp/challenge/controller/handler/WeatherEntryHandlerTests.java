package de.bcxp.challenge.controller.handler;

import de.bcxp.challenge.controller.WeatherEntryController;
import de.bcxp.challenge.model.WeatherEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherEntryHandlerTests {


    @Test
    @DisplayName("Input of valid CSV should return list of String arrays. Exemplary generic class set to WeatherEntry")
    void isContenderSpreadSmallerWhenSpreadIsSmallerTest() {
        //Arrange
        int currentSpread = 2;
        int contenderSpread = 1;

        //Act
        boolean result = WeatherEntryHandler.isContenderSpreadSmaller(currentSpread, contenderSpread);

        //Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Input of valid CSV should return list of String arrays. Exemplary generic class set to WeatherEntry")
    void isContenderSpreadSmallerWhenSpreadIsNotSmallerTest() {
        //Arrange
        int currentSpread = 2;
        int contenderSpread = 3;

        //Act
        boolean result = WeatherEntryHandler.isContenderSpreadSmaller(currentSpread, contenderSpread);

        //Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Compute day spread when input is valid.")
    void getWeatherEntryDaySpreadWhenInputOKTest(){
        //Arrange
        WeatherEntry weatherEntry = new WeatherEntry();
        weatherEntry.setMaximumTemperature(100);
        weatherEntry.setMinimumTemperature(1);

        //Act
        int result = WeatherEntryHandler.getWeatherEntryDaySpread(weatherEntry);

        //Assert
        assertEquals(99, result);
    }

    @Test
    @DisplayName("Compute day spread when input is null.")
    void getWeatherEntryDaySpreadWhenInputNullTest(){
        //Arrange

        //Act
        int result = WeatherEntryHandler.getWeatherEntryDaySpread(null);

        //Assert
        assertEquals(0, result);
    }

}
