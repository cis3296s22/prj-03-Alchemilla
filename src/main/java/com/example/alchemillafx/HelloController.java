package com.example.alchemillafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;


import java.net.URL;
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

    String[] plants = {"rose","daffodil"};

    String currentPlant;

    @FXML
    private void displayPlant(BufferedImage plant){

    }



    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        plantList.getItems().addAll(plants);
        plantList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2){
                currentPlant = plantList.getSelectionModel().getSelectedItem();
                plantData.setText(currentPlant);
            }

        });

    }
}