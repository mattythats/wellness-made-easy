package com.example.wellnessapp;

import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Task1Activity extends AppCompatActivity {
    private TextView termView, definitionView;
    private GlossaryClass glossary;
    private String activity = "Task1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(activity, "onCreate starts");
        setContentView(R.layout.activity_task1);
        termView = findViewById(R.id.word_text);
        definitionView = findViewById(R.id.definition_text);
        glossary = new GlossaryClass();
        Pair<String, String> word = glossary.getTerm();
        termView.setText(getString(R.string.term_placeholder, word.first));
        definitionView.setText(getString(R.string.definition_placeholder, word.second));
        Log.i(activity, "onCreateEnds");
    }

    public void showDefinition(View v){
        definitionView.setVisibility(View.VISIBLE);
    }

    public void pickWord(View v){
        Pair<String, String> word = glossary.getTerm();
        termView.setText(getString(R.string.term_placeholder, word.first));
        definitionView.setVisibility(View.INVISIBLE);
        definitionView.setText(getString(R.string.definition_placeholder, word.second));
    }
}
