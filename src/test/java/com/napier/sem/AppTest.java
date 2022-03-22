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


    // Population tests ----------------------------------
    // City
    @Test
    void testDisplayCityNull()
    {
        app.displayCity(null);
    }

    @Test
    void displayCity()
    {

        City city = new City();
        city.setId(1);
        city.setPopulation(500000);
        city.setName("London");
        app.displayCity(city);
    }

    // World
    @Test
    void testDisplayWorldPopNull() { app.displayWorldPop(null); }

    @Test
    void displayWorldPop()
    {
        Country world = new Country();
        world.setPopulation(15435456);
        app.displayWorldPop(world);
    }

    // Continent
    @Test
    void testDisplayContinentPopNull() { app.displayContinentPop(null); }

    @Test
    void displayContinentPop()
    {
        Country continent = new Country();
        continent.setContinent("Africa");
        continent.setCode("1235");
        continent.setPopulation(854600);
        app.displayContinentPop(continent);
    }

    //Region
    @Test
    void testDisplayRegionPopNull() { app.displayRegionPop(null); }

    @Test
    void displayRegionPop()
    {
        Country region = new Country();
        region.setCode("1587");
        region.setPopulation(54882);
        region.setRegion("Albama");
        app.displayRegionPop(region);
    }

    // Country
    @Test
    void testDisplayCountryPopNull() { app.displayCountryPop(null); }

    @Test
    void displayCountryPop()
    {
        Country country = new Country();
        country.setCode("1258");
        country.setPopulation(500000);
        country.setName("Australia");
        app.displayCountryPop(country);
    }

    //District
    @Test
    void testDisplayDistrictPopNull() { app.displayDistrictPop(null); }

    @Test
    void displayDistrictPop()
    {
        City city = new City();
        city.setName("Area51");
        city.setDistrict("Lumberjack");
        city.setPopulation(456);
        app.displayDistrictPop(city);
    }

    // Population in cities with user input
    @Test
    void testWorldCitiesNull() { }

    @Test
    void displayWorldCities()
    {

    }


}