/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.Scanner;

/**
 *
 * @author albertoobando
 */
public class AVLTreeTest {
    
    public static void main(String[] args)
    {            
        Scanner scan = new Scanner(System.in);
        /* Creating object of AVLTree */
        AVLTree avlt = new AVLTree(); 
 
        System.out.println("AVLTree Tree Test\n");          
        char ch;
        /*  Perform tree operations  */
        do    
        {
            System.out.println("\nAVLTree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. check empty");
            System.out.println("5. clear tree");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter string element to insert");
                Scanner scan2 = new Scanner(System.in);
                ImageNode example = new ImageNode("Link");
                avlt.insert( scan2.nextLine() , example);                     
                break;                          
            case 2 : 
                System.out.println("Enter string element to search");
                Scanner scan3 = new Scanner(System.in);
                System.out.println("Search result : "+ avlt.search( scan3.nextLine() ));
                break;                                          
            case 3 : 
                System.out.println("Nodes = "+ avlt.countNodes());
                break;     
            case 4 : 
                System.out.println("Empty status = "+ avlt.isEmpty());
                break;     
            case 5 : 
                System.out.println("\nTree Cleared");
                avlt.makeEmpty();
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display tree  */ 
            System.out.print("\nPost order : ");
            avlt.postorder();
            System.out.print("\nPre order : ");
            avlt.preorder();
            System.out.print("\nIn order : ");
            avlt.inorder();
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
    
}
