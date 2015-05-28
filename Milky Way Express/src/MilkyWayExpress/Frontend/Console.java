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

import MilkyWayExpress.Backend.Constants;
import MilkyWayExpress.Backend.Game;
import MilkyWayExpress.Backend.Planets.Planet;
import MilkyWayExpress.Backend.States.IState;
import java.util.Scanner;
import java.io.File;

/**
 *
 * @author woozlinux
 */
public interface Console {  
    
    /**
     *
     * @param state
     */
   
    
    public static void drawGalaxy(Game game)
    {
        Planet[][] temp = game.Galaxy().getGrid();
        
        for(int r = 0; r <= Constants.ROWS; r++)
        {
            for(int c = 0; c <= Constants.COLS; c++)
            {
                //Draw spaceship position @ galaxy
                if(game.Player().Spaceship().Coordinates().getX() == c && game.Player().Spaceship().Coordinates().getY() == r)
                    System.out.print(" | " + temp[r][c].getPlanetName() + " * ");
                else
                    System.out.print(" | " + temp[r][c].getPlanetName());
            }
            System.out.println();
        }

    }
    
    public static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
    
    /**
     *
     * @return
     */
    public static String askPlayerName()
    {
        Scanner scanner = new Scanner(System.in);
        
        clearConsole();
        System.out.print("Insert your name.\n");
        System.out.print("\n[ACTION]: ");
                
        return scanner.nextLine();
    }
    
    /**
     *
     * @return
     */
    public static String loadMenu()
    {
        Scanner scanner = new Scanner(System.in);
        File f;
        
        clearConsole();
        System.out.print("Insert name of save file.\n");
        System.out.print("\n[ACTION]: ");
        String fname = scanner.nextLine().concat(".mwe");
        
        
        
        f = new File(fname);
        if(f.exists() && !f.isDirectory()) 
        { 
            return fname;
        }
        else
            loadMenu();
        return "";
    }
    
    /**
     *
     * @return
     */
    public static String saveMenu()
    {
        Scanner scanner = new Scanner(System.in);
        File f;
        
        clearConsole();
        System.out.print("Insert name of save file.\n");
        System.out.print("\n[ACTION]: ");
        return scanner.nextLine().concat(".mwe");
    }
    
    /**
     *
     * @return
     */
    public static int mainMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int resp;
                
        clearConsole();

        System.out.print("\n\n\tMilky Way Express\n\n");

        System.out.print("\tChoose an action:\n\n");
        System.out.print("1 - New Game\n");
        System.out.print("2 - Load Game\n");
        System.out.print("3 - Exit\n");
        System.out.print("\n[ACTION]: ");

        resp = scanner.nextInt();

        while(resp > 3 || resp < 1)
        {
            System.out.print("\n\tChoose an action:\n\n");
            System.out.print("1 - New Game\n");
            System.out.print("2 - Load Game\n");
            System.out.print("3 - Exit\n");  
            System.out.print("\n[ACTION]: ");

            resp = scanner.nextInt();
        }
        return resp;
    }
    
    /**
     *
     * @return
     */
    public static char getAction()
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\n\tChoose an action:\n\n");
        System.out.print("s - Save Game\n");
        System.out.print("q - Quit Game\n");
        System.out.print("t - No Ideia\n");  
        System.out.print("\n[ACTION]: ");

        return scanner.findInLine(".").charAt(0);
    }
    
    /**
     *
     * @param g
     */
    public static void showInfo(Game g)
    {
        System.out.print("\n\tPlayer Information\n\n");
        System.out.print("Name               - " + g.Player().getName() + "\n");
        System.out.print("Credits            - " + g.Player().Spaceship().Coins().getCount() + "\n"); 
        System.out.print("Coordinates(X, Y)  - " + g.Player().Spaceship().Coordinates().getX() +", " + g.Player().Spaceship().Coordinates().getY() + "\n");
        System.out.print("Cargo Level        - " + g.Player().Spaceship().Cargo().getLevel() + "\n");
        System.out.print("Resource 1         - " + g.Player().Spaceship().Cargo().getResource01().getName() + "\n");
        System.out.print("Resource 2         - " + g.Player().Spaceship().Cargo().getResource02().getName() + "\n");
        if(g.Player().Spaceship().Cargo().isUnlocked())
            System.out.print("Resource 3         - " + g.Player().Spaceship().Cargo().getResource03().getName() + "\n");
        System.out.print("Weapon Level       - " + g.Player().Spaceship().Weapon().getLevel() + "\n");
        
        System.out.print("\n\nWorld Information\n\n");
        System.out.print("Round              - " + g.getRound() + "\n");
        System.out.print("Empire's Credit    -" + g.Coins().getCount()+"\n");
    }
    
    /**
     *
     */
    public static void endGame()
    {
        clearConsole();

        System.out.print("\n\n\tMilky Way Express\n\n");
        System.out.print("Your Spaceship has ran out of credits.\n\n");
        System.out.print("\tGame Over\n\n");
        System.out.print("Press any key to quit...");
        
        Scanner scanner = new Scanner(System.in);
        scanner.nextByte();
        
        System.exit(1);
    }
}
