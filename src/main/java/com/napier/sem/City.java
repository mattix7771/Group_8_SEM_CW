package com.napier.sem;
/**
 * @author Edgar Park, Mattia Merati and Mateusz Wilczynski
 * City class represents a city language
 * since version 1.0.3
 */

public class City {


    /**
     * City's  id
     */
    private int id;

    /**
     * City's  name
     */
    private String name;

    /**
     * City's country Code
     */
    private String countryCode;

    /**
     * City's district
     */
    private String district;

    /**
     * City's  population
     */
    private int population;



    /**
     * getters and setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * end of getters and setters
     */
}
