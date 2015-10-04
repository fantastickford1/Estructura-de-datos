/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicajavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Karlos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button btnDisappear;
    @FXML
    private Pane Contenedor;
    @FXML
    private Slide slide;
    @FXML
    private ProgressBar Bar;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    //Andres 1 , JAvier, Rito, Alexis Javier, Farelo, Julian, Sierra 
    @FXML
    private void Exit(ActionEvent event){
        System.exit(0);
    }
    
    @FXML
    private void CentrarApp(ActionEvent event){
        Stage stage = (Stage) Contenedor.getScene().getWindow();
        stage.centerOnScreen();
    }
    
    @FXML
    private void OnDisappear(ActionEvent event){
        String TextoBoton;
        TextoBoton = btnDisappear.getText();
        if("Disappear".equals(TextoBoton)){
            Contenedor.setVisible(false);
            btnDisappear.setText("Appear");
        }else{
            Contenedor.setVisible(true);
            btnDisappear.setText("Disappear");
        }
    }
    
    @FXML
    private void OnDisable(ActionEvent event){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
