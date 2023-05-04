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


import java.util.LinkedList;

/**
 * Node2 object
 * Creates an object saving information about button, and booleans.
 * Getters and setters are defined.
 */
public class Node2 {
    private String Button;
    private boolean Player1;
    private boolean Player2;

    LinkedList node = new LinkedList();

    public Node2(String button, boolean player1, boolean player2){
        this.Button = button;
        this.Player1 = player1;
        this.Player2 =  player2;

        node.add(Button);
        node.add(Player1);
        node.add(Player2);
    }

    public String getButtonName(){
        return Button;
    }

    public boolean getPlayer1Track(){
        return (boolean) node.get(1);
    }

    public boolean getPlayer2Track(){
        return (boolean) node.get(2);
    }

    public void setPlayer1Track(boolean player1){
        node.set(1, player1);
    }

    public void setPlayer2Track(boolean player2){
        node.set(2, player2);
    }



}