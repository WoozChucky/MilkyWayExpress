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
package MilkyWayExpress.Backend.States;

import MilkyWayExpress.Backend.GameModel;
import MilkyWayExpress.Backend.Planets.Planet;
import java.io.Serializable;

/**
 *
 * @author woozlinux
 */
public class Explore extends IStateAdapter implements Serializable {

    /**
     *
     * @param g
     */
    public Explore(GameModel g) {
        super(g);
    }
    
    /**
     *
     * @return
     */
    @Override
    public IState explore()
    {     
        //Get coordinates from current player position
        int x = getGame().Player().Spaceship().Coordinates().getX();
        int y = getGame().Player().Spaceship().Coordinates().getY();
        
        Planet[][] grid = getGame().Galaxy().getGrid();

        //Center Screen
        //Y    X 
        if(grid[y][x].getDiscovered() == false)
           getGame().Galaxy().getGrid()[y][x].setDiscovered(true);

        
       //Bottom 
       //Y+1   X
       if(y + 1 >= 0 && y + 1 <= grid.length - 1 && x >= 0 && x <= grid[y].length)
       {
            if(grid[y - 1][x].getDiscovered() == false)
               getGame().Galaxy().getGrid()[y - 1][x].setDiscovered(true);
       }

       //Bottom Right
       //Y+1   X+1
       if(y + 1 >= 0 && y + 1 <= grid.length - 1 && x + 1 >= 0 && x + 1 <= grid[y].length - 1)
       {
           if(grid[y +1][x + 1].getDiscovered() == false)
               getGame().Galaxy().getGrid()[y + 1][x + 1].setDiscovered(true);
       }
       
       //Bottom Left
       //Y+1   X-1
       if(y + 1 >= 0 && y + 1 <= grid.length - 1 && x - 1 >= 0 && x - 1 <= grid[y].length - 1)
       {
           if(grid[y +1][x - 1].getDiscovered() == false)
               getGame().Galaxy().getGrid()[y + 1][x - 1].setDiscovered(true);
       }

       //Top
       //Y-1    X
       if(y - 1 >= 0 && y - 1 <= grid.length - 1 && x >= 0 && x <= grid[y].length - 1){
           if(grid[y - 1][x].getDiscovered() == false)
               getGame().Galaxy().getGrid()[y - 1][x].setDiscovered(true);
       }

       //Top Right
       //Y-1   X+1
       if(y - 1 >= 0 && y - 1 <= grid.length - 1 && x + 1 >= 0 && x + 1 <= grid[y].length - 1){
           if(grid[y - 1][x + 1].getDiscovered() == false)
               getGame().Galaxy().getGrid()[y - 1][x + 1].setDiscovered(true);
       }
       
       //Top Left
       //Y-1   X-1
       if(y - 1 >= 0 && y - 1 <= grid.length - 1 && x -1 >= 0 && x-1 <= grid[y].length - 1){
           if(grid[y - 1][x - 1].getDiscovered() == false)
               getGame().Galaxy().getGrid()[y - 1][x - 1].setDiscovered(true);
       }
    
       //Left
       //Y   X-1
       if(y >= 0 && y <= grid.length -1 && x -1 >= 0 && x-1 <= grid[y].length - 1){
           if(grid[y][x - 1].getDiscovered() == false)
               getGame().Galaxy().getGrid()[y][x - 1].setDiscovered(true);
       }
       
       //Right
       //Y   X+1
       if(y >= 0 && y <= grid.length -1 && x +1 >= 0 && x+1 <= grid[y].length - 1){
           if(grid[y][x + 1].getDiscovered() == false)
               getGame().Galaxy().getGrid()[y][x + 1].setDiscovered(true);
       }
       
       System.out.println(grid.length);
       
       return new ReplenishMarkets(getGame());
    }
    
    
            
}
