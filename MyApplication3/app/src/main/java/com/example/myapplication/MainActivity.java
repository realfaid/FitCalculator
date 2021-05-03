package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText editText2, editText3, editText4,  editText5;
    Button button;
    DatabaseReference reff ;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        editText4=(EditText)findViewById(R.id.editText4);
        editText5=(EditText)findViewById(R.id.editText5);
        button=(Button) findViewById(R.id.button);
        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int agea=Integer.parseInt(editText3.getText().toString().trim());
                Float hit=Float.parseFloat(editText5.getText().toString().trim());
                Long phn= Long.parseLong(editText4.getText().toString().trim());

                member.setName(editText2.getText().toString().trim());
                member.setAge (agea);
                member.setHt (hit) ;
                member.setPh(phn);

                reff.push().setValue(member);
                Toast.makeText(MainActivity.this, "zapisuji data", Toast.LENGTH_SHORT).show();

            }
        });
    }
}