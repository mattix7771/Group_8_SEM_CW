package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/*
*  This program was created as a project for Software Engineering Methods Module
*  Program retrieves data from MySql database based on instructions within the app
*  Created by Edgar Park, Mattia Merati and Mateusz Wilczynski
*  Date: 01/02/2022
*  Location: Edinburgh Napier University
* */


public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " +                                  Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Retrieving city information from database
     */
    public City getCity(String aName) // executes query and returns object
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.city.ID, world.city.CountryCode, world.city.District, world.city.Name, world.city.Population  "
                            + "FROM world.city "
                            + "WHERE world.city.Name = '"+ aName + "' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            if (rset.next())
            {
                City city = new City();
                city.setDistrict(rset.getString("District"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setName(rset.getString("Name"));
                city.setPopulation(rset.getInt("Population"));
                city.setId(rset.getInt("ID"));
                return city;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }

    /**
     * Display city information
     */
    public void displayCity(City city)
    {
        if (city == null)
        {
            System.out.println("No valid city");
            return;
        }

            System.out.println(
                    city.getId() + " "
                            + city.getName() + " "
                            + city.getCountryCode() + " "
                            + city.getPopulation() + "\n")   ;

    }
    /**
     * Display country information
     */
    public void displayCountry(Country country)
    {
        if (country == null)
        {
            System.out.println("No valid country");
            return;
        }

        System.out.println(
                country.getCode() + " "
                        + country.getName() + " "
                        + country.getContinent() + " "
                        + country.getRegion() + " "
                        + country.getCapital() + " "
                        + country.getPopulation() + "\n")   ;

    }
    /**
     *  Print Country methods
     */
    public void printCountry(ArrayList<Country> countries) {
        // Check cities is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        // Print header
        System.out.println(String.format("%-3s %-52s %-13s %-26s %-10s %-10s ", "Code", "Name", "Continent","Region", "Population", "Capital"));
        // Loop over all cities in the list
        for (Country c : countries) {
            if (c == null)
                continue;
            String country_s =
                    String.format("%-3s %-52s %-13s %-26s %-10s %-10s ",
                            c.getCode(), c.getName(), c.getContinent(),c.getRegion(), c.getPopulation(), c.getCapital() );
            System.out.println(country_s);
        }
    }
    /**
     * Retrieving country information from database
     */
    public Country getCountry(String cName)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.country.Name, world.country.Code,world.country.Capital,world.country.Code2," +
                            "world.country.Continent, world.country.GNP,world.country.GNPOld,world.country.GovernmentForm," +
                            "world.country.HeadOfState, world.country.IndepYear,world.country.LifeExpectancy,world.country.LocalName," +
                            "world.country.Population, world.country.Region,world.country.SurfaceArea "
                            + "FROM  world.country "
                            + "WHERE world.country.name = '"+ cName + "' ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            if (rset.next())
            {
                Country country = new Country();
                country.setName(rset.getString("Name"));
                country.setPopulation(rset.getInt("Population"));
                country.setCapital(rset.getString("Capital"));
                country.setCode(rset.getString("Code"));
                country.setCode2(rset.getString("Code2"));
                country.setGnp(rset.getInt("GNP"));
                country.setGnpOld(rset.getInt("GNPOld"));
                country.setGovernmentForm(rset.getString("GovernmentForm"));
                country.setHeadOfState(rset.getString("HeadOfState"));
                country.setIndepYear(rset.getInt("IndepYear"));
                country.setLifeExpectancy(rset.getDouble("LifeExpectancy"));
                country.setContinent(rset.getString("Continent"));
                country.setLocalName(rset.getString("LocalName"));
                country.setRegion(rset.getString("Region"));
                country.setSurfaceArea(rset.getInt("SurfaceArea"));

                return country;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }

    /**
     * Retrieving country information from database
     */
    public Country getCountryC(String cCode)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.country.Name, world.country.Code,world.country.Capital,world.country.Code2," +
                            "world.country.Continent, world.country.GNP,world.country.GNPOld,world.country.GovernmentForm," +
                            "world.country.HeadOfState, world.country.IndepYear,world.country.LifeExpectancy,world.country.LocalName," +
                            "world.country.Population, world.country.Region,world.country.SurfaceArea "
                            + "FROM  world.country "
                            + "WHERE world.country.code = '"+ cCode + "' ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            if (rset.next())
            {
                Country country = new Country();
                country.setName(rset.getString("Name"));
                country.setPopulation(rset.getInt("Population"));
                country.setCapital(rset.getString("Capital"));
                country.setCode(rset.getString("Code"));
                country.setCode2(rset.getString("Code2"));
                country.setGnp(rset.getInt("GNP"));
                country.setGnpOld(rset.getInt("GNPOld"));
                country.setGovernmentForm(rset.getString("GovernmentForm"));
                country.setHeadOfState(rset.getString("HeadOfState"));
                country.setIndepYear(rset.getInt("IndepYear"));
                country.setLifeExpectancy(rset.getDouble("LifeExpectancy"));
                country.setContinent(rset.getString("Continent"));
                country.setLocalName(rset.getString("LocalName"));
                country.setRegion(rset.getString("Region"));
                country.setSurfaceArea(rset.getInt("SurfaceArea"));

                return country;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }
    /**
     *    POPULATION IN Countries of the world
     */
    public ArrayList<Country> getAllCountries() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.country.Name, world.country.Code,world.country.Capital,world.country.Code2," +
                            "world.country.Continent, world.country.GNP,world.country.GNPOld,world.country.GovernmentForm," +
                            "world.country.HeadOfState, world.country.IndepYear,world.country.LifeExpectancy,world.country.LocalName," +
                            "world.country.Population, world.country.Region,world.country.SurfaceArea "
                            + "FROM  world.country "
                            + "ORDER BY world.country.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {


                Country country = new Country();
                country.setName(rset.getString("Name"));
                country.setPopulation(rset.getInt("Population"));
                country.setCapital(rset.getString("Capital"));
                country.setCode(rset.getString("Code"));
                country.setCode2(rset.getString("Code2"));
                country.setGnp(rset.getInt("GNP"));
                country.setGnpOld(rset.getInt("GNPOld"));
                country.setGovernmentForm(rset.getString("GovernmentForm"));
                country.setHeadOfState(rset.getString("HeadOfState"));
                country.setIndepYear(rset.getInt("IndepYear"));
                country.setLifeExpectancy(rset.getDouble("LifeExpectancy"));
                country.setContinent(rset.getString("Continent"));
                country.setLocalName(rset.getString("LocalName"));
                country.setRegion(rset.getString("Region"));
                country.setSurfaceArea(rset.getInt("SurfaceArea"));
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population details");
            return null;
        }
    }
    public ArrayList<Country> getAllCountries(int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.country.Name, world.country.Code,world.country.Capital,world.country.Code2," +
                            "world.country.Continent, world.country.GNP,world.country.GNPOld,world.country.GovernmentForm," +
                            "world.country.HeadOfState, world.country.IndepYear,world.country.LifeExpectancy,world.country.LocalName," +
                            "world.country.Population, world.country.Region,world.country.SurfaceArea "
                            + "FROM  world.country "
                            + "ORDER BY world.country.Population DESC "
                            + "LIMIT " + limit +" ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {


                Country country = new Country();
                country.setName(rset.getString("Name"));
                country.setPopulation(rset.getInt("Population"));
                country.setCapital(rset.getString("Capital"));
                country.setCode(rset.getString("Code"));
                country.setCode2(rset.getString("Code2"));
                country.setGnp(rset.getInt("GNP"));
                country.setGnpOld(rset.getInt("GNPOld"));
                country.setGovernmentForm(rset.getString("GovernmentForm"));
                country.setHeadOfState(rset.getString("HeadOfState"));
                country.setIndepYear(rset.getInt("IndepYear"));
                country.setLifeExpectancy(rset.getDouble("LifeExpectancy"));
                country.setContinent(rset.getString("Continent"));
                country.setLocalName(rset.getString("LocalName"));
                country.setRegion(rset.getString("Region"));
                country.setSurfaceArea(rset.getInt("SurfaceArea"));
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population details");
            return null;
        }
    }
    /**
     *    POPULATION IN Countries of the continent
     */
    public ArrayList<Country> getAllCountriesCont(String continentName) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.country.Name, world.country.Code,world.country.Capital,world.country.Code2," +
                            "world.country.Continent, world.country.GNP,world.country.GNPOld,world.country.GovernmentForm," +
                            "world.country.HeadOfState, world.country.IndepYear,world.country.LifeExpectancy,world.country.LocalName," +
                            "world.country.Population, world.country.Region,world.country.SurfaceArea "
                            + "FROM  world.country "
                            + "WHERE world.country.Continent = '"+ continentName + "' "
                            + "ORDER BY world.country.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {


                Country country = new Country();
                country.setName(rset.getString("Name"));
                country.setPopulation(rset.getInt("Population"));
                country.setCapital(rset.getString("Capital"));
                country.setCode(rset.getString("Code"));
                country.setCode2(rset.getString("Code2"));
                country.setGnp(rset.getInt("GNP"));
                country.setGnpOld(rset.getInt("GNPOld"));
                country.setGovernmentForm(rset.getString("GovernmentForm"));
                country.setHeadOfState(rset.getString("HeadOfState"));
                country.setIndepYear(rset.getInt("IndepYear"));
                country.setLifeExpectancy(rset.getDouble("LifeExpectancy"));
                country.setContinent(rset.getString("Continent"));
                country.setLocalName(rset.getString("LocalName"));
                country.setRegion(rset.getString("Region"));
                country.setSurfaceArea(rset.getInt("SurfaceArea"));
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population details");
            return null;
        }
    }
    public ArrayList<Country> getAllCountriesCont(String continentName, int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.country.Name, world.country.Code,world.country.Capital,world.country.Code2," +
                            "world.country.Continent, world.country.GNP,world.country.GNPOld,world.country.GovernmentForm," +
                            "world.country.HeadOfState, world.country.IndepYear,world.country.LifeExpectancy,world.country.LocalName," +
                            "world.country.Population, world.country.Region,world.country.SurfaceArea "
                            + "FROM  world.country "
                            + "WHERE world.country.Continent = '"+ continentName + "' "
                            + "ORDER BY world.country.Population DESC "
                            + "LIMIT " + limit +" ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {


                Country country = new Country();
                country.setName(rset.getString("Name"));
                country.setPopulation(rset.getInt("Population"));
                country.setCapital(rset.getString("Capital"));
                country.setCode(rset.getString("Code"));
                country.setCode2(rset.getString("Code2"));
                country.setGnp(rset.getInt("GNP"));
                country.setGnpOld(rset.getInt("GNPOld"));
                country.setGovernmentForm(rset.getString("GovernmentForm"));
                country.setHeadOfState(rset.getString("HeadOfState"));
                country.setIndepYear(rset.getInt("IndepYear"));
                country.setLifeExpectancy(rset.getDouble("LifeExpectancy"));
                country.setContinent(rset.getString("Continent"));
                country.setLocalName(rset.getString("LocalName"));
                country.setRegion(rset.getString("Region"));
                country.setSurfaceArea(rset.getInt("SurfaceArea"));
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population details");
            return null;
        }
    }
    /**
     *    POPULATION IN Countries of the region
     */
    public ArrayList<Country> getAllCountriesRegion(String regionName) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.country.Name, world.country.Code,world.country.Capital,world.country.Code2," +
                            "world.country.Continent, world.country.GNP,world.country.GNPOld,world.country.GovernmentForm," +
                            "world.country.HeadOfState, world.country.IndepYear,world.country.LifeExpectancy,world.country.LocalName," +
                            "world.country.Population, world.country.Region,world.country.SurfaceArea "
                            + "FROM  world.country "
                            + "WHERE world.country.Region = '"+ regionName + "' "
                            + "ORDER BY world.country.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {


                Country country = new Country();
                country.setName(rset.getString("Name"));
                country.setPopulation(rset.getInt("Population"));
                country.setCapital(rset.getString("Capital"));
                country.setCode(rset.getString("Code"));
                country.setCode2(rset.getString("Code2"));
                country.setGnp(rset.getInt("GNP"));
                country.setGnpOld(rset.getInt("GNPOld"));
                country.setGovernmentForm(rset.getString("GovernmentForm"));
                country.setHeadOfState(rset.getString("HeadOfState"));
                country.setIndepYear(rset.getInt("IndepYear"));
                country.setLifeExpectancy(rset.getDouble("LifeExpectancy"));
                country.setContinent(rset.getString("Continent"));
                country.setLocalName(rset.getString("LocalName"));
                country.setRegion(rset.getString("Region"));
                country.setSurfaceArea(rset.getInt("SurfaceArea"));
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population details");
            return null;
        }
    }
    public ArrayList<Country> getAllCountriesRegion(String regionName, int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.country.Name, world.country.Code,world.country.Capital,world.country.Code2," +
                            "world.country.Continent, world.country.GNP,world.country.GNPOld,world.country.GovernmentForm," +
                            "world.country.HeadOfState, world.country.IndepYear,world.country.LifeExpectancy,world.country.LocalName," +
                            "world.country.Population, world.country.Region,world.country.SurfaceArea "
                            + "FROM  world.country "
                            + "WHERE world.country.Region = '"+ regionName + "' "
                            + "ORDER BY world.country.Population DESC "
                            + "LIMIT " + limit +" ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {


                Country country = new Country();
                country.setName(rset.getString("Name"));
                country.setPopulation(rset.getInt("Population"));
                country.setCapital(rset.getString("Capital"));
                country.setCode(rset.getString("Code"));
                country.setCode2(rset.getString("Code2"));
                country.setGnp(rset.getInt("GNP"));
                country.setGnpOld(rset.getInt("GNPOld"));
                country.setGovernmentForm(rset.getString("GovernmentForm"));
                country.setHeadOfState(rset.getString("HeadOfState"));
                country.setIndepYear(rset.getInt("IndepYear"));
                country.setLifeExpectancy(rset.getDouble("LifeExpectancy"));
                country.setContinent(rset.getString("Continent"));
                country.setLocalName(rset.getString("LocalName"));
                country.setRegion(rset.getString("Region"));
                country.setSurfaceArea(rset.getInt("SurfaceArea"));
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population details");
            return null;
        }
    }
    /**
     *  Print cities methods
     */
    public void printCities(ArrayList<City> cities) {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.println(String.format("%-35s %-20s %-3s %-10s ", "Name", "District", "Country", "Population"));
        // Loop over all cities in the list
        for (City c : cities) {
            if (c == null)
                continue;
            String city_s =
                    String.format("%-35s %-20s %-3s %-10s ",
                            c.getName(), c.getDistrict(), c.getCountryCode(), c.getPopulation() );
            System.out.println(city_s);
        }
    }

    /**
     *    POPULATION IN CITIES of the world
     */
    public ArrayList<City> getAllCities() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.city.CountryCode, world.city.District, world.city.Name, world.city.Population "
                            + "FROM world.city "
                            + "ORDER BY world.city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {

                City c = new City();
                c.setCountryCode(rset.getString("CountryCode"));
                c.setName(rset.getString("Name"));
                c.setDistrict(rset.getString("District"));
                c.setPopulation(rset.getInt("Population"));
                cities.add(c);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city population details");
            return null;
        }
    }

    // Overloaded method to include limit selected by the user
    public ArrayList<City> getAllCities(int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.city.CountryCode, world.city.District, world.city.Name, world.city.Population "
                            + "FROM world.city "
                            + "ORDER BY world.city.Population DESC "
                            + "LIMIT " + limit +" ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {

                City c = new City();
                c.setCountryCode(rset.getString("CountryCode"));
                c.setName(rset.getString("Name"));
                c.setDistrict(rset.getString("District"));
                c.setPopulation(rset.getInt("Population"));
                cities.add(c);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city population details");
            return null;
        }
    }

    /**
     *    POPULATION IN CITIES for the continent
     */
    public ArrayList<City> getAllCitiesC(String continent) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.city.CountryCode, world.city.District, world.city.Name, world.city.Population "
                            + "FROM world.city, world.country "
                            + "WHERE world.city.CountryCode = world.country.Code "
                            + "AND world.country.Continent = '" + continent +"' "
                            + "ORDER BY world.city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {

                City c = new City();
                c.setCountryCode(rset.getString("CountryCode"));
                c.setName(rset.getString("Name"));
                c.setDistrict(rset.getString("District"));
                c.setPopulation(rset.getInt("Population"));
                cities.add(c);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city population details");
            return null;
        }
    }

        // Overloaded method to include limit selected by the user
    public ArrayList<City> getAllCitiesC(String continent, int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.city.CountryCode, world.city.District, world.city.Name, world.city.Population "
                            + "FROM world.city, world.country "
                            + "WHERE world.city.CountryCode = world.country.Code "
                            + "AND world.country.Continent = '" + continent +"' "
                            + "ORDER BY world.city.Population DESC "
                            + "LIMIT "+ limit  +" ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {

                City c = new City();
                c.setCountryCode(rset.getString("CountryCode"));
                c.setName(rset.getString("Name"));
                c.setDistrict(rset.getString("District"));
                c.setPopulation(rset.getInt("Population"));
                cities.add(c);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city population details");
            return null;
        }
    }

    /**
     *    POPULATION IN CITIES for the region
     */
    public ArrayList<City> getAllCitiesR(String region) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.city.CountryCode, world.city.District, world.city.Name, world.city.Population "
                            + "FROM world.city, world.country "
                            + "WHERE world.city.CountryCode = world.country.Code "
                            + "AND world.country.Region = '" + region +"' "
                            + "ORDER BY world.city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {

                City c = new City();
                c.setCountryCode(rset.getString("CountryCode"));
                c.setName(rset.getString("Name"));
                c.setDistrict(rset.getString("District"));
                c.setPopulation(rset.getInt("Population"));
                cities.add(c);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city population details");
            return null;
        }
    }

    // Overloaded method to include limit selected by the user
    public ArrayList<City> getAllCitiesR(String region, int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.city.CountryCode, world.city.District, world.city.Name, world.city.Population "
                            + "FROM world.city, world.country "
                            + "WHERE world.city.CountryCode = world.country.Code "
                            + "AND world.country.Region = '" + region +"' "
                            + "ORDER BY world.city.Population DESC "
                            + "LIMIT "+ limit  +" ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {

                City c = new City();
                c.setCountryCode(rset.getString("CountryCode"));
                c.setName(rset.getString("Name"));
                c.setDistrict(rset.getString("District"));
                c.setPopulation(rset.getInt("Population"));
                cities.add(c);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city population details");
            return null;
        }
    }

    /**
     *    POPULATION IN CITIES for the district
     */
    public ArrayList<City> getAllCitiesD(String district) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.city.CountryCode, world.city.District, world.city.Name, world.city.Population "
                            + "FROM world.city, world.country "
                            + "WHERE world.city.CountryCode = world.country.Code "
                            + "AND world.city.District = '" + district +"' "
                            + "ORDER BY world.city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {

                City c = new City();
                c.setCountryCode(rset.getString("CountryCode"));
                c.setName(rset.getString("Name"));
                c.setDistrict(rset.getString("District"));
                c.setPopulation(rset.getInt("Population"));
                cities.add(c);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city population details");
            return null;
        }
    }
    // Overloaded method to include limit selected by the user
    public ArrayList<City> getAllCitiesD(String district, int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.city.CountryCode, world.city.District, world.city.Name, world.city.Population "
                            + "FROM world.city, world.country "
                            + "WHERE world.city.CountryCode = world.country.Code "
                            + "AND world.city.District = '" + district +"' "
                            + "ORDER BY world.city.Population DESC "
                            + "LIMIT "+ limit  +" ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {

                City c = new City();
                c.setCountryCode(rset.getString("CountryCode"));
                c.setName(rset.getString("Name"));
                c.setDistrict(rset.getString("District"));
                c.setPopulation(rset.getInt("Population"));
                cities.add(c);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city population details");
            return null;
        }
    }

    /**
     * Main
     */
    public static void main(String[] args)
    {
        //create new application
        App a = new App();

        if(args.length < 1){
            a.connect("localhost:33060", 30000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        // ArrayLists
        ArrayList<City> all = new ArrayList<City>( );
        all = a.getAllCitiesR("Western Europe", 5);
        a.printCities(all);
        ArrayList<City> d = new ArrayList<City>( );
        d = a.getAllCitiesD("Hamburg", 5);
        a.printCities(d);
        ArrayList<City> c = new ArrayList<City>( );
        c= a.getAllCitiesC("Europe", 5);
        a.printCities(c);

        // Disconnect from database
        a.disconnect();
    }
}
