package com.example.alchemillafx;

import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionEvent;

import static org.junit.Assert.*;

public class PlantControllerTest {
    PlantController pc;

    @Before
    public void setup() {
        pc = new PlantController();
    }

    /**
     * Call to display should display test profile name.
     */
    @Test
    public void shouldReturnTestProfile() {
        pc.currentProfile = "james";
        assertEquals("Should display profile name present",
                pc.getCurrentProfile(), "james");
    }
}