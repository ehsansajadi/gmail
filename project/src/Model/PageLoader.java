package Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PageLoader {

    private static final int WIDTH = 400 ;
    private static final int HEIGHT = 650 ;
    private static Stage stage ;

    public static void initStage(Stage primaryStage){
        stage = primaryStage ;
        stage.setTitle("Sign in");
        stage.initStyle(StageStyle.DECORATED);
/*      stage.setResizable(true);
        stage.setMinHeight(HEIGHT);
        stage.setMinWidth(WIDTH);
        stage.setMaxHeight(650);
        stage.setMaxWidth(350);*/
        stage.getIcons().add(new Image(Paths.get("Resource/image/logo-gmail.png").toUri().toString()));
    }
    public void load(String url) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(url));

        stage.setScene(new Scene(root, WIDTH,HEIGHT));
        stage.show();
    }
}
