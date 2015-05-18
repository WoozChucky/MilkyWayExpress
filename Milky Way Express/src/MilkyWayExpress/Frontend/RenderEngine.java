/*
 * The MIT License
 *
 * Copyright 2015 woozlinux.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package MilkyWayExpress.Frontend;

import MilkyWayExpress.Backend.Game;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author woozlinux
 */
public class RenderEngine implements Serializable {
    
    private Game game;
    
    public synchronized void playSound(final String url) {
    new Thread(new Runnable() {
      public void run() {
        try {
          Clip clip = AudioSystem.getClip();
          AudioInputStream inputStream = AudioSystem.getAudioInputStream(Game.class.getResourceAsStream(url));
          clip.loop(3);
          clip.open(inputStream);
          clip.start(); 
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
          System.err.println(e.getMessage());
        }
      }
    }).start();
    }
    
    /**
     *
     */
    public RenderEngine()
    {
        game = new Game(this);
    }
        
    /**
     *
     */
    public void boot()
    {
        game.play();
    }
    
    /**
     *
     * @return
     */
    public Game loadGame()
    {
        String savefile = Console.loadMenu();
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savefile));
                game = (Game)ois.readObject();
                ois.close();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        return game;
    }
    
    /**
     *
     * @param s
     */
    public void saveGame(String s)
    {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(s));
            oos.writeObject(game);
            oos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
