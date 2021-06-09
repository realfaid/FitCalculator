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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EditActivity extends AppCompatActivity {
    String nazev, nazev1, limit, jednotka, popis, nazev2, body1, prvniDatum, splneno;
    TextView textNazev, textBody, textLimit, textZLimitu, textJednotka, textPopis;
    EditText editTextZapsat;
    Button btnZapsat;
    DatabaseReference reff, data;
    Cvik cvik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_activity);
        Intent ht2= getIntent();
        Bundle b = ht2.getExtras();
        nazev2 = (String) b.get("nazev2");



        reff = FirebaseDatabase.getInstance().getReference("Cvik").child(nazev2);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){

                limit= dataSnapshot.child("limit").getValue().toString();
                body1 = dataSnapshot.child("body").getValue().toString();
                prvniDatum = dataSnapshot.child("prvni_datum").getValue().toString();
                splneno = dataSnapshot.child("splneno_limit").getValue().toString();
                jednotka  = dataSnapshot.child("jednotka_mereni").getValue().toString();
                popis= dataSnapshot.child("popis_cviku").getValue().toString();

                textLimit = findViewById(R.id.editLimit1);
                textJednotka = findViewById(R.id.editJednotka1);
                textPopis =  findViewById(R.id.editPopis1);

                textLimit.setText(limit);
                textPopis.setText(popis);
                textJednotka.setText(jednotka);
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
                Intent ht1 = new Intent(EditActivity.this, MainActivity.class);
                startActivity(ht1);
                return true;


            case R.id.history_menu:
                Intent ht3 = new Intent(EditActivity.this, HistorieActivity.class);
                startActivity(ht3);
                return true;

            case R.id.guide_menu:
                setContentView(R.layout.guide);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void editDat(View view) {

        cvik = new Cvik();
        reff = FirebaseDatabase.getInstance().getReference("Cvik");


        int limit1 = Integer.parseInt(textLimit.getText().toString().trim());
        int splneno1 = Integer.parseInt(splneno);
        int body2 = Integer.parseInt(body1);



        cvik.setPopis_cviku(textPopis.getText().toString().trim());
        cvik.setLimit(limit1);
        cvik.setJednotka_mereni(textJednotka.getText().toString().trim());
        cvik.setNazev(nazev2);
        cvik.setPrvni_datum(prvniDatum);
        cvik.setSplneno_limit(splneno1);
        cvik.setBody(body2);



        reff.child(nazev2).setValue(cvik);
        Toast.makeText(EditActivity.this, "Aktualizuji data.", Toast.LENGTH_SHORT).show();
        Intent ht1 = new Intent(EditActivity.this, MainActivity.class);
        startActivity(ht1);

    }


    public void odstranitData(View view){
        cvik = new Cvik();
        reff = FirebaseDatabase.getInstance().getReference("Cvik");

        Historie historie = new Historie();
        DatabaseReference dataHistorie = FirebaseDatabase.getInstance().getReference("Historie");






        cvik.setPopis_cviku(null);
        cvik.setLimit(null);
        cvik.setJednotka_mereni(null);
        cvik.setNazev(null);
        cvik.setPrvni_datum(null);
        cvik.setSplneno_limit(null);
        cvik.setBody(null);

        historie.setDatum(null);
        historie.setNazev(null);
        historie.setZapsano(null);


        reff.child(nazev2).setValue(cvik);
        dataHistorie.child(nazev2).setValue(historie);
        Toast.makeText(EditActivity.this, "Mažu data.", Toast.LENGTH_SHORT).show();
        Intent ht1 = new Intent(EditActivity.this, MainActivity.class);
        startActivity(ht1);

    }
}
