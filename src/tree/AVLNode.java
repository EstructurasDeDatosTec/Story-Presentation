
package tree;

import java.util.ArrayList;
import java.io.Serializable;

public class AVLNode implements Serializable{
    
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
    public AVLNode(String pTag, ImageNode pLink)
    {
        Left = null;
        Right = null;
        Data = pTag;
        Height = 0;
        this.Links.add(pLink);
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
    
    //Funciones para ver los datos de un nodo
    public void recorrerDebugNode()
    {
        System.out.println(this.getData());
        System.out.println("\n");
        for(int i=0 ; i<=this.getLinks().size()-1;i++)
        {
            System.out.println(this.getLinks().get(i).getLink());
            System.out.println("\n");
            System.out.print(this.getLinks().get(i).getStatus());
            System.out.println("\n");
            
        }
    }
    
    //Funcion para debuguear un nodo
    public void debug(){
        if (this.getLinks().size() == 1){ //Cuando el nodo solo tiene una imagen
            if (this.getLinks().get(0).getStatus() == false){
                this.getLinks().get(0).setTrue();
            }else{
                this.getLinks().remove(0);
            }
        }else{ //Cuando tiene mas de una imagen
            ArrayList<Integer> pointersToDelete = new ArrayList<Integer>();
            for (int i = 0; i <= this.getLinks().size() - 1; i++){
                if (this.getLinks().get(i).getStatus() == false){
                    this.getLinks().get(i).setTrue();
                }else{
                    pointersToDelete.add(i); /*Me da los indices que tengo que
                    eliminar
                    */
                }
            }
            //Empiezo a borrar los punteros
            int amountToDelete = 0; //sirve para poder borrar el puntero correcto
            if (pointersToDelete.isEmpty()){
                //Do nothing
            }else if (pointersToDelete.size() == 1){
                this.getLinks().remove(pointersToDelete.get(0));
            }
            for (int x = 0; x < pointersToDelete.size(); x++){
                this.getLinks().remove(pointersToDelete.get(x) - amountToDelete);
                amountToDelete++;
            }
        }
    }
    
}
