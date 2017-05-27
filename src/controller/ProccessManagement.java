
package controller;
import java.net.URISyntaxException;
import java.util.ArrayList;
import tree.AVLTree;
import storyteller.ApiCall;
import storyteller.JsonRead;
import tree.ImageNode;
import ui.StoryUI;


public class ProccessManagement {
    private JsonRead readJson;
    private AVLTree AVLTree;
    private ArrayList<ImageNode> finalImageNodes;
     private ArrayList<String> finalUrlLinks = new ArrayList<String>() ;
    private ArrayList<String> finalImageCaptions= new ArrayList<String>();
    
    
    public ProccessManagement(String pPath) throws URISyntaxException
    {
        readJson = new JsonRead();
        readJson.photoLinks(pPath);
        this.getTree();
        finalImageNodes = AVLTree.getImagesNode();
        
    }
     
    public void getTree()
    {
        
        AVLTree= readJson.getPhotoAnalize().getPhotoTree();
    }

    public AVLTree getAVLTree() {
        return AVLTree;
    }

    public void setAVLTree(AVLTree AVLTree) {
        this.AVLTree = AVLTree;
    }
    
    
    public void captionLinks()
    {
         for (int i = 0; i<=finalImageNodes.size()-1;i++)
         {
           finalUrlLinks.add(finalImageNodes.get(i).getLink());
         }
         
         for (int i = 0; i<=finalImageNodes.size()-1;i++)
         {
           finalImageCaptions.add(finalImageNodes.get(i).getDescription());
         }
    }

    public ArrayList<String> getFinalUrlLinks() {
        return finalUrlLinks;
    }

    public void setFinalUrlLinks(ArrayList<String> finalUrlLinks) {
        this.finalUrlLinks = finalUrlLinks;
    }

    public ArrayList<String> getFinalImageCaptions() {
        return finalImageCaptions;
    }

    public void setFinalImageCaptions(ArrayList<String> finalImageCaptions) {
        this.finalImageCaptions = finalImageCaptions;
    }
}
