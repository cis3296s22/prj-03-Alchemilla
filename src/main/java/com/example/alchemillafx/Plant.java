package com.example.alchemillafx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

/**
 * Class for storing information of a single plant. Implements serializable for easy storage.
 */
public class Plant implements Serializable {
    private String plantImage;
    private String plantName;
    private Integer waterDelta;
    private Integer foodDelta;
    private String food;
    private String instructions;
    private String description;

    /**
     * Plant constructor. Designed to be form fill-able to work with our GUI interface (JavaFX popup form)
     * @param plantImage path to stored image of plant, relative file path
     * @param plantName name of the plant
     * @param waterDelta how many days between watering of plant
     * @param foodDelta how many days between giving plant food or fertilizer
     * @param food what kind of fertilizer/plant food is preferred by this plant
     * @param instructions any more complicated care instructions should go here (arbitrarily long String)
     * @param description a description of the plant should go here (arbitrarily long String)
     */
    public Plant(
            String plantImage,
            String plantName,
            Integer waterDelta,
            Integer foodDelta,
            String food,
            String instructions, //lower scrollable pane
            String description) {//ditto
        this.plantImage = plantImage;
        this.plantName = plantName;
        this.waterDelta = waterDelta;
        this.foodDelta = foodDelta;
        this.food = food;
        this.instructions = instructions;
        this.description = description;
    }

    /**
     * getter for the complicated instructions
     * @return arbitrarily long String
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * getter for the long-form plant description
     * @return arbitrarily long String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Uses plant
     * @return BufferedImage object that can be displayed by JavaFx imagepane
     * @throws IOException cannot access file system or cannot find file
     * //TODO catch ioexception and return default image
     */
    public BufferedImage getPlantImage() throws IOException
    {
        return ImageIO.read(Objects.requireNonNull(Plant.class.getResource(plantImage)));
    }


    /**
     * get the name of the plant
     * @return String
     */
    public String getPlantName() {
        return plantName;
    }

    /**
     * get the time between waterings of the plant
     * @return integer value representing a number of days
     */
    public Integer getWaterDelta() {
        return waterDelta;
    }

    /**
     * get the time between feedings of the plant
     * @return integer value representing a number of days
     */
    public Integer getFoodDelta() {
        return foodDelta;
    }

    public String getImagePath(){return plantImage;}

    /**
     * get a string representation of the type of food/fertilizer this plant requires/prefers
     * @return String - name of plant food
     */
    public String getFood() {
        return food;
    }
}
