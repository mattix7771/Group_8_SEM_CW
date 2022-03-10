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

    public City getCity(int ID) // executes query and returns object
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, Population "
                            + "FROM world.city "
                            + "WHERE ID = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            if (rset.next())
            {
                City city = new City();
                city.name = rset.getString("Name");
                city.population =rset.getInt("Population");
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
// displays city records
    public void displayCity(City city)
    {
        if (city != null)
        {
            System.out.println(
                    city.id + " "
                            + city.name + " "
                            + city.population + "\n")   ;
        }
    }
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        City city = a.getCity(1);
        // Display results
        a.displayCity(city);
        // Disconnect from database
        a.disconnect();
    }
}
