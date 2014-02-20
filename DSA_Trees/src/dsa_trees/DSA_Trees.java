/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsa_trees;

/**
 *
 * @author HP
 */
public class DSA_Trees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        BinaryTree Newtree =new BinaryTree();
            Newtree.insert(5);
            Newtree.insert(48);
            Newtree.insert(20);
            Newtree.insert(57);
            Newtree.insert(3);
            Newtree.insert(8);
     
            Newtree.traverse();
    }
    
}
