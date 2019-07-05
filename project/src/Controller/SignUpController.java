package Controller;

import Model.Main;
import Model.PageLoader;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import utility.Message;
import utility.MessageType;
import utility.user;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class SignUpController {

    @FXML
    public SplitPane root ;
    @FXML
    public Button Signup2 ;
    @FXML
    public TextField reenterpassword,name, lastname, age , username , password ;
    @FXML
    public Label  namel , lastnamel , agel ,usernamel, passwordl , reenterl , ageerror ,passerror , reenterpasserror;

    public void initialize() {
        FadeTransition ft = new FadeTransition(Duration.millis(2000) , root);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.playFromStart();
    }

    public void Signup2(ActionEvent actionEvent) throws IOException {

        user newuser = new user();


        if (!password.getText().isEmpty() && !username.getText().isEmpty() && !name.getText().isEmpty() &&
                !reenterpassword.getText().isEmpty() && !lastname.getText().isEmpty() && !age.getText().isEmpty() )
        {

            if (Integer.parseInt(age.getText()) >= 12) {

                ageerror.setVisible(false);

                if (password.getText().length() >= 8) {

                    passerror.setVisible(false);
                    ageerror.setVisible(false);

                    if (password.getText().equalsIgnoreCase(reenterpassword.getText())) {

                        passerror.setVisible(false);
                        ageerror.setVisible(false);
                        reenterpasserror.setVisible(false);

                        newuser.setName(name.getText());
                        newuser.setAge(age.getText());
                        newuser.setLastname(lastname.getText());
                        newuser.setUsername(username.getText());
                        newuser.setPassword(password.getText());

                        Message message = new Message();
                        message.setMessageType(MessageType.SignUp);
                        Main.output.writeObject(message);
                        Main.output.writeObject(newuser);


/*                      FileOutputStream f1 = new FileOutputStream("2.ser", true);
                        ObjectOutputStream out = new ObjectOutputStream(f1);
                        out.writeObject(newuser);*/
                        //LoadMembers.ALLMEMBERS.add(newuser);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION, " signed up successfully ");
                        alert.showAndWait();
                        new PageLoader().load("/View/sample.fxml");

                    }
                    else{
                        reenterpasserror.setVisible(true);
                    }
                }
                else{
                    passerror.setVisible(true);
                }
            }
            else{
                ageerror.setVisible(true);
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, " fill all above field ");
            alert.showAndWait();
        }
    }
}
