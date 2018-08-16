package com.dummies.invest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    public final static String BANKID = "com.dummies.invest.BANKID";
    public final static String INVID = "com.dummies.invest.INVID";


    private Button Search;
    private EditText amount;
    private String name;
    private Double deposit;
    private Double rate;
    private TextView  textView1;
    private TextView  textView2;
    private TextView  textView3;
    private TextView  textView4;
    private TextView proceed;
   // private Double deposit;
    private String  bankID;
    private String  bankName;
    private String  invType;
    private String  rates; //private Double rate;
    private String  period;
    private String  invId;


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
        textView1   = findViewById(R.id.textView3);
        textView2   = findViewById(R.id.textView4);
        textView3   = findViewById(R.id.textView5);
        proceed     = findViewById(R.id.proceed);



    }

    public void btnSearch(View v) {

        if (amount.getText().toString().trim().length() < 1) {

            Alerts alerts = new Alerts(MainActivity.this,"Alert!","Please enter an amount","Ok","Cancel");
            alerts.showAlert();

        }else {

            //setting Cardview 2 back to visible to display information
            HighRateContainer.setVisibility(View.VISIBLE);

            //calling api for the bank with higest investment rate

            try{

                HashMap postData = new HashMap();
                postData.put("amount", "200");

                PostResponseAsyncTask taskRead = new PostResponseAsyncTask(MainActivity.this, postData, new AsyncResponse() {
                    @Override
                    public void processFinish(String apiData) {

//                        Toast.makeText(MainActivity.this, apiData.toString(), Toast.LENGTH_SHORT).show();


                        String [] info  =apiData.split("/");
                        bankID=info[0]; bankName=info[1]; invType=info[2]; rates= info[3]; period=info[4]; invId=info[5];
                        //for bankname
                        textView1.setText( bankName);

                        //for invType
                        textView2.setText( invType);



                        //for rates

                        rate=  100* Double.parseDouble(rates);
                        //  StringBuffer sb = new StringBuffer(rate);
                        textView3.setText( String.valueOf( rate )+ "%");


                        //setting proceed button to visivle
                        proceed.setVisibility(View.VISIBLE);





                    }
                });
                taskRead.execute(highRateURL);

                //new RetrieveLogin().execute(amount.getText().toString());

            }catch (Exception ex){

                Toast.makeText(MainActivity.this, "Oops. something went wrong. check internet connection", Toast.LENGTH_LONG).show();
            }


        }
    }

    //filling the
    public void fillForm(View v){

        Intent intent = new Intent(MainActivity.this, RequestFormActivity.class);
        //Passing Bank ID and Investment ID to next activity
        intent.putExtra(BANKID,bankID);
        intent.putExtra(INVID, invId);

        startActivity(intent);


    }

    }
