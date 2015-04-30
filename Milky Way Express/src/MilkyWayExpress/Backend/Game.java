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
package MilkyWayExpress.Backend;

import MilkyWayExpress.Backend.Player.Player;
import MilkyWayExpress.Backend.ResourcesF.Coin;
import MilkyWayExpress.Backend.ResourcesF.Resources;
import MilkyWayExpress.Backend.States.IStatus;
import MilkyWayExpress.Frontend.Console;
import MilkyWayExpress.Frontend.RenderEngine;
import java.io.Serializable;

/**
 *
 * @author woozlinux
 */
public class Game implements Serializable {
    
    private IStatus status;
    private Player player;
    private final RenderEngine renderEngine;
    private final Galaxy galaxy;
    private final Resources coins;
    private char action;
    private int round;
    
    /**
     *
     * @param re
     */
    public Game(RenderEngine re)
    {
        galaxy = new Galaxy();
        renderEngine = re;
        coins = new Coin();
        coins.setCount(20); 
        round = 0;
    }
    
    /**
     *
     * @return
     */
    public Player Player()
    {
        return player;
    }

    /**
     *
     * @return
     */
    public Galaxy Galaxy()
    {
        return galaxy;
    }

    /**
     *
     * @return
     */
    public Resources Coins()
    {
        return coins;
    }

    /**
     *
     * @return
     */
    public int getRound()
    {
        return round;
    }

    /**
     *
     */
    public void play()
    {
        //Main cycle of game
        while(player.Spaceship().Coins().getCount() > 0)
        {
            
            Console.showInfo(this);
            
            action = Console.getAction();

            System.out.println("\n\t- " + Character.getNumericValue(action) + "\n");
            
            switch(action)
            {
                
                case 's':
                    renderEngine.saveGame(Console.saveMenu());
                    break;
                case 'q':
                    System.exit(0);
                    break;
                case 't':
                    Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() - 1);
                    break;
                    
            }
            round++;
            Console.clearConsole();
        }
        
        Console.endGame();

    }
    
    /**
     *
     */
    public void newGame()
    {
        galaxy.GenerateGalaxy();
        player = new Player(Console.askPlayerName());
        
        play();
    }
    
    /**
     *
     * @return
     */
    public IStatus getSatus() 
    {
        return status;
    }
}
