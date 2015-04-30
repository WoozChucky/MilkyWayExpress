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
package MilkyWayExpress.Backend.Planets;

import MilkyWayExpress.Backend.ResourcesF.Resources;
import java.io.Serializable;
import java.util.Objects;
import java.lang.Object;

/**
 *
 * @author woozlinux
 */
public class Planet implements Serializable {
    private String name;
    private Resources resource1, resource2;
    private PlanetType type;
    private int CostResource01; //Water
    private int CostResource02; //Food
    private int CostResource03; //Medical
    private int CostResource04; //Illegal
    
    /**
     *
     * @param r
     */
    public void setResource01(Resources r)
    {
        resource1 = r;
    }

    /**
     *
     * @param r
     */
    public void setResource02(Resources r)
    {
        resource2 = r;
    }

    /**
     *
     * @return
     */
    public Resources getResource01()
    {
        return resource1;
    }

    /**
     *
     * @return
     */
    public Resources getResource02()
    {
        return resource2;
    }

    /**
     *
     * @return
     */
    public String getPlanetName()
    {
        return name;
    }

    /**
     *
     * @return
     */
    public PlanetType getPlanetType()
    {
        return type;
    }

    /**
     *
     * @return
     */
    public int getResourceCost01()
    {
        return CostResource01;
    }

    /**
     *
     * @return
     */
    public int getResourceCost02()
    {
        return CostResource02;
    }

    /**
     *
     * @return
     */
    public int getResourceCost03()
    {
        return CostResource03;
    }

    /**
     *
     * @return
     */
    public int getResourceCost04()
    {
        return CostResource04;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            { return false; }
        if (obj == this)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.type);
        hash = 79 * hash + this.CostResource01;
        hash = 79 * hash + this.CostResource02;
        hash = 79 * hash + this.CostResource03;
        hash = 79 * hash + this.CostResource04;
        return hash;
    }
    
    /**
     *
     * @param n
     * @param t
     */
    public Planet(String n, PlanetType t)
    {
        this.type = t;
        switch(t)
        {
            case NONPIRATE:
                name = n;
                resource1 = null;
                resource2 = null;
                switch(n)
                {
                    case "Gethen":
                        CostResource01 = 0;
                        CostResource02 = 3;
                        CostResource03 = 0;
                        CostResource04 = 0;
                        break;
                    case "Kiber":
                        CostResource01 = 0;
                        CostResource02 = 0;
                        CostResource03 = 3;
                        CostResource04 = 0;
                        break;
                    case "Reverie":
                        CostResource01 = 3;
                        CostResource02 = 0;
                        CostResource03 = 0;
                        CostResource04 = 0;
                        break;
                    case "Tiamat":
                        CostResource01 = 0;
                        CostResource02 = 3;
                        CostResource03 = 0;
                        CostResource04 = 0;
                        break;
                    case "Lamarckia":
                        CostResource01 = 0;
                        CostResource02 = 0;
                        CostResource03 = 3;
                        CostResource04 = 0;
                        break;
                    case "Arrakis":
                        CostResource01 = 3;
                        CostResource02 = 0;
                        CostResource03 = 0;
                        CostResource04 = 0;
                        break;
                }
                break;
            case PIRATE:
                name = n;
                resource1 = null;
                resource2 = null;
                switch(n)
                {
                    case "Whirl":
                        CostResource01 = 0;
                        CostResource02 = 3;
                        CostResource03 = 0;
                        CostResource04 = 0;
                        break;
                    case "Striterax":
                        CostResource01 = 0;
                        CostResource02 = 0;
                        CostResource03 = 3;
                        CostResource04 = 0;
                        break;
                    case "Asperta":
                        CostResource01 = 3;
                        CostResource02 = 0;
                        CostResource03 = 0;
                        CostResource04 = 0;
                        break;
                }
                break;
            case WORMHOLE:
                name = n;
                resource1 = null;
                resource2 = null;
                CostResource01 = 0;
                CostResource02 = 0;
                CostResource03 = 0;
                CostResource04 = 0;
                break;
        }
        
    }
}
