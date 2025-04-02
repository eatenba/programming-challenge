package de.bcxp.challenge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryEntryTests {

    @Test
    @DisplayName("Test setter/getter of property Name")
    public void setgetNameTest(){
        //Arrange
        String name = "Test";
        CountryEntry countryEntry = new CountryEntry();

        //Act
        countryEntry.setName(name);

        //Assert
        assertEquals(name, countryEntry.getName());
    }

    @Test
    @DisplayName("Test setter/getter of property Area")
    public void setgetAreaTest(){
        //Arrange
        int area = 100;
        CountryEntry countryEntry = new CountryEntry();

        //Act
        countryEntry.setArea(area);

        //Assert
        assertEquals(area, countryEntry.getArea());
    }

    @Test
    @DisplayName("Test setter/getter of property Population")
    public void setgetPopulationTest(){
        //Arrange
        int population = 100;
        CountryEntry countryEntry = new CountryEntry();

        //Act
        countryEntry.setPopulation(population);

        //Assert
        assertEquals(population, countryEntry.getPopulation());
    }

}
