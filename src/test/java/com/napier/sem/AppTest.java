package com.napier.sem;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Unit Tests
 */
public class AppTest
{
    /**
     * Creating app object
     */
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /**
     * City tests
     */
    @Test // Null test
    void testDisplayCityNull()
    {
        app.displayCity(null);
    }

    @Test // Displaying city information test
    void displayCity()
    {
        City city = new City();
        city.setId(1);
        city.setPopulation(500000);
        city.setName("London");
        app.displayCity(city);
    }

    @Test // Empty arrayList test
    void testDisplayPrintCitiesEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCities(cities);
    }

    @Test // Null arrayList test
    void testDisplayPrintCitiesNull()
    {
        app.printCities(null);
    }

    @Test // Display arrayList information test v2
    void testDisplayPrintCitiesNameNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.setId(2);
        city.setName(null);
        city.setDistrict("Essex");
        city.setCountryCode(null);
        city.setPopulation(45452);
        cities.add(city);
        app.printCities(cities);
    }

    @Test // Display arrayList information test
    void displayPrintCities()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.setId(2);
        city.setName("London");
        city.setDistrict("Essex");
        city.setCountryCode("0124");
        city.setPopulation(5860);
        cities.add(city);
        app.printCities(cities);
    }

    /**
     * Country tests
     */
    @Test // Displaying country information test
    void displayCountry()
    {
        Country country = new Country();
        country.setCode("010");
        country.setName("UK");
        country.setContinent("Brexit");
        country.setRegion("Scotland");
        country.setCapital("Edinburgh");
        country.setPopulation(456660);
        app.displayCountry(country);
    }

    @Test // Null country test
    void testDisplayCountryNull()
    {
        app.displayCountry(null);
    }

    @Test // Empty arrayList test
    void testDisplayPrintCountriesEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountry(countries);
    }

    @Test // Null arrayList
    void testDisplayPrintCountriesNull() { app.printCountry(null); }

    @Test // Display arrayList information test
    void displayPrintCountries()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country();
        country.setName("England");
        country.setPopulation(56486);
        country.setCapital("London");
        country.setRegion("South");
        country.setContinent("UK");
        country.setCode("456465");
        countries.add(country);
        app.printCountry(countries);
    }

    /**
     * Stats tests
     */
    @Test // Population stats NULL test
    void testDisplayPrintStatsPopulationNull(){ app.printStatsPopulation(null); }

    @Test // Population stats EMPTY test
    void testDisplayPrintStatsPopulationEmpty()
    {
        ArrayList<Stats> stats = new ArrayList<Stats>();
        app.printStatsPopulation(stats);
    }

    @Test // Display population stats arrayList test
    void displayPrintStatsPopulation()
    {
        ArrayList<Stats> stats = new ArrayList<Stats>();
        Stats statistics = new Stats();
        statistics.setPlace("Cardiff");
        statistics.setPlacePop(564156);
        statistics.setRuralPop(452452);
        statistics.setUrbanPop(4545245);
        statistics.setUrbPercentage("45%");
        statistics.setRuralPercentage("55%");
        stats.add(statistics);
        app.printStatsPopulation(stats);
    }

    @Test // Language stats NULL test
    void testDisplayPrintStatsLanguageNull() { app.printStatsLanguage(null); }

    @Test // Language stats EMPTY test
    void testDisplayPrintStatsLanguageEmpty()
    {
        ArrayList<Stats> stats = new ArrayList<Stats>();
        app.printStatsLanguage(stats);
    }

    @Test // Display language stats test
    void displayPrintStatsLanguage()
    {
        ArrayList<Stats> stats = new ArrayList<Stats>();
        Stats statistics = new Stats();
        statistics.setLanguage("Arabic");
        statistics.setTotalSpeakers(165450);
        statistics.setTotalSpeakersPercentage("12%");
        stats.add(statistics);
        app.printStatsLanguage(stats);
    }

    @Test // Single population NULL test
    void testDisplayPrintSinglePopNull()
    {
        app.printSinglePop(null);
    }

    /**
     * Capital tests
     */
    @Test // Capital NULL test
    void testDislayPrintCapitalsNUll(){ app.printCapitals(null); }

    @Test // Capital EMPTY test
    void testDisplayPrintCapitalsEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitals(cities);
    }

    @Test // Display capital test
    void displayPrintCapitals()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City capital = new City();
        capital.setName("London");
        capital.setCountryCode("UK-005");
        capital.setPopulation(6004);
        cities.add(capital);
        app.printCapitals(cities);
    }
}