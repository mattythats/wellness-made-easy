package com.example.wellnessapp;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Random;

class GlossaryTerm{
    private String term;
    private String definition;

    GlossaryTerm(String word, String meaning){
        term = word;
        definition = meaning;
    }

    public String getTerm(){
        return term;
    }

    public String getDefinition(){
        return definition;
    }

}

public class GlossaryClass {
    private ArrayList<GlossaryTerm> words;
    private int which_term = -1;
    //TODO: add sound/picture arrays and relevant getters

    public GlossaryClass(){
        words = new ArrayList<GlossaryTerm>();

        //Chapter 1 terms
        words.add(new GlossaryTerm("Cultural Competence", "Writing that is clear and to the point which takes less time to" +
                "read and understand."));
        words.add(new GlossaryTerm("Numeracy", "Is understanding written words such that you can participate" +
                "in society, meet your goals and develop your knowledge and" +
                "potential."));
        words.add(new GlossaryTerm("Plain Language", "Moving resources from the hospital into the community to" +
                "support all aspects of wellness (examples: disease" +
                "management, support groups, timely treatment to avoid" +
                "serious illness, home visits) by empowering people to take" +
                "responsibility for their own wellness."));
        words.add(new GlossaryTerm("Literacy", "Behaviors, attitudes and policies that come together, between" +
                "people of differing cultures, that enables them to work" +
                "together effectively."));
        words.add(new GlossaryTerm("Health Literacy", "The ability to understand mathematical information to manage" +
                "mathematical demands in a range of situations."));
        words.add(new GlossaryTerm("Population Health", "The degree that a person can understand basic health" +
                "information and available services so that you can make" +
                "appropriate health choices."));
    }

    public Pair<String, String> getTerm(){
        Random r = new Random();
        int rand = r.nextInt(words.size());
        while(rand == which_term){
            rand = r.nextInt(words.size());
        }
        which_term = rand;
        Pair<String, String> p = new Pair<>(words.get(which_term).getTerm(), words.get(which_term).getDefinition());
        return p;
    }
}
