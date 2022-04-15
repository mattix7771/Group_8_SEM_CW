package com.napier.sem;
/**
 * @author Edgar Park, Mattia Merati and Mateusz Wilczynski
 * CountryLanguage class represents country language
 * since version 1.0.3
 */

public class CountryLanguage {


    /**
     * language's  code
     */
    private String code;

    /**
     * language's name
     */
    private String language;
    /**
     *  language's status
     */
    private Boolean isOfficial;

    /**
     * language's percentage
     */
    private String percentage;



    /**
     *  getters and setters
     */

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     *
     * @return
     */
    public Boolean getOfficial() {
        return isOfficial;
    }

    /**
     *
     * @param official
     */
    public void setOfficial(Boolean official) {
        isOfficial = official;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
    /**
     * end of getters and setters
     */
}
