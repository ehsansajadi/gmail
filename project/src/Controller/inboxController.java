package Controller;

import Model.PageLoader;
import javafx.event.ActionEvent;

import java.io.IOException;

public class inboxController {
    public void compose(ActionEvent actionEvent) throws IOException {

        new PageLoader().load("/View/sendmail.fxml");

    }
}
