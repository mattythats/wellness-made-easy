package com.example.wellnessapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class WordSearchActivity extends AppCompatActivity {
    private String activity;
    private InputStream is;
    private ArrayList<WordSearchTerm> terms;
    private WordSearchXmlParser wsxp;
    private WordSearchGrid grid;
    private ConstraintLayout layout;
    private TableLayout tbl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_search);

        activity = "WordSearch";
        try {
            is = getAssets().open("word_search_terms.xml");
            wsxp = new WordSearchXmlParser(is);
            terms = (ArrayList<WordSearchTerm>) wsxp.parse();
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
        layout = findViewById(R.id.layout);
        grid = new WordSearchGrid(15,13,terms);
        Log.i(activity, "grid.populate ends");
        tbl = findViewById(R.id.gridTable);
        for(int i = 0; i < grid.getRows(); i++){
            TableRow tr = new TableRow(this);
            tr.setId(tbl.getId() + ((grid.getRows()+1)*i));
            for(int j = 0; j < grid.getCols(); j++){
                TextView tv = new TextView(this);
                tv.setPadding(7, 0, 7, 0);
                tv.setText(String.valueOf(grid.getLetter(i,j)));
                tr.addView(tv);
                tv.setId(tr.getId() + j);
                tv.setPadding(10,10,10,10);
                tv.setTextAppearance(this, R.style.TextAppearance_AppCompat_Medium);
            }
            tbl.addView(tr);
        }
        Log.i(activity, "onCreate ends");
    }

}
