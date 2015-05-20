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
import java.awt.Dimension;
import java.awt.Toolkit;
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
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author woozlinux
 */
public class RenderEngine implements Serializable {
    
    private Game game;
    
    public static void centerScreen(JFrame f)
    {
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = f.getSize().width;
        int h = f.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        f.setLocation(x, y);
    }
    
    public static void openForm(JFrame current, JFrame next)
    {
        current.dispose();
        next.setVisible(true);
    }
    
    public static void openForm(JFrame current, JFrame next, boolean fullscreen)
    {
        current.dispose();
        next.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        next.setVisible(true);
    }
    
    public static void showGameInfo(Game g, JLabel name, JLabel credits, JLabel coordinates, JLabel cargolevel, JLabel res1, JLabel res2, JLabel res3, JLabel weaponlevel)
    {
        name.setText("Name - " + g.Player().getName());
        credits.setText("Credits - " + g.Player().Spaceship().Coins().getCount()); 
        coordinates.setText("Coordinates(X, Y) - " + g.Player().Spaceship().Coordinates().getX() +", " + g.Player().Spaceship().Coordinates().getY());
        cargolevel.setText("Cargo Level - " + g.Player().Spaceship().Cargo().getLevel());
        res1.setText("Resource 1 - " + g.Player().Spaceship().Cargo().getResource01().getName());
        res2.setText("Resource 2 - " + g.Player().Spaceship().Cargo().getResource02().getName());
        if(g.Player().Spaceship().Cargo().isUnlocked())
            res3.setText("Resource 3 - " + g.Player().Spaceship().Cargo().getResource03().getName());
        else
            res3.setText("Resource 3 - Locked");
        weaponlevel.setText("Weapon Level - " + g.Player().Spaceship().Weapon().getLevel());
        

    }
    
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
