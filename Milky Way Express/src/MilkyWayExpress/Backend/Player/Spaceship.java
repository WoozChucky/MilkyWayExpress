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
import MilkyWayExpress.Backend.ResourcesF.Coin;
import MilkyWayExpress.Backend.ResourcesF.Empty;
import MilkyWayExpress.Backend.ResourcesF.Resources;
import java.io.Serializable;

/**
 *
 * @author woozlinux
 */
public class Spaceship implements Serializable {
    private Coordinate coords;
    
    private final WeaponUpgrade wp01;
    private final WeaponUpgrade wp02;
    private final CargoUpgrade cp01;
    
    private final Cargo cargo;
    private final Weapon weapon;
    
    private Resources resource01;
    private Resources resource02;
    private Resources resource03;
    private final Resources coins;
    
    /**
     *
     */
    public Spaceship()
    {
        coords = new Coordinate(Constants.STARTCOL, Constants.STARTROW);
        wp01 = new WeaponUpgrade(4);
        wp02 = new WeaponUpgrade(5);
        cp01 = new CargoUpgrade(3);
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
    public Weapon Weapon()
    {
        return weapon;
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
    public Coordinate Coordinates()
    {
        return coords;
    }
}
