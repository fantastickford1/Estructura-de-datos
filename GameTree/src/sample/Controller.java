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

public class Controller implements Initializable {


    private Stage primaryStage;
    private Scene scene;
    private static boolean recover = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void playGame(){
        recover = false;
        openGame();
    }

    @FXML private void recoverGame() {
        recover = true;
        openGame();
    }

    public void openGame(){
        Stage stage = new Stage();
        FXMLLoader myLoader = new FXMLLoader(
                getClass().getResource("/sample/CoreGameFXML.fxml")
        );
        Parent root = null;
        try {
            root = (Parent) myLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CoreGameController myController = myLoader.getController();
        Scene playScene = new Scene(root);
        myController.setStage(stage);
        myController.setScene(playScene);
        stage.setScene(playScene);
        stage.show();
        this.primaryStage.close();
    }

    public boolean getABoolean(){
        return recover;
    }

    public void setStage(Stage stage) {
        this.primaryStage = stage;
    }

    public void setScene(Scene inicialScene) {
        this.scene = inicialScene;
    }
}
