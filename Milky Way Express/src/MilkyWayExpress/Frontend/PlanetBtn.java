/*
 * The MIT License
 *
 * Copyright 2015 woozlinux.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package MilkyWayExpress.Frontend;

import MilkyWayExpress.Backend.Coordinate;
import MilkyWayExpress.Backend.GameModel;
import MilkyWayExpress.Backend.Planets.PlanetType;
import MilkyWayExpress.Backend.Resources.ResourceType;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author woozlinux
 */
class PlanetBtn extends JButton 
{
    GameModel game;
    GameView frm;
    int X, Y;
    
    public PlanetBtn(GameView f, GameModel g, int x, int y)
    {
        frm = f;
        game = g;
        this.X = x;
        this.Y = y;

        //game.Galaxy().getGrid()[Y][X].setDiscovered(false);
        
        if(game.Galaxy().getGrid()[Y][X].getPlanetType() == PlanetType.VOID)
            setEnabled(false);
        else
            try {
                Image img = ImageIO.read(getClass().getResource("Assets/undiscovered.jpg"));
                this.setIcon(new ImageIcon(img));
                setEnabled(true);
            } catch (IOException ex) {}
        
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                f.displayPlanetInfo(game.Galaxy().getGrid()[Y][X], X, Y);

                if(frm.game.isTrading() && game.Player().Spaceship().Coordinates().getX() == X && game.Player().Spaceship().Coordinates().getY() == Y && (game.Galaxy().getGrid()[Y][X].getPlanetType() == PlanetType.NONPIRATE || game.Galaxy().getGrid()[Y][X].getPlanetType() == PlanetType.PIRATE))
                {
                    //Buy zone
                    frm.buyIconLb.setVisible(true);
                    frm.buyBtn1.setVisible(true);
                    frm.buyBtn2.setVisible(true);
                    frm.buyBtn1.setEnabled(false);
                    frm.buyBtn2.setEnabled(false);
                    frm.resLabel1.setVisible(true);
                    frm.resLabel2.setVisible(true);
                    frm.unlockBuyBtn.setVisible(true);
                    frm.unlockBuyBtn.setEnabled(true);
                    
                    //Sell zone
                    frm.sellIconLb.setVisible(true);
                    frm.sellBtn1.setVisible(true);
                    frm.sellBtn2.setVisible(true);
                    frm.sellBtn3.setVisible(true);
                    frm.sellBtn1.setEnabled(true);
                    frm.sellBtn2.setEnabled(true);
                    frm.sellBtn3.setEnabled(true);
                    frm.resLb1.setVisible(true);
                    frm.resLb2.setVisible(true);
                    frm.resLb3.setVisible(true);
                    
                    //set planet to button property
                    frm.buyBtn1.putClientProperty("PlanetInfo", game.Galaxy().getGrid()[Y][X]);
                    frm.buyBtn2.putClientProperty("PlanetInfo", game.Galaxy().getGrid()[Y][X]);
                    
                    frm.sellBtn1.putClientProperty("PlanetInfo", game.Galaxy().getGrid()[Y][X]);
                    frm.sellBtn2.putClientProperty("PlanetInfo", game.Galaxy().getGrid()[Y][X]);
                    frm.sellBtn3.putClientProperty("PlanetInfo", game.Galaxy().getGrid()[Y][X]);
                    
                    
                    //Buy Area
                    if (game.Galaxy().getGrid()[Y][X].getPlanetType() == PlanetType.NONPIRATE) 
                    {
                        frm.resLabel1.setText("Resource 1: " + game.Galaxy().getGrid()[Y][X].getResource01().getName());
                        frm.resLabel2.setText("Resource 2: " + game.Galaxy().getGrid()[Y][X].getResource02().getName());
                        
                        switch(game.Galaxy().getGrid()[Y][X].getResource01().getResourceType())
                        {
                            case WATER:
                                frm.buyBtn1.setText("Buy for " + game.Galaxy().getGrid()[Y][X].getWaterCost() + " coins");
                                break;
                            case FOOD:
                                frm.buyBtn1.setText("Buy for " + game.Galaxy().getGrid()[Y][X].getFoodCost() + " coins");
                                break;
                            case MEDICAL:
                                frm.buyBtn1.setText("Buy for " + game.Galaxy().getGrid()[Y][X].getMedicalCost() + " coins");
                                break;
                        }
                        
                        switch(game.Galaxy().getGrid()[Y][X].getResource02().getResourceType())
                        {
                            case WATER:
                                frm.buyBtn2.setText("Buy for " + game.Galaxy().getGrid()[Y][X].getWaterCost() + " coins");
                                break;
                            case FOOD:
                                frm.buyBtn2.setText("Buy for " + game.Galaxy().getGrid()[Y][X].getFoodCost() + " coins");
                                break;
                            case MEDICAL:
                                frm.buyBtn2.setText("Buy for " + game.Galaxy().getGrid()[Y][X].getMedicalCost() + " coins");
                                break;
                        }
                    }
                    else if (game.Galaxy().getGrid()[Y][X].getPlanetType() == PlanetType.PIRATE)
                    {
                        frm.resLabel1.setText("Resource 1: " + game.Galaxy().getGrid()[Y][X].getResource01().getName());
                        frm.resLabel2.setVisible(false);
                        frm.buyBtn2.setVisible(false);
                        frm.buyBtn1.setText("Buy for " + game.Galaxy().getGrid()[Y][X].getIllegalCost()+ " coins");
                    }
                    
                    
                    //Sell Area
                    if(game.Player().Spaceship().Cargo().getResource01().getResourceType() != ResourceType.EMPTY)
                    {
                        frm.resLb1.setText("Resource 1: " + game.Player().Spaceship().Cargo().getResource01().getName());
                        switch(game.Player().Spaceship().Cargo().getResource01().getResourceType())
                        {
                            case WATER:
                                frm.sellBtn1.setText("Sell for " + game.Galaxy().getGrid()[Y][X].getWaterCost() + " coins");
                                break;
                            case FOOD:
                                frm.sellBtn1.setText("Sell for " + game.Galaxy().getGrid()[Y][X].getFoodCost() + " coins");
                                break;
                            case MEDICAL:
                                frm.sellBtn1.setText("Sell for " + game.Galaxy().getGrid()[Y][X].getMedicalCost() + " coins");
                                break;
                        }
                    }
                    else
                    {
                        frm.resLb1.setText("Resource 1: Empty");
                        frm.sellBtn1.setVisible(false);
                    }
                    
                    if(game.Player().Spaceship().Cargo().getResource02().getResourceType() != ResourceType.EMPTY)
                    {
                        frm.resLb2.setText("Resource 2: " + game.Player().Spaceship().Cargo().getResource02().getName());
                        switch(game.Player().Spaceship().Cargo().getResource02().getResourceType())
                        {
                            case WATER:
                                frm.sellBtn2.setText("Sell for " + game.Galaxy().getGrid()[Y][X].getWaterCost() + " coins");
                                break;
                            case FOOD:
                                frm.sellBtn2.setText("Sell for " + game.Galaxy().getGrid()[Y][X].getFoodCost() + " coins");
                                break;
                            case MEDICAL:
                                frm.sellBtn2.setText("Sell for " + game.Galaxy().getGrid()[Y][X].getMedicalCost() + " coins");
                                break;
                        }
                    }
                    else
                    {
                        frm.resLb2.setText("Resource 2: Empty");
                        frm.sellBtn2.setVisible(false);
                    }
                    if(game.Player().Spaceship().Cargo().getResource03() != null)
                    {
                        frm.resLb3.setText("Resource 3: " + game.Player().Spaceship().Cargo().getResource03().getName());
                        switch(game.Player().Spaceship().Cargo().getResource03().getResourceType())
                        {
                            case WATER:
                                frm.sellBtn3.setText("Sell for " + game.Galaxy().getGrid()[Y][X].getWaterCost() + " coins");
                                break;
                            case FOOD:
                                frm.sellBtn3.setText("Sell for " + game.Galaxy().getGrid()[Y][X].getFoodCost() + " coins");
                                break;
                            case MEDICAL:
                                frm.sellBtn3.setText("Sell for " + game.Galaxy().getGrid()[Y][X].getMedicalCost() + " coins");
                                break;
                        }
                    }
                    else
                    {
                        frm.resLb3.setText("Resource 3: Empty");
                        frm.sellBtn3.setVisible(false);
                    }
                }

                if(frm.game.canMove())
                    frm.game.move(new Coordinate(X, Y));
            }
        });

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if(game.Galaxy().getGrid()[Y][X].getDiscovered() == true)
        {
            switch(game.Galaxy().getGrid()[Y][X].getPlanetType())
            {
                case NONPIRATE:
                switch(game.Galaxy().getGrid()[Y][X].getPlanetName())
                {
                    case "Gethen":
                            try {
                                Image img = ImageIO.read(getClass().getResource("Assets/gethen.jpg"));
                                this.setIcon(new ImageIcon(img));
                            } catch (IOException ex) {}
                    break;
                    case "Kiber":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/kiber.jpg"));
                            this.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;
                    case "Arrakis":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/arrakis.jpg"));
                            this.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;
                    case "Lamarckia":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/lamarckia.jpg"));
                            this.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;
                    case "Tiamat":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/tiamat.jpg"));
                            this.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;
                    case "Reverie":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/reverie.jpg"));
                            this.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;

                }
                setText("");
                break;
                case PIRATE:
                    switch(game.Galaxy().getGrid()[Y][X].getPlanetName())
                    {
                        case "Asperta":
                            try {
                                Image img = ImageIO.read(getClass().getResource("Assets/asperta.jpg"));
                                this.setIcon(new ImageIcon(img));
                            } catch (IOException ex) {}
                        break;
                        case "Striterax":
                            try {
                                Image img = ImageIO.read(getClass().getResource("Assets/striterax.jpg"));
                                this.setIcon(new ImageIcon(img));
                            } catch (IOException ex) {}
                        break;
                        case "Whirl":
                            try {
                                Image img = ImageIO.read(getClass().getResource("Assets/whirl.jpg"));
                                this.setIcon(new ImageIcon(img));
                            } catch (IOException ex) {}
                        break;
                    }
                    setText("");
                    break;
                case WORMHOLE:
                    try {
                        Image img = ImageIO.read(getClass().getResource("Assets/wormhole.jpg"));
                        this.setIcon(new ImageIcon(img));
                    } catch (IOException ex) {}
                    setText("");
                    break;
                case EMPTY:
                    try {
                        Image img = ImageIO.read(getClass().getResource("Assets/empty.jpg"));
                        this.setIcon(new ImageIcon(img));
                    } catch (IOException ex) {}
                    setText("");
                    break;
                case VOID:
                    setEnabled(false);
                    break;
            }
            if(frm.game.Player().Spaceship().Coordinates().getX() == X && frm.game.Player().Spaceship().Coordinates().getY() == Y)
            {
                setText("*"+frm.game.Player().getName()+"*");
            }
        }
    }
}