package com.example.wellnessapp;

import java.sql.Time;
import java.util.List;
import java.util.Random;

public class WordSearchGrid {
    private char[][] grid;
    private int cols, rows;
    private List<WordSearchTerm> terms;
    public String temp;

    public WordSearchGrid(int c, int r, List<WordSearchTerm> t){
        cols = c;
        rows = r;
        grid = new char[rows][cols];
        terms = t;
        populateGrid();
    }

    private void populateGrid(){
        System.out.println("Populating grid");
        Random r = new Random();
        Time t = new Time(0);
        r.setSeed(t.getTime());
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int rand = r.nextInt(26)+97;
                while((char) rand == 'l'){
                    rand = r.nextInt(26)+97;
                }
                grid[i][j] = (char)rand;
            }
        }
        for(int i = 0; i < terms.size(); i++){
            WordSearchTerm term = terms.get(i);
            System.out.println("term: " + term.getWord());
            System.out.println("pos: (" + term.getStartPos().first + "," + term.getStartPos().second + ")");
            System.out.println("dir: " + term.getDir());
            if(term.getDir() == 0){
                addAcrossWord(term);
            } else{
                addDownWord(term);
            }
        }
    }

    private void addAcrossWord(WordSearchTerm term){
        String word = term.getWord();
        int xPos = term.getStartPos().first;
        int yPos = term.getStartPos().second;
        for(int i = 0; i < word.length(); i++){
            int newX = xPos + i;
            System.out.println("[" + yPos+  "," + newX + "]" + word.charAt(i));
            grid[yPos][xPos+i] = word.toUpperCase().charAt(i); //TODO: remove toUpperCase
        }
    }

    private void addDownWord(WordSearchTerm term){
        String word = term.getWord();
        int xPos = term.getStartPos().first;
        int yPos = term.getStartPos().second;
        for(int i = 0; i < word.length(); i++){
            int newY = yPos + i;
            System.out.println("[" + newY+  "," + xPos + "]" + word.charAt(i));
            grid[yPos+i][xPos] = word.toUpperCase().charAt(i);
        }
    }

    public void printGrid(){
        System.out.println();
        String s = "";
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                s += grid[i][j];
            }
            s += '\n';
        }
        temp = s;
    }

    public int getCols(){
        return cols;
    }

    public int getRows(){
        return rows;
    }

    public char getLetter(int i, int j){
        return grid[i][j];
    }

}
