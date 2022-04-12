package com.napier.sem;
/**
 * @author Edgar Park, Mattia Merati and Mateusz Wilczynski
 * Report class represents populastion reports
 * since version 1.0.3
 */
public class Stats {


    /**
     *  represents a name of the report - can be a country, continent or a region
     */
    private String place;
    /**
     *  represents total population
     */
    private long placePop;
    /**
     *  represents urban population
     */
    private int urbanPop;
    /**
     *  represents rural population
     */
    private long ruralPop;
    /**
     *  represents urban population percentage
     */
    private String urbPercentage;
    /**
     *  represents rural population percentage
     */
    private String ruralPercentage;


    /**
     *  getters and setters
     */
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getPlacePop() {
        return placePop;
    }

    public void setPlacePop(long placePop) {
        this.placePop = placePop;
    }

    public int getUrbanPop() {
        return urbanPop;
    }

    public void setUrbanPop(int urbanPop) {
        this.urbanPop = urbanPop;
    }

    public long getRuralPop() {
        return ruralPop;
    }

    public void setRuralPop(long ruralPop) {
        this.ruralPop = ruralPop;
    }

    public String getUrbPercentage() {
        return urbPercentage;
    }

    public void setUrbPercentage(String urbPercentage) {
        this.urbPercentage = urbPercentage;
    }

    public String getRuralPercentage() {
        return ruralPercentage;
    }

    public void setRuralPercentage(String ruralPercentage) {
        this.ruralPercentage = ruralPercentage;
    }

}
