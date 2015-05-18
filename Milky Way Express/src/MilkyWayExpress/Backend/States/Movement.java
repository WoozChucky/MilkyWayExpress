/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MilkyWayExpress.Backend.States;

import MilkyWayExpress.Backend.Game;
import MilkyWayExpress.Frontend.Console;
import java.util.Scanner;

/**
 *
 * @author woozlinux
 */
public final class Movement extends IState {
    private final String stateName = "Movement";

    
    public Movement(Game g)
    {
        super(g);
        Console.drawGalaxy(getGame());
        Console.showInfo(getGame());
        Console.printStateInfo(this);
        
        System.out.println("@ State - " + this.getName());
        
        Scanner s = new Scanner(System.in);
        char c;                
        String option;
 
        while(true){
            option = s.next().toUpperCase();

            if(option.length() >= 1){
                c = option.charAt(0);
            }else{
                c = ' ';
            }

            switch(c){
                case 'M':
                    move();
                case 'S':
                    saveGame();
                case 'O': 
                    options();
                case 'E': 
                    System.exit(0);
                default: 
                    break;
            } 
        }
       
    }
    
    @Override
    public IState mainMenu()
    {
        return this;
    }
    
    @Override
    public IState newGame()
    {
        return this;
    }
    
    @Override
    public IState loadGame()
    {
        return this;
    }
    @Override
    public IState saveGame()
    {
        return new SaveGame(getGame());
    }
    
    @Override
    public IState move()
    {
        return new Move(getGame());
    }
    
    @Override
    public IState movement()
    {
        return this;
    }
    
    @Override
    public IState options()
    {
        return this;
    }
    
    @Override
    public String getName()
    {
        return stateName;
    }
}
