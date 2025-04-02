package de.bcxp.challenge.model.converter;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerConverterTests {

    @Test
    @DisplayName("Conversion test if input is integer.")
    public void convertWhenInputIntegerTest(){
        //Arrange
        IntegerConverter integerConverter = new IntegerConverter();

        try{
            //Act
            Integer result = integerConverter.convert("1");

            //Assert
            assertEquals(1, result);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Test"})
    public void convertWhenInputInvalidTest(String input){
        //Arrange
        IntegerConverter integerConverter = new IntegerConverter();

        CsvDataTypeMismatchException thrown = assertThrows(
                CsvDataTypeMismatchException.class,
                () -> integerConverter.convert(input),
                "Expected working constructor to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains("Invalid integer value:"));

    }

}
