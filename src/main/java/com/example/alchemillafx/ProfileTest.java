package com.example.alchemillafx;

import org.junit.Before;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest {

    String str;
    Profile prof;
    Plant plant1;
    Plant plant2;
    LinkedList<Plant> plants;
    Calendar cal;

    @Before
    public void setup() {
        str = "TestProfile";
        prof = new Profile(str);
        plant1 = new Plant("url/test1", "test1Plant",
                20, 30, "plant1Food", "plant1Instruct",
                "plant1Desc");
        plant2 = new Plant("url/test2", "testPlant2",
                30, 20, "plant2Food", "plant2Instruct",
                "plant2Desc");
        plants = new LinkedList<Plant>();
        cal = new GregorianCalendar();
    }

    @org.junit.Test
    public void shouldDisplayProfileName() {
        assertEquals(str, prof.getName(),
                "Should display \"TestProfile\" as name of profile:");
    }

    @org.junit.Test
    public void shouldDisplayNewName() {
        String strNew = "NewTestProfile";
        prof.setName(strNew);
        assertEquals(strNew, prof.getName(),
                "Should display \"NewTestProfile\" as the new name of profile:");
    }

    @org.junit.Test
    public void shouldReturnNullWithNoPlants() {
        assertEquals(plants, prof.getPlants(),
                "Should have a null LinkedList of Plant objects:");
    }

    @org.junit.Test
    public void shouldReturnPlantWhenPlantAdded() {
        prof.addPlant(plant1);
        plants.add(plant1);
        assertEquals(plants, prof.getPlants(),
                "Should have a single LinkedList of Plant objects:");
    }

    @org.junit.Test
    public void shouldReturnArrayListOfPlantsWhenPlantsAdded() {
        prof.addPlant(plant1);
        prof.addPlant(plant2);

        plants.add(plant1);
        plants.add(plant2);

        assertEquals(plants, prof.getPlants(),
                "Should have a single LinkedList of Plant objects:");
    }

    @org.junit.Test
    public void shouldReturnNullStartDateWhenNoneSet() {
        assertEquals(cal, prof.getStartDate(),
                "Should have a single LinkedList of Plant objects:");
    }

    @org.junit.Test
    public void shouldReturnStartDateWhenSet() {
        cal.set(Calendar.YEAR, Calendar.JANUARY, Calendar.SATURDAY);
        prof.setStartDate(cal);
        assertEquals(cal, prof.getStartDate(),
                "Should have a single LinkedList of Plant objects:");
    }

    @org.junit.Test
    public void shouldReturnStartDateFromConstruction() {
        cal.set(Calendar.YEAR, Calendar.JANUARY, Calendar.SATURDAY);
        prof = new Profile(str, cal);

        assertEquals(cal, prof.getStartDate(),
                "Should have a single LinkedList of Plant objects:");
    }
}