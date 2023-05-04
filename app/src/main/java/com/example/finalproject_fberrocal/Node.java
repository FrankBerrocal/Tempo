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


public class Node {

    private Node Left;
    private Node Right;
    private String CountryName;
    private String CountryFile;
    private Boolean CountryAnswer;
    int ID;

    /**
     * Node()
     *
     * @param
     * @return
     * Default class constructor
     * RC O(1)
     */
    public Node(){
        CountryName = null;
        CountryFile = null;
        ID = 0;
        CountryAnswer = null;
    }


    /**
     * Constructor Node
     *
     * @param countryName
     * @param countryFile
     * @param id
     * @returns
     * constructor
     * Description initialize a new tree node.
     * RC O(1)
     **/
    public Node(String countryName, String countryFile, int id, Boolean countryAnswer){
        CountryName = countryName;
        CountryFile = countryFile;
        ID = id;
        CountryAnswer = countryAnswer;
    }

    /**
     * Method ToString
     *
     * @param
     * @returns String
     * ToString
     * Overrides toString method to display contents of node.
     * RC O(1)
     **/
    @Override
    public String toString(){
        return  "Country Info: " + getID() +
                ",\n" + getCountryName() +
                ",\n" + getCountryFile();

    }



    /**Left****************************************************************/

    /**
     * public setLeft
     *
     * @param node
     * @return
     * set method
     * creates a reference to Left node.
     * RC O(1)
     */

    public void setLeft(Node node){ Left = node; }

    /**
     * public getLeft
     *
     * @param
     * @return Node
     * get method
     * Returns node Left object.
     * RC O(1)
     */
    public Node getLeft(){ return Left;}

    /**Right****************************************************************/
    /**
     * public setRight
     *
     * @param node
     * @return
     * set method
     * creates a reference to Right node.
     * RC O(1)
     */
    public void setRight(Node node){ Right = node; }

    /**
     * public getRight
     *
     * @param
     * @return Node
     * get method
     * Returns node Right object.
     * RC O(1)
     */
    public Node getRight(){ return Right;}

    /**FirstName****************************************************************/
    /**
     * public setCountryName
     *
     * @param countryName
     * @return
     * set method
     * sets the value of variable CountryName
     * RC O(1)
     */

    public void setCountryName(String countryName){ CountryName = countryName; }

    /**
     * public getCountryName
     *
     * @param
     * @return CountryName
     * get method
     * Returns string object.
     * RC O(1)
     */
    public String getCountryName(){ return CountryName;}

    /**LastName****************************************************************/
    /**
     * public setCountryFile
     *
     * @param countryFile
     * @return none
     * set method
     * sets the value of variable LastName
     * RC O(1)
     */

    public void setCountryFile(String countryFile){ CountryFile = countryFile; }

    /**
     * public getCountryFile
     *
     * @param
     * @return LastName
     * get method
     * Returns string object.
     * RC O(1)
     */
    public String getCountryFile(){ return CountryFile;}



    /**ID****************************************************************/
    /**
     * public setID
     *
     * @param id
     * @return
     * set method
     * sets the value of variable ID
     * RC O(1)
     */

    public void setID(int id){ ID = id; }

    /**
     * public getID
     *
     * @param
     * @return int
     * get method
     * Returns int object.
     * RC O(1)
     */
    public int getID(){ return ID;}


    /**Answer****************************************************************/
    /**
     * public setAnswer
     *
     * @param countryAnswer
     * @return
     * set method
     * sets the value of variable Answer
     * RC O(1)
     */

    public void setCountryAnswer(Boolean countryAnswer){ CountryAnswer = countryAnswer; }

    /**
     * public getAnswer
     *
     * @param
     * @return Answer
     * get method
     * Returns Boolean object.
     * RC O(1)
     */
    public Boolean getCountryAnswer(){ return CountryAnswer;}

}