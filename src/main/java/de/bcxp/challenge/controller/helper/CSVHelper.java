package de.bcxp.challenge.controller.helper;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;

public class CSVHelper {

    /**
     * Method instantiates a CSVReader instance.
     * @param reader Should be a valid instance of a FileReader.
     * @param separator Separator found in CSV file.
     * @param skipLines Header lines to skip in CSV file.
     * @return Correctly instantiated CSVReader instance.
     */
    protected static CSVReader getReaderForWeatherCSV(FileReader reader, char separator, int skipLines){
        if(reader != null){
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(separator)
                    .withIgnoreQuotations(true)
                    .build();
            return new CSVReaderBuilder(reader)
                    .withSkipLines(skipLines)
                    .withCSVParser(parser)
                    .build();
        }
        else {
            throw new IllegalArgumentException("Input parameter should not be null.");
        }

    }

    /**
     * Method reads weather data in CSV format into List<String[]> format.
     * @param csvFilePath Valid filepath to weather data in csv format.
     * @param separator Separator found in CSV file.
     * @param skipLines Header lines to skip in CSV file.
     * @return Data of input CSV file in format List<String[]>
     * @throws Exception if input path is wrong/empty/false or instantiating the CSVReader is bad.
     */
    public static List<String[]> readCSVLines(String csvFilePath, char separator, int skipLines) throws Exception{
        try (FileReader filereader = new FileReader(csvFilePath) ) {
            CSVReader csvReader = getReaderForWeatherCSV(filereader, separator, skipLines);
            return csvReader.readAll();
        }
    }
}
