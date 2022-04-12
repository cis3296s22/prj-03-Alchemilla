package com.example.alchemillafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label plantData;
    //@FXML
    //private ScrollPane description;
    @FXML
    private ListView<String> plantList;

    @FXML
    private ImageView plantImage;

    String currentProfile = "joe"; //TODO currently hardcoded for testing, obviously cannot stay like this
    String currentPlant = "";
    LinkedList<String> plants = new LinkedList<String>();


    @FXML
    private void displayPlant(BufferedImage plant){

    }



    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        SerializeClassData sc = new SerializeClassData();
        try {
            Profile profile = sc.getProfile(currentProfile);
            LinkedList<Plant> plantLinkedList = profile.getPlants();
            Iterator i = plantLinkedList.iterator();
            while (i.hasNext()){
               Plant tempPlant = (Plant)i.next();
               plantList.getItems().add(tempPlant.getPlantName());
               plants.add(tempPlant.getPlantName());

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        plantList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2){
                currentPlant = plantList.getSelectionModel().getSelectedItem();
                plantData.setText(currentPlant);
            }

        });

    }
}