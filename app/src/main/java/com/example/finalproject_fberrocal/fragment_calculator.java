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

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_calculator#newInstance} factory method to
 * create an instance of this fragment.
 * this fragment was not renamed, and its used to diplay a Tic Tac Toe game.
 */
public class fragment_calculator extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //definition of all local button elements for association with layout elements
    private Button button_0_0, button_0_1, button_0_2,
            button_1_0, button_1_1, button_1_2,
            button_2_0, button_2_1, button_2_2, button_play;

    //instancing of boolean flags for validation of winning plays.
    private boolean button_0_0_checked, button_0_1_checked, button_0_2_checked,
            button_1_0_checked, button_1_1_checked, button_1_2_checked,
            button_2_0_checked, button_2_1_checked, button_2_2_checked = false;

    //this is the data structure where I am keeping record of buttons and movements.
    PlayRecord record = new PlayRecord();
    private TextView playerOnTurn;
    private TextView scoreTracker;

    //additional variables for player identification, and score keeping.
    private String p1 = "Player 1";
    private String p2 = "Player 2";
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private int playCounter = 1;
    private int roundCounter = 1;

    public fragment_calculator() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_calculator.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_calculator newInstance(String param1, String param2) {
        fragment_calculator fragment = new fragment_calculator();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * onCreate
     * @param savedInstanceState If the fragment is being re-created from
     * a previous saved state, this is the state.
     * Captures the elements from the layout and associate them with the views in this class.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * onCreateView
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return view
     *
     * This is the main difference between the Activities and Fragments.  On an activity,
     * the onCreate method is used to associate layout and class methods, in a fragment, on the
     * onCreateView method, an instance of the layout is created using View, working as the anchor point
     * to the local elements.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

//Association of layout elements with activity elements
        button_play = view.findViewById(R.id.button_play);
        playerOnTurn = view.findViewById(R.id.textPlayer);
        scoreTracker = view.findViewById(R.id.textScoreTracker);

        //row 0
        button_0_0 = view.findViewById(R.id.button_0_0);
        button_0_1 = view.findViewById(R.id.button_0_1);
        button_0_2 = view.findViewById(R.id.button_0_2);

        //row 1
        button_1_0 = view.findViewById(R.id.button_1_0);
        button_1_1 = view.findViewById(R.id.button_1_1);
        button_1_2 = view.findViewById(R.id.button_1_2);

        //row 2
        button_2_0 = view.findViewById(R.id.button_2_0);
        button_2_1 = view.findViewById(R.id.button_2_1);
        button_2_2 = view.findViewById(R.id.button_2_2);


        //instance of PlayRecord to keep track of buttons and movements
        createPlayRecord();

        //Implementation of callback (because is listening to itself), and its method onClick, this changes the boolean and send to validation
        //each click will set the validation flag to true, the button will be sent to colorization and the winning validation will be made

        //row 0
        button_0_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_0_0_checked = true;
                playMove(button_0_0);
            }
        });

        button_0_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_0_1_checked = true;
                playMove(button_0_1);
            }
        });

        button_0_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_0_2_checked = true;
                playMove(button_0_2);
            }
        });

        //row 1
        button_1_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_1_0_checked = true;
                playMove(button_1_0);
            }
        });

        button_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_1_1_checked = true;
                playMove(button_1_1);
            }
        });

        button_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_1_2_checked = true;
                playMove(button_1_2);
            }
        });


        //row 2
        button_2_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_2_0_checked = true;
                playMove(button_2_0);
            }
        });

        button_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_2_1_checked = true;
                playMove(button_2_1);
            }
        });

        button_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_2_2_checked = true;
                playMove(button_2_2);
            }
        });

        button_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_play.setBackgroundColor(Color.WHITE);
                button_play.setEnabled(false);
                restartGame();
            }
        });




        return view;
    }

    /**
     * createPlayRecord
     * Record is PlayRecord object create using a Map, capturing an view button object, and booleans for validation.
     */
    private void createPlayRecord(){
        record.addNode("button_0_0", false, false);
        record.addNode("button_0_1", false, false);
        record.addNode("button_0_2", false, false);
        record.addNode("button_1_0", false, false);
        record.addNode("button_1_1", false, false);
        record.addNode("button_1_2", false, false);
        record.addNode("button_2_0", false, false);
        record.addNode("button_2_1", false, false);
        record.addNode("button_2_2", false, false);
    }

    /**
     * displayToast
     * @param message
     * Use to display messages to users.
     */
    private void displayToast(String message) { //O(1)
        Toast.makeText(requireContext(), message,
                Toast.LENGTH_LONG).show();
    }

    /**
     * playMove
     * @param button
     * A counter is used to validate if the turn is odd or even, this will activate the processing of the buttons pressed
     * Logic markers are flagged to signal which buttons have been used.
     */
    private void playMove(@NonNull Button button){ //O(1)

        String buttonName = getResources().getResourceEntryName(button.getId()); //String tag of the layout object button send to this method.

        System.out.println(playCounter + " counter en PlayMove");

        //by tracking modulus of roundCounter, I allow player 2 to start on even rounds.
        if(roundCounter%2!=0){
            //when playerCounter is odd, button is yellow, if even is blue.
            if(playCounter%2==0){
                playerOnTurn.setText(p2); //display the name of player in turn
                buttonYellowProcessing(button); //process the button as blue
                record.setPlayer2Track(record.getIndex(buttonName), true);  //flags the logic marker as true if the button belongs to player 1
            }else{
                playerOnTurn.setText(p1); //display the name of player in turn
                buttonBlueProcessing(button); //process the button as yellow
                record.setPlayer1Track(record.getIndex(buttonName), true); //flags the logic marker as true if the button belongs to player 2
            }

        }else {
            //when playerCounter is odd, button is yellow, if even is blue.
            if(playCounter%2==0){
                playerOnTurn.setText(p1); //display the name of player in turn
                buttonBlueProcessing(button); //process the button as blue
                record.setPlayer1Track(record.getIndex(buttonName), true);  //flags the logic marker as true if the button belongs to player 1
            }else{
                playerOnTurn.setText(p2); //display the name of player in turn
                buttonYellowProcessing(button); //process the button as yellow
                record.setPlayer2Track(record.getIndex(buttonName), true); //flags the logic marker as true if the button belongs to player 2
            }
        }

        System.out.println(record.getButtonName(record.getIndex(buttonName)) +" "+ record.getPlayer1Track(record.getIndex(buttonName)) + " "+ record.getPlayer2Track(record.getIndex(buttonName)));
        validatePlay();

    }

    /**
     * validatePlay
     * using the logic markers, all buttons processed and marked are observe to trigger the wonProcessing method.
     */
    private void validatePlay() {  //O(1)


        if(button_0_0_checked == true
                && button_0_1_checked == true
                && button_0_2_checked == true
                && button_1_0_checked == true
                && button_1_1_checked == true
                && button_1_2_checked == true
                && button_2_0_checked == true
                && button_2_1_checked == true
                && button_2_2_checked == true){
            restartGame();

        }

        //winning by horizontal rows, evaluation of player 1
        if(button_0_0_checked == true
                && button_0_1_checked == true
                && button_0_2_checked == true
                && record.getPlayer1Track(record.getIndex("button_0_0")) == true
                && record.getPlayer1Track(record.getIndex("button_0_1")) == true
                && record.getPlayer1Track(record.getIndex("button_0_2")) == true ){
            wonProcessing(p1);

        }else if(button_1_0_checked == true
                && button_1_1_checked == true
                && button_1_2_checked == true
                && record.getPlayer1Track(record.getIndex("button_1_0")) == true
                && record.getPlayer1Track(record.getIndex("button_1_1")) == true
                && record.getPlayer1Track(record.getIndex("button_1_2")) == true ){
            wonProcessing(p1);

        }else if(button_2_0_checked == true
                && button_2_1_checked == true
                && button_2_2_checked == true
                && record.getPlayer1Track(record.getIndex("button_2_0")) == true
                && record.getPlayer1Track(record.getIndex("button_2_1")) == true
                && record.getPlayer1Track(record.getIndex("button_2_2")) == true ){
            wonProcessing(p1);

        }

        //winning by vertical rows
        else if(button_0_0_checked == true
                && button_1_0_checked == true
                && button_2_0_checked == true
                && record.getPlayer1Track(record.getIndex("button_0_0")) == true
                && record.getPlayer1Track(record.getIndex("button_1_0")) == true
                && record.getPlayer1Track(record.getIndex("button_2_0")) == true){
            wonProcessing(p1);


        }else if(button_0_1_checked == true
                && button_1_1_checked == true
                && button_2_1_checked == true
                && record.getPlayer1Track(record.getIndex("button_0_1")) == true
                && record.getPlayer1Track(record.getIndex("button_1_1")) == true
                && record.getPlayer1Track(record.getIndex("button_2_1")) == true){
            wonProcessing(p1);


        }else if(button_0_2_checked == true
                && button_1_2_checked == true
                && button_2_2_checked == true
                && record.getPlayer1Track(record.getIndex("button_0_2")) == true
                && record.getPlayer1Track(record.getIndex("button_1_2")) == true
                && record.getPlayer1Track(record.getIndex("button_2_2")) == true){
            wonProcessing(p1);

        }

        //winning by diagonals
        else if(button_0_0_checked == true
                && button_1_1_checked == true
                && button_2_2_checked == true
                && record.getPlayer1Track(record.getIndex("button_0_0")) == true
                && record.getPlayer1Track(record.getIndex("button_1_1")) == true
                && record.getPlayer1Track(record.getIndex("button_2_2")) == true){
            wonProcessing(p1);


        }else if(button_0_2_checked == true
                && button_1_1_checked == true
                && button_2_0_checked == true
                && record.getPlayer1Track(record.getIndex("button_0_2")) == true
                && record.getPlayer1Track(record.getIndex("button_1_1")) == true
                && record.getPlayer1Track(record.getIndex("button_2_0")) == true){
            wonProcessing(p1);


        } else //winning by horizontal rows, evaluation of player 2
            if(button_0_0_checked == true
                    && button_0_1_checked == true
                    && button_0_2_checked == true
                    && record.getPlayer2Track(record.getIndex("button_0_0")) == true
                    && record.getPlayer2Track(record.getIndex("button_0_1")) == true
                    && record.getPlayer2Track(record.getIndex("button_0_2")) == true ){
                wonProcessing(p2);


            }else if(button_1_0_checked == true
                    && button_1_1_checked == true
                    && button_1_2_checked == true
                    && record.getPlayer2Track(record.getIndex("button_1_0")) == true
                    && record.getPlayer2Track(record.getIndex("button_1_1")) == true
                    && record.getPlayer2Track(record.getIndex("button_1_2")) == true ){
                wonProcessing(p2);


            }else if(button_2_0_checked == true
                    && button_2_1_checked == true
                    && button_2_2_checked == true
                    && record.getPlayer2Track(record.getIndex("button_2_0")) == true
                    && record.getPlayer2Track(record.getIndex("button_2_1")) == true
                    && record.getPlayer2Track(record.getIndex("button_2_2")) == true ){
                wonProcessing(p2);

            }

            //winning by vertical rows
            else if(button_0_0_checked == true
                    && button_1_0_checked == true
                    && button_2_0_checked == true
                    && record.getPlayer2Track(record.getIndex("button_0_0")) == true
                    && record.getPlayer2Track(record.getIndex("button_1_0")) == true
                    && record.getPlayer2Track(record.getIndex("button_2_0")) == true){
                wonProcessing(p2);

            }else if(button_0_1_checked == true
                    && button_1_1_checked == true
                    && button_2_1_checked == true
                    && record.getPlayer2Track(record.getIndex("button_0_1")) == true
                    && record.getPlayer2Track(record.getIndex("button_1_1")) == true
                    && record.getPlayer2Track(record.getIndex("button_2_1")) == true){
                wonProcessing(p2);

            }else if(button_0_2_checked == true
                    && button_1_2_checked == true
                    && button_2_2_checked == true
                    && record.getPlayer2Track(record.getIndex("button_0_2")) == true
                    && record.getPlayer2Track(record.getIndex("button_1_2")) == true
                    && record.getPlayer2Track(record.getIndex("button_2_2")) == true){
                wonProcessing(p2);


            }

            //winning by diagonals
            else if(button_0_0_checked == true
                    && button_1_1_checked == true
                    && button_2_2_checked == true
                    && record.getPlayer2Track(record.getIndex("button_0_0")) == true
                    && record.getPlayer2Track(record.getIndex("button_1_1")) == true
                    && record.getPlayer2Track(record.getIndex("button_2_2")) == true){
                wonProcessing(p2);


            }else if(button_0_2_checked == true
                    && button_1_1_checked == true
                    && button_2_0_checked == true
                    && record.getPlayer2Track(record.getIndex("button_0_2")) == true
                    && record.getPlayer2Track(record.getIndex("button_1_1")) == true
                    && record.getPlayer2Track(record.getIndex("button_2_0")) == true){
                wonProcessing(p2);


            }

    }

    /**
     * disableButtons.
     * when called, all buttons are disable so players cannot keep pressing them.
     */
    private void disableButtons(){
        button_0_0.setEnabled(false);
        button_0_1.setEnabled(false);
        button_0_2.setEnabled(false);
        button_1_0.setEnabled(false);
        button_1_1.setEnabled(false);
        button_1_2.setEnabled(false);
        button_2_0.setEnabled(false);
        button_2_1.setEnabled(false);
        button_2_2.setEnabled(false);
        button_play.setEnabled(true);
        button_play.setBackgroundColor(Color.GREEN);
    }

    /**
     * restartGame
     * buttons are sent to resetButton method, also, other methods are invoked and variables reset.
     */
    private void restartGame(){
        roundCounter++;
        resetButton(button_0_0);
        resetButton(button_0_1);
        resetButton(button_0_2);
        resetButton(button_1_0);
        resetButton(button_1_1);
        resetButton(button_1_2);
        resetButton(button_2_0);
        resetButton(button_2_1);
        resetButton(button_2_2);
        playCounter = 1;
        resetChecks();
        playerOnTurn.setText("Round "+ roundCounter);
    }

    /**
     * resetButton
     * @param button
     * Button is enabled, drawables are erased, and the background color is taken back to initial state.
     */
    private void resetButton(@NonNull Button button){
        button.setEnabled(true);
        button.setCompoundDrawables(null, null, null, null);
        button.setBackgroundColor(Color.rgb(255, 136, 0));
        displayToast("New Round!");
        if(roundCounter%2==0){
            displayToast(p2+ " its your turn!");
        }else{
            displayToast(p1+ " its your turn!");
        }
        playCounter = 1;
    }

    /**
     * resetChecks
     * All logical markers are set to false.
     */
    private void resetChecks(){  //O(1)
        button_0_0_checked = false;
        button_0_1_checked = false;
        button_0_2_checked = false;
        button_1_0_checked = false;
        button_1_1_checked = false;
        button_1_2_checked = false;
        button_2_0_checked = false;
        button_2_1_checked = false;
        button_2_2_checked = false;
        record.setPlayer1Track(record.getIndex("button_0_0"), false);
        record.setPlayer1Track(record.getIndex("button_0_1"), false);
        record.setPlayer1Track(record.getIndex("button_0_2"), false);
        record.setPlayer1Track(record.getIndex("button_1_0"), false);
        record.setPlayer1Track(record.getIndex("button_1_1"), false);
        record.setPlayer1Track(record.getIndex("button_1_2"), false);
        record.setPlayer1Track(record.getIndex("button_2_0"), false);
        record.setPlayer1Track(record.getIndex("button_2_1"), false);
        record.setPlayer1Track(record.getIndex("button_2_2"), false);
        record.setPlayer2Track(record.getIndex("button_0_0"), false);
        record.setPlayer2Track(record.getIndex("button_0_1"), false);
        record.setPlayer2Track(record.getIndex("button_0_2"), false);
        record.setPlayer2Track(record.getIndex("button_1_0"), false);
        record.setPlayer2Track(record.getIndex("button_1_1"), false);
        record.setPlayer2Track(record.getIndex("button_1_2"), false);
        record.setPlayer2Track(record.getIndex("button_2_0"), false);
        record.setPlayer2Track(record.getIndex("button_2_1"), false);
        record.setPlayer2Track(record.getIndex("button_2_2"), false);
    }

    /**
     * buttonBlueProcessing
     * @param button
     * Color is set to blue (this is not working in the fragment).
     * icon is displayed, and padding adapted for better presentation of the icon.  Button is disabled.
     * playerCounter is increased.
     */
    private void buttonBlueProcessing(@NonNull Button button){
        button.setBackgroundColor(Color.BLUE);
        button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.moon_icon, 0, 0, 0);
        button.setPadding(90, 0,0,0);
        button.setEnabled(false);  //buttons cannot be pressed
        //color change is not working in fragment.  minor detail.
        playCounter++;
    }
    /**
     * buttonYellowProcessing
     * @param button
     * Color is set to yellow (this is not working in the fragment).
     * icon is displayed, and padding adapted for better presentation of the icon.  Button is disabled.
     * playerCounter is increased.
     */
    private void buttonYellowProcessing(@NonNull Button button){
        button.setBackgroundColor(Color.YELLOW);
        button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.sun_icon, 0, 0, 0);
        button.setPadding(90, 0,0,0);
        button.setEnabled(false);
        playCounter++;
    }

    /**
     * wonProcessing.
     * @param p
     * notification of winning player.
     */
    private void wonProcessing(String p){
        displayToast("Round won by " + p +"!");
        //assignment of points to winner based on the string send on validatePlay()
        if(p.equals("Player 1")){
            scorePlayer1++;
        }else{
            scorePlayer2++;
        }
        scoreTracker.setText(scorePlayer1 +"-"+scorePlayer2);
        System.out.println("Player 1:" + scorePlayer1);
        System.out.println("Player 2:" + scorePlayer2);
        disableButtons();

    }

}

/**
 * References

https://developer.android.com/reference/android/widget/TextView#setCompoundDrawablesWithIntrinsicBounds(int,%20int,%20int,%20int)
https://developer.android.com/guide/topics/ui/notifiers/toasts
https://developer.android.com/reference/android/widget/Button
https://developer.android.com/reference/android/content/res/Resources.html#getResourceEntryName(int)


Considerations

The multiple methods in my code are O(1), constants.
I did not want to include any loops for two reasons:
1.  I want to provide the fastest runtime complexity, this allows to select the elements and receive a fast response.
2.  I want to provide a different algorithm knowing that loops will be the most used solution in the internet, along with Scanner.
3.  I want to implement part of the data structure I created for my class of Data Structures, Prof.  Sohaib Bajwa will recognize it.
4.  I want to force my complicated capacity of analysis to provide something complicated but from a simplified point of view.

*/

