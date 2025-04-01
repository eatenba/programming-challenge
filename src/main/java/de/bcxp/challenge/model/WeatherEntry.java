package de.bcxp.challenge.model;

import com.opencsv.bean.CsvCustomBindByName;
import de.bcxp.challenge.model.converter.IntegerConverter;
import lombok.Data;
import lombok.NonNull;

/**
 * Basic model class for WeatherEntries.
 * MAYBE: Add expected units to variable names once known.
 */
@Data
public final class WeatherEntry {

    @CsvCustomBindByName(converter = IntegerConverter.class, column = "Day")
    private int day;
    @CsvCustomBindByName(converter = IntegerConverter.class, column = "MxT")
    private int maximumTemperature;
    @CsvCustomBindByName(converter = IntegerConverter.class, column = "MnT")
    private int minimumTemperature;

    public WeatherEntry() {
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(int maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    public int getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(int minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }
}
