package sample;

import java.io.Serializable;

/**
 * Created by Karlos on 11/24/2015.
 */
public class TreeGame implements Serializable{

    private Node root;
    private Node temp;
    private Node recover;
    //private static final long serialVersionUID = 1;
    private int count;
    private int height;


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

    public void setRoot(Node root){
        this.root = root;
        recover = root;
        temp = recover;
    }

    public Node getRoot(){
        return this.root;
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
        temp.left = questionNode;
        questionNode.left = recover;
        temp = questionNode;
        temp.right = answerNode;
    }

    public void newCuestionYesOption(String newQuestion, String newAnswer) {
        Node questionNode = new Node(newQuestion);
        Node answerNode = new Node(newAnswer);
        temp.right = questionNode;
        questionNode.left = recover;
        temp = questionNode;
        temp.right = answerNode;
    }

    public int getChildrens(){
        this.count = 0;
        countNodes(this.root);
        return this.count;
    }

    private void countNodes(Node node){
        if (node != null){
            this.count++;
            countNodes(node.left);
            countNodes(node.right);
        }
    }

    public int getHeight(){
        this.height = 0;
        calculateHeight(this.root,1);
        return this.height;
    }

    private void calculateHeight(Node node, int lvl){
        if (node != null){
            calculateHeight(node.left, lvl+1);
            if (lvl > this.height){
                this.height = lvl;
            }
            calculateHeight(node.right, lvl+1);
        }
    }

}
