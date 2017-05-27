
package tree;

import java.io.Serializable;

public class ImageNode implements Serializable{
    
    private boolean Status;
    private String Link;
    
    //Constructor
    public ImageNode(String pLink){
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
    
    public void setStatus(boolean pStatus){
        this.Status = pStatus;
    }
    
    public void setLink(String pLink){
        this.Link = pLink;
    }
    
    public String getLink(){
        return this.Link;
    }
    
    
}
