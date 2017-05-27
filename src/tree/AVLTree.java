
package tree;

import java.net.URL;
import java.util.ArrayList;


public class AVLTree {
    
    private AVLNode root;  
    ArrayList<String> urlPhotos = new ArrayList();
	 
    /* Constructor */
    public AVLTree()
    {
        root = null;
    }
    
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    
    /* Make the tree logically empty */
    public void makeEmpty()
    {
        root = null;
    }
    
    /* Function to insert data */
    public void insert(String data, ImageNode pLink)
    {
        root = insert(data, root, pLink);
    }
    
    /* Function to get height of node */
    private int height(AVLNode pNode )
    {
        return pNode == null ? -1 : pNode.getHeight();
    }
    
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
    
    /* Function to insert data recursively */
    private AVLNode insert(String pTag, AVLNode pNode, ImageNode pLink)
    {
        if (pNode == null)
            pNode = new AVLNode(pTag, pLink);
        
        else if (pTag.compareTo((String) pNode.getData()) < 0 )
        {
            pNode.setLeft(insert( pTag, pNode.getLeft() , pLink));
            if( height( pNode.getLeft() ) - height( pNode.getRight() ) == 2 )
                if( pTag.compareTo((String) pNode.getLeft().getData()) < 0)
                    pNode = rotateWithLeftChild( pNode );
                else
                    pNode = doubleWithLeftChild( pNode );
        }
        else if( pTag.compareTo((String) pNode.getData()) > 0 )
        {
            pNode.setRight( insert( pTag, pNode.getRight() , pLink));
            if( height( pNode.getRight() ) - height( pNode.getLeft() ) == 2 )
                if( pTag.compareTo((String) pNode.getRight().getData()) > 0 )
                    pNode = rotateWithRightChild( pNode );
                else
                    pNode = doubleWithRightChild( pNode );
        }
        else
        {
            pNode.getLinks().add(pLink);
        }
        pNode.setHeight( max( height( pNode.getLeft() ), height( pNode.getRight() ) ) + 1);
        return pNode;
    }
    
    /* Rotate binary tree node with left child */     
    private AVLNode rotateWithLeftChild(AVLNode k2Node)
    {
        AVLNode k1Node = k2Node.getLeft();
        k2Node.setLeft(k1Node.getRight());
        k1Node.setRight(k2Node);
        k2Node.setHeight(max( height( k2Node.getLeft() ), height( k2Node.getRight() ) ) + 1);
        k1Node.setHeight(max( height( k1Node.getLeft() ), k2Node.getHeight() ) + 1);
        return k1Node;
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode k1Node)
    {
        AVLNode k2Node = k1Node.getRight();
        k1Node.setRight(k2Node.getLeft());
        k2Node.setLeft(k1Node);
        k1Node.setHeight(max( height( k1Node.getLeft() ), height( k1Node.getRight() ) ) + 1);
        k2Node.setHeight(max( height( k2Node.getRight() ), k1Node.getHeight() ) + 1);
        return k2Node;
    }
    
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private AVLNode doubleWithLeftChild(AVLNode k3Node)
    {
        k3Node.setLeft(rotateWithRightChild( k3Node.getLeft() ));
        return rotateWithLeftChild( k3Node );
    }
    
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */      
    private AVLNode doubleWithRightChild(AVLNode k1Node)
    {
        k1Node.setRight(rotateWithLeftChild( k1Node.getRight() ));
        return rotateWithRightChild( k1Node );
    }  
    

    
    /* Functions to search for an element */
    public boolean search(String pVal)
    {
        return search(root, pVal);
    }
    
    private boolean search(AVLNode pNode, String pVal)
    {
        boolean found = false;
        while ((pNode != null) && !found)
        {
            String rval = (String) pNode.getData();
            if (pVal.compareTo(rval) < 0)
                pNode = pNode.getLeft();
            else if (pVal.compareTo(rval) > 0)
                pNode = pNode.getRight();
            else
            {
                found = true;
                break;
            }
            found = search(pNode, pVal);
        }
        return found;
    }
    
    
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    
    private void inorder(AVLNode pNode)
    {
        
        if (pNode != null)
        {
            inorder(pNode.getLeft());
            System.out.print(pNode.getData() +" "); 
           
            inorder(pNode.getRight());
           
        }
        
    }
    
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    
    private void preorder(AVLNode pNode)
    {
        if (pNode != null)
        {
            System.out.print(pNode.getData() +" ");
            preorder(pNode.getLeft());             
            preorder(pNode.getRight());
        }
    }
    
 
    
    public int getBalance(AVLNode pNode)
    {
        if (pNode == null)
            return 0;
        return height(pNode.getLeft()) - height(pNode.getRight());
    }
    
    public AVLNode deleteNode(AVLNode root, String key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;
 
        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key.compareTo((String) root.getData()) < 0 )
            root.setLeft(deleteNode(root.getLeft(), key));
 
        // If the key to be deleted is greater than the
        // root's key, then it lies in right subtree
        else if (key.compareTo((String) root.getData()) > 0)
            root.setRight(deleteNode(root.getRight(), key));
 
