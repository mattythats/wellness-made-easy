package com.example.wellnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String activity = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(activity, "onCreate ends");
    }

    public void openTask(View v){
        Log.i(activity, "openTask starts");
        Intent intent = null;
        if(v.getId() == R.id.to_glossary_button){
            Log.i(activity, "glossary button clicked");
            intent = new Intent(this, Task1Activity.class);
        } else {
            Context context = getApplicationContext();
            String s = "Not done yet";
            Toast toast = Toast.makeText(context,s, Toast.LENGTH_LONG);
            toast.show();
        }
        if(intent != null){
            Log.i(activity, "launching intent");
            startActivity(intent);
        }
    }
}
