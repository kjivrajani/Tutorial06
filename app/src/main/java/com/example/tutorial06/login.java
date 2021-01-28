package com.example.tutorial06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    TextView txtuser;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtuser = findViewById(R.id.txtuser);
        preferences = getSharedPreferences("Collag", MODE_PRIVATE);
        String userinfo = preferences.getString("username", "");

        if (userinfo.equals("")) {
            Intent intent = new Intent(login.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        /* Bundle bundle = getIntent().getExtras();
         String Valueusername = bundle.getString("Valueusername");*/

        txtuser.setText(userinfo);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.logout:
                Toast.makeText(this, "Logout Scssfull", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username","");
                editor.remove("userinfo");
                editor.commit();


                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
                finish();

                break;

            default:
                Toast.makeText(this, "Default", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}