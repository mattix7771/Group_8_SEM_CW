package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test // assertEquals test
    void testGetEmployee()
    {
        City city = app.getCity("London");
        assertEquals(city.getCountryCode(), "GBR");
        assertEquals(city.getPopulation(), 7285000);
        assertEquals(city.getDistrict(), "England");
    }
}
