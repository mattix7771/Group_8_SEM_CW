package com.napier.sem;

import com.napier.sem.App;
import com.napier.sem.City;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /**
     * UNIT TESTS
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
        ArrayList<City> cities = new ArrayList<City>();
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
}