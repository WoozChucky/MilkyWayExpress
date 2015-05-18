/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MilkyWayExpress.Backend.States;

import MilkyWayExpress.Backend.Game;
import MilkyWayExpress.Frontend.Console;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author woozlinux
 */
public final class SaveGame extends IState {
    private final String stateName = "SaveGame";

    
    public SaveGame(Game g)
    {
        super(g);
        
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Console.saveMenu()));
            oos.writeObject(getGame());
            oos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
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
