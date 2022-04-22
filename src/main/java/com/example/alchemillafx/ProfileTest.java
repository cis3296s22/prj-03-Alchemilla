package com.example.alchemillafx;

import org.junit.Before;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest {

    String str;
    Profile prof;

    @Before
    public void setup() {
        str = "TestProfile";
        prof = new Profile(str);
        Plant plant1 = new Plant("url/test1", "test1Plant",
                20, 30, "plant1Food", "plant1Instruct",
                "plant1Desc");
        Plant plant2 = new Plant("url/test2", "testPlant2",
                30, 20, "plant2Food", "plant2Instruct",
                "plant2Desc");
    }

    @org.junit.Test
    public void shouldDisplayProfileName() {
        assertEquals(str, prof.getName(),
                "Should display \"TestProfile\" as name of profile:");
    }


}