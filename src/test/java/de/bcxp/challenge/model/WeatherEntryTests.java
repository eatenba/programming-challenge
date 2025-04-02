package de.bcxp.challenge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherEntryTests {

    @Test
    @DisplayName("Test setter/getter of property MaximumTemperature")
    public void setgetMaximumTemperatureTest(){
        //Arrange
        int mxt = 100;
        WeatherEntry weatherEntry = new WeatherEntry();

        //Act
        weatherEntry.setMaximumTemperature(mxt);

        //Assert
        assertEquals(mxt, weatherEntry.getMaximumTemperature());
    }

    @Test
    @DisplayName("Test setter/getter of property MinimumTemperature")
    public void setgetMinimumTemperatureTest(){
        //Arrange
        int mnt = 100;
        WeatherEntry weatherEntry = new WeatherEntry();

        //Act
        weatherEntry.setMinimumTemperature(mnt);

        //Assert
        assertEquals(mnt, weatherEntry.getMinimumTemperature());
    }

    @Test
    @DisplayName("Test setter/getter of property Day")
    public void setgetDayTest(){
        //Arrange
        int day = 100;
        WeatherEntry weatherEntry = new WeatherEntry();

        //Act
        weatherEntry.setDay(day);

        //Assert
        assertEquals(day, weatherEntry.getDay());
    }

}
