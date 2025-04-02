package de.bcxp.challenge.view;

import de.bcxp.challenge.controller.CountryEntryController;
import de.bcxp.challenge.controller.WeatherEntryController;
import de.bcxp.challenge.controller.services.CSVService;
import de.bcxp.challenge.model.CountryEntry;
import de.bcxp.challenge.model.WeatherEntry;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        WeatherEntryController weatherEntryController = new WeatherEntryController(new CSVService<>("src/main/resources/de/bcxp/challenge/weather.csv", ',', WeatherEntry.class));
        int dayWithSmallestTempSpread = weatherEntryController.getSmallestTemperatureSpread();     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        CountryEntryController countryEntryController = new CountryEntryController(new CSVService<>("src/main/resources/de/bcxp/challenge/countries.csv", ';', CountryEntry.class));
        String countryWithHighestPopulationDensity = countryEntryController.getDensestPopulatedCountry(); // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
