package com.example.pixelstat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Studentdb extends AppCompatActivity {

    TextView t1,t2,t3,t4,m1,m2,m3;
    private FirebaseAuth mauth;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    Student s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentdb);

        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        m1=(TextView)findViewById(R.id.m1);
        m2=(TextView)findViewById(R.id.m2);
        m3=(TextView)findViewById(R.id.m3);

        s = new Student();

        mauth = FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference(mauth.getUid()).child("setting");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    t1.setText(snapshot.child("sname").getValue().toString());
                    t2.setText(snapshot.child("fname").getValue().toString());
                    t3.setText(snapshot.child("iname").getValue().toString());
                    t4.setText(snapshot.child("branch").getValue().toString());
                    m1.setText(snapshot.child("m1").getValue().toString());
                    m2.setText(snapshot.child("m2").getValue().toString());
                    m3.setText(snapshot.child("m3").getValue().toString());

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });


    }
}