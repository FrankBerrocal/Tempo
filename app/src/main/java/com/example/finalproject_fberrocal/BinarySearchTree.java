/**
 * Frank Berrocal Azofeifa
 * Final Project
 *
 * SODV3203 Mobile Application Development
 * Prof.  Ali Moussa
 * Bow Valley College
 *
 * April 2023
 */

package com.example.finalproject_fberrocal;

public class BinarySearchTree {

    private Node Root;

    /**
     * Method insert
     * @param countryName
     * @param countryFile
     * @param id
     * @returns
     * Initialize a new node and insert it in a tree by evaluating the salary information.
     * RC O(log n)
     **/
    public void insert(String countryName, String countryFile, int id, Boolean answer){

        Node node = new Node(countryName, countryFile, id, answer);

        if(Root == null){
            Root = node;
            return;
        }

        Node current = Root;

        // requirement:  should be based on the salary of the employee
        while(true){
            if(id < current.getID()){
                if(current.getLeft() == null) {  //if node is leaf, assign to the left
                    current.setLeft(node);
                    break;
                }
                current = current.getLeft();  //next node

            }else if(id >= current.getID()){
                if(current.getRight() == null) {  //if node is leaf, assign to the left
                    current.setRight(node);
                    break;
                }
                current = current.getRight(); //next node
            }
        }
    }

    /**
     * Method search
     * @param id
     * @returns Node
     * Retrieves the node using the ID as .  In a binary tree this position indicates the lowest value.
     * RC O(log n)
     **/
    public Node search(int id){

        Node current = Root;

        while(true){
            if(id < current.getID()){  //if ID value is lower than the one saved in the current node
                if(current.getLeft() == null) {
                    break;
                }
                current = current.getLeft();

            }else if(id > current.getID()){  //if ID value is higher than the one saved in the current node
                if(current.getRight() == null) {
                    break;
                }
                current = current.getRight();
            }else if(id == current.getID()){  //if the id corresponds with that of the node
                return current;
            }
        }
        return null;
    }

    /**
     * Method totalCountries
     * @param
     * @returns Node
     * This is a public method created to be called outside the BinaryTreeClass without having to send a node as parameter
     * RC O(1)
     **/
    public int totalCountries(){  //method overload, to call it from outside, since my nodes are private

        return totalCountries(Root);

    }

    /**
     * Method totalCountries
     * @param root
     * @returns
     * This private method is traversing recursively the tree.  The base case are the leaf nodes. Once found, the variable countries
     * is increased one unit everytime left or right is visited.  Runtime complexity is o(n) because visits each node once.
     * RC O(n)
     **/
    private int totalCountries(Node root){  //recursive method, should be private, it can only be accessed from this class.
        if(root == null)
            return 0;
        int countries = 1;
        countries += totalCountries(root.getLeft());
        countries += totalCountries(root.getRight());
        return countries;
    }
}
