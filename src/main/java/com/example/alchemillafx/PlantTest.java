package com.example.alchemillafx;

import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import static org.junit.Assert.*;

public class PlantTest {

    String url;
    String plantName;
    int waterDelta;
    int foodDelta;
    String food;
    String instructions;
    String description;
    Plant plant;

    @Before
    public void setup() {
        url = "url/test";
        plantName = "testPlant";
        waterDelta = 20; foodDelta = 30;
        food = "testPlantFood";
        instructions = "Water testPlant";
        description = "testPlantDesc";

        plant = new Plant(url, plantName, waterDelta, foodDelta, food,
                instructions, description);
    }

    /**
     * Call to display should display instructions provided in constructor.
     */
    @Test
    public void shouldReturnInstructions() {
        assertEquals("Should display instructions entered in constructor:",
                "Water testPlant", plant.getInstructions());
    }

    /**
     * Call to display should display description provided in constructor.
     */
    @Test
    public void shouldReturnDescription() {
        assertEquals("Should display description entered in constructor:",
                "testPlantDesc", plant.getDescription());
    }

    /**
     * Call to display should display plant name provided in constructor.
     */
    @Test
    public void shouldReturnPlantName() {
        assertEquals("Should display name entered in constructor:",
                "testPlant", plant.getPlantName());
    }

    /**
     * Call to display should display water delta provided in constructor.
     */
    @Test
    public void shouldReturnWaterDelta() {
        assertEquals("Should display water delta entered in constructor:",
                (Integer) 20, plant.getWaterDelta());
    }

    /**
     * Call to display should display food delta provided in constructor.
     */
    @Test
    public void shouldReturnFoodDelta() {
        assertEquals("Should display food delta entered in constructor:",
                (Integer) 30, plant.getFoodDelta());
    }

    /**
     * Call to display should display image path URL provided in constructor.
     */
    @Test
    public void shouldReturnImagePath() {
        assertEquals("Should display URL entered in constructor:",
                "url/test", plant.getImagePath());
    }

    /**
     * Call to display should display food provided in constructor.
     */
    @Test
    public void shouldReturnFood() {
        assertEquals("Should display food entered in constructor:",
                "testPlantFood", plant.getFood());
    }
}