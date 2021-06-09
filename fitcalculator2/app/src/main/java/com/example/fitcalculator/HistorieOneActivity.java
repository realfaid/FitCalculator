package com.example.fitcalculator;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ValueEventListener;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import android.view.MenuInflater;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class HistorieOneActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    String nazev1, pocet1, datum1, jednotka;
    HistorieAdapter adapter;
    DatabaseReference mbase;
    public String nazevCviku;
    Cvik cvik;
    DatabaseReference reff, body;

    TextView textNazev, textPocet, textDatum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_one_history);
        Intent ht2= getIntent();
        Bundle b = ht2.getExtras();

        nazev1 = (String) b.get("nazev");

        reff = FirebaseDatabase.getInstance().getReference().child("Cvik").child(nazev1);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){

            }

        });





        mbase = FirebaseDatabase.getInstance().getReference("Historie").child(nazev1);
        recyclerView = findViewById(R.id.recycler3);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));


        FirebaseRecyclerOptions<Historie> options1
                = new FirebaseRecyclerOptions.Builder<Historie>()
                .setQuery(mbase, Historie.class)
                .build();

        adapter = new HistorieAdapter(options1);

        recyclerView.setAdapter(adapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();

    }


    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.main_menu:
                Intent ht1 = new Intent(HistorieOneActivity.this, MainActivity.class);
                startActivity(ht1);
                return true;


            case R.id.history_menu:
                Intent ht2 = new Intent(HistorieOneActivity.this, HistorieActivity.class);
                startActivity(ht2);
                return true;

            case R.id.guide_menu:
                setContentView(R.layout.guide);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    }









