/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author albertoobando
 */
public class Image {
    
    private boolean Status;
    private String Link;
    
    //Constructor
    public Image(String pLink){
        this.Status = false;
        this.Link = pLink;
    }
    
    //Setters y Getters
    
    public void setTrue(){
        this.Status = true;
    }
    
    public void setFalse(){
        this.Status = false;
    }
    
    public boolean getStatus(){
        return this.Status;
    }
    
    public void setLink(String pLink){
        this.Link = pLink;
    }
    
    public String getLink(){
        return this.Link;
    }
}
