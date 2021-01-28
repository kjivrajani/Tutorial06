package com.example.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void btnlogin(View view) {
        Toast.makeText(this, "Registration Successfull", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Registration.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}