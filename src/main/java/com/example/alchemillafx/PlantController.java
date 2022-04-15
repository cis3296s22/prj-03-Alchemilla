package com.example.alchemillafx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.text.*;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PlantController extends Application
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



    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Sets Title, Loads the FXML File
        primaryStage.setTitle("Enter Plant Info");
        FXMLLoader loader = new FXMLLoader();
        String path = "@prj-03-Alchemilla/src/resources/com.example.alchemilla/plant-form.fxml";
        FileInputStream stream = new FileInputStream(path);

        // we vboxed up; creates pane and details
        VBox box = new VBox(loader.load(stream));

        Scene scene = new Scene(box, 2000, 2000); // arbitrary numbers
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    protected void onButtonClick() {
        actiontarget.setText("Welcome to JavaFX Application!");

        String imageString = plantimagepath.getText();
        String nameString = plantname.getText();
        String waterString = water.getText();
        String foodDeltaString = fooddelta.getText();
        String foodString = food.getText();
        String descString = description.getText();
        String instructionString = instruction.getText();


        // NEEDS PLANT IMAGE PATH ADAPTER
        Plant plant = new Plant(plantimagepath, nameString, Integer.parseInt(waterString), Integer.parseInt(foodDeltaString), foodString, descString, instructionString);
    }

    private BufferedImage (String path)
    {
        try
        {
            BufferedImage image = ImageIO.read();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main (String[] args)
    {
        Application.launch(args);
    }
}
