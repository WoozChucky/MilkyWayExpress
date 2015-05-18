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
public final class MainMenu extends IState {
    private final String stateName = "MainMenu";

    
    public MainMenu(Game g)
    {
        super(g);
        System.out.println("@ State - " + this.getName());
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
    public IState options()
    {
        return this;
    }
    
    @Override
    public IState movement()
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
    public String getName()
    {
        return stateName;
    }
}
