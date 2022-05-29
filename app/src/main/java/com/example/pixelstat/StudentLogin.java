package com.example.pixelstat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StudentLogin extends AppCompatActivity {

    private EditText username;
    private EditText Password;
    private FirebaseAuth firebaseAuth;
    Button signup,forgotpass,dashb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        signup=(Button)findViewById(R.id.tvinfo);
        forgotpass=(Button)findViewById(R.id.forgotpas);
        dashb=(Button)findViewById(R.id.button);
        username=(EditText)findViewById(R.id.editText);
        Password=(EditText)findViewById(R.id.editText2);


        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user!=null){
            finish();
            startActivity(new Intent(StudentLogin.this,Studentdb.class));
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentLogin.this,StudentReg.class));
            }
        });

        dashb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(StudentLogin.this);
                progressDialog.setTitle("Authenticating");
                progressDialog.setMessage("Please Wait...");
                progressDialog.show();
                check(username.getText().toString(), Password.getText().toString());
            }
        });
    }

    private  void check(String name,String pass)
    {
        firebaseAuth.signInWithEmailAndPassword(name, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    ProgressDialog progressDialog=new ProgressDialog(StudentLogin.this);
                    progressDialog.dismiss();
                    Toast.makeText(StudentLogin.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent idb=new Intent(StudentLogin.this,Studentdb.class);
                    startActivity(idb);

                }
                else {

                    Toast.makeText(StudentLogin.this,"Login Failed",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


}
