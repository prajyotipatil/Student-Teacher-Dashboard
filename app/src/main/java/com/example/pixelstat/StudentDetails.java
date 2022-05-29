package com.example.pixelstat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentDetails extends AppCompatActivity {

    EditText m1,m2,m3,d1,d2,d3,d4;
    Button save;
    Student s;
    private DatabaseReference mDatabase;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        m1=(EditText)findViewById(R.id.m1);
        m2=(EditText)findViewById(R.id.m2);
        m3=(EditText)findViewById(R.id.m3);
        d1=(EditText)findViewById(R.id.db2);
        d2=(EditText)findViewById(R.id.db2);
        d3=(EditText)findViewById(R.id.db3);
        d4=(EditText)findViewById(R.id.db4);
        save=(Button)findViewById(R.id.bsave);

        s=new Student();
        mauth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference(mauth.getUid());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    s.setFname(d1.getText().toString());
                    s.setFname(d2.getText().toString());
                    s.setIname(d3.getText().toString());
                    s.setBatch(d4.getText().toString());
                    s.setM1(m1.getText().toString().trim());
                    s.setM2(m2.getText().toString().trim());
                    s.setM3(m3.getText().toString());
                    mDatabase.child("setting").setValue(s);
                    Toast.makeText(StudentDetails.this, "Data added successfully!!", Toast.LENGTH_LONG).show();

            }
        });


    }
}