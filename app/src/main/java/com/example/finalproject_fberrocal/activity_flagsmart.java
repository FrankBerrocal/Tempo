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

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class activity_flagsmart extends AppCompatActivity {

    //interface variables
    private Button Country1;
    private Button Country2;
    private Button Country3;
    private Button Country4;
    private Button Next;
    private Button CorrectOption;
    private ImageView Flag;
    private TextView ScoreTracker;

    //processing variables
    private Tree Game = new Tree();
    private Map<Integer, Integer> CountryMap = new HashMap<>();  //key - value pair
    private Random randomTreeIndex = new Random();  //index randomly selected.
    private Random randomButtonIndex = new Random();  //button randomly selected.
    private Map<Integer, Node> CountryInformation = new HashMap<>();
    private Button[] buttons = new Button[4];
    private boolean Flagged;
    private int Score = 0;
    private Integer SelectedButton;
    private Boolean[] buttons_val = new Boolean[4];
    public static final String EXTRA_SCORE = "com.example.assignment2_fberrocal.extra.SCORE";


    /**
     * onCreate()
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     * @return
     * Initialization of elements, association of UI elements with programmatic elements.
     * RC O(1)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flagsmart);

        Country1 = findViewById(R.id.buttonCountry1);
        Country2 = findViewById(R.id.buttonCountry2);
        Country3 = findViewById(R.id.buttonCountry3);
        Country4 = findViewById(R.id.buttonCountry4);
        Next = findViewById(R.id.buttonNext);
        Flag = findViewById(R.id.mainFlag);
        ScoreTracker = findViewById(R.id.scoreTracker);

        setButtonArray();
        setBooleanArray();

        /**
         * processing invoke brings all the initial data to the buttons and image view.
         */
        try {
            processing();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        /**
         * Set up listeners for all buttons, if clicked, set boolean to true, send for validation.
         */
        Country1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons_val[0] = true;
                validation(buttons_val[0], 0);
            }
        });

        Country2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons_val[1] = true;
                validation(buttons_val[1], 1);
            }
        });

        Country3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons_val[2] = true;
                validation(buttons_val[2],2);
            }
        });

        Country4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons_val[3] = true;
                validation(buttons_val[3], 3);
            }
        });

        /**
         * onClick() => Next.
         *
         * Conditional is invoking the method clickedButtons(), this validates the Boolean array to
         * check if any button was clicked.   If one is true, the the intent is called.
         * Then a new intent is created for this same activity, and sending score as Extra, allowing the
         * value to be passed to subsequent instances of the same activity.
         * Then, getNext() is called to prepare all visual elements.
         */
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(clickedButtons()){
                    Intent intent = new Intent(activity_flagsmart.this, activity_flagsmart.class);
                    intent.putExtra(EXTRA_SCORE, Score);
                    startActivity(intent);
                } else {
                    displayToast("Please select any response before continuing");
                }
            }
        });
        //uploads the value of Score from Extra, from the previous instance.
        Score = getIntent().getIntExtra(EXTRA_SCORE, 0);
        ScoreTracker.setText(Score+"");
    }

    /**
     * processing()
     *
     * @throws Exception
     * Sends a map to randomNumbers, create a random number for the button displaying a flag.
     * Activates getCountryInformation and send all required parameters.
     * Activates processButtons and send all required paratmers.
     * This method is used after the new intent is called, to re-paint all the information in the activity.
     * RC:  check every source method.
     */
    private void processing() throws Exception {
        CountryMap = randomNumbers(CountryMap);
        SelectedButton = randomButton();
        getCountryInformation(CountryMap, CountryInformation, SelectedButton, Game);
        processButtons(CountryInformation, Flagged);
    }

    /**
     * randomNumbers()
     *
     * @param
     * @return countryMap
     * Generate 4 random numbers between 1 and 252, and return a Set with those four numbers.
     * Creates an index saved as key, for position-accessing purposes
     * RC O(log n)  (requires to search in the binary tree).
     */
    private Map<Integer, Integer> randomNumbers(Map<Integer, Integer> countryMap) {
        int min = 1;
        int max = 252;
        int index = 0;

        while (countryMap.size() < 4) {
            countryMap.put(index++, randomTreeIndex.nextInt(max - min + 1) + min);
        }
        return countryMap;
    }

    /**
     * randomButton()
     *
     * @param
     * @return flagButton
     * Generate 4 random numbers between 1 and 4.
     * This is used to select which button will hold the right answer.
     * RC O(1)
     */
    private Integer randomButton(){
        Integer flagButton = 0;
        flagButton = randomButtonIndex.nextInt(3 - 0 + 1) + 0;
        return flagButton;
    }

    /**
     * setButtonArray()
     *
     * @param
     * @return
     * During initialization, and after designation of related Ui content, each button is uploaded into a Button array
     * for dynamic manipulation.
     * RC O(1)
     */
    private void setButtonArray(){
        buttons[0] = Country1;
        buttons[1] = Country2;
        buttons[2] = Country3;
        buttons[3] = Country4;
    }

    /**
     * setBooleanArray()
     *
     *  @param
     *  @return
     *  During initialization, and after initialization, each boolean is uploaded into an array
     *  for dynamic manipulation.
     *  RC O(1)
     */
    private void setBooleanArray(){
        buttons_val[0] = false;
        buttons_val[1] = false;
        buttons_val[2] = false;
        buttons_val[3] = false;
    }

    /**
     *getCountryInformation()
     *
     * @param map
     * @param countryInformation
     * @param answer
     * @param game
     * @return countryInformation
     *
     * The parameters for this method are:
     *   a map populated with 4 random values between 1 and 252 (number of countries)
     *   an empty map with an integer key, and a Node value (containing all the country information)
     *   an integer indicating a random value between 1 and 4 (number of buttons)
     *   a tree object that contains information from all countries and territories in the world, and their flags.
     * Running 4 times, the method puts in each space the value of i as key, and the node from the world tree based on the random numbers in Map
     * if the value of i is equal to the number of the random button selected to hold a flag, the boolean flag of the node is set to true.
     * a Map<integer, node> object is returned, containing the value of the 4 selected nodes.
     * RC O(log n)  (requires to search in the binary tree).
     */
    private Map<Integer, Node> getCountryInformation(Map<Integer, Integer> map, Map<Integer, Node> countryInformation, int answer, Tree game){
        for ( Integer i = 0; i < map.size(); i++) {
            countryInformation.put(i,game.getCountryInfo(map.get(i)));  //search for a node and return it, save it in the map.
            if(i == answer)
                countryInformation.get(i).setCountryAnswer(true);  //a node has been chosen to show its flag.
        }
        return countryInformation;
    }

    /**
     * processButtons()
     *
     * @param countryInformation
     * @param flag
     * @throws Exception
     *
     * The Map<integer, node> is iterated, the content of the boolean in the node is saved to a boolean Flagged
     * This boolean is used as conditional element.
     * If the node has its boolean value set to true (established in getCountryInformation()), the name of the flag file
     * is sent to fillFlag method, and the name of the country is sent to fillButton method.
     * Important:  the button with a true boolean is saved in the CorrectOption Button object for later use.
     * If the boolean in the node is set to fase, only the fillButton method is processed.
     * An exception has been included to handle unexpected scenarios.
     * RC O(n)
     */
    private void processButtons(Map<Integer, Node> countryInformation, boolean flag) throws Exception{
        for (Integer i =0; i < CountryInformation.size(); i++){

            Flagged = CountryInformation.get(i).getCountryAnswer();

            if (Flagged) {
                fillFlag(Flag, CountryInformation.get(i).getCountryFile());
                fillButton(buttons[i], CountryInformation.get(i).getCountryName());
                CorrectOption = buttons[i];
            } else if (!(Flagged)) {
                fillButton(buttons[i], CountryInformation.get(i).getCountryName());
            } else {
                throw new Exception ("Non-managed Situation");
            }
        }
    }

    /**
     * validation()
     *
     * @param clicked
     * @param i
     *
     * When clicked, the boolean variable associated with each button is set to true.
     * If the button clicked, which boolean is true, and the boolean in the node are both set to true,
     * then this is the element chosen to display its flag.
     * In the case of true, the displayToast, highlightCorrectOption(), disableButtons, displayScore, and checkScore methods are activated.
     * Also, Score is incremented one unit.
     * In the case of false, displayToast, showCorrectOption, disableButtons, and displayScore methods are invoked.
     * Score is set to 0.
     * RC O(1)
     */
    private void validation(Boolean clicked, Integer i){

        if(clicked == CountryInformation.get(i).getCountryAnswer()) {
            displayToast("Correct =)");
            highlightCorrectOption();
            disableButtons();
            Score++;
            displayScore(Score);
            checkScore();

        }else{
            displayToast("Incorrect =(");
            showCorrectOption();
            disableButtons();
            Score = 0;
            displayScore(Score);

        }
    }

    /**
     * fillFlag()
     *
     * @param flag
     * @param flagName
     * The name of the flag file rerieved from the selected node is used to identify the resource in the drawable folder,
     * then it is assigned to the ImageView flag.
     * RC O(1)
     */
    private void fillFlag(ImageView flag, String flagName){
        int resourceId = getResources().getIdentifier(flagName, "drawable", getPackageName());
        flag.setImageResource(resourceId);
    }

    /**
     * fillButton
     *
     * @param button
     * @param countryName
     *
     * The name of the country as well as the selected button are passed, the name is used to set the text in the button
     * and the font color is set to black.
     * RC O(1)
     */
    private static void fillButton(Button button, String countryName) {
        button.setText(countryName);
        button.setTextColor(Color.BLACK);
    }

    /**
     * disableButtons()
     *
     * @param
     * @return
     *
     * The Button array is iterated and setEnable property is set to false.  Next does not belong to this array.
     * RC O(n)
     */
    private void disableButtons(){
        for (int j = 0; j < buttons.length; j++) {
            buttons[j].setEnabled(false);
        }
    }

    /**
     * greyOutButtons
     *
     * @param
     * @return
     * The Button array is iterated and color of all buttons is set to grey.
     * RC O(n)
     */
    private void greyOutButtons(){
        for (int j = 0; j < buttons.length; j++) {
            buttons[j].setBackgroundColor(Color.GRAY);
        }
    }

    /**
     * highlightCorrectOption()
     *
     * @param
     * @return
     * When this method is called, greyOutButtons() is invoked.
     * The button saved in CorrectOption has its color changed to green, and text color set to black.
     * After these changes, disableButtons() is called.
     * RC refer to each individual method.
     */
    private void highlightCorrectOption(){
        greyOutButtons();
        CorrectOption.setBackgroundColor(Color.GREEN);
        CorrectOption.setTextColor(Color.BLACK);
        disableButtons();
    }

    /**
     * shoCorrectOption()
     *
     * @param
     * @return
     * The method greyOutButtons is called, CorrectOption button background color is set to red, and text color
     * is set to black.  After that, all disableButtons() is invoked.
     * RC refer to each individual method.
     */
    private void showCorrectOption(){
        greyOutButtons();
        CorrectOption.setBackgroundColor(Color.RED);
        CorrectOption.setTextColor(Color.BLACK);
        disableButtons();
    }

    /**
     * checkScore()
     *
     * @param
     * @return
     * When score is equal to 5, displayToast is invoked.
     * Also, a new intent is created conducting toward ThirdActivity. Then the intent is started.
     * RC O(1)
     */
    private void checkScore() {
        if (Score == 5) {
            displayToast("You've Won!!!");
            Intent intent = new Intent(this, activity_won.class);
            startActivity(intent);
        }
    }

    /**
     * displayScore()
     *
     * @param score
     * @return
     * The score is painted in the ScoreTracker TextView.
     * RC O(1)
     */
    private void displayScore(int score){
        ScoreTracker.setText(Score+"");
    }

    /**
     * displayToast()
     *
     * @param message
     * @return
     * A string is received to display in a Toast element, time set to short.
     * RC O(1)
     */
    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    /**
     * getNext()
     *
     * @param
     * @return
     * @throws Exception
     * After receiving a self-intent, the methods resetButtonVal(), enableButtons(), resetImaveView() and processing() are called
     * This allow to reset all validation booleans indicating if a button was clicked, enable all buttons to change their information,
     * reset the image view, and selecting all random elements and populating the ImageView and Buttons again.
     * RC refer to each individual method.
     */
    private void getNext() throws Exception {

        enableButtons();
        resetImageView();
        resetButtonVal();
        processing();
    }

    /**
     * enableButtons()
     *
     * @param
     * @return
     * Button array is iterated and each element is setEnabled == true
     * RC O(n)
     */
    private void enableButtons(){
        for (int j = 0; j < buttons.length; j++) {
            buttons[j].setEnabled(true);
        }
    }

    /**
     * resetButtonVal
     *
     * @param
     * @return
     * Boolean array is iterated and each element is set to false, to indicate none has been clicked.
     * RC O(n)
     */
    private void resetButtonVal(){
        for (int j = 0; j < buttons_val.length; j++) {
            buttons_val[j] =false;
        }
    }

    /**
     * resetImageView()
     *
     * @param
     * @return
     * The ImageView flag is set to transparent to avoid displaying any image during re-population of data.
     * RC O(1)
     */
    private void resetImageView(){
        Flag.setImageResource(android.R.color.transparent);
    }

    /**
     * clickedButtons()
     *
     * @param
     * @return boolean
     * Iterate the boolean array to determine if any button has been clicked.
     * This is to prevent clicking Next if no button has been clicked.
     * RC O(n)
     */
    private Boolean clickedButtons(){
        for (int j = 0; j < buttons_val.length; j++) {
            Log.d("DEBUG", "Button " + j + " value is " + buttons_val[j]);
            if(buttons_val[j] == true)
                return true;
        }
        return false;
    }

}

/**
 * References
 * Flagpedia.  (n.d.).   Country Flags of the World (list of all 254).  Flags of the world.  Retrieved on March 27th, 2023, from https://flagpedia.net/index
 * Google.  (n.d.). Menus and pickers, 4.3.  Android Fundamentals.  Retrieved on March 27th, 2023, from https://developer.android.com/codelabs/android-training-provide-user-navigation#2
 * Google.  (n.d.). User navigation, 4.4.  Android Fundamentals.  Retrieved on March 27th, 2023, from  https://developer.android.com/codelabs/android-training-menus-and-pickers#2
 * PNG ALL. (n.d.) Golden Cup PNG Photo.  PNG All.  Retrieved on March 29th, 2023, from https://www.pngall.com/golden-cup-png/download/34244
 */