package com.example.alchemillafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.io.File;
import java.util.Calendar;

public class RegistrationController {

    @FXML
    private TextField nameInput;

    @FXML
    private TextField emailInput;

    @FXML
    private PasswordField pwdInput;

    @FXML
    private Button submitButton;

    @FXML
    protected void onClick(ActionEvent event) {
        Window owner = submitButton.getScene().getWindow();

        String nameString = nameInput.getText();
        String emailString = emailInput.getText();
        String pwdString = pwdInput.getText();

        Profile newProf = new Profile(nameString, Calendar.getInstance());
        SerializeClassData sc = new SerializeClassData();
        File f = new File(nameString);

        sc.storeProfile(nameString, newProf);
    }
}
