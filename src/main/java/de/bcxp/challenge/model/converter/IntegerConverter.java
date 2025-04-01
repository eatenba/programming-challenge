package de.bcxp.challenge.model.converter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public final class IntegerConverter extends AbstractBeanField<Integer, String> {
    @Override
    protected Integer convert(String value) throws CsvDataTypeMismatchException {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new CsvDataTypeMismatchException("Invalid integer value: " + value);
        }
    }
}

