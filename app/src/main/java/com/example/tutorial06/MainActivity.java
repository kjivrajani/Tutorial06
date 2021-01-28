package com.example.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnlogin;
    EditText editemail,editpassword;
    TextView txtlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = findViewById(R.id.btnlogin);
        editemail = findViewById(R.id.editemail);
        editpassword = findViewById(R.id.editpassword);
        txtlogin = findViewById(R.id.txtlogin);
    }

    public void btnLoginClick(View view) {
        String Valueusername = editemail.getText().toString();
        String Valuepassword = editpassword.getText().toString();
        if(Valueusername.equals(""))
        {
            Toast.makeText(this, "Username can not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(Valuepassword.equals(""))
        {
            Toast.makeText(this, "password can not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(Valuepassword.length() < 6)
        {
            Toast.makeText(this, "password mus be maximum 6 size", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(Valueusername).matches())
        {
            Toast.makeText(this, "user name must be Preper email Address", Toast.LENGTH_SHORT).show();
        }

        if (Valueusername.equals("kjivrajani728@rku.ac.in") && Valuepassword.equals("123456"))
        {
            SharedPreferences preferences = getSharedPreferences("Collag",MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("username",Valueusername);
            editor.commit();


            Intent intent = new Intent(MainActivity.this,login.class);
           // intent.putExtra("Valueusername",Valueusername);
            startActivity(intent);
            Toast.makeText(this, "Login Succesful", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void getRegister(View view) {
        Intent intent = new Intent(MainActivity.this,Registration.class);
        startActivity(intent);
    }
}