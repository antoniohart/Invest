package com.dummies.invest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

public class RequestFormActivity extends AppCompatActivity {
    TextView userEmail, userMobile;


    String getBankID, getInvestmentID;

    String saveRequestURL = Utility.getGetSaveRequestURL();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userEmail = findViewById(R.id.userEmail);
        userMobile = findViewById(R.id.userMobile);


        Intent iRetrieve = getIntent();
        getBankID = iRetrieve.getStringExtra(MainActivity.BANKID);
        getInvestmentID = iRetrieve.getStringExtra(MainActivity.INVID);

//        Toast.makeText(RequestFormActivity.this,getBankID+"\n"+getInvestmentID, Toast.LENGTH_SHORT).show();


    }

    public void submitRequest(View v){

        if (userEmail.getText().toString().trim().length() < 1 || userEmail.getText().toString().trim().length() < 1 ) {

            Alerts alerts = new Alerts(RequestFormActivity.this,"Alert!","Please fields are required","Ok","Cancel");
            alerts.showAlert();

        }else {

            //calling api to save request details

            try{

                HashMap postData = new HashMap();
                postData.put("BnkID", getBankID.toString());
                postData.put("InvID", getInvestmentID.toString());
                postData.put("Email", userEmail.getText().toString().trim());
                postData.put("Mobile", userMobile.getText().toString().trim());

                PostResponseAsyncTask taskRead = new PostResponseAsyncTask(RequestFormActivity.this, postData, new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {

//                        Toast.makeText(RequestFormActivity.this, s.toString(), Toast.LENGTH_SHORT).show();

                        if(s.equalsIgnoreCase("data saved")){

                            Alerts alerts = new Alerts(RequestFormActivity.this,"Thank you for your request","An Agent will contact you soon","Ok","Cancel");
                            alerts.showAlert();

                        }else{

                            Alerts alerts = new Alerts(RequestFormActivity.this,"Submission failed","Please check your internet connection and try again","Ok","Cancel");
                            alerts.showAlert();
                        }


                    }
                });
                taskRead.execute(saveRequestURL);

                //new RetrieveLogin().execute(amount.getText().toString());

            }catch (Exception ex){

                Toast.makeText(RequestFormActivity.this, "Oops. something went wrong. check internet connection", Toast.LENGTH_LONG).show();
            }


        }
    }
}