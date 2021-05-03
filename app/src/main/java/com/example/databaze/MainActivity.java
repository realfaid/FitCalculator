package com.example.databaze;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText editTextTextPersonName2, editTextTextPersonName3, editTextTextPersonName4,  editTextTextPersonName5;
Button button;
DatabaseReference reff ;
Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        editTextTextPersonName2=(EditText)findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3=(EditText)findViewById(R.id.editTextTextPersonName3);
    editTextTextPersonName4=(EditText)findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName5=(EditText)findViewById(R.id.editTextTextPersonName5);
        button=(Button) findViewById(R.id.button);
       member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
   button.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
       int agea=Integer.parseInt(editTextTextPersonName3.getText().toString().trim());
       Float hit=Float.parseFloat(editTextTextPersonName5.getText().toString().trim());
       Long phn= Long.parseLong(editTextTextPersonName4.getText().toString().trim());

       member.setName(editTextTextPersonName2.getText().toString().trim());
member.setAge (agea);
member.setHt (hit) ;
member.setPh(phn);

reff.child("member1").setValue(member);
           Toast.makeText(MainActivity.this, "zapisuji data", Toast.LENGTH_SHORT).show();

       }
   });
    }
}