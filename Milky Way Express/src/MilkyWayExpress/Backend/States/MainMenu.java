/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MilkyWayExpress.Backend.States;

import MilkyWayExpress.Backend.Game;

/**
 *
 * @author woozlinux
 */
public class MainMenu implements IState {
    private final String stateName = "MainMenu";
    
    Game game;
    
    public MainMenu(Game g)
    {
        game = g;
    }
    
    @Override
    public IState mainMenu()
    {
        return this;
    }
    
    @Override
    public IState newGame()
    {
        return new NewGame(game);
    }
    
    @Override
    public IState options()
    {
        return new Options(game);
    }
    
    @Override
    public IState movement()
    {
        return new Movement(game);
    }
    
    @Override
    public IState loadGame()
    {
        return new LoadGame(game);
    }
    
    @Override
    public String getName()
    {
        return stateName;
    }
}
