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
package MilkyWayExpress.Backend.Player;

import MilkyWayExpress.Backend.Constants;
import MilkyWayExpress.Backend.Coordinate;
import MilkyWayExpress.Backend.Resources.Coin;
import MilkyWayExpress.Backend.Resources.Empty;
import MilkyWayExpress.Backend.Resources.Resource;
import java.io.Serializable;

/**
 *
 * @author woozlinux
 */
public class Spaceship implements Serializable {
    private final Coordinate coords;
    
    private final Cargo cargo;
    private final Weapon weapon;
    
    private Resource resource01;
    private Resource resource02;
    private Resource resource03;
    private final Resource coins;
    
    /**
     *
     */
    public Spaceship()
    {
        coords = new Coordinate(Constants.STARTCOL, Constants.STARTROW);
        cargo = new Cargo();
        weapon = new Weapon();
        coins = new Coin();
        coins.setCount(10);
        
    }
    
    /**
     *
     * @return
     */
    public Cargo Cargo()
    {
        return cargo;
    }
    
    /**
     *
     * @return
     */
    public int upgradeWeapon()
    {
        if(weapon.getLevel() >= 5)
        {
            return -1;
        }
        
        if((coins.getCount() - weapon.getLevel()) >= 0)
        {
            weapon.setLevel(weapon.getLevel() + 1);
            coins.setCount(coins.getCount() - weapon.getLevel());
            return 1;
        }
        return 0;
    }
    
    /**
     *
     * @return
     */
    public int upgradeCargo()
    {
        if(cargo.getLevel() >= 3)
            return -1;
        if((coins.getCount() - cargo.getLevel()) >= 0)
        {
            coins.setCount(coins.getCount() - cargo.getLevel());
            cargo.unlockResource03();
            return 1;
        }
        return 0;
    }
    /**
     *
     * @return
     */
    public Weapon Weapon()
    {
        return weapon;
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
    public Coordinate Coordinates()
    {
        return coords;
    }
}
