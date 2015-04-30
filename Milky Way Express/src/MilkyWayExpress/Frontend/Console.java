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

import java.util.Scanner;
import java.io.File;

/**
 *
 * @author woozlinux
 */
public interface Console {  
    
    public static void clearConsole(){
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
    
    public static String askPlayerName()
    {
        Scanner scanner = new Scanner(System.in);
        
        clearConsole();
        System.out.print("Insert your name.\n");
        System.out.print("\n[ACTION]: ");
                
        return scanner.nextLine();
    }
    
    public static String loadMenu()
    {
        Scanner scanner = new Scanner(System.in);
        File f;
        
        clearConsole();
        System.out.print("Insert name of save file.\n");
        System.out.print("\n[ACTION]: ");
        String fname = scanner.nextLine().concat(".dat");
        
        f = new File(fname);
        if(f.exists() && !f.isDirectory()) 
        { 
            return fname;
        }
        else
            loadMenu();
        return "";
    }
    
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
    
    public static void getAction()
    {
        
    }
    
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
