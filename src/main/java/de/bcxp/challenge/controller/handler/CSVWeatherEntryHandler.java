package de.bcxp.challenge.controller.handler;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import de.bcxp.challenge.model.WeatherEntry;

import java.io.FileReader;
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
     * Method instantiates a CSVReader instance with values set according to data found in weather.csv
     * @param reader Should be a valid instance of a FileReader.
     * @return Instantiated CSVReader if input was correct, else throws IllegalArgumentException with error note.
     */
    protected CSVReader getReaderForWeatherCSV(FileReader reader){
        if(reader != null){
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(',')
                    .withIgnoreQuotations(true)
                    .build();

            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build();
            return csvReader;
        }
        else {
            throw new IllegalArgumentException("Input parameter should not be null.");
        }

    }

    /**
     * Method reads weather data in CSV format into List<String[]> format.
     * @param csvFilePath Valid filepath to weather data in csv format.
     * @return Weather data of input CSV file in format List<String[]>
     * @throws Exception if input path is wrong/empty/false or instantiating the CSVReader is bad.
     */
    protected List<String[]> readCSVLines(String csvFilePath) throws Exception{
        try (FileReader filereader = new FileReader(csvFilePath); ) {
            CSVReader csvReader = getReaderForWeatherCSV(filereader);
            return csvReader.readAll();
        }
    }

    /**
     * TODO
     * @return
     */
    @Override
    public List<WeatherEntry> getWeatherEntries() {
        try {
            List<String[]> csvLines = this.readCSVLines(this.getCsvFilePath());
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
