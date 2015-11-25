package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader myLoader = new FXMLLoader(
             getClass().getResource("/sample/sample.fxml")
        );
        Parent root = (Parent) myLoader.load();
        Controller myController = myLoader.getController();
        Scene scene = new Scene(root);
        myController.setStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Play");
        primaryStage.show();

        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
