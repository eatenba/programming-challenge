package de.bcxp.challenge.controller.handler;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public final class CSVEntryHandler<T> implements IHandler<T>{

    protected String csvFilePath;
    protected char separator;
    protected Class<T> entryType;

    /**
     * Default constructor should be given a valid csv file path.
     * Will be checked down the line
     * @param csvFilePath: Param cannot be blank or null, else a IllegalArgumentException is thrown.
     */
    public CSVEntryHandler(String csvFilePath, char separator, Class<T> entryType){
        if(csvFilePath == null || csvFilePath.isBlank() || entryType == null){
            throw new IllegalArgumentException("Parameter cannot be null.");
        }
        this.entryType = entryType;
        this.csvFilePath = csvFilePath;
        this.separator = separator;
    }

    /**
     * Implements getEntries from Interface with generic class.
     * @return List of entry instances if found. Else returns empty ArrayList.
     */
    @Override
    public List<T> getEntries() {
        try {
            Reader reader = new BufferedReader(new FileReader(this.csvFilePath));
            CsvToBean<T> csvReader = new CsvToBeanBuilder<T>(reader)
                    .withType(this.entryType)
                    .withSeparator(this.separator)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .withThrowExceptions(false)
                    .build();
            List<T> parsedEntries = csvReader.parse();
            logFaultyEntries(csvReader.getCapturedExceptions());
            return parsedEntries;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Function logs faulty CSV lines to error output.
     * Could be replaced by a more sophisticated logging interface in production env.
     * @param exceptionsList List of exceptions produced by CsvReader
     */
    protected void logFaultyEntries(List<CsvException> exceptionsList){
        for (int i = 0; i < exceptionsList.size(); i++) {
            CsvException exception = exceptionsList.get(i);
            System.err.println("Skipped bad CSV line: " + exception.getLineNumber());
            System.err.println("Error message: " + exception.getMessage());
        }
    }
}
