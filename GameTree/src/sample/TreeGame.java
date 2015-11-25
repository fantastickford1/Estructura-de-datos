package sample;

import java.io.Serializable;

/**
 * Created by Karlos on 11/24/2015.
 */
public class TreeGame implements Serializable{

    Node root;
    Node temp;
    Node recover;
    private static final long serialVersionUID = 1;

    TreeGame(){
        root = null;
        temp = new Node();
        recover = null;
    }

    public void setRoot(String firtCuestion,String yesAnswer,String noAnswer){
        root = new Node(firtCuestion);
        root.right = new Node(yesAnswer);
        root.left = new Node(noAnswer);
        recover = root;
        temp = recover;
    }

    public String yesObtion(){
        if (recover.right != null){
            temp = recover;
            recover = recover.right;
            return recover.data;
        }else{
            return null;
        }
    }

    public String noOption(){
        if (recover.left != null){
            temp = recover;
            recover = recover.left;
            return recover.data;
        }else{
            return null;
        }
    }

    public void newCuestionNoOption(String newQuestion, String newAnswer) {
        Node questionNode = new Node(newQuestion);
        Node answerNode = new Node(newAnswer);
        if (temp != root){
            temp.right = questionNode;
        }else{
            temp.left = questionNode;
        }
        questionNode.left = recover;
        temp = questionNode;
        temp.right = answerNode;
    }

    public void newCuestionYesOption(String newQuestion, String newAnswer) {
        Node questionNode = new Node(newQuestion);
        Node answerNode = new Node(newAnswer);
        if (temp != root){
            temp.left = questionNode;
        }else{
            temp.right = questionNode;
        }
        questionNode.left = recover;
        temp = questionNode;
        temp.right = answerNode;
    }
}
