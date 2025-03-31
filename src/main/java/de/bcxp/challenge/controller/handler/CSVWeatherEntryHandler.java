package de.bcxp.challenge.controller.handler;

import de.bcxp.challenge.controller.helper.CSVHelper;
import de.bcxp.challenge.model.WeatherEntry;

import java.util.List;

/**
 * Basic weather data handler for working with data provided in CSV format.
 */
public class CSVWeatherEntryHandler implements IWeatherEntryHandler{

    private String csvFilePath;

    /**
     * Default constructor should be given a valid csv file path.
     * Will be checked down the line
     * @param csvFilePath: Param cannot be blank or null, else a IllegalargumentException is thrown.
     */
    public CSVWeatherEntryHandler(String csvFilePath){
        this.setCsvFilePath(csvFilePath);
    }

    /**
     * TODO
     * @return
     */
    @Override
    public List<WeatherEntry> getWeatherEntries() {
        try {
            List<String[]> csvLines = CSVHelper.readCSVLines(this.getCsvFilePath(), ',', 1);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    /**
     * Default getter for variable.
     * @return Path to handled CSV file.
     */
    public String getCsvFilePath() {
        return csvFilePath;
    }

    /**
     * Adapted setter for variable.
     * Checks if input is null or blank - throws IllegalArgumentException if so.
     * @param csvFilePath Should contain valid path to to be handled CSV file.
     */
    public void setCsvFilePath(String csvFilePath) {
        if(csvFilePath == null || csvFilePath.isBlank()){
            throw new IllegalArgumentException("Input path cannot be null or blank.");
        }else {
            this.csvFilePath = csvFilePath;
        }
    }
}
