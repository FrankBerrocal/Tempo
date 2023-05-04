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

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;


public class activity_radio extends AppCompatActivity {

    EditText input_search;
    TextView text_station;

    private final String url ="https://mytuner-radio.com/search/?q=";

    /**
     * onCreate
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *  captures the layout views into local views.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        input_search = findViewById(R.id.input_search);
        text_station = findViewById(R.id.text_station);


    }

    /**
     * showRadio
     * @param view
     * capture the search input information and send it to the web interface of TuneIn webapp.
     */
    public void showRadio(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        String finalURL = "";
        String station = input_search.getText().toString();
        if (station.equals("")) {
            input_search.setText("Please enter subject!");
        } else {
            finalURL = url + "?q=" + station;
            System.out.println(finalURL);

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(finalURL));
            startActivity(intent);
        }


    }
}