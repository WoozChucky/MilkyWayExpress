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
import MilkyWayExpress.Backend.Planets.PlanetType;
import MilkyWayExpress.Backend.Planets.Planet;
import MilkyWayExpress.Backend.ResourcesF.Medical;
import MilkyWayExpress.Backend.ResourcesF.Illegal;
import MilkyWayExpress.Backend.ResourcesF.Water;
import MilkyWayExpress.Backend.ResourcesF.Food;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * .
 * The galaxy class contains the grid of {@link Planet}
 * and the manipulation of the game map, its resources
 * and pirate spawns.
 * @version 1.0
 * @author woozlinux
 * 
 */
public class Galaxy implements Serializable {
    
    private final Planet GETHEN;
    private final Planet KIBER;
    private final Planet REVERIE;
    private final Planet TIAMAT;
    private final Planet LAMARCKIA;
    private final Planet ARRAKIS;
    private final Planet WHIRL;
    private final Planet STRITERAX;
    private final Planet ASPERTA;
    private final Planet WORMHOLE01;
    private final Planet WORMHOLE02;
    private final Planet WORMHOLE03;
    private final Planet WORMHOLE04;
    private final Planet VOID;
    private final Planet FILL;
    
    private final ArrayList<Planet> planets;
    
    private final Planet[][] grid;
    
    /**
     *
     */
    public Galaxy()
    {
        GETHEN = new Planet("Gethen", PlanetType.NONPIRATE);
        KIBER = new Planet("Kiber", PlanetType.NONPIRATE);
        REVERIE = new Planet("Reverie", PlanetType.NONPIRATE);
        TIAMAT = new Planet("Tiamat", PlanetType.NONPIRATE);
        LAMARCKIA = new Planet("Lamarckia", PlanetType.NONPIRATE);
        ARRAKIS = new Planet("Arrakis", PlanetType.NONPIRATE);
        WHIRL = new Planet("Whirl", PlanetType.PIRATE);
        STRITERAX = new Planet("Striterax", PlanetType.PIRATE);
        ASPERTA = new Planet("Asperta", PlanetType.PIRATE);
        WORMHOLE01 = new Planet("Wormhole 01", PlanetType.WORMHOLE);
        WORMHOLE02 = new Planet("Wormhole 02", PlanetType.WORMHOLE);
        WORMHOLE03 = new Planet("Wormhole 03", PlanetType.WORMHOLE);
        WORMHOLE04 = new Planet("Wormhole 04", PlanetType.WORMHOLE);
        
        VOID = new Planet("VOID", PlanetType.PIRATE);
        FILL = new Planet("FILL", PlanetType.PIRATE);
        
        planets = new ArrayList<>();
        
        planets.add(GETHEN);
        planets.add(KIBER);
        planets.add(REVERIE);
        planets.add(TIAMAT);
        planets.add(LAMARCKIA);
        planets.add(ARRAKIS);
        planets.add(WHIRL);
        planets.add(STRITERAX);
        planets.add(ASPERTA);
        planets.add(WORMHOLE03);
        planets.add(WORMHOLE04);
        
        grid = new Planet[][] {
         { VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, WORMHOLE02 },
         { VOID, VOID, VOID, FILL, VOID, VOID, VOID, VOID, FILL },
         { VOID, VOID, FILL, FILL, FILL, VOID, FILL, FILL, FILL },
         { VOID, FILL, FILL, FILL, FILL, FILL, FILL, FILL, VOID },
         { FILL, FILL, FILL, VOID, FILL, FILL, FILL, VOID, VOID },
         { FILL, VOID, VOID, VOID, VOID, FILL, VOID, VOID, VOID },
         { WORMHOLE01, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID }
        };
    }
    
