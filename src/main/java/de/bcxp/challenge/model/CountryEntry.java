package de.bcxp.challenge.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import de.bcxp.challenge.model.converter.IntegerConverter;

public class CountryEntry {

    @CsvBindByName(column = "Name")
    private String name;
    @CsvCustomBindByName(converter = IntegerConverter.class, column = "Population")
    private int population;
    @CsvCustomBindByName(converter = IntegerConverter.class, column = "Area")
    private int area;

    public CountryEntry() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
