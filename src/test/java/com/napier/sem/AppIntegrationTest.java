package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration Tests
 */
public class AppIntegrationTest {

    /**
     * Connection to database setup
     */
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    @Test  //City extraction test
    void testGetCity()
    {
        City city = app.getCity("London");
        assertEquals(city.getCountryCode(), "GBR");
        assertEquals(city.getPopulation(), 7285000);
        assertEquals(city.getDistrict(), "England");
    }

    @Test  //Country extraction test
    void testGetCountry()
    {
        Country country = app.getCountry("United Kingdom");
        assertEquals(country.getCode(), "GBR");
        assertEquals(country.getName(), "United Kingdom");
        assertEquals(country.getContinent(), "Europe");
        assertEquals(country.getRegion(), "British Islands");
        assertEquals(country.getSurfaceArea(), 242900.00);
        assertEquals(country.getIndepYear(), 1066);
        assertEquals(country.getPopulation(), 59623400);
        assertEquals(country.getLifeExpectancy(), 77.7);
        assertEquals(country.getGnp(), 1378330.00);
        assertEquals(country.getGnpOld(), 1296830.00);
        assertEquals(country.getLocalName(), "United Kingdom");
        assertEquals(country.getGovernmentForm(), "Constitutional Monarchy");
        assertEquals(country.getHeadOfState(), "Elisabeth II");
        assertEquals(country.getCapital(), "456");
        assertEquals(country.getCode2(), "GB");
    }

    @Test  //Extraction of all cities test
    void testGetAllCities()
    {
        List<City> cities = app.getAllCities();
        assertEquals(cities.size(), 4079);
    }

    @Test  //Extraction of all cities with limited results test
    void testGetAllCitiesWithLimit()
    {
        List<City> cities = app.getAllCities(100);
        assertEquals(cities.size(), 100);
    }

    @Test  //Extraction of all cities within continent test
    void testGetAllCitiesWithinContinent()
    {
        List<City> cities = app.getAllCitiesC("Europe");
        assertEquals(cities.size(), 841);
    }

    @Test  //Extraction of all cities within continent and limited results test
    void testGetAllCitiesWithinContinentAndLimit()
    {
        List<City> cities = app.getAllCitiesC("Europe", 100);
        assertEquals(cities.size(), 100);

        Country country = app.getCountryC(cities.get(0).getCountryCode());
        assertEquals(country.getContinent(), "Europe");
    }

    @Test  //Extraction of all cities within region test
    void testGetAllCitiesWithinRegion()
    {
        List<City> cities = app.getAllCitiesR("British Islands");
        assertEquals(cities.size(), 83);
    }

    @Test  //Extraction of all cities within region and limited results test
    void testGetAllCitiesWithinRegionAndLimit()
    {
        List<City> cities = app.getAllCitiesR("British Islands", 50);
        assertEquals(cities.size(), 50);

        Country country = app.getCountryC(cities.get(0).getCountryCode());
        assertEquals(country.getRegion(), "British Islands");
    }

    @Test  //Extraction of all cities within district test
    void testGetAllCitiesWithinDistrict()
    {
        List<City> cities = app.getAllCitiesD("Veneto");
        assertEquals(cities.size(), 4);
    }

    @Test  //Extraction of all cities within district and limited results test
    void testGetAllCitiesWithinDistrictAndLimit()
    {
        List<City> cities = app.getAllCitiesD("Veneto", 2);
        assertEquals(cities.size(), 2);
        assertEquals(cities.get(0).getDistrict(), "Veneto");
    }

    @Test //Extraction of all capitals test
    void testGetAllCapitals(){
        List<City> capitals = app.getAllCapitals();
        assertEquals(capitals.size(), 232);
    }

    @Test //Extraction of all capitals with limit test
    void testGetAllCapitalsWithLimit(){
        List<City> capitals = app.getAllCapitals(100);
        assertEquals(capitals.size(), 100);
    }

    @Test //Extraction of all capitals within a region
    void testGetAllCapitalsWithinRegion(){
        List<City> capitals = app.getAllCapitalsRegion("Southern Europe");
        assertEquals(capitals.size(), 15);
    }

    @Test //Extraction of all capitals within a region and limited results test
    void testGetAllCapitalsWithinRegionAndLimit(){
        List<City> capitals = app.getAllCapitalsRegion(10, "Southern Europe");
        assertEquals(capitals.size(), 10);

        Country c = app.getCountry(capitals.get(0).getCountryCode());
        assertEquals(c.getRegion(), "Southern Europe");
    }

    @Test //Extraction of all capitals within a continent test
    void testGetAllCapitalsWithinContinent(){
        List<City> capitals = app.getAllCapitalsContinent("Europe");
        assertEquals(capitals.size(), 46);
    }

    @Test //Extraction of all capitals within a continent and limited results test
    void testGetAllCapitalsWithinContinentAndLimit(){
        List<City> capitals = app.getAllCapitalsContinent(20, "Europe");
        assertEquals(capitals.size(), 20);

        Country c = app.getCountry(capitals.get(0).getCountryCode());
        assertEquals(c.getContinent(), "Europe");
    }

/*
    @Test //Extraction of all capitals
    void testGetAllCapitals(){
        List<City> capitals = app.getAllCapitals();
    }
 */
}
