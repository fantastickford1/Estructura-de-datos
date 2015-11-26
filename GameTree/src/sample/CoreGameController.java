package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Karlos on 11/23/2015.
 */
public class CoreGameController implements Initializable {

    @FXML private Label question;
    private TreeGame tree;
    private String dataQuestion;
    private String selectedData;
    private String newAnswer;
    private String newQuestion;
    private Scene scene;
    private Stage primaryStage;
    private String lastData;
    private boolean yesOrno;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Controller temp = new Controller();
        boolean recover = temp.getABoolean();
        tree = new TreeGame();
        if (recover){
            this.tree = recoverTree();
            tree.setRoot(this.tree.getRoot());
            dataQuestion = tree.root.data;
            question.setText(dataQuestion);

        }else {
            tree.setRoot("Es privado?","Es carro","Es combi");
            dataQuestion = tree.root.data;
            question.setText(dataQuestion);
        }

    }

    @FXML
    private void yesOptionPath(){
       String data = tree.yesObtion();
        if (data != null){
            question.setText("Es un/una " + data + "?");
            yesOrno = true;
        }else{
            question.setText("I made it! It's " + data + "!");
            doYouWindow();
        }
    }

    @FXML
    private void noOptionPath(){
        String data = tree.noOption();
        if (data != null){
            this.selectedData = data;
            question.setText("Es un/una" + selectedData + "?");
            yesOrno = false;
        }else {
            openAnswerWindow();
            if (yesOrno){
                tree.newCuestionYesOption(this.newQuestion,this.newAnswer);
            }else {
                tree.newCuestionNoOption(this.newQuestion,this.newAnswer);
            }
            saveTree(tree);
            openInicialWindow();
        }
    }

    private void openAnswerWindow(){
        Stage stage = new Stage();
        FXMLLoader myLoader = new FXMLLoader(
                getClass().getResource("/sample/AnswerFXML.fxml")
        );
        Parent root = null;
        try {
            root = (Parent) myLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AnswerFXMLController myController = myLoader.getController();
        Scene answerScene = new Scene(root);
        myController.setScene(answerScene);
        ///////////////////////////////////////////
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Answer input");
        dialog.setContentText("En que estabas pensando?");
        dialog.setHeaderText(null);
        dialog.setGraphic(null);
        Optional<String> result = dialog.showAndWait();
        this.newAnswer = "";
        if (result.isPresent()){
            this.newAnswer = result.get();
        }
        ///////////////////////////////////////////
        myController.setQuestionLabel("¿Que diferencia tiene "+this.selectedData+" con " +this.newAnswer);
        myController.setStage(stage);
        stage.setScene(answerScene);
        stage.showAndWait();
        //this.newAnswer = myController.getAnswer();
        this.newQuestion = myController.getQuestion();
    }

    private void openInicialWindow(){
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

    private void doYouWindow(){
        Stage stage = new Stage();
        FXMLLoader myLoader = new FXMLLoader(
                getClass().getResource("/sample/doYouFXML.fxml")
        );
        Parent root =  null;
        try {
            root = (Parent) myLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doYouFXMLController myController = myLoader.getController();
        Scene doYouScene = new Scene(root);
        myController.setScene(doYouScene);
        myController.setStage(stage);
        stage.setScene(doYouScene);
        stage.showAndWait();
        this.primaryStage.close();
    }

    private void saveTree(TreeGame node){
        try {
            final FileOutputStream fo = new FileOutputStream("game.bin");
            final ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(node);
            oos.flush();
            oos.close();
            System.out.println("Saved it");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TreeGame recoverTree(){
        try {
            final FileInputStream fis = new FileInputStream("game.bin");
            final ObjectInputStream ois = new ObjectInputStream(fis);
            final Object deserializedObject = ois.readObject();
            System.out.println("Tipo de objeto " + deserializedObject.getClass().getName());
            if (deserializedObject instanceof TreeGame){
                return (TreeGame) deserializedObject;
            }else{
                System.out.println("No se esperaba " + deserializedObject.getClass().getName());
            }
            ois.close();
            if (tree != null){
                System.out.println("Recovered");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public void setScene(Scene playScene) {
        this.scene = playScene;
    }

    public void setStage(Stage stage) {
        this.primaryStage = stage;
    }
}
