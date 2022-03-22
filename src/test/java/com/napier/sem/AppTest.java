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




    // Population in cities with user input
    @Test
    void testWorldCitiesNull() { }

    @Test
    void displayWorldCities()
    {

    }


}