package de.bcxp.challenge.controller;

import de.bcxp.challenge.controller.handler.IHandler;
import de.bcxp.challenge.model.CountryEntry;

import java.util.List;

public class CountryController {

    private final IHandler<CountryEntry> countryEntryIHandler;

    public CountryController(IHandler<CountryEntry> countryEntryIHandler) {
        this.countryEntryIHandler = countryEntryIHandler;
    }

    public String getHighestPopulatedCountry(){
        List<CountryEntry> countryEntries = countryEntryIHandler.getEntries();
        return "TODO";
    }

}
