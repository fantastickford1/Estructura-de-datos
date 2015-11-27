package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Karlos on 11/26/2015.
 */
public class TreeWatcherController implements Initializable{

    @FXML
    private Group group;
    @FXML
    private Label noNodosLabel,lvlLabel;
    @FXML
    private Button plus,drecress;

    private TreeGame theTree;
    private Scene scene;
    private double x,y = 30;
    private double count = 1;
    private double T = 100;
    private double temp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void zoomPlus(){
        group.setScaleX(T++/100);
        group.setScaleY(T++/100);
    }

    @FXML private void zoomLess(){
        group.setScaleX(T--/100);
        group.setScaleY(T--/100);
    }

    public void setTree(TreeGame tree){
        this.theTree = tree;
        noNodosLabel.setText("["+ theTree.getChildrens() + "]");
        lvlLabel.setText("[" + theTree.getHeight() + "]");
        this.temp = Math.pow(2,theTree.getHeight());
        this.x = 160* temp /2;
        this.y = 50;
        postOrder();
    }

    public void postOrder(){
        postOrder(this.theTree.getRoot(),this.x,this.y,this.temp);
    }

    public void postOrder(Node node,double x,double y,double temp){
        if (node != null){
            postOrder(node.left,x - 50 * temp,y + 170,4);
            postOrder(node.right,x + 50 * temp,y + 170,8);
            Circle circle = new Circle(20);
            circle.setId(node.data.replace(" ", "-"));
            circle.setFill(Color.RED);
            circle.setCenterX(x);
            circle.setCenterY(y);
            group.getChildren().add(circle);
            setLines(circle,node);
        }
    }


    private void setLines(Circle circle, Node node) {
        if(node.right != null || node.left != null ){
            try{
                Line line = new Line();
                line.startXProperty().bind(circle.centerXProperty());
                line.startYProperty().bind(circle.centerYProperty());
                Circle circle2 = (Circle)group.lookup("#" + node.left.data.replace(" ", ""));
                System.out.println("a"+circle2.getId());
                line.endXProperty().bind(circle2.centerXProperty());
                line.endYProperty().bind(circle2.centerYProperty());
                line.setStroke(Color.STEELBLUE);
                line.setStrokeWidth(1);
                group.getChildren().add(0,line);
            }catch(Exception e){
            }
            try{
                Line line = new Line();
                line.startXProperty().bind(circle.centerXProperty());
                line.startYProperty().bind(circle.centerYProperty());
                Circle circle2 = (Circle)group.lookup("#" + node.right.data.replace(" ", ""));
                System.out.println("a"+circle2.getId());
                line.endXProperty().bind(circle2.centerXProperty());
                line.endYProperty().bind(circle2.centerYProperty());
                line.setStroke(Color.STEELBLUE);
                line.setStrokeWidth(1);
                group.getChildren().add(0,line);
            }catch(Exception e){
            }
        }

    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }


}
