package com.example.fitcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity extends AppCompatActivity {
    String nazev, body1, limit1, splneno_z_limitu1, jednotka_mereni1;
    TextView textNazev, textBody, textLimit, textZLimitu, textJednotka;
    EditText editTextZapsat;
    Button btnZapsat;
    DatabaseReference reff, data;
    Cvik cvik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        Intent ht2= getIntent();
        Bundle b = ht2.getExtras();
        nazev = (String) b.get("nazev");
        textNazev = findViewById(R.id.textNazev);
        textBody = findViewById(R.id.textBody);
        textLimit = findViewById(R.id.textLimit);
        textZLimitu = findViewById(R.id.textZLimitu);
        textJednotka = findViewById(R.id.textJednotka);
        textNazev.setText(nazev);

        reff = FirebaseDatabase.getInstance().getReference().child("Cvik").child(nazev);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
               body1 = dataSnapshot.child("body").getValue().toString();
                limit1= dataSnapshot.child("limit").getValue().toString();
                splneno_z_limitu1  = dataSnapshot.child("splneno_limit").getValue().toString();
                jednotka_mereni1= dataSnapshot.child("jednotka_mereni").getValue().toString();
              textBody.setText(body1);
                textLimit.setText(limit1);
                textZLimitu.setText(splneno_z_limitu1);
                textJednotka.setText(jednotka_mereni1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){

            }

        });

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.main_menu:
                Intent ht1 = new Intent(Activity.this, MainActivity.class);
                startActivity(ht1);
                return true;


            case R.id.history_menu:
                Intent ht2 = new Intent(Activity.this, HistorieActivity.class);
                startActivity(ht2);
                return true;

            case R.id.guide_menu:
                setContentView(R.layout.guide);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    public void zapisPoctu(View view){
        int splneno = Integer.parseInt(splneno_z_limitu1);
        editTextZapsat = findViewById(R.id.editTextZapsat);
        String pocetZapsany = editTextZapsat.getText().toString();
        int pocetZapis = Integer.parseInt(pocetZapsany);
       FirebaseDatabase.getInstance().getReference().child("Cvik").child(nazev).child("splneno_limit").setValue(splneno+pocetZapis);
        Intent ht1 = new Intent(Activity.this, MainActivity.class);
        startActivity(ht1);

        int pocetZapsany1 = Integer.parseInt(pocetZapsany.toString().trim());

        Historie historie = new Historie();
        data = FirebaseDatabase.getInstance().getReference("Historie").child(nazev).push();
        Date thisDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/Y");
        historie.setDatum(dateForm.format(thisDate));
        historie.setNazev(nazev);
        historie.setZapsano(pocetZapsany1);


        data.setValue(historie);

        
    }


    public void editovat(View view){

        Intent ht3 = new Intent(Activity.this, EditActivity.class);
        ht3.putExtra("nazev2", nazev);
        startActivity(ht3);

    }
}
