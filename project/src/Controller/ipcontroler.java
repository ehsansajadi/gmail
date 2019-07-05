package Controller;

import Model.Main;
import Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ipcontroler {
    @FXML
    public Label ip ;
    @FXML
    public TextField ipaddress ;
    @FXML
    public Button enterip ;

    private static Socket socket;

    public String IPAddress = "";
    private int port = 8888;


    public void enterip(ActionEvent actionEvent) throws IOException {

        socket = new Socket(ipaddress.getText() , port);
        //System.out.println("1" + IPAddress);
        Main.output = new ObjectOutputStream(socket.getOutputStream());
        Main.input = new ObjectInputStream(socket.getInputStream());
        new PageLoader().load("../View/sample.fxml");
    }
}
