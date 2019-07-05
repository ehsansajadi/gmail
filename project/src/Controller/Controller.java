package Controller;

import Model.Main;
import Model.PageLoader;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;
import utility.Message;
import utility.MessageType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Controller {

    public static final String USERNAME = "ehsan" ;
    public static final String PASSWORD = "sajadi" ;

    @FXML
    public Button button , Signup ;
    @FXML
    public PasswordField passwordField ;
    @FXML
    public TextField textField , visiblePasswordField  ;
    @FXML
    public Label wrongPassword  ;
    @FXML
    public CheckBox showPassword ;

// animation

/*    public void initialize() {
        TranslateTransition tt = new TranslateTransition(Duration.millis(1000) , button);
        tt.setToX(-50);
        tt.playFromStart();
    }*/

    public void signin(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        if (textField.getText().equals(USERNAME) && ( passwordField.getText().equals(PASSWORD) || visiblePasswordField.getText().equals(PASSWORD)) ) {
            wrongPassword.setVisible(false);
            new PageLoader().load("../View/inbox.fxml");

/*          Alert alert = new Alert(Alert.AlertType.INFORMATION, " Hello ");
            alert.showAndWait();*/
        }
        else{
            wrongPassword.setVisible(true);
        }
    }

    public void visiblePassword() {
        if(showPassword.isSelected()) {
            visiblePasswordField.setText(passwordField.getText());
            visiblePasswordField.setVisible(true);
            passwordField.setVisible(false);
        }
        else{
            passwordField.setText(visiblePasswordField.getText());
            visiblePasswordField.setVisible(false);
            passwordField.setVisible(true);
        }
    }

    public void Signup(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("../View/Signup.fxml");
    }

    public Object ReadObjectFromFile(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