        // if key is same as root's key, then this is the node
        // to be deleted
        else
        {
 
            // node with only one child or no child
            if ((root.getLeft() == null) || (root.getRight() == null))
            {
                AVLNode temp = null;
                if (temp == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();
 
                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else   // One child case
                    root = temp; // Copy the contents of
                                 // the non-empty child
            }
            else
            {
 
                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                AVLNode temp = minValueNode(root.getRight());
 
                // Copy the inorder successor's data to this node
                root.setData( temp.getData());
 
                // Delete the inorder successor
                root.setRight(deleteNode(root.getRight(), temp.getData()));
            }
        }
 
        // If the tree had only one node then return
        if (root == null)
            return root;
 
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);
 
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getBalance(root);
 
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.getLeft()) >= 0)
            return rightRotate(root);
 
        // Left Right Case
        if (balance > 1 && getBalance(root.getLeft()) < 0)
        {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }
 
        // Right Right Case
        if (balance < -1 && getBalance(root.getRight()) <= 0)
            return leftRotate(root);
 
        // Right Left Case
        if (balance < -1 && getBalance(root.getRight()) > 0)
        {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }
 
        return root;
    }
    
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    public AVLNode rightRotate(AVLNode pNode)
    {
        AVLNode x = pNode.getLeft();
        AVLNode T2 = x.getRight();
 
        // Perform rotation
        x.setRight(pNode);
        pNode.setLeft(T2);
 
        // Update heights
        pNode.setHeight(max(height(pNode.getLeft()), height(pNode.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
 
        // Return new root
        return x;
    }
    
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    public AVLNode leftRotate(AVLNode pNode)
    {
        AVLNode y = pNode.getRight();
        AVLNode T2 = y.getLeft();
 
        // Perform rotation
        y.setLeft(pNode);
        pNode.setRight(T2);
 
        //  Update heights
        pNode.setHeight(max(height(pNode.getLeft()), height(pNode.getRight()) + 1));
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
 
        // Return new root
        return y;
    }
    
    public AVLNode minValueNode(AVLNode node)
    {
        AVLNode current = node;
 
        while (current.getLeft() != null)
           current = current.getLeft();
 
        return current;
    }

    
    //Setters y getters
    
   
    
    
public void debug(AVLNode pNode){
        if (pNode.getLinks().size() == 1){
            if (pNode.getLinks().get(0).getStatus() == false){
                pNode.getLinks().get(0).setTrue();
            }else{
                pNode.getLinks().remove(0);
                
            }
        }else{
            int arraySize = pNode.getLinks().size();
            for (int i = arraySize-1; i >= 0; i--){
                if (pNode.getLinks().get(i).getStatus() == false){
                    pNode.getLinks().get(i).setTrue();
                }else{
                    pNode.getLinks().remove(i);
                }
            }
        }
    }
    
    public void debugTree()
    {
        debugTree(root);
    }
    
    private void debugTree(AVLNode pNode)
    {
        if (pNode != null)
        {
            debugTree(pNode.getLeft());
            debug(pNode);
            debugTree(pNode.getRight());
        }
    }
      
  public ArrayList<ImageNode> getImagesNode()
    {
        ArrayList<ImageNode> result = new ArrayList<ImageNode>();
        getImagesNode(root, result);
        System.out.println("\n");
        System.out.println(result);
        return result;
    }
    
   private void getImagesNode(AVLNode pNode, ArrayList<ImageNode> pArray)
    {
        if (pNode != null)
        {
            getImagesNode(pNode.getLeft(), pArray);
            ArrayList<ImageNode> temp = this.getImagesNodeList(pNode, pArray);
            getImagesNode(pNode.getRight(), temp);
        }
    }
    
    public ArrayList<ImageNode> getImagesNodeList(AVLNode pNode, ArrayList<ImageNode> pArray)
    {
        if (pNode.getLinks().size() == 1){
            pArray.add(pNode.getLinks().get(0));
        }else{
            for(int i=0 ; i<pNode.getLinks().size()-1;i++)
            {
                pArray.add(pNode.getLinks().get(i));
            } 
        }
        return pArray;
    }
    
    
    
    
     public void setRoot(AVLNode pNode){
        this.root = pNode;
    }
    
    public AVLNode getRoot(){
        return this.root;
    }
    
    public void printTree(){
        printTree(root);
    }
    
    public void printTree(AVLNode pNode){
        if (pNode != null)
        {
            printTree(pNode.getLeft());
            if (!pNode.getLinks().isEmpty()){
                for (int i = 0; i < pNode.getLinks().size(); i++){
                    System.out.print("Tag: ");
                    System.out.println(pNode.getData());
                    System.out.print("Image Link: ");
                    System.out.println(pNode.getLinks().get(i).getLink());
                    System.out.print("Image description: ");
                    System.out.println(pNode.getLinks().get(i).getDescription());
                }
            }
            printTree(pNode.getRight());
        }
    }

}