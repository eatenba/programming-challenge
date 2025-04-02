package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.services.CSVService;
import de.bcxp.challenge.model.WeatherEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherEntryControllerTests {

    @Test
    @DisplayName("Invalid constructor test")
    void constructWeatherControllerWhenParameterNullTest(){
        //Arrange & Act
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new WeatherEntryController(null),
                "Expected working constructor to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains("Parameter cannot be null."));
    }

    @Test
    @DisplayName("Valid constructor test")
    void constructWeatherControllerWhenParameterOKTest(){
        //Arrange
        CSVService<WeatherEntry> csvService = new CSVService<>("temp", ',', WeatherEntry.class);

        //Act
        WeatherEntryController weatherEntryController = new WeatherEntryController(csvService);

        //Assert
        assertEquals(csvService, weatherEntryController.weatherEntryIService);
    }

    @Test
    @DisplayName("Input of valid CSV should return list of String arrays. Exemplary generic class set to WeatherEntry")
    void getSmallestSpreadWithGivenCSVTest() {
        //Arrange
        WeatherEntryController weatherEntryController = new WeatherEntryController(new CSVService<>("src/main/resources/de/bcxp/challenge/weather.csv", ',', WeatherEntry.class));

        //Act
        int resultDay = weatherEntryController.getSmallestTemperatureSpread();

        //Assert
        assertEquals(resultDay, 14);
    }

    @Test
    @DisplayName("Compute smallest weather spread day when parameter bad.")
    void computeSmallestTemperatureSpreadWhenInputParameterBadTest (){
        //Arrange
        CSVService<WeatherEntry> csvService = new CSVService<>("src/main/resources/de/bcxp/challenge/weather.csv", ',', WeatherEntry.class);
        WeatherEntryController weatherEntryController = new WeatherEntryController(csvService);

        //Act
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> weatherEntryController.computeSmallestTemperatureSpread(null),
                "Expected working constructor to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains("Parameter should not be null."));
    }

    @Test
    @DisplayName("Compute smallest weather spread day when parameter bad.")
    void computeSmallestTemperatureSpreadWhenInputParameterEmptyTest (){
        //Arrange
        CSVService<WeatherEntry> csvService = new CSVService<>("src/main/resources/de/bcxp/challenge/weather.csv", ',', WeatherEntry.class);
        WeatherEntryController weatherEntryController = new WeatherEntryController(csvService);

        //Act
        int result = weatherEntryController.computeSmallestTemperatureSpread(new ArrayList<>());

        //Assert
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Compute smallest weather spread day from provided sample data.")
    void computeSmallestTemperatureSpreadWhenInputOKTest (){
        //Arrange
        CSVService<WeatherEntry> csvService = new CSVService<>("src/main/resources/de/bcxp/challenge/weather.csv", ',', WeatherEntry.class);
        WeatherEntryController weatherEntryController = new WeatherEntryController(csvService);

        //Act
        int result = weatherEntryController.computeSmallestTemperatureSpread(csvService.getEntries());

        //Assert
        assertEquals(14, result);
    }

}
