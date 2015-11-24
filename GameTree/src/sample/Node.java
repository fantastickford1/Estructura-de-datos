package sample;

import java.io.Serializable;

/**
 * Created by Karlos on 11/23/2015.
 */
public class Node implements Serializable {

    public Node right,left;
    public String data;
    private static final long serialVersionUID = 1;

    public Node(){
        this.data = null;
        this.right = null;
        this.left = null;
    }

    public Node(String data){
        this.data = data;
        this.right = null;
        this.left = null;
    }
}
