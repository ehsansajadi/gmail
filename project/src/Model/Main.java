package Model;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main extends Application {

    private static final int WIDTH = 300 ;
    private static final int HEIGHT = 500 ;

    @FXML
    public Label ip ;
    @FXML
    public TextField ipaddress ;
    @FXML
    public Button enterip ;

    public static ObjectInputStream input;
    public static ObjectOutputStream output;

    @Override
    public void init() throws IOException {
        //Alluser.loaduser();

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        PageLoader.initStage(primaryStage);
        new PageLoader().load("../View/ipaddress.fxml");
    }

    @Override
    public  void  stop(){
        System.out.println("program stoped");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
