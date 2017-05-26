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
public class AVLTree {
    
    private AVLNode root;     
	 
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
    public void insert(String data, String pLink)
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
    private AVLNode insert(String pTag, AVLNode pNode, String pLink)
    {
        if (pNode == null)
            pNode = new AVLNode(pTag, pLink);
        else if (pTag.compareTo(pNode.getData()) < 0 )
        {
            pNode.setLeft(insert( pTag, pNode.getLeft(), pLink ));
            if( height( pNode.getLeft() ) - height( pNode.getRight() ) == 2 )
                if( pTag.compareTo(pNode.getLeft().getData()) < 0)
                    pNode = rotateWithLeftChild( pNode );
                else
                    pNode = doubleWithLeftChild( pNode );
        }
        else if( pTag.compareTo(pNode.getData()) > 0 )
        {
            pNode.setRight( insert( pTag, pNode.getRight(), pLink ));
            if( height( pNode.getRight() ) - height( pNode.getLeft() ) == 2 )
                if( pTag.compareTo(pNode.getRight().getData()) > 0 )
                    pNode = rotateWithRightChild( pNode );
                else
                    pNode = doubleWithRightChild( pNode );
        }
        else{ //Duplicate
            pNode.setLinks(pLink);
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
    
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    
    private int countNodes(AVLNode pNode)
    {
        if (pNode == null)
            return 0;
        else
        {
            int lenght = 1;
            lenght += countNodes(pNode.getLeft());
            lenght += countNodes(pNode.getRight());
            return lenght;
        }
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
            String rval = pNode.getData();
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
    
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(AVLNode pNode)
    {
        if (pNode != null)
        {
            postorder(pNode.getLeft());             
            postorder(pNode.getRight());
            System.out.print(pNode.getData() +" ");
        }
    }
    
}
