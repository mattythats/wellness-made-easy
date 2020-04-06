package com.example.wellnessapp;

import android.util.Pair;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

class GlossaryTerm{
    private String term;
    private String definition;
    int chapter;

    GlossaryTerm(String word, String meaning, int c){
        term = word;
        definition = meaning;
        chapter = c;
    }

    public String getTerm(){
        return term;
    }

    public String getDefinition(){
        return definition;
    }

    public int getChapter(){
        return chapter;
    }

}

public class GlossaryClass {
    private ArrayList<GlossaryTerm> words;
    private InputStream is;
    private int which_term = -1;
    //TODO: add sound/picture arrays and relevant getters

    public GlossaryClass(InputStream input) throws IOException, XmlPullParserException {
        is = input;
        GlossaryXmlParser gxp = new GlossaryXmlParser(is);
        words = (ArrayList<GlossaryTerm>) gxp.parse();
    }

    public GlossaryTerm getTerm(){
        Random r = new Random();
        int rand = r.nextInt(words.size());
        while(rand == which_term){
            rand = r.nextInt(words.size());
        }
        which_term = rand;
        return words.get(which_term);
    }
}
