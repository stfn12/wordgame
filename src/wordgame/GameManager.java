/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordgame;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author RGI3
 */
public class GameManager {

    public char[][] tiles=new char[10][10];
    public Player player1 = new Player();
    public Player player2 = new Player();
    public Player player3 = new Player();

    public void init() {
        generateTiles();

    }

    public void generateTiles() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tiles[i][j] = (char)('A' + ThreadLocalRandom.current().nextInt(0, 25 + 1));
            }
        }
    }

    public char[][] getTiles() {
        return tiles;
    }

    public void setTiles(char[][] tiles2) {
        tiles = tiles2;
    }

    public String getPlayerTiles() {
        StringBuilder playerTiles = new StringBuilder(7);
        for (int i = 0; i < 7; i++) {
            playerTiles.append(tiles[ThreadLocalRandom.current().nextInt(0, 6 + 1)][ThreadLocalRandom.current().nextInt(0, 6 + 1)]);
        }
        return playerTiles.toString();
    }
    public boolean isValidWord(Player player)  {

        FileReader fileReaderDictionary = null;
        try {
            fileReaderDictionary = new FileReader("Dictionary.txt");
            BufferedReader dictionary = new BufferedReader(fileReaderDictionary);
            String str;
            while ((str = dictionary.readLine()) != null) {
                str = str.toUpperCase();
                if (str.equals(player.word)) {
                    if (!player.wordsUsed.contains(player.word)) {
                        if (player.word.length() > 1) {
                            player.wordsUsed.add(player.word);
                        }
                        return true;
                    } else {
                        return false;
                    }
                }
            }   return false;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileReaderDictionary.close();
            } catch (IOException ex) {
                Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public boolean containsLetters(Player player, String letters)  {
        int ok=0;
        for (int j = 0; j < player.word.length(); j++){
            for (int i = 0; i < letters.length(); i++){
                if(letters.charAt(i)==player.word.charAt(j))
                    ok=1;
            }
            if(ok==0)
                return false;
            ok=0;
        }
        return true;
    }
    
    public void increasePoints(Player player){
        player.addPoints(player.word.length()*10);
    }
    
}
