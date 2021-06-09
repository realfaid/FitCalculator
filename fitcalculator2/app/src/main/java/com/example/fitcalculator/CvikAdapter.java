package com.example.fitcalculator;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;



public class CvikAdapter extends FirebaseRecyclerAdapter<Cvik, CvikAdapter.cvikViewholder> {


    public CvikAdapter(
            @NonNull FirebaseRecyclerOptions<Cvik> options) {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull cvikViewholder holder,
                     int position, Cvik model) {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.name.setText(model.getNazev());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
      holder.splneno_z_limitu.setText(String.valueOf(model.getSplneno_limit()));

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
       holder.limit.setText(String.valueOf(model.getLimit()));
    }


    public cvikViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType) {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cvik, parent, false);
        return new CvikAdapter.cvikViewholder(view);
    }

    // Sub Class to create references of the views in Crad
// view (here "person.xml")
    class cvikViewholder
            extends RecyclerView.ViewHolder   {
        TextView name, splneno_z_limitu, limit, jednotka;
        public cvikViewholder(@NonNull View itemView)
        {
            super(itemView);


            name= itemView.findViewById(R.id.Nazev);
            splneno_z_limitu = itemView.findViewById(R.id.splneno_z_limitu);
            limit = itemView.findViewById(R.id.limit);


            itemView.findViewById(R.id.btnRozklik).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent ht1 = new Intent( view.getContext(), Activity.class);
                    ht1.putExtra("nazev", name.getText());

                    view.getContext().startActivity(ht1);
                }
            });
        }
    }


}