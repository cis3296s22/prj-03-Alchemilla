package com.example.alchemillafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

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
    String currentPlantName;
    LinkedList<String> plants = new LinkedList<String>();
    Profile profile;

    @FXML
    private void displayPlant(BufferedImage plant){

    }



    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        SerializeClassData sc = new SerializeClassData();
        try {
            profile = sc.getProfile(currentProfile);
            LinkedList<Plant> plantLinkedList = profile.getPlants();
            Iterator i = plantLinkedList.iterator();
            while (i.hasNext()){
               Plant tempPlant = (Plant)i.next();
               plantList.getItems().add(tempPlant.getPlantName());
               plants.add(tempPlant.getPlantName());

            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        plantList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2){

                currentPlantName = plantList.getSelectionModel().getSelectedItem();
                plantData.setText(currentPlantName);

                //iterate through plants to get image information
                LinkedList<Plant> lp = profile.getPlants();
                Iterator i = lp.iterator();

                while(i.hasNext()){
                    Plant p = (Plant) i.next();
                    if (p.getPlantName().equals(currentPlantName)){
                        try {


                            plantImage.setImage(SwingFXUtils.toFXImage(p.getPlantImage(),null));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }

        });

    }
}