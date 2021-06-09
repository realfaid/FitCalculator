package com.example.fitcalculator;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;



public class HistorieAdapter extends FirebaseRecyclerAdapter<Historie, HistorieAdapter.cvikViewholder> {


    public HistorieAdapter(
            @NonNull FirebaseRecyclerOptions<Historie> options) {
        super(options);

    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull cvikViewholder holder,
                     int position, Historie model) {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.Nazev1.setText(model.getNazev());

        holder.Pocet1.setText(String.valueOf(model.getZapsano()));
        holder.Datum1.setText(model.getDatum());
     // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")

    }


    public cvikViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType) {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.historie, parent, false);
        return new HistorieAdapter.cvikViewholder(view);
    }

    // Sub Class to create references of the views in Crad
// view (here "person.xml")
    class cvikViewholder
            extends RecyclerView.ViewHolder   {
        TextView Nazev1, Pocet1, Datum1;
        public cvikViewholder(@NonNull View itemView)
        {
            super(itemView);


            Nazev1= itemView.findViewById(R.id.textNazev1);
            Pocet1= itemView.findViewById(R.id.textPocet1);
            Datum1= itemView.findViewById(R.id.textDatum1);




        }

    }



}