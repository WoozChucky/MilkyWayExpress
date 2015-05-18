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
public class Options implements IState {
    private final String stateName = "Options";
    
    Game game;
    
    public Options(Game g)
    {
        game = g;
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
    public IState saveGame()
    {
        return new SaveGame(game);
    }
    
    @Override
    public IState move()
    {
        return new Move(game);
    }
    
    @Override
    public IState options()
    {
        return this;
    }
    
    @Override
    public IState movement()
    {
        return new Movement(game);
    }
    
    @Override
    public String getName()
    {
        return stateName;
    }
}
