
package tree;

public class ImageNode {
    
    private boolean Status=false;
    private String Link;
    private String Description;
    //Constructor
    public ImageNode(String pLink){
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
    
    public void printImage()
    {
        System.out.println(this.getStatus());
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
    
}
