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

public class PlantController implements Initializable
{
    @FXML
    private Text actiontarget;

    @FXML
    private TextField plantname;

    @FXML
    private TextField water;

    @FXML
    private TextField fooddelta;

    @FXML
    private TextField food;

    @FXML
    private TextField description;

    @FXML
    private TextField instruction;

    @FXML
    private TextField plantimagepath;

    // These should be private
    public Profile profile;
    public String currentProfile = "joe"; // hardcoded, this doesn't change with set method for some reason

    public String getCurrentProfile()
    {
        return currentProfile;
    }

    @FXML
    public void onButtonClick(ActionEvent ae) {
        // probably want to have something here that makes sure that all data entries are there from UI
        // Maybe use alert

        // Set Strings to pass into plant object
        String imageString = plantimagepath.getText();
        System.out.println("imageString = " + imageString);
        String nameString = plantname.getText();
        System.out.println("nameString = " + nameString);
        String waterString = water.getText();
        System.out.println("waterString = " + waterString);
        String foodDeltaString = fooddelta.getText();
        System.out.println("foodDeltaString = " + foodDeltaString);
        String foodString = food.getText();
        System.out.println("foodString = " + foodString);
        String descString = description.getText();
        System.out.println("descString = " + descString);
        String instructionString = instruction.getText();
        System.out.println("instructionString = " + instructionString);

        System.out.println("current profile: " + this.currentProfile);

        Plant plant = new Plant(imageString, nameString, Integer.parseInt(waterString), Integer.parseInt(foodDeltaString), foodString, descString, instructionString);
        System.out.println("plant to be added: " + plant);

        // Save to profile
        DataHolder hold = DataHolder.getInstance(); // get singleton object with passed data
        SerializeClassData sc = hold.getClassData();
        profile = hold.getProfile();
        System.out.println("Plant Controller profile from singleton: " + profile);
        System.out.println("name of profile is: " + profile.getName());
        profile.addPlant(plant);
        System.out.println("added this plant: " + plant);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }
/*
    private BufferedImage readImage(String path)
    {
        BufferedImage image;

        try
        {
            File file = new File(path);
            image = ImageIO.read(file);

        }
        catch (IOException e)
        {
            e.printStackTrace();
            image = null;
            return image; // this gotta be bad programming
        }

        return image;
    }
*/
}
