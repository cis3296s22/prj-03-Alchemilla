package com.example.alchemillafx;

// import javafx.application.Application;
import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.fxml.Initializable;
// import javafx.scene.Scene;
// import javafx.scene.control.Label;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.*;

// import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;
// import javax.imageio.ImageIO;
import javafx.event.ActionEvent;

import javax.swing.*;

/**
 * JavaFX controller that displays a Plant Form, and stores the information from user input into plant object and stores that plant object into profile in memory.
 */

public class PlantController implements Initializable
{
    /**
     * User Input for plant name
     */
    @FXML
    private TextField plantname;

    /**
     * User Input for water delta
     */
    @FXML
    private TextField water;

    /**
     * User Input for food delta
     */
    @FXML
    private TextField fooddelta;

    /**
     * User Input for food name
     */
    @FXML
    private TextField food;

    /**
     * User Input for plant description
     */
    @FXML
    private TextField description;

    /**
     * User Input for plant care instructions
     */
    @FXML
    private TextField instruction;

    /**
     * User Input for the path to plant image
     */
    @FXML
    private TextField plantimagepath;

    // These should be private
    public Profile profile;
    public String currentProfile = "joe"; // hardcoded, this doesn't change with set method for some reason

    /**
     * On click method for button, takes user input from TextFields, creates Plant object from them, stores into profile in memory.
     * @param ae On click of "submit" button
     */
    @FXML
    public void onButtonClick(ActionEvent ae) {
        // probably want to have something here that makes sure that all data entries are there from UI
        // Maybe use alert

        // Set Strings to pass into plant object
        String imageString = plantimagepath.getText();
        String nameString = plantname.getText();
        String waterString = water.getText();
        String foodDeltaString = fooddelta.getText();
        String foodString = food.getText();
        String descString = description.getText();
        String instructionString = instruction.getText();


        Plant plant = new Plant(imageString, nameString, Integer.parseInt(waterString), Integer.parseInt(foodDeltaString), foodString, instructionString, descString);
        // Plant samePlant = new Plant(imageString, nameString, Integer.parseInt(waterString), Integer.parseInt(foodDeltaString), foodString, instructionString, descString);

        // PRINT OUT VALUES TO CONSOLE
        /*
        System.out.println("plant to be added: " + plant);
        System.out.println("another plant diff hash: " + samePlant);
        System.out.println("plant.getImagePath = " + plant.getImagePath());
        System.out.println("plant.getPlantName = " + plant.getPlantName());
        System.out.println("plant.getWaterDelta = " + plant.getWaterDelta());
        System.out.println("plant.getFoodDelta = " + plant.getFoodDelta());
        System.out.println("plant.getFood = " + plant.getFood());
        System.out.println("plant.getDescription = " + plant.getDescription());
        System.out.println("plant.getInstructions = " + plant.getInstructions());
        */

        // Save to profile
        DataHolder hold = DataHolder.getInstance(); // get singleton object with passed data
        SerializeClassData sc = hold.getClassData();
        profile = hold.getProfile();
        // System.out.println("Plant Controller profile from singleton: " + profile);
        // System.out.println("name of profile is: " + profile.getName());
        profile.addPlant(plant);
        // System.out.println("added this plant: " + plant);

        // Verify the plants in the profile
        /*
        LinkedList<Plant> lp = profile.getPlants();
        Iterator i = lp.iterator();

        while(i.hasNext()) {
            Plant p = (Plant) i.next();
            System.out.println(p.getPlantName());
        } */

        // get current hello controller and update
        HelloController hc = hold.getHelloController();
        hc.initialize(null, null);
    }

    /**
     * Method for dynamically populating the screen. Call to update profile information.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {}
}
