package com.example.pixelstat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Teacherdb extends AppCompatActivity {

    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherdb);

        t1=(TextView)findViewById(R.id.t1);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Teacherdb.this,StudentDetails.class));
            }
        });
    }
}