package com.example.wellnessapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

public class Task1Activity extends AppCompatActivity {
    private TextView termView, definitionView, chapterView;
    private GlossaryClass glossary;
    private String activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = "Task1";
        Log.i(activity, "onCreate starts");
        setContentView(R.layout.activity_task1);
        termView = findViewById(R.id.word_text);
        definitionView = findViewById(R.id.definition_text);
        chapterView = findViewById(R.id.chapter_text);
        InputStream in = null;
        try {
            Log.i(activity, "trying inputstream/glossary");
            in = getAssets().open("term_glossary.xml");
            glossary = new GlossaryClass(in);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        GlossaryTerm word = glossary.getTerm();
        termView.setText(getString(R.string.term_placeholder, word.getTerm()));
        definitionView.setText(getString(R.string.definition_placeholder, word.getDefinition()));
        chapterView.setText(getString(R.string.chapter_placeholder, word.getChapter()));
        Log.i(activity, "onCreateEnds");
    }

    public void showDefinition(View v){
        Log.i(activity, "showDefinition");
        definitionView.setVisibility(View.VISIBLE);
    }

    public void pickWord(View v){
        Log.i(activity, "pickWord");
        GlossaryTerm word = glossary.getTerm();
        termView.setText(getString(R.string.term_placeholder, word.getTerm()));
        chapterView.setText(getString(R.string.chapter_placeholder, word.getChapter()));
        definitionView.setVisibility(View.INVISIBLE);
        definitionView.setText(getString(R.string.definition_placeholder, word.getDefinition()));
    }
}
