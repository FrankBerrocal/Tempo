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

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.DecimalFormat;

public class activity_weather extends AppCompatActivity {

    EditText input_city;
    Spinner input_country;
    TextView weather_display;
    private final String url ="https://api.openweathermap.org/data/2.5/weather";
    private final String api_id = "7b00ead376fe3fae0d5f38cba0ebb08f";
    DecimalFormat df = new DecimalFormat( "#.##");

    /**
     * onCreate
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     * get the elements from Layout into this class.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        input_city = findViewById(R.id.input_city);
        input_country = findViewById(R.id.input_country);
        weather_display = findViewById(R.id.weather_display);
    }

    /**
     * showWeather
     * @param view
     * Capture the data from city and country.  Country is retrieving the first two characters refering to the ISO 2-digit code
     * assinged to each country.   The information is used to create an URI used for the API request.
     * if a response is obtained, all data is saved in a JSON object, temp, senstation and humidity are saved tna then displayed,
     * along with the country name, this information is sent to a TextView.
     */
    public void showWeather(View view) {
        //hide the keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);


        String temporal_url ="";
        String city = input_city.getText().toString().trim();
        String country = ((String) input_country.getSelectedItem()).substring(0,2);
        System.out.println(country);

        if(city.equals("")){
            weather_display.setText("Please enter City!");
        }else{
            if(!country.equals("")){
                temporal_url = url + "?q=" + city + "," + country + "&appid=" + api_id;
            }else{
                temporal_url = url + "?q=" + city + "," + "&appid=" + api_id;
            }
            StringRequest stringRequest = new StringRequest(Request.Method.POST, temporal_url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("response", response);
                    String output = "";
                    try {
                        //create a JSON object using the string received from the API
                        JSONObject jsonResponse = new JSONObject(response);

                        JSONObject jsonObjectMain = jsonResponse.getJSONObject("main"); //get all elements from param main
                        //extract the variables from the main param
                        double temp = jsonObjectMain.getDouble("temp") - 273.15;  //all temperature in Kelvin, subtract to convert to Celsius
                        double feelslike = jsonObjectMain.getDouble("feels_like") - 273.15;
                        int humidity = jsonObjectMain.getInt("humidity");  //percentage

                        JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");  //names in json
                        String countryName = jsonObjectSys.getString("country");

                        //create an output link concatenating all variables.
                        output += "Current weather in: \n"
                                + city +  " (" + countryName + ")"
                                + "\nTemperature: " + df.format(temp) + " °C"  // ASCII Alt + 0176 for degrees
                                + "\nFeels like : " + df.format(feelslike) + " °C"
                                + "\nHumidity: " + humidity + "%";
                        weather_display.setText(output);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }

}

/**
 * References
 *
 * InputMethodManager: https://developer.android.com/reference/android/view/inputmethod/InputMethodManager.html
 * hideSoftInputFromWindow method: https://developer.android.com/reference/android/view/inputmethod/InputMethodManager.html#hideSoftInputFromWindow(android.os.IBinder,%20int)
 * Managing the Keyboard: https://developer.android.com/training/keyboard-input/index.html
 */