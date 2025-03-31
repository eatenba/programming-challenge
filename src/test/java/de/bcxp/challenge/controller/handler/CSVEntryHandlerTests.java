package de.bcxp.challenge.controller.handler;

import de.bcxp.challenge.model.WeatherEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CSVEntryHandlerTests {

    @Test
    @DisplayName("Input of valid CSV should return list of String arrays. Exemplary generic class set to WeatherEntry")
    void readCSVLinesWhenInputOKTest() {
        try{
            //Arrange
            String path = "src/main/resources/de/bcxp/challenge/weather.csv";
            CSVEntryHandler<WeatherEntry> handler = new CSVEntryHandler<>(path, ',', WeatherEntry.class);
            //Act
            List<WeatherEntry> result =  handler.getEntries();
            //Assert
            assertNotNull(result);
        }
        catch(Exception e){
            System.out.println("Temp");
        }
    }

}
