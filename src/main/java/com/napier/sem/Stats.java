package com.napier.sem;
/**
 * @author Edgar Park, Mattia Merati and Mateusz Wilczynski
 * Report class represents data required for language and population reports
 * since version 1.0.3
 */
public class Stats {

    /**
     *  Variables used in retrieving data urban and rural population
     */
    /**
     *  Represents statistical data required
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
     *  Variables used in retrieving data about language speakers
     */


    /**
     *  represents language name
     */
    private String Language;
    /**
     *  represents total number of speakers of a language
     */
    private long totalSpeakers;
    /**
     *  represents percentage of world populatiuon that speaks a particular language
     */
    private String totalSpeakersPercentage;






    /**
     *  getters and setters
     */
    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public long getTotalSpeakers() {
        return totalSpeakers;
    }

    public void setTotalSpeakers(long totalSpeakers) {
        this.totalSpeakers = totalSpeakers;
    }

    public String getTotalSpeakersPercentage() {
        return totalSpeakersPercentage;
    }

    public void setTotalSpeakersPercentage(String totalSpeakersPercentage) {
        this.totalSpeakersPercentage = totalSpeakersPercentage;
    }

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
