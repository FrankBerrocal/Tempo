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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class activity_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * onCreateOptionsMenu
     * @param menu The options menu in which you place your items.
     * brings the menu layout to the Main Activity.
     * @return
     * This method attaches the menu to the MainActivity.
     * RC O(1)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * showRadio
     * @param view
     * Initialize an intent to display activity_radio.
     */
    public void showRadio(View view) {
        Intent intent = new Intent(this, activity_radio.class);
        startActivity(intent);
    }

    /**
     * showWeather
     * @param view
     * Initialize an intent to display activity_weather.
     */
    public void showWeather(View view) {
        Intent intent = new Intent(this, activity_weather.class);
        startActivity(intent);
    }

    /**
     * showNews
     * @param view
     * Initialize an intent to display activity_news.
     */
    public void showNews(View view) {
        Intent intent = new Intent(this, activity_news.class);
        startActivity(intent);
    }

    /**
     * showTime
     * @param view
     * Initialize an intent to display activity_time.
     */
    public void showTime(View view) {
        Intent intent = new Intent(this, activity_time.class);
        startActivity(intent);
    }

    /**
     * showGame
     * @param view
     * Initialize an intent to display activity_game.
     */
    public void showGame(View view) {
        Intent intent = new Intent(this, activity_flagsmart.class);
        startActivity(intent);
    }

    /**
     * showSupport
     * @param view
     * Initialize an intent to display activity_support.
     */
    public void showSupport(View view) {
        Intent intent = new Intent(this, activity_support.class);
        startActivity(intent);
    }


    /**
     * onOptionsItemSelected()
     *
     * @param item The menu item that was selected.
     * @return
     * Listens to all item elements in the menu and selected the element clicked.
     * Then an intent is used to call the associated activity.
     * RC O(1)
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mi_help:
                Intent intentHelp = new Intent(this, activity_help.class);
                int requestCodeHelp = 1;
                startActivityForResult(intentHelp, requestCodeHelp);
                return true;
            case R.id.mi_about:
                Intent intent = new Intent(this, activity_about.class);
                int requestCodeAbout = 1;
                startActivityForResult(intent, requestCodeAbout);
                return true;
            case R.id.mi_info:
                Intent intentInfo = new Intent(this, activity_info.class);
                int requestCodeInfo = 1;
                startActivityForResult(intentInfo, requestCodeInfo);
                return true;
        }
        return true;
    }
}