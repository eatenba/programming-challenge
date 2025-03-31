package de.bcxp.challenge.controller.helper;

import de.bcxp.challenge.controller.handler.CSVWeatherEntryHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CSVHelperTests {
    @Test
    @DisplayName("Input of valid CSV should return list of String arrays")
    void readCSVLinesWhenInputOKTest() {
        //Arrange
        String path = "src/main/resources/de/bcxp/challenge/weather.csv";
        CSVWeatherEntryHandler handler = new CSVWeatherEntryHandler(path);

        //Act
        try{
            List<String[]> result =  CSVHelper.readCSVLines(path, ',', 1);
            assertNotNull(result);
        }
        catch(Exception e){

        }
    }
}
