package com.example.regexpdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloController {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField contactField;

    @FXML
    private TextField postalField;

    @FXML
    private Label outputLabel;

    @FXML
    protected void onSubmitButtonClicked() {
        String username = usernameField.getText();
        String contact = contactField.getText();
        String postal = postalField.getText();

        boolean isUsernameValid = validateUsername(username);
        boolean isContactValid = validateContact(contact);
        boolean isPostalValid = validatePostalCode(postal);

        StringBuilder result = new StringBuilder();

        if (isUsernameValid && isContactValid && isPostalValid) {
            result.append("All inputs are valid!");
        } else {
            if (!isUsernameValid) {
                result.append("Invalid Username. It should start with an uppercase letter and only contain letters.\n");
            }
            if (!isContactValid) {
                result.append("Invalid Contact Number. It should be exactly 10 digits long and in the format XXX XXX XXXX or (XXX) XXX XXXX.\n");
            }
            if (!isPostalValid) {
                result.append("Invalid Postal Code. It should be in one of the acceptable Canadian postal code formats.\n");
            }
        }

        outputLabel.setText(result.toString());
    }

    private boolean validateUsername(String username) {
        return username.matches("^[A-Z][a-zA-Z]*$");
    }

    private boolean validateContact(String contact) {
        return contact.matches("^\\(\\d{3}\\) \\d{3} \\d{4}$") || contact.matches("^\\d{3} \\d{3} \\d{4}$");
    }

    private boolean validatePostalCode(String postal) {
        return postal.matches("^[A-Za-z]\\d[A-Za-z][ -]?\\d[A-Za-z]\\d$");
    }
}
