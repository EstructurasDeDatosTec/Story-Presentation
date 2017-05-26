
package tree;

import javafx.scene.chart.PieChart.Data;
import java.util.ArrayList;


public class AVLNode {
    
    private AVLNode Left, Right;
    private ArrayList<ImageNode> Links = new ArrayList<ImageNode>();
    private String Data;
    private int Height;

    /* Constructor */
    public AVLNode()
    {
        Left = null;
        Right = null;
        Data = "";
        Height = 0;
    }
    /* Constructor */
    public AVLNode(String pTag, String pLink)
    {
        Left = null;
        Right = null;
        Data = pTag;
        Height = 0;
        ImageNode pImage = new ImageNode(pLink);
        this.Links.add(pImage);
    }
    
    //Setters and Getters
    
    public AVLNode getLeft() {
            return Left;
    }

    public void setLeft(AVLNode left) {
            this.Left = left;
    }

    public AVLNode getRight() {
            return Right;
    }

    public void setRight(AVLNode right) {
            this.Right = right;
    }

    public String getData() {
            return Data;
    }

    public void setData(String data) {
            this.Data = data;
    }

    public int getHeight() {
            return Height;
    }

    public void setHeight(int height) {
            this.Height = height;
    }
    
    public ArrayList<ImageNode> getLinks(){
        return this.Links;
    }
    
    public void setLinks(String pLink){
        ImageNode pImage = new ImageNode(pLink);
        this.Links.add(pImage);
    }
    
    //Otras Funciones
    
    public boolean isLeaf(){
        if (this.Left == null && this.Right == null){
            return true;
        }else{
            return false;
        }
    }
    
    public AVLNode getMax(AVLNode pRoot){
        if (pRoot.Right != null){
            getMax(pRoot);
        }
        return pRoot;
    }
    
    public AVLNode getMin(AVLNode pRoot){
        if (pRoot.Left != null){
            getMin(pRoot);
        }
        return pRoot;
    }
    
}
