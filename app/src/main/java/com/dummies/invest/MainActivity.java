package com.dummies.invest;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private Button Search;
    private EditText amount;
    private String name;
    private Double deposit;
    private Double rate;

    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;


    CardView HighRateContainer;

    String highRateURL = Utility.getGetHighRateURL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

           Search =findViewById(R.id.search);
           amount =findViewById(R.id.amount);

           HighRateContainer = findViewById(R.id.card2);



    }

    public void btnSearch(View v) {

        if (amount.getText().toString().trim().length() < 1) {

            Toast.makeText(MainActivity.this, "You have enter an Amount", Toast.LENGTH_LONG).show();

        }else {

            //setting Cardview 2 back to visible to display information
            HighRateContainer.setVisibility(View.VISIBLE);

            //calling api for the bank with higest investment rate
            HashMap postData = new HashMap();
            postData.put("amount", "200");

            PostResponseAsyncTask taskRead = new PostResponseAsyncTask(MainActivity.this, postData, new AsyncResponse() {
                @Override
                public void processFinish(String apiData) {

                    Toast.makeText(MainActivity.this, apiData.toString(), Toast.LENGTH_SHORT).show();

                }
            });
            taskRead.execute(highRateURL);

            //new RetrieveLogin().execute(amount.getText().toString());

        }
    }

    //filling the
    public void fillForm(View v){

        Intent intent = new Intent(MainActivity.this, RequestFormActivity.class);
        startActivity(intent);
    }

    }
