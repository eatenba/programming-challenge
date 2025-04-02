package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.handler.CSVEntryHandler;
import de.bcxp.challenge.model.CountryEntry;
import de.bcxp.challenge.model.WeatherEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherControllerTests {

    @Test
    @DisplayName("Invalid constructor test")
    void constructWeatherControllerWhenParameterNullTest(){
        //Arrange & Act
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new WeatherController(null),
                "Expected working constructor to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains("Parameter cannot be null."));
    }

    @Test
    @DisplayName("Valid constructor test")
    void constructWeatherControllerWhenParameterOKTest(){
        //Arrange
        CSVEntryHandler<WeatherEntry> csvEntryHandler = new CSVEntryHandler<>("temp", ',', WeatherEntry.class);

        //Act
        WeatherController weatherController = new WeatherController(csvEntryHandler);

        //Assert
        assertEquals(csvEntryHandler, weatherController.weatherEntryIHandler);
    }

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
    @DisplayName("Compute smallest weather spread day when parameter bad.")
    void computeSmallestTemperatureSpreadWhenInputParameterBadTest (){
        //Arrange
        CSVEntryHandler<WeatherEntry> csvEntryHandler = new CSVEntryHandler<>("src/main/resources/de/bcxp/challenge/weather.csv", ',', WeatherEntry.class);
        WeatherController weatherController = new WeatherController(csvEntryHandler);

        //Act
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> weatherController.computeSmallestTemperatureSpread(null),
                "Expected working constructor to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains("Parameter should not be null."));
    }

    @Test
    @DisplayName("Compute smallest weather spread day when parameter bad.")
    void computeSmallestTemperatureSpreadWhenInputParameterEmptyTest (){
        //Arrange
        CSVEntryHandler<WeatherEntry> csvEntryHandler = new CSVEntryHandler<>("src/main/resources/de/bcxp/challenge/weather.csv", ',', WeatherEntry.class);
        WeatherController weatherController = new WeatherController(csvEntryHandler);

        //Act
        int result = weatherController.computeSmallestTemperatureSpread(new ArrayList<>());

        //Assert
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Compute smallest weather spread day from provided sample data.")
    void computeSmallestTemperatureSpreadWhenInputOKTest (){
        //Arrange
        CSVEntryHandler<WeatherEntry> csvEntryHandler = new CSVEntryHandler<>("src/main/resources/de/bcxp/challenge/weather.csv", ',', WeatherEntry.class);
        WeatherController weatherController = new WeatherController(csvEntryHandler);

        //Act
        int result = weatherController.computeSmallestTemperatureSpread(csvEntryHandler.getEntries());

        //Assert
        assertEquals(14, result);
    }

    @Test
    @DisplayName("Input of valid CSV should return list of String arrays. Exemplary generic class set to WeatherEntry")
    void isContenderSpreadSmallerWhenSpreadIsSmallerTest() {
        //Arrange
        int currentSpread = 2;
        int contenderSpread = 1;

        //Act
        boolean result = WeatherController.isContenderSpreadSmaller(currentSpread, contenderSpread);

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
        boolean result = WeatherController.isContenderSpreadSmaller(currentSpread, contenderSpread);

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
        int result = WeatherController.getWeatherEntryDaySpread(weatherEntry);

        //Assert
        assertEquals(99, result);
    }

    @Test
    @DisplayName("Compute day spread when input is null.")
    void getWeatherEntryDaySpreadWhenInputNullTest(){
        //Arrange

        //Act
        int result = WeatherController.getWeatherEntryDaySpread(null);

        //Assert
        assertEquals(0, result);
    }
}
