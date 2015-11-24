package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Karlos on 11/23/2015.
 */
public class CoreGameController implements Initializable {

    @FXML private Label question;
    private Node raiz;
    private Node reco;
    private String dataQuestion;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        raiz = new Node("Es privado?");
        raiz.right = new Node("Es Automovil");
        raiz.left = new Node("Es Combi");
        dataQuestion = raiz.data;
        question.setText(dataQuestion);
        reco = raiz;
    }

    @FXML
    private void yesObtion(){
        if (reco.right != null){
            reco = reco.right;
            question.setText(reco.data + "?");
        }else{
            question.setText("I made it! it's " + reco.data + "!");
        }
    }

    @FXML
    private void noObtion(){
        if (reco.left != null){
            reco = reco.left;
            question.setText(reco.data + "?");
        }else{
            //answer = Whats in your mind?
            //diferent = Whats the diferent bettewn reco.data and answer
            reco.data = diferent;
            reco.right = new Node(answer);
        }
    }
}
