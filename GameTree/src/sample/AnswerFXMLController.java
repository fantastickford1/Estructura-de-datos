package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Karlos on 11/23/2015.
 */
public class AnswerFXMLController implements Initializable {

    @FXML private TextField questionField;
    @FXML private Label questionLabel;
    public String question;
    private Scene scene;
    private Stage primaryStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML public void getData(){
        question = questionField.getText();
        this.primaryStage.close();
    }

    public void setQuestionLabel(String text){
        this.questionLabel.setText(text);
    }

    public String getQuestion(){
        return this.question;
    }

    public void setScene(Scene answerScene) {
        this.scene = answerScene;
    }

    public void setStage(Stage stage) {
        this.primaryStage = stage;
    }
}
