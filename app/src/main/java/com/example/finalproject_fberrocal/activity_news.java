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

import static java.security.AccessController.getContext;

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
import android.widget.EditText;
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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class activity_news extends AppCompatActivity {

    EditText input_subject;
    TextView news_display;

    Spinner input_country, input_language;
    private final String url ="https://gnews.io/api/v4/search";
    private final String api_id ="a320f547f1c770a9acebfb3b815d22c5";
    String subject ="";

    String country = "";

    String language = "";


    /**
     * onCreate
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *  creates the associtaion of local UI elements with the ones created in layout.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        input_subject = findViewById(R.id.input_subject);
        input_country = findViewById(R.id.input_country);
        input_language = findViewById(R.id.input_language);
        news_display = findViewById(R.id.news_display);

    }

    /**
     * showNews
     * @param view
     * captures the information from the Layout elements, and concatenates the data into a
     * URI required by the API.   if response is obtained the data is downloaded to a JSONObject
     * then a JSONArray, and during the iteration of its components, the title and URL are added to an
     * href element to be displayed in the textView, using a LinkMovement method that calls the browser.
     */
    public void showNews(View view) {
        //hide the keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);


        String temporal_url = "";
        subject = input_subject.getText().toString().trim();
        country = ((String) input_country.getSelectedItem()).substring(0,2);
        language = ((String) input_language.getSelectedItem()).substring(0,2);


        System.out.println(country);
        if (subject.equals("")) {
            news_display.setText("Please enter subject!");
        } else {
            temporal_url = url + "?q=" + subject + "&lang="+language+"&country="+country+"&max=5&apikey=" + api_id;
            System.out.println(temporal_url);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, temporal_url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("response", response);
                    try {
                        //create a JSON object using the string received from the API
                        JSONObject jsonResponse = new JSONObject(response);
                        JSONArray articlesArray = jsonResponse.getJSONArray("articles"); //get the articles array
                        StringBuilder sb = new StringBuilder();
                        //this was added to clear the textview when another query is made.
                        sb.setLength(0);
                        news_display.setText("");


                        //loop through the articles array
                        for (int i = 0; i < articlesArray.length(); i++) {
                            //extract the variables from each article object, in each iteration of the array

                            JSONObject articleObject = articlesArray.getJSONObject(i);
                            String title = articleObject.getString("title");
                            String finalURL = articleObject.getString("url");


                            //this is converting the url to HMTL tags.
                            sb.append("<a href='" + finalURL + "'>" + title + "</a><br><br>");

                            //custom object to associate the title with the URL
                            news_display.setClickable(true);
                            news_display.setPaintFlags(news_display.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                            news_display.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(finalURL));
                                    startActivity(intent);
                                }
                            });
                        }
                        news_display.append(Html.fromHtml(sb.toString()));
                        news_display.setMovementMethod(LinkMovementMethod.getInstance());


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
 *
 Google.  (n.d.).  InputMethodManager. Android Developers. Retrieved April 9th, 2023, from https://developer.android.com/reference/android/view/inputmethod/InputMethodManager

 Google.  (n.d.).  JSONArray.  Android Developers. Retrieved April 9th, 2023, from https://developer.android.com/reference/org/json/JSONArray

 Google.  (n.d.).  JSONObject.  Android Developers. Retrieved April 9th, 2023, from https://developer.android.com/reference/org/json/JSONObject

 Google.  (n.d.).  JSONObject.getJSONArray(). Android Developers. Retrieved April 9th, 2023, from https://developer.android.com/reference/org/json/JSONObject#getJSONArray(java.lang.String)

 Google.  (n.d.).  JSONObject.getString(). Android Developers. Retrieved April 9th, 2023, from https://developer.android.com/reference/org/json/JSONObject#getString(java.lang.String)

 Google.  (n.d.). MalformedURLException. Android Developers. Retrieved April 9th, 2023, from https://developer.android.com/reference/java/net/MalformedURLException

 Google.  (n.d.).  String.trim(). Android Developers. Retrieved April 9th, 2023, from https://developer.android.com/reference/java/lang/String#trim()

 Google.  (n.d.).  View.getWindowToken(). Android Developers. Retrieved April 9th, 2023, from  https://developer.android.com/reference/android/view/View#getWindowToken()

 Google.  (n.d.).  Volley.newRequestQueue(). Android Developers. Retrieved April 9th, 2023, from  https://developer.android.com/training/volley/requestqueue#java
 */