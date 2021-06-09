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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistorieActivity extends AppCompatActivity {
    String text;
    private RecyclerView recyclerView;
    TextView historie;
    EditText editTextZapsat;
    Button btnZapsat;
    CvikAdapter1 adapter;
    DatabaseReference mbase;
    Cvik cvik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mbase = FirebaseDatabase.getInstance().getReference("Cvik");
        recyclerView = findViewById(R.id.recycler2);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));


        FirebaseRecyclerOptions<Cvik> options1
                = new FirebaseRecyclerOptions.Builder<Cvik>()
                .setQuery(mbase, Cvik.class)
                .build();

        adapter = new CvikAdapter1(options1);

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
                Intent ht1 = new Intent(HistorieActivity.this, MainActivity.class);
                startActivity(ht1);
                return true;


            case R.id.history_menu:
                Intent ht2 = new Intent(HistorieActivity.this, HistorieActivity.class);
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