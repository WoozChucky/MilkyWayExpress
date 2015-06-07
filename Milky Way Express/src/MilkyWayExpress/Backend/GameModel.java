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

import MilkyWayExpress.Backend.Planets.Planet;
import MilkyWayExpress.Backend.Planets.PlanetType;
import MilkyWayExpress.Backend.Player.Player;
import MilkyWayExpress.Backend.Resources.Coin;
import MilkyWayExpress.Backend.Resources.Empty;
import MilkyWayExpress.Backend.Resources.Resource;
import MilkyWayExpress.Backend.Resources.ResourceType;
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
    private final Resource coins;
    private char action;
    private int round;
    private PirateAttack pirateAttack;
    public boolean attackActive;
    
    /**
     *
     */
    public GameModel()
    {
        galaxy = new Galaxy();
        coins = new Coin();
        coins.setCount(20); 
        round = 0;
        pirateAttack = null;
        attackActive = false;
        setState(new AwaitsBegin(this));
    }
    
    public void startGame()
    {
        setState(state.start());
    }
    
    /**
     *
     */
    public void explore()
    {
        setState(state.explore());
    }
    
    /**
     *
     */
    public void fillMarkets()
    {
        setState(state.fillMarkets());
    }
    
    /**
     *
     */
    public void trade()
    {
        setState(state.trade());
    }
    
    public boolean finished()
    {
        for(int r = 0; r <= Constants.ROWS; r++)
        {
            for(int c = 0; c <= Constants.COLS; c++)
            {
                if (Galaxy().getGrid()[r][c].getPlanetType() != PlanetType.VOID)
                    if(!Galaxy().getGrid()[r][c].getDiscovered())
                        return false;
            }
        }
        return true;
    }
    
    public void generatePirateAttacks()
    {
        int rand = Constants.randInt(0, 6);
        
        if(rand==0)
        {
            pirateAttack = new PirateAttack();
            attackActive = true;
        }
    }
    
    public int resolvePirateAttack()
    {
         if(PirateAttack().getAttackPower() <= Player().Spaceship().Weapon().getLevel())
                    {
                        attackActive = false;
                        return 0;
                    }
                    else
                    {
                        attackActive = false;
                        int diff = PirateAttack().getAttackPower() - Player().Spaceship().Weapon().getLevel();
                        Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() - diff);
                        return 1;
                    }
    }
    
    /**
     *
     * @param coords
     * @return
     */
    public boolean movingOneTileOnly(Coordinate coords)
    {
        int nextX = coords.getX();
        int nextY = coords.getY();
        int currentX = Player().Spaceship().Coordinates().getX();
        int currentY = Player().Spaceship().Coordinates().getY();
        boolean validX = false;
        boolean validY = false;
        
        if(currentX + 1 == nextX || currentX - 1 == nextX || currentX == nextX)
            validX = true;
        
        if(currentY + 1 == nextY || currentY - 1 == nextY || currentY == nextY)
            validY = true;
        
        return (validX && validY);
    }
    
    public boolean samePosition(Coordinate coords)
    {
        return (coords.getX() == Player().Spaceship().Coordinates().getX() && coords.getY() == Player().Spaceship().Coordinates().getY());
    }
    
    /**
     *
     * @param coords
     * @return
     */
    public int move(Coordinate coords)
    {
        Coordinate next;
        if(Player().Spaceship().Coins().getCount() <= 0)
        {
            setState(new GameOver(this));
            return 0;
        }
        
        if(samePosition(coords))
            return -1;
        
        if(movingOneTileOnly(coords))
        {
            if(Galaxy().getGrid()[coords.getY()][coords.getX()].getDiscovered() == true)
            {
                if(Galaxy().getGrid()[coords.getY()][coords.getX()].getPlanetType() == PlanetType.WORMHOLE)
                {
                    next = Galaxy().findNextWormhole(coords);
                    if(next == null)
                        return 0;
                    else
                    {
                        setState(state.move(next, true));
                    }

                }
                else
                {
                    Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() - 1);
                    round++;
                    setState(state.move(coords, false));
                }

            }
        }
        else
            return 1;
        return 0;
    }
    
    /**
     *
     * @return
     */
    public boolean isTrading()
    {
        return Trade.class.isInstance(state);
    }
    
    /**
     *
     * @return
     */
    public boolean canMove()
    {        
        return Move.class.isInstance(state);
    }
    
    /**
     *
     * @param p
     * @param which
     * @return
     */
    public int buyResource(Planet p, int which)
    {
        //Return -1 : No space
        //Return 0  : Not enough credits
        //Return 1  : Success
        
        if(which == 1)
        {
            switch(p.getResource01().getResourceType())
                {
                    case WATER:
                        if(Player().canBuy(p.getWaterCost()))
                            if(Player().Buy(p.getWaterCost(), p.getResource01()))
                            {
                                p.setResource01(new Empty());
                                return 1;
                            }
                            else
                                return -1;
                        else
                            return 0;

                    case FOOD:
                        if(Player().canBuy(p.getFoodCost()))
                            if(Player().Buy(p.getFoodCost(), p.getResource01()))
                            {
                                p.setResource01(new Empty());
                                return 1;
                            }
                            else
                                return -1;
                        else
                            return 0;

                    case MEDICAL:
                        if(Player().canBuy(p.getMedicalCost()))
                            if(Player().Buy(p.getMedicalCost(), p.getResource01()))
                            {
                                p.setResource01(new Empty());
                                return 1;
                            }
                            else
                                return -1;
                        else
                            return 0;
                        
                    case ILLEGAL:
                        if(Player().canBuy(p.getIllegalCost()))
                            if(Player().Buy(p.getIllegalCost(), p.getResource01()))
                            {
                                p.setResource01(new Empty());
                                return 1;
                            }
                            else
                                return -1;
                        else
                            return 0;
                }
        }
        else 
        {
            switch(p.getResource02().getResourceType())
                {
                    case WATER:
                        if(Player().canBuy(p.getWaterCost()))
                            if(Player().Buy(p.getWaterCost(), p.getResource02()))
                            {
                                p.setResource02(new Empty());
                                return 1;
                            } 
                            else
                                return -1;
                        else
                            return 0;

                    case FOOD:
                        if(Player().canBuy(p.getFoodCost()))
                            if(Player().Buy(p.getFoodCost(), p.getResource02()))
                            {
                                p.setResource02(new Empty());
                                return 1;
                            }
                            else
                                return -1;
                        else
                            return 0;

                    case MEDICAL:
                        if(Player().canBuy(p.getMedicalCost()))
                            if(Player().Buy(p.getMedicalCost(), p.getResource02()))
                            {
                                p.setResource02(new Empty());
                                return 1;
                            }
                            else
                                return -1;
                        else
                            return 0;                        
                }
        }
        return 1;
    }
    
    /**
     *
     * @param p
     * @param res
     * @param which
     * @return
     */
    public int sellResource(Planet p, Resource res, int which)
    {
     
        switch(which)
        {
            case 1:
                switch(p.getPlanetType())
                {
                    case NONPIRATE:
                        switch(res.getResourceType())
                        {
                            case WATER:
                                Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getWaterCost());
                                Player().Spaceship().Cargo().setResource01(new Empty());
                                return 1;
                            case FOOD:
                                Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getFoodCost());
                                Player().Spaceship().Cargo().setResource01(new Empty());
                                return 1;
                            case MEDICAL:
                                Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getMedicalCost());
                                Player().Spaceship().Cargo().setResource01(new Empty());
                                return 1;
                            case ILLEGAL:
                                Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getIllegalCost());
                                Player().Spaceship().Cargo().setResource01(new Empty());
                                return 1;
                        }
                    break;
                    case PIRATE:
                        switch(p.getPlanetName())
                        {
                            case "Whirl":
                                if(res.getResourceType() == ResourceType.FOOD)
                                {
                                    Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getFoodCost());
                                    Player().Spaceship().Cargo().setResource01(new Empty());
                                    return 1;
                                }
                                return 0;
                            case "Striterax":
                                if(res.getResourceType() == ResourceType.MEDICAL)
                                {
                                    Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getMedicalCost());
                                    Player().Spaceship().Cargo().setResource01(new Empty());
                                    return 1;
                                }
                                return 0;
                            case "Asperta":
                                if(res.getResourceType() == ResourceType.WATER)
                                {
                                    Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getWaterCost());
                                    Player().Spaceship().Cargo().setResource01(new Empty());
                                    return 1;
                                }
                                return 0;
                        }
                    break;
                }
                break;
            case 2:
                switch(p.getPlanetType())
                {
                    case NONPIRATE:
                        switch(res.getResourceType())
                        {
                            case WATER:
                                Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getWaterCost());
                                Player().Spaceship().Cargo().setResource02(new Empty());
                                return 1;
                            case FOOD:
                                Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getFoodCost());
                                Player().Spaceship().Cargo().setResource02(new Empty());
                                return 1;
                            case MEDICAL:
                                Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getMedicalCost());
                                Player().Spaceship().Cargo().setResource02(new Empty());
                                return 1;
                            case ILLEGAL:
                                Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getIllegalCost());
                                Player().Spaceship().Cargo().setResource02(new Empty());
                                return 1;
                        }
                    break;
                    case PIRATE:
                        switch(p.getPlanetName())
                        {
                            case "Whirl":
                                if(res.getResourceType() == ResourceType.FOOD)
                                {
                                    Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getFoodCost());
                                    Player().Spaceship().Cargo().setResource02(new Empty());
                                    return 1;
                                }
                                return 0;
                            case "Striterax":
                                if(res.getResourceType() == ResourceType.MEDICAL)
                                {
                                    Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getMedicalCost());
                                    Player().Spaceship().Cargo().setResource02(new Empty());
                                    return 1;
                                }
                                return 0;
                            case "Asperta":
                                if(res.getResourceType() == ResourceType.WATER)
                                {
                                    Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getWaterCost());
                                    Player().Spaceship().Cargo().setResource02(new Empty());
                                    return 1;
                                }
                                return 0;
                        }
                    break;
                }
                break;
            case 3:
                if(Player().Spaceship().Cargo().isUnlocked())
                    switch(p.getPlanetType())
                    {
                        case NONPIRATE:
                            switch(res.getResourceType())
                            {
                                case WATER:
                                    Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getWaterCost());
                                    Player().Spaceship().Cargo().setResource03(new Empty());
                                    return 1;
                                case FOOD:
                                    Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getFoodCost());
                                    Player().Spaceship().Cargo().setResource03(new Empty());
                                    return 1;
                                case MEDICAL:
                                    Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getMedicalCost());
                                    Player().Spaceship().Cargo().setResource03(new Empty());
                                    return 1;
                                case ILLEGAL:
                                    Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getIllegalCost());
                                    Player().Spaceship().Cargo().setResource03(new Empty());
                                    return 1;
                            }
                        break;
                        case PIRATE:
                            switch(p.getPlanetName())
                            {
                                case "Whirl":
                                    if(res.getResourceType() == ResourceType.FOOD)
                                    {
                                        Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getFoodCost());
                                        Player().Spaceship().Cargo().setResource03(new Empty());
                                        return 1;
                                    }
                                    return 0;
                                case "Striterax":
                                    if(res.getResourceType() == ResourceType.MEDICAL)
                                    {
                                        Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getMedicalCost());
                                        Player().Spaceship().Cargo().setResource03(new Empty());
                                        return 1;
                                    }
                                    return 0;
                                case "Asperta":
                                    if(res.getResourceType() == ResourceType.WATER)
                                    {
                                        Player().Spaceship().Coins().setCount(Player().Spaceship().Coins().getCount() + p.getWaterCost());
                                        Player().Spaceship().Cargo().setResource03(new Empty());
                                        return 1;
                                    }
                                    return 0;
                            }
                        break;
                    }
                else
                    return -1;
                break;
        }
        return 0;
    }
    
    /**
     *
     */
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
    
    public PirateAttack PirateAttack()
    {
        return pirateAttack;
    }

    /**
     *
     * @return
     */
    public Resource Coins()
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
    
    /**
     *
     * @param player
     */
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
