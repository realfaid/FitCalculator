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


public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    String nazev1, body1, celkoveBody;
    CvikAdapter adapter;
    DatabaseReference mbase;
    public String nazevCviku;
    Cvik cvik;
    DatabaseReference reff, body;
    EditText nazev, limit, splneno_z_limitu, popis, jednotka_mereni;
    TextView pocetCelkovychBodu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mbase = FirebaseDatabase.getInstance().getReference("Cvik");
        recyclerView = findViewById(R.id.recycler1);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));


        FirebaseRecyclerOptions<Cvik> options1
                = new FirebaseRecyclerOptions.Builder<Cvik>()
                .setQuery(mbase, Cvik.class)
                .build();

        adapter = new CvikAdapter(options1);

        recyclerView.setAdapter(adapter);


        nazev = (EditText) findViewById(R.id.editNazevCviku);
        limit = (EditText) findViewById(R.id.editLimit);

        jednotka_mereni = (EditText) findViewById(R.id.editJednotka);
        popis = (EditText) findViewById(R.id.editPopis);


       
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


    public void plusButtonClicked(View v) {
        setContentView(R.layout.add_activity);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.main_menu:
                Intent ht1 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(ht1);
                return true;


            case R.id.history_menu:
                Intent ht2 = new Intent(MainActivity.this, HistorieActivity.class);
                startActivity(ht2);
                return true;

            case R.id.guide_menu:
                setContentView(R.layout.guide);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void zapisDat(View view) {
        nazev = (EditText) findViewById(R.id.editNazevCviku);
        limit = (EditText) findViewById(R.id.editLimit);
        jednotka_mereni = (EditText) findViewById(R.id.editJednotka);
        popis = (EditText) findViewById(R.id.editPopis);
        Date thisDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/Y");
        cvik = new Cvik();
        reff = FirebaseDatabase.getInstance().getReference("Cvik");


        int limit1 = Integer.parseInt(limit.getText().toString().trim());

        cvik.setPrvni_datum(dateForm.format(thisDate));
        cvik.setNazev(nazev.getText().toString().trim());




        cvik.setPopis_cviku(popis.getText().toString().trim());
        cvik.setLimit(limit1);
        cvik.setSplneno_limit(0);
        cvik.setBody(0);
        cvik.setJednotka_mereni(jednotka_mereni.getText().toString().trim());


        reff.child(nazev.getText().toString().trim()).setValue(cvik);
        Toast.makeText(MainActivity.this, "Zapisuji data.", Toast.LENGTH_SHORT).show();
        Intent ht1 = new Intent(MainActivity.this, MainActivity.class);
        startActivity(ht1);

    }




    }





