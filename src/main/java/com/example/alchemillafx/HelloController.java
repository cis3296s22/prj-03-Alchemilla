package com.example.alchemillafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;

/**
 * JavaFX Controller that handles displaying profile and plant information in the main scene
 */
public class HelloController implements Initializable {


    /**
     * Display at a glance information about plants
     */
    @FXML
    private TextFlow plantData;
    //@FXML
    //private ScrollPane description;
    /**
     * display a selectable list of plants owned by the current profile
     */
    @FXML
    private ListView<String> plantList;
    /**
     * Display description and instructions for the currently chosen plant in the scrollable pane
     */
    @FXML
    private TextFlow description;
    /**
     * Display plant image
     */
    @FXML
    private ImageView plantImage;

    String currentProfile = "joe"; //holds current profile. Currently hardcoded until ready to implement real deal
    String currentPlantName; //Currently selected plant
    LinkedList<String> plants = new LinkedList<String>(); //hold list of plant names owned by profile
    Profile profile; //actual profile object from which we gather plant objects etc.
    Plant currentPlant; //actual current plant object

    @FXML
    private void displayPlant(BufferedImage plant){

    }

    @FXML
    private MenuItem accountItem;

    @FXML
    private MenuItem plantItem;

    @FXML
    private void plantLaunch(ActionEvent e)
    {
        /*
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("plant-form.fxml"));
        Parent root = loader.load();
        */

        Stage s = new Stage();
        PlantApplication plantApp = new PlantApplication();
        try {
            plantApp.start(s);
        }

        catch(Exception exception)
        {

        }
    }

    @FXML
    private void profileLaunch(ActionEvent e)
    {
        /*
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("plant-form.fxml"));
        Parent root = loader.load();
        */

        Stage stage = new Stage();
        RegistrationApplication regApp = new RegistrationApplication();
        try {
            regApp.start(stage);
        }

        catch(Exception exception)
        {

        }
    }


    /**
     * Display Plant description and Plant instruction data members in the scrollable pane
     * @param des Plant.description
     * @param inst Plant.instructions
     */
    @FXML
    private void displayDescription(String des, String inst){
        Text desBold = new Text();//"Description\n");
        desBold.setText("Description\n");   //
        desBold.setFont(Font.font("Helvetica",FontWeight.BOLD, 16));
        Text descriptionBox = new Text();
        Text instruction = new Text("Instructions\n");
        instruction.setFont(Font.font("Helvetica",FontWeight.BOLD,16));
        Text instructionBox = new Text("\n");
        descriptionBox.setText(des+"\n");
        instructionBox.setText(inst+"\n");
       // String test = "hello world ";
       // Text test = new Text("Ipso lorum and a lot of other text to demonstrate that lka;ljafd there is indeed a capability for scrolling. Ok this isn't enough yet, let's add some new lines \n\n\n\n\n\n\n\n\n ok much better... how we looking? time to compile. fingers crossed");
        TextFlow desFlow = new TextFlow(desBold,descriptionBox,instruction,instructionBox);
        description.getChildren().clear();
        description.getChildren().addAll(desBold,descriptionBox,instruction,instructionBox);

    // = desFlow;

    }

    /**
     * Changes pane which displays Information about plant such as water & food deltas, plant name, etc.
     * @param plant Plant object for which we wish to display information
     */
    @FXML
    private void displayLabel(Plant plant){

        Text nameLabel = new Text();
        nameLabel.setText("Name: ");
        nameLabel.setFont(Font.font("Helvetica",FontWeight.BOLD,14));
        Text name = new Text();
        name.setText(plant.getPlantName()+"\n");
        Text waterLabel = new Text();
        waterLabel.setText("Watering Schedule\n");
        waterLabel.setFont(Font.font("Helvetica",FontWeight.BOLD,14));
        Text water = new Text();
        String w = "Water every "+plant.getWaterDelta()+" days.\n";
        water.setText(w);


        plantData.getChildren().clear();
        plantData.getChildren().addAll(nameLabel,name,waterLabel,water);


    }

    /**
     * Method for dynamically populating the screen. Call to update profile information.
     */
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
            /**
             * Implements changes based on user selection. Currently hooked to ListView object
             * Changes Picture, Instruction, and Description display panes
             * @param arg0 none
             * @param arg1 none
             * @param arg2 none
             */
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2){

                currentPlantName = plantList.getSelectionModel().getSelectedItem();

                //plantData.setText(currentPlantName);

                //iterate through plants to get image information
                LinkedList<Plant> lp = profile.getPlants();
                Iterator i = lp.iterator();

                while(i.hasNext()){
                    Plant p = (Plant) i.next();
                    if (p.getPlantName().equals(currentPlantName)){
                        currentPlant = p;
                        //set description
                        displayDescription(p.getDescription(),p.getInstructions());
                        displayLabel(p);
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