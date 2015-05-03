/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MilkyWayExpress.Backend.States;

import MilkyWayExpress.Backend.Game;
import MilkyWayExpress.Frontend.Console;

/**
 *
 * @author woozlinux
 */
public class Movement implements IState {
    private final String stateName = "Movement";
    
    Game game;
    
    public Movement(Game g)
    {
        game = g;
        
        Console.drawGalaxy(game.Galaxy());
        Console.showInfo(game);
    }
    
    @Override
    public IState mainMenu()
    {
        return new MainMenu(game);
    }
    
    @Override
    public IState newGame()
    {
        return new NewGame(game);
    }
    
    @Override
    public IState loadGame()
    {
        return new LoadGame(game);
    }
    
    @Override
    public IState movement()
    {
        return this;
    }
    
    @Override
    public IState options()
    {
        return new Options(game);
    }
    
    @Override
    public String getName()
    {
        return stateName;
    }
}
