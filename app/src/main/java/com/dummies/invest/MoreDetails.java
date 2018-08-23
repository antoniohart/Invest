package com.dummies.invest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MoreDetails extends AppCompatActivity {
    private List<InvestInfo> persons;
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);






      rv = findViewById(R.id.rvs);
      rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        initializeData();
        initializeAdapter();
    }


    private void initializeAdapter(){
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(persons);
        rv.setAdapter(adapter);
    }






    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new InvestInfo("Stanbic Bank","Fixed deposit", "13%"));
        persons.add(new InvestInfo("Lavery Maiss" , "Fixed deposit", "15%"));
      persons.add(new InvestInfo("Lillie Watts", "Fixed deposit", "17.5%"));
    }





}
