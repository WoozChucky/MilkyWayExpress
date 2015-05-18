/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MilkyWayExpress.Backend.States;

import MilkyWayExpress.Backend.Game;
import MilkyWayExpress.Backend.Player.Player;
import MilkyWayExpress.Frontend.Console;

/**
 *
 * @author woozlinux
 */
public final class NewGame extends IState {
    private final String stateName = "NewGame";
     
    public NewGame(Game g)
    {
        super(g);
        getGame().Galaxy().GenerateGalaxy();
        getGame().setPlayer(new Player(Console.askPlayerName()));
        
        System.out.println("@ State - " + this.getName());
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
