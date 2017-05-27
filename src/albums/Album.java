/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package albums;

import tree.*;
import java.io.Serializable;

/**
 * Esta es la clase que se va a guardar en la compu como archivo
 * @author albertoobando
 */
public class Album implements Serializable{
    
    private String Name;
    private AVLTree Tree;
    
    //Constructor
    public Album (String pName, AVLTree pTree){
        this.Name = pName;
        this.Tree = pTree;
    }
    
    //Setters y Getters
    public void setName(String pName){
        this.Name = pName;
    }
    
    public String getName(){
        return this.Name;
    }
    
    public void setTree(AVLTree pTree){
        this.Tree = pTree;
    }
    
    public AVLTree getTree(){
        return this.Tree;
    }
    
}
