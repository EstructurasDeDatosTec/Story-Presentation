/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import javafx.scene.chart.PieChart.Data;
import java.util.ArrayList;

/**
 *
 * @author albertoobando
 */
public class AVLNode {
    
    private AVLNode Left, Right;
    private String Data;
    private int Height;
    private ArrayList<String> Links = new ArrayList<String>();

    /* Constructor */
    public AVLNode()
    {
        Left = null;
        Right = null;
        Data = "";
        Height = 0;
        Links = null;
    }
    /* Constructor */
    public AVLNode(String pTag)
    {
        Left = null;
        Right = null;
        Data = pTag;
        Height = 0;
    }
    
    public AVLNode(String pTag, String pLink)
    {
        Left = null;
        Right = null;
        Data = pTag;
        Height = 0;
        Links.add(pLink);
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
    
    public void setLinks(String pData){
        this.Links.add(pData);
    }
    
    public ArrayList<String> getLinks(){
        return this.Links;
    }
    
}
