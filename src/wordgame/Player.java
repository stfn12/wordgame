/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordgame;

import java.util.ArrayList;

/**
 *
 * @author RGI3
 */
public class Player extends Thread {

    public String tiles;
    public String word;
    public int points=0;
    public ArrayList<String> wordsUsed=new ArrayList<>();
    
    @Override
    public void run() {
        
    }
    public void setTiles(String tiles2){
        tiles= tiles2;
    }
    public void setWord(String word2){
        word=word2;
    }
    public void addPoints(int points2){
        points+=points2;
    }
    public int getpoints(){
        return points;
    }
}
