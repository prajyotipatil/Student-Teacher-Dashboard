package com.example.pixelstat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button gotoTeacherdb;
    private Button gotoStudentdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gotoTeacherdb=(Button)findViewById(R.id.teacher);
        gotoStudentdb=(Button)findViewById(R.id.student);

        gotoTeacherdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TeacherLogin.class));
            }
        });

        gotoStudentdb.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,StudentLogin.class));
            }
        }));
    }
}