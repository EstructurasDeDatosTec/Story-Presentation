/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.ArrayList;

import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author albertoobando
 */
public class AVLNode {
    
    private AVLNode Left, Right;
    private ArrayList<Image> Links = new ArrayList<Image>();
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
        Image pImage = new Image(pLink);
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
    
    public ArrayList<Image> getLinks(){
        return this.Links;
    }
    
    public void setLinks(String pLink){
        Image pImage = new Image(pLink);
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
