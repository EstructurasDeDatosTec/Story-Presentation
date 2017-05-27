/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package albums;

import tree.*;
import java.io.*;

/**
 * Esta es la clase que se va a guardar en la compu como archivo
 * @author albertoobando
 */
public class Album implements Serializable{
    
    private String Name; //nombre del album
    private AVLTree Tree; //arbol con las fotos del album
    
    //Constructor
    public Album (String pName, AVLTree pTree){
        this.Name = pName;
        this.Tree = pTree;
    }
    
    public Album(){
        this.Name = "";
        this.Tree = new AVLTree();
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
    
    //Save Album
    public RWFile saveFile(String pName, AVLTree pTree){
        RWFile result = new RWFile(pName);

        Serialize<AVLTree> se = new Serialize<AVLTree>(result);
        result.writeFile(se.serializing(pTree));

        return result;
    }
    
    //Read Album and get its tree
    public AVLTree readFile(File pFile){
        AVLTree result = null;
        
        RWFile archivo = new RWFile(pFile.getAbsolutePath());
        Serialize<AVLTree> op = new Serialize<AVLTree>(archivo);

        result = op.deserializing(archivo.readFile());

        return result;
    }
    
    
    
}
