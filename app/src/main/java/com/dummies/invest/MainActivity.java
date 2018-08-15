package com.dummies.invest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private String name;
    private Double deposit;
    private Double rate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           button =findViewById(R.id.button3);
           editText=findViewById(R.id.editText);



    }
}
