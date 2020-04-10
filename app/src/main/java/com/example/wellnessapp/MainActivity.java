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
            Log.i(activity, "Task1 triggered");
            intent = new Intent(this, Task1Activity.class);
        } else if(v.getId() == R.id.to_puzzles_button){
            Log.i(activity, "Task2 - triggered");
            intent = new Intent(this, Task2Activity.class);
        } else{
            Context context = getApplicationContext();
            String s;
            if(v.getId() == R.id.to_matching_button || v.getId() == R.id.to_story_button){
                s = "This is Kyle's screen";
            } else {
                s = "Not done yet";
            }
            Toast toast = Toast.makeText(context,s, Toast.LENGTH_SHORT);
            toast.show();
        }
        if(intent != null){
            Log.i(activity, "launching intent from MainActivity");
            startActivity(intent);
        }
    }
}
