package com.example.alchemillafx;

// import javafx.application.Application;
import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.fxml.Initializable;
// import javafx.scene.Scene;
// import javafx.scene.control.Label;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.text.*;

// import java.awt.image.BufferedImage;
import java.io.*;
// import javax.imageio.ImageIO;
import javafx.event.ActionEvent;

import javax.swing.*;

public class PlantController
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

    // HARDCODED
    Profile profile;
    String currentProfile = "joe";

    @FXML
    protected void onButtonClick(ActionEvent ae) {
        // probably want to have something here that makes sure that all data entries are there from UI
        // Maybe use alert
        //  actiontarget.setText("Welcome to JavaFX Application!");

        String imageString = plantimagepath.getText();
        String nameString = plantname.getText();
        String waterString = water.getText();
        String foodDeltaString = fooddelta.getText();
        String foodString = food.getText();
        String descString = description.getText();
        String instructionString = instruction.getText();


        Plant plant = new Plant(imageString, nameString, Integer.parseInt(waterString), Integer.parseInt(foodDeltaString), foodString, descString, instructionString);

        // Save to profile
        SerializeClassData sc = new SerializeClassData();
        try {
            profile = sc.getProfile(currentProfile);
            profile.addPlant(plant);
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
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
