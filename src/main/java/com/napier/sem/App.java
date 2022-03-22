package com.napier.sem;

import java.sql.*;

/*
*  This program was created as a project for Software Engineering Methods Module
*  Program retrieves data from MySql database based on instructions within the app
*  Created by Edgar Park, Ruben Cavaco Mattia Merati and Mateusz Wilczynski
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
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
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

    // GET POPULATION ------------------------------------------------------------------
    // CITY
    public City getCity(String aName) // executes query and returns object
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.country.name, concat(((SUM(world.city.Population) / world.country.Population)*100),'%') as CityPopPercantage "
                            + "FROM world.city, world.country "
                            + "WHERE world.city.CountryCode = world.country.code"
                            + "GROUP BY world.country.name,world.country.Population";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            if (rset.next())
            {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setPopulation(rset.getInt("Population"));
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
                            + city.getPopulation() + "\n")   ;

    }

    // COUNTRY
    public Country getCountry(String cName)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT world.country.name, concat(((SUM(world.city.Population) / world.country.Population)*100),'%') as CityPopPercantage "
                            + "FROM world.city, world.country "
                            + "WHERE world.city.CountryCode = world.country.code"
                            + "GROUP BY world.country.name,world.country.Population";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            if (rset.next())
            {
                Country country = new Country();
                country.setName(rset.getString("Name"));
                country.setPopulation(rset.getInt("Population"));
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

    public void displayCountryPop(Country country)
    {
        if (country == null)
        {
            System.out.println("No valid country");
            return;
        }

        System.out.println(
                country.getCode() + " "
                        + country.getName() + " "
                        + country.getPopulation() + "\n")   ;
    }

    // REGION
    public Country getRegion (String rName)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population "
                            + "FROM world.country "
                            + "WHERE Name = " + rName;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new region if valid.
            // Check one is returned
            if (rset.next())
            {
                Country region = new Country();
                region.setName(rset.getString("Name"));
                region.setPopulation(rset.getInt("Population"));
                return region;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get region details");
            return null;
        }
    }

    public void displayRegionPop(Country country)
    {
        if (country == null)
        {
            System.out.println("No valid region");
            return;
        }

        System.out.println(
                country.getCode() + " "
                        + country.getName() + " "
                        + country.getPopulation() + "\n")   ;
    }

    // CONTINENT
    public Country getContinent (String cName)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population "
                            + "FROM world.country "
                            + "WHERE Name = " + cName;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new continent if valid.
            // Check one is returned
            if (rset.next())
            {
                Country cOntinent = new Country();
                cOntinent.setName(rset.getString("Name"));
                cOntinent.setPopulation(rset.getInt("Population"));
                return cOntinent;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent details");
            return null;
        }
    }

    public void displayContinentPop(Country country)
    {
        if (country == null)
        {
            System.out.println("No valid continent");
            return;
        }

        System.out.println(
                country.getCode() + " "
                        + country.getName() + " "
                        + country.getPopulation() + "\n")   ;
    }

    // WORLD
    public Country getWorld (int pop)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Population "
                            + "FROM world.country "
                            + "WHERE Population = " + pop;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new world if valid.
            // Check one is returned
            if (rset.next())
            {
                Country world = new Country();
                world.setPopulation(rset.getInt("Population"));
                return world;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public void displayWorldPop(Country world)
    {
        if (world == null)
        {
            System.out.println("No valid continent");
            return;
        }

        System.out.println(
                world.getCode() + " "
                        + world.getPopulation() + "\n")   ;
    }

    // DISTRICT
    public City getDistrict (String disPop)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population "
                            + "FROM world.city "
                            + "WHERE Name = " + disPop;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new district if valid.
            // Check one is returned
            if (rset.next())
            {
                City disTrict = new City();
                disTrict.setName(rset.getString("Name"));
                disTrict.setPopulation(rset.getInt("Population"));
                return disTrict;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public void displayDistrictPop(City dis)
    {
        if (dis == null)
        {
            System.out.println("No valid district");
            return;
        }

        System.out.println(
                dis.getId() + " "
                        + dis.getName() + "\n"
                        + dis.getDistrict() + "\n"
                        + dis.getPopulation() + "\n")   ;
    }

    // POPULATION IN CITIES -----------------------


    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // POPULATION ----------------
        City city = a.getCity("Edinburgh");
        Country country = a.getCountry("Australia");
        Country region = a.getRegion("Albama");
        Country cont = a.getContinent("Africa");
        Country world = a.getWorld(132155);
        City district = a.getDistrict("Area51");
        // Display population results
        a.displayCity(city);
        a.displayCountryPop(country);
        a.displayRegionPop(region);
        a.displayContinentPop(cont);
        a.displayWorldPop(world);
        a.displayDistrictPop(district);
        // ---------------------------
        // POPULATION IN CITIES



        // Disconnect from database
        a.disconnect();
    }
}
