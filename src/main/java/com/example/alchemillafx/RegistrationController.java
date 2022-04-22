package com.example.alchemillafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * JavaFX class that controls a user registration form, takes user input, creates a profile, and stores in memory.
 */
public class RegistrationController {

    /**
     * Input field for username
     */
    @FXML
    private TextField nameInput;

    /**
     * Input Field for email address
     */
    @FXML
    private TextField emailInput;

    /**
     * Input Field for password
     */
    @FXML
    private PasswordField pwdInput;

    /**
     * Button to trigger storing profile into memory
     */
    @FXML
    private Button submitButton;

    /**
     * Gets user input from input fields, creates profile, and stores profile in memory
     * @param event Button on click action
     */
    @FXML
    protected void onClick(ActionEvent event) {
        Window owner = submitButton.getScene().getWindow();

        String nameString = nameInput.getText();
        String emailString = emailInput.getText();
        String pwdString = pwdInput.getText();

        Profile newProf = new Profile(nameString, Calendar.getInstance());
        SerializeClassData sc = new SerializeClassData();
        File f = new File(nameString);
        try {
            f.createNewFile();
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }

        sc.storeProfile(nameString, newProf);
    }
}
