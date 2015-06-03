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
import MilkyWayExpress.Backend.States.AwaitsBegin;
import MilkyWayExpress.Backend.States.GameOver;
import MilkyWayExpress.Backend.States.IState;
import MilkyWayExpress.Backend.States.Move;
import MilkyWayExpress.Backend.States.Trade;
import java.io.Serializable;
import java.util.Observable;

/**
 *
 * @author woozlinux
 */
public class GameModel extends Observable implements Serializable {
    
    private IState state;
    
    private Player player;
    private final Galaxy galaxy;
    private final Resources coins;
    private char action;
    private int round;
    
    /**
     *
     */
    public GameModel()
    {
        galaxy = new Galaxy();
        coins = new Coin();
        coins.setCount(20); 
        round = 0;
        setState(new AwaitsBegin(this));
    }
    
    public void startGame(String playerName)
    {
        setState(state.start(playerName));
    }
    
    public void explore()
    {
        setState(state.explore());
    }
    
    public void fillMarkets()
    {
        setState(state.fillMarkets());
    }
    
    public void trade()
    {
        setState(state.trade());
    }
    
    public void move(Coordinate coords)
    {
        if(Player().Spaceship().Coins().getCount() <= 0)
        {
            setState(new GameOver(this));
            return;
        }
        
        Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() - 1);
        round++;
        setState(state.move(coords));
    }
    
    public boolean isTrading()
    {
        return Trade.class.isInstance(state);
    }
    
    public boolean canMove()
    {        
        return Move.class.isInstance(state);
    }
    
    public void update()
    {
        setChanged();
        notifyObservers();
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
    
    private void setState(IState state) 
    {
        this.state = state;
        setChanged();
        notifyObservers();
    }
    
    public void setPlayer(Player player)
    {
        this.player = player;
    }
    
    /**
     *
     * @return
     */
    public IState getState() 
    {
        return state;
    }
}
