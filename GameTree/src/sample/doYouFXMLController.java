package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Karlos on 11/24/2015.
 */
public class doYouFXMLController implements Initializable {

    @FXML private Button treeButton;
    private Stage primaryStage;
    private Scene scene;
    private TreeGame TREE;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image treeImage = new Image(getClass().getResourceAsStream("/img/tree-icon-green.png"));
        ImageView tree = new ImageView(treeImage);
        tree.setFitHeight(30);
        tree.setFitWidth(30);
        treeButton.setGraphic(tree);
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

    @FXML private void openTreeWatchWindow(){
        Stage stage = new Stage();
        FXMLLoader myloader = new FXMLLoader(
                getClass().getResource("/sample/TreeWatcherFXML.fxml")
        );
        Parent root = null;
        try {
            root = (Parent) myloader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        TreeWatcherController myController = myloader.getController();
        Scene TreeWatcherScene = new Scene(root);
        myController.setScene(TreeWatcherScene);
        myController.setTree(this.TREE);
        stage.setScene(TreeWatcherScene);
        stage.show();
    }

    @FXML private void close(){
        System.exit(0);
    }

    public void setTreeAux(TreeGame tree){
        this.TREE = tree;
    }

    public void setScene(Scene doYouScene) {
        this.scene = doYouScene;
    }

    public void setStage(Stage stage) {
        this.primaryStage = stage;
    }
}
