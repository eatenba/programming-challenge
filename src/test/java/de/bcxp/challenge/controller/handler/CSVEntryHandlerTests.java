package de.bcxp.challenge.controller.handler;

import de.bcxp.challenge.model.WeatherEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVEntryHandlerTests {

    @Test
    @DisplayName("Invalid constructor test")
    void constructCSVEntryHandlerWhenCSVFilePathNullTest(){
        //Arrange & Act
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new CSVEntryHandler<WeatherEntry>(null, '1', WeatherEntry.class),
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
                () -> new CSVEntryHandler<WeatherEntry>("", '1', WeatherEntry.class),
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
                () -> new CSVEntryHandler<WeatherEntry>("src/temp.csv", '1', null),
                "Expected working constructor to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains("Parameter cannot be null."));
    }

    @Test
    @DisplayName("Valid constructor test")
    void constructCSVEntryHandlerWhenInputOKTest(){
        //Arrange & Act
        CSVEntryHandler<WeatherEntry> weatherEntry = new CSVEntryHandler<WeatherEntry>("src/temp.csv", '1', WeatherEntry.class);

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
            CSVEntryHandler<WeatherEntry> handler = new CSVEntryHandler<>(path, ',', WeatherEntry.class);
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
            CSVEntryHandler<WeatherEntry> handler = new CSVEntryHandler<>(path, ',', WeatherEntry.class);
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