    /**
     *
     */
    public void GenerateGalaxy()
    {
        ArrayList<Planet> temp = planets;
        
        int next;
        for(int r = 0; r <= Constants.ROWS; r++)
        {
            for(int c = 0; c <= Constants.COLS; c++)
            {
                if(grid[r][c].equals(FILL))
                {
                    next = Constants.randInt(0, 12);
        
                    switch(next)
                    {
                        case 0:
                            if(temp.contains(GETHEN))
                            {
                                grid[r][c] = GETHEN;
                                temp.remove(GETHEN);
                            }
                            else
                                c--;
                            break;
                        case 1:
                            if(temp.contains(KIBER))
                            {
                                grid[r][c] = KIBER;
                                temp.remove(KIBER);
                            }
                            else
                                c--;
                            break;
                        case 2:
                            if(temp.contains(REVERIE))
                            {
                                grid[r][c] = REVERIE;
                                temp.remove(REVERIE);
                            }
                            else
                                c--;
                            break;
                        case 3:
                            if(temp.contains(TIAMAT))
                            {
                                grid[r][c] = TIAMAT;
                                temp.remove(TIAMAT);
                            }
                            else
                                c--;
                            break;
                        case 4:
                            if(temp.contains(LAMARCKIA))
                            {
                                grid[r][c] = LAMARCKIA;
                                temp.remove(LAMARCKIA);
                            }
                            else
                                c--;
                            break;
                        case 5:
                            if(temp.contains(ARRAKIS))
                            {
                                grid[r][c] = ARRAKIS;
                                temp.remove(ARRAKIS);
                            }
                            else
                                c--;
                            break;
                        case 6:
                            if(temp.contains(WHIRL))
                            {
                                grid[r][c] = WHIRL;
                                temp.remove(WHIRL);
                            }
                            else
                                c--;
                            break;
                        case 7:
                            if(temp.contains(STRITERAX))
                            {
                                grid[r][c] = STRITERAX;
                                temp.remove(STRITERAX);
                            }
                            else
                                c--;
                            break;
                        case 8:
                            if(temp.contains(ASPERTA))
                            {
                                grid[r][c] = ASPERTA;
                                temp.remove(ASPERTA);
                            }
                            else
                                c--;
                            break;
                        case 11:
                            if(temp.contains(WORMHOLE03))
                            {
                                grid[r][c] = WORMHOLE03;
                                temp.remove(WORMHOLE03);
                            }
                            else
                                c--;
                            break;
                        case 12:
                            if(temp.contains(WORMHOLE04))
                            {
                                grid[r][c] = WORMHOLE04;
                                temp.remove(WORMHOLE04);
                            }
                            else
                                c--;
                            break;
                    }
                }
            }
        }  
    }
    
    /**
     *
     */
    public void GenerateResources()
    {
        for(Planet p : planets)
        {
            switch(p.getPlanetType())
            {
                case NONPIRATE:
                    int nextRes01 = MilkyWayExpress.Backend.Constants.randInt(0, 2);
                    int nextRes02 = MilkyWayExpress.Backend.Constants.randInt(0, 2);
                    
                    switch(nextRes01)
                    {
                        case 0:
                            p.setResource01(new Food());
                            break;
                        case 1:
                            p.setResource01(new Water());
                            break;
                        case 2:
                            p.setResource01(new Medical());
                            break;
                    }
                    
                    switch(nextRes02)
                    {
                        case 0:
                            p.setResource02(new Food());
                            break;
                        case 1:
                            p.setResource02(new Water());
                            break;
                        case 2:
                            p.setResource02(new Medical());
                            break;
                    }
                    
                    break;
                case PIRATE:
                    
                    p.setResource01(new Illegal());
                    
                    break;
            }
        }
    }
    
    /**
     *
     * @return
     */
    public Planet[][] getGrid()
    {
        return this.grid;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Planet> getPlanets()
    {
        return planets;
    }
    
    /**
     *
     */
    public void print()
    {
        System.out.println();
        for(int r = 0; r <= Constants.ROWS; r++)
        {
            for(int c = 0; c <= Constants.COLS; c++)
            {
                System.out.print(grid[r][c].getPlanetName() + " | ");
            }
            System.out.println();
        }
    }
    
}
