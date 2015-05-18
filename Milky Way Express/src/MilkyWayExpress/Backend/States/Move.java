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
public final class Move extends IState {
    private final String stateName = "Move";

    
    public Move(Game g)
    {
        super(g);
        
        Console.printStateInfo(this);
        
        System.out.println("@ State - " + this.getName());
        
        Scanner s = new Scanner(System.in);
        int x, y;                
        String option;

        while(!s.hasNextInt()) s.next();
        x = s.nextInt();

        System.out.print("\n[ACTION]: ");

        while(!s.hasNextInt()) s.next();
        y = s.nextInt();
 
        
        getGame().Player().Spaceship().Coordinates().setX(x);
        getGame().Player().Spaceship().Coordinates().setY(y);
        
        movement();
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
        return this;
    }
    
    @Override
    public IState move()
    {
        return this;
    }
    
    @Override
    public IState movement()
    {
        return new Movement(getGame());
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
