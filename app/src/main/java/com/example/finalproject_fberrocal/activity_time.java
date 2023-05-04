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
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class activity_time extends AppCompatActivity {
    Spinner input_timezone;
    TextView time_display;
    String url = "https://www.timeapi.io/api/TimeZone/zone?timeZone=";

    /**
     * onCreate
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *  Retrieves views required from layout.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        time_display = findViewById(R.id.time_display);
        input_timezone = findViewById(R.id.input_timezone);


    }

    /**
     * showTime
     * @param view
     * Connection to TimeAPI.  Inforamtion is retrieved from EditText element, a request is made using the URI created, if
     * a response is received, the information is saved in a JSONObject, the information if processed into format using
     * a SimpleDateFormat template, then saved as date.  The process is repeated with individual templates for Date and Time
     * so both elements, from a same source, can be displayed individually.
     */
    public void showTime(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        String temporal_url = "";
        String timezone = (String) input_timezone.getSelectedItem();

        if (input_timezone.equals("")) {
            time_display.setText("Please select timezone!");
        } else {
            temporal_url = url + timezone;
        }
        System.out.println(temporal_url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, temporal_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response", response);
                String output = "";
                try {
                    //create a JSON object using the string received from the API
                    JSONObject jsonResponse = new JSONObject(response);
                    System.out.println(jsonResponse);


                    //capture the element currentLocalTime from API
                    String currentLocalDateTimeStr = jsonResponse.getString("currentLocalTime");

                    //retrieve the original format and applies with to object captured from JSON
                    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS");
                    Date currentLocalDateTime = dateTimeFormat.parse(currentLocalDateTimeStr);

                    //then I used the formatted object and apply my own format.
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedCurrentLocalDate = dateFormat.format(currentLocalDateTime);

                    //then I used the formatted object and apply my own format.
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                    String formattedCurrentLocalTime = timeFormat.format(currentLocalDateTime);

                    //create an output link concatenating all variables.
                    output += "Current Date: \n"
                            + formattedCurrentLocalDate+"\n\n"
                            +"Time :\n"
                            + formattedCurrentLocalTime  ;
                    time_display.setText(output);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
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

/**
 * References
 *
 * Oracle.  (n.d.). SimpleDateFormat.format(Date date).  Oracle.  Retrieved on April 9th, 2023, from https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/SimpleDateFormat.html#format(java.util.Date)
 *
 * Oracle.  (n.d.). SimpleDateFormat(String pattern).  Oracle.  Retrieved on April 9th, 2023, from https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/SimpleDateFormat.html#%3Cinit%3E(java.lang.String)
 *
 * Oracle.  (n.d.). SimpleDateFormat.parse(String source).  Oracle.  Retrieved on April 9th, 2023, from https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/SimpleDateFormat.html#parse(java.lang.String)
 */