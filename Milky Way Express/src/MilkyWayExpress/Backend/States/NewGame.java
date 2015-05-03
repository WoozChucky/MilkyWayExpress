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
public class NewGame implements IState {
    private final String stateName = "NewGame";
    
    Game game;
    
    public NewGame(Game g)
    {
        game = g;
        game.Galaxy().GenerateGalaxy();
        game.setPlayer(new Player(Console.askPlayerName()));
        movement();
    }
    
    @Override
    public IState mainMenu()
    {
        return new MainMenu(game);
    }
    
    @Override
    public IState newGame()
    {
        return this;
    }
    
    @Override
    public IState loadGame()
    {
        return new LoadGame(game);
    }
    
    @Override
    public IState movement()
    {
        return new Movement(game);
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
