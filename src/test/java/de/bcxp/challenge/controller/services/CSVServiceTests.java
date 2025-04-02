package de.bcxp.challenge.controller.services;

import de.bcxp.challenge.model.WeatherEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVServiceTests {

    @Test
    @DisplayName("Invalid constructor test")
    void constructCSVEntryHandlerWhenCSVFilePathNullTest(){
        //Arrange & Act
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new CSVService<>(null, '1', WeatherEntry.class),
                "Expected working constructor to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains("Parameter cannot be null."));
    }

    @Test
    @DisplayName("Invalid constructor test")
    void constructCSVEntryHandlerWhenCSVFilePathEmptyTest(){
        //Arrange & Act
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new CSVService<>("", '1', WeatherEntry.class),
                "Expected working constructor to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains("Parameter cannot be null."));
    }

    @Test
    @DisplayName("Invalid constructor test")
    void constructCSVEntryHandlerWhenEntryTypeNullTest(){
        //Arrange & Act
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new CSVService<WeatherEntry>("src/temp.csv", '1', null),
                "Expected working constructor to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains("Parameter cannot be null."));
    }

    @Test
    @DisplayName("Valid constructor test")
    void constructCSVEntryHandlerWhenInputOKTest(){
        //Arrange & Act
        CSVService<WeatherEntry> weatherEntry = new CSVService<>("src/temp.csv", '1', WeatherEntry.class);

        //Assert
        assertEquals('1', weatherEntry.separator);
        assertEquals(WeatherEntry.class, weatherEntry.entryType);
        assertEquals("src/temp.csv", weatherEntry.csvFilePath);
    }

    @Test
    @DisplayName("Read CSV when input is correct test")
    void getEntriesWhenInputOKTest() {
        try{
            //Arrange
            String path = "src/main/resources/de/bcxp/challenge/weather.csv";
            CSVService<WeatherEntry> handler = new CSVService<>(path, ',', WeatherEntry.class);
            //Act
            List<WeatherEntry> result =  handler.getEntries();
            //Assert
            assertNotNull(result);
            assertEquals(30, result.size());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Read CSV when input is incorrect test")
    void getEntriesWhenInputBADTest() {
        try{
            //Arrange
            String path = "src/main/resources/de/bcxp/challenge/xxx.csv";
            CSVService<WeatherEntry> handler = new CSVService<>(path, ',', WeatherEntry.class);
            //Act
            List<WeatherEntry> result =  handler.getEntries();
            //Assert
            assertNotNull(result);
            assertEquals(0, result.size());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
