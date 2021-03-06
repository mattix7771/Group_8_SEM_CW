package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.sql.SQLException;
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
        assertEquals(country.getCapital(), "London");
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

    @Test //Extraction of population statistics of all regions test
    void testGetPopStatsByRegion(){
        List<Stats> stats = app.getPopStatsByRegion();

        for(int i = 0; i < stats.size(); i++){
            if(stats.get(i).getPlace().equals("Southern Europe")){
                assertEquals(stats.get(i).getPlace(), "Southern Europe");
                assertEquals(stats.get(i).getPlacePop(), 144674200);
                assertEquals(stats.get(i).getRuralPop(), 104657542);
                assertEquals(stats.get(i).getRuralPercentage(), 72.34+"%");
                assertEquals(stats.get(i).getUrbanPop(), 40016658);
                assertEquals(stats.get(i).getUrbPercentage(), 27.66+"%");
            }
        }
    }

    @Test //Extraction of population statistics of all countries test
    void testGetPopStatsByCountry(){
        List<Stats> stats = app.getPopStatsByCountry();

        for(int i = 0; i < stats.size(); i++){
            if(stats.get(i).getPlace().equals("Italy")){
                assertEquals(stats.get(i).getPlace(), "Italy");
                assertEquals(stats.get(i).getPlacePop(), 57680000);
                assertEquals(stats.get(i).getRuralPop(), 42592981);
                assertEquals(stats.get(i).getRuralPercentage(), 73.84+"%");
                assertEquals(stats.get(i).getUrbanPop(), 15087019);
                assertEquals(stats.get(i).getUrbPercentage(), 26.16+"%");
            }
        }
    }

    @Test //Extraction of population statistics of all continents test
    void testGetPopStatsByContinent(){
        List<Stats> stats = app.getPopStatsByContinent();

        for(int i = 0; i < stats.size(); i++){
            if(stats.get(i).getPlace().equals("Europe")){
                assertEquals(stats.get(i).getPlace(), "Europe");
                assertEquals(stats.get(i).getPlacePop(), 730074600);
                assertEquals(stats.get(i).getRuralPop(), 488131787);
                assertEquals(stats.get(i).getRuralPercentage(), 66.86+"%");
                assertEquals(stats.get(i).getUrbanPop(), 241942813);
                assertEquals(stats.get(i).getUrbPercentage(), 33.14+"%");
            }
        }
    }

    @Test //Extraction of language speakers test
    void testGetAllLanguageSpeakers(){
        List<Stats> languages = app.getLanguageSpeakers();

        for(int i = 0; i < languages.size(); i++){
            if(languages.get(i).getLanguage().equals("English")){
                assertEquals(languages.get(i).getLanguage(), "English");
                assertEquals(languages.get(i).getTotalSpeakers(), 347077867);
                assertEquals(languages.get(i).getTotalSpeakersPercentage(), 5.71+"%");
            }
        }
    }

    @Test //Output cities results to table test
    void testOutputCities(){
        List<City> cities = app.getAllCities();
        app.outputCities(cities, "all_cities.md");

        String dir = "reports/all_cities.md";
        File f = new File(dir);

        assertTrue(f.exists());
        assertTrue(f.isFile());
        assertEquals(f.getName(), "all_cities.md");
    }

    @Test //Output capitals results to table test
    void testOutputCapitals(){
        List<City> capitals = app.getAllCapitals();
        app.outputCapitals(capitals, "all_capitals.md");

        String dir = "reports/all_capitals.md";
        File f = new File(dir);

        assertTrue(f.exists());
        assertTrue(f.isFile());
        assertEquals(f.getName(), "all_capitals.md");
    }

    @Test //Output countries results to table test
    void testOutputCountries(){
        List<Country> countries = app.getAllCountries();
        app.outputCountries(countries, "all_countries.md");

        String dir = "reports/all_countries.md";
        File f = new File(dir);

        assertTrue(f.exists());
        assertTrue(f.isFile());
        assertEquals(f.getName(), "all_countries.md");
    }

    @Test //Output stats results to table test
    void testOutputStats(){
        List<Stats> stats = app.getPopStatsByContinent();
        app.outputStats(stats, "all_stats.md");

        String dir = "reports/all_stats.md";
        File f = new File(dir);

        assertTrue(f.exists());
        assertTrue(f.isFile());
        assertEquals(f.getName(), "all_stats.md");
    }

    @Test //Output language stats results to table test
    void testOutputLanguageStats(){
        List<Stats> stats = app.getLanguageSpeakers();
        app.outputLanguageStats(stats, "language_stats.md");

        String dir = "reports/language_stats.md";
        File f = new File(dir);

        assertTrue(f.exists());
        assertTrue(f.isFile());
        assertEquals(f.getName(), "language_stats.md");
    }

    @Test //Output single population entry to table test
    void testOutputSinglePopStats(){
        List<Stats> stats = app.getPopStatsByContinent();
        app.outputSinglePopStats(stats, "single_continent_population_entry.md");

        String dir = "reports/single_continent_population_entry.md";
        File f = new File(dir);

        assertTrue(f.exists());
        assertTrue(f.isFile());
        assertEquals(f.getName(), "single_continent_population_entry.md");
    }

    @Test //Extraction of population within a city test
    void testGetCityPop() throws SQLException {
        Stats stats = app.getCityPop("Rotterdam");
        assertEquals(stats.getPlacePop(), 593321);
    }

    @Test //Extraction of population within a district test
    void testGetDistrictPop(){
        Stats stats = app.getDistrictPop("Zuid-Holland");
        assertEquals(stats.getPlacePop(), 1476710);
    }

    @Test //Extraction of population within a continent test
    void testGetContPop(){
        Stats stats = app.getContinentPop("Europe");
        assertEquals(stats.getPlacePop(), 730074600);
    }

    @Test //Extraction of population within a country test
    void testGetCountryPop(){
        Stats stats = app.getCountryPop("Italy");
        assertEquals(stats.getPlacePop(), 57680000);
    }

    @Test //Extraction of population within a region test
    void testGetRegPop(){
        Stats stats = app.getRegionPop("Southern Europe");
        assertEquals(stats.getPlacePop(), 144674200);
    }

    @Test //Extraction of world population test
    void testGetWorldPop(){
        Stats stats = app.getWorldPop();
        assertEquals(stats.getPlacePop(), 6078749450L);
    }

    @Test //Extraction of all countries within a continent test
    void testGetAllCountriesCont(){
        List<Country> countries = app.getAllCountriesCont("Europe");
        assertEquals(countries.size(), 46);
    }

    @Test //Extraction of all countries within a region test
    void testGetAllCountriesRegion(){
        List<Country> countries = app.getAllCountriesRegion("Southern Europe");
        assertEquals(countries.size(), 15);
    }

    @Test //Extraction of all countries within a region and limited results test
    void testGetAllCountriesRegionAndLimit(){
        List<Country> countries = app.getAllCountriesRegion("Southern Europe", 10);
        assertEquals(countries.size(), 10);
        assertEquals(countries.get(0).getName(), "Italy");
        assertEquals(countries.get(1).getName(), "Spain");
    }

    @Test //Extraction of all cities within a country test
    void testGetAllCitiesCountry(){
        List<City> cities = app.getAllCitiesCountry("Italy");
        assertEquals(cities.size(), 58);
    }

    @Test //Extraction of all cities within a country and limited result test
    void testGetAllCitiesCountryAndLimit(){
        List<City> cities = app.getAllCitiesCountry("Italy", 20);
        assertEquals(cities.size(), 20);
        assertEquals(cities.get(0).getName(), "Roma");
        assertEquals(cities.get(1).getName(), "Milano");
        assertEquals(cities.get(2).getName(), "Napoli");
    }

}
