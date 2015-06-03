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

/**
 *
 * @author woozlinux
 */
public class Planet implements Serializable {
    private String name;
    private Resources resource1, resource2;
    private PlanetType type;
    private int waterCost; //Water
    private int foodCost; //Food
    private int medicalCost; //Medical
    private int illegalCost; //Illegal
    private boolean discovered;
    
    @Override
    public boolean equals(Object obj)
    {       
        Planet rhs = (Planet) obj;
        
        return rhs.type == this.type && rhs.name.equals(this.name);

    }
    
    public void setDiscovered(boolean d)
    {
        discovered = d;
    }
    public boolean getDiscovered()
    {
        return discovered;
    }
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
    public int getWaterCost()
    {
        return waterCost;
    }

    /**
     *
     * @return
     */
    public int getFoodCost()
    {
        return foodCost;
    }

    /**
     *
     * @return
     */
    public int getMedicalCost()
    {
        return medicalCost;
    }

    /**
     *
     * @return
     */
    public int getIllegalCost()
    {
        return illegalCost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.type);
        hash = 79 * hash + this.waterCost;
        hash = 79 * hash + this.foodCost;
        hash = 79 * hash + this.medicalCost;
        hash = 79 * hash + this.illegalCost;
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
        discovered = false;
        switch(t)
        {
            case NONPIRATE:
                name = n;
                resource1 = null;
                resource2 = null;
                switch(n)
                {
                    case "Gethen":
                        waterCost = 1;
                        foodCost = 3;
                        medicalCost = 2;
                        illegalCost = 3;
                        break;
                    case "Kiber":
                        waterCost = 3;
                        foodCost = 1;
                        medicalCost = 2;
                        illegalCost = 3;
                        break;
                    case "Reverie":
                        waterCost = 1;
                        foodCost = 2;
                        medicalCost = 3;
                        illegalCost = 3;
                        break;
                    case "Tiamat":
                        waterCost = 3;
                        foodCost = 2;
                        medicalCost = 1;
                        illegalCost = 3;
                        break;
                    case "Lamarckia":
                        waterCost = 2;
                        foodCost = 3;
                        medicalCost = 1;
                        illegalCost = 3;
                        break;
                    case "Arrakis":
                        waterCost = 2;
                        foodCost = 1;
                        medicalCost = 3;
                        illegalCost = 3;
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
                        waterCost = 0;
                        foodCost = 3;
                        medicalCost = 0;
                        illegalCost = 0;
                        break;
                    case "Striterax":
                        waterCost = 0;
                        foodCost = 0;
                        medicalCost = 3;
                        illegalCost = 0;
                        break;
                    case "Asperta":
                        waterCost = 3;
                        foodCost = 0;
                        medicalCost = 0;
                        illegalCost = 0;
                        break;
                }
                break;
            case WORMHOLE:
                name = n;
                resource1 = null;
                resource2 = null;
                waterCost = 0;
                foodCost = 0;
                medicalCost = 0;
                illegalCost = 0;
                break;
                
            case VOID:
                name = "Void";
                resource1 = null;
                resource2 = null;
                waterCost = 0;
                foodCost = 0;
                medicalCost = 0;
                illegalCost = 0;
                break;
            case EMPTY:
                name = "Empty";
                resource1 = null;
                resource2 = null;
                waterCost = 0;
                foodCost = 0;
                medicalCost = 0;
                illegalCost = 0;
                break;
        }
      discovered = false;  
    }
}
