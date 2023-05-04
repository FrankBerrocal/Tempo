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


import android.widget.Button;

import java.util.LinkedList;

/**
 * PlayRecord
 * This class implements an object containing a button, two booleans.
 * This element is saved in a LinkedList, setters and getters are defined.
 */
public class PlayRecord {
    LinkedList<Node2> vector= new LinkedList<>();

    public PlayRecord(){

    }

    public void addNode(String button, boolean player1, boolean player2){
        vector.add(new Node2(button, player1, player2));
    }

    public String getButtonName(int index){
        return vector.get(index).getButtonName();
    }

    public boolean getPlayer1Track(int index){
        return vector.get(index).getPlayer1Track();
    }

    public boolean getPlayer2Track(int index){
        return vector.get(index).getPlayer2Track();
    }

    public void setPlayer1Track(int index, boolean player1){
        vector.get(index).setPlayer1Track(player1);
    }

    public void setPlayer2Track(int index, boolean player2){
        vector.get(index).setPlayer2Track(player2);
    }

    public int getIndex(String button){
        for (int i = 0; i < vector.size(); i++) {
            if(button.equals(vector.get(i).getButtonName())){
                return i; // return the index of the node with matching button name
            }
        }
        return -1; // return -1 if the button name is not found
    }

}

