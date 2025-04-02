package de.bcxp.challenge.view;

import de.bcxp.challenge.controller.CountryController;
import de.bcxp.challenge.controller.WeatherController;
import de.bcxp.challenge.controller.handler.CSVEntryHandler;
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
        WeatherController weatherController = new WeatherController(new CSVEntryHandler<>("src/main/resources/de/bcxp/challenge/weather.csv", ',', WeatherEntry.class));
        int dayWithSmallestTempSpread = weatherController.getSmallestTemperatureSpread();     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        CountryController countryController = new CountryController(new CSVEntryHandler<>("src/main/resources/de/bcxp/challenge/countries.csv", ';', CountryEntry.class));
        String countryWithHighestPopulationDensity = countryController.getDensestPopulatedCountry(); // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
