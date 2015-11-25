package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Karlos on 11/24/2015.
 */
public class doYouFXMLController implements Initializable {


    private Stage primaryStage;
    private Scene scene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void openInicial(){
        Stage stage = new Stage();
        FXMLLoader mylLoader = new FXMLLoader(
                getClass().getResource("/sample/sample.fxml")
        );
        Parent root = null;
        try {
            root = (Parent) mylLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Controller myController = mylLoader.getController();
        Scene inicialScene = new Scene(root);
        myController.setScene(inicialScene);
        myController.setStage(stage);
        stage.setScene(inicialScene);
        stage.show();
        this.primaryStage.close();
    }

    @FXML private void close(){
        System.exit(0);
    }

    public void setScene(Scene doYouScene) {
        this.scene = doYouScene;
    }

    public void setStage(Stage stage) {
        this.primaryStage = stage;
    }
}
