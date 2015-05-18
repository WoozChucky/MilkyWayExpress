/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MilkyWayExpress.Backend.States;

import MilkyWayExpress.Backend.Game;
import MilkyWayExpress.Frontend.Console;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author woozlinux
 */
public class LoadGame implements IState {
    private final String stateName = "LoadGame";
    
    Game game;
    
    public LoadGame(Game g)
    {
        game = g;
        
        String savefile = Console.loadMenu();
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savefile));
                game = (Game)ois.readObject();
                ois.close();
            } catch(Exception ex) {
                ex.printStackTrace();
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
        return new NewGame(game);
    }
    
    @Override
    public IState loadGame()
    {
        return new LoadGame(game);
    }
    
    @Override
    public IState options()
    {
        return new Options(game);
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

