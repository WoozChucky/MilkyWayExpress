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

import MilkyWayExpress.Backend.Constants;
import MilkyWayExpress.Backend.GameModel;
import MilkyWayExpress.Backend.Planets.Planet;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author woozlinux
 */
public final class GameView extends javax.swing.JFrame implements Observer {

    /**
     *
     */
    public GameModel game;
    
    /**
     * Creates new form GameForm
     * @param g
     */
    public GameView(GameModel g) {
        initComponents();
        game = g;
        game.addObserver(this);
        prepareComponents();
    }

    /**
     *
     */
    public void prepareComponents()
    {
        this.getRootPane().setDefaultButton(AdvanceStateBtn);
        
        //PlayerInfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        
        //Planet zone
        planetNameLb.setVisible(false);
        plantTypeLb.setVisible(false);
        res1Lb.setVisible(false);
        res2Lb.setVisible(false);
        coordinatesLb.setVisible(false);
        discoveredLb.setVisible(false);
        jButton1.setVisible(false);
        
        //Buy zone
        buyIconLb.setVisible(false);
        buyBtn1.setVisible(false);
        buyBtn2.setVisible(false);
        resLabel1.setVisible(false);
        resLabel2.setVisible(false);
        unlockBuyBtn.setVisible(false);
        
        //jLabel10.setVisible(false);
        //jLabel2.setVisible(false);
        
        //Sell zone
        sellIconLb.setVisible(false);
        sellBtn1.setVisible(false);
        sellBtn2.setVisible(false);
        sellBtn3.setVisible(false);
        resLb1.setVisible(false);
        resLb2.setVisible(false);
        resLb3.setVisible(false);

        try {
            Image img = ImageIO.read(getClass().getResource("Assets/spaceship.jpg"));
            spaceshipLabel.setText("");
            spaceshipLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {}
        
        board.setLayout(new GridLayout(7, 9));
         for(int i=0;i<= Constants.ROWS;i++)
                for(int j=0; j<= Constants.COLS; j++)
                    board.add(new PlanetBtn(this, game, j, i));

        StateLabel.setText("STATE: " + game.getState().getClass().getSimpleName());
    }
    
    /**
     *
     */
    public void hideTradeOptions()
    {
        //Buy zone
        buyIconLb.setVisible(false);
        buyBtn1.setVisible(false);
        buyBtn2.setVisible(false);
        resLabel1.setVisible(false);
        resLabel2.setVisible(false);
        unlockBuyBtn.setVisible(false);
        
        //Sell zone
        sellIconLb.setVisible(false);
        sellBtn1.setVisible(false);
        sellBtn2.setVisible(false);
        sellBtn3.setVisible(false);
        resLb1.setVisible(false);
        resLb2.setVisible(false);
        resLb3.setVisible(false);
    }
    
    /**
     *
     * @param p
     * @param x
     * @param y
     */
    public void displayPlanetInfo(Planet p, int x, int y)
    {
        if(p.getDiscovered() == true)
        {
            PlanetPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
            planetNameLb.setVisible(true);
            planetNameLb.setText("Name: " + p.getPlanetName());

            plantTypeLb.setVisible(true);
            plantTypeLb.setText("Type: " + p.getPlanetType().toString());

            res1Lb.setVisible(true);
            if(p.getResource01() != null)
                res1Lb.setText("Resource 1: " + p.getResource01().getClass().getSimpleName());
            else
                res1Lb.setText("Resource 1: Empty");

            res2Lb.setVisible(true);
            if(p.getResource02() != null)
                res2Lb.setText("Resource 2: " + p.getResource02().getClass().getSimpleName());
            else
                res2Lb.setText("Resource 2: Empty");

            coordinatesLb.setVisible(true);
            coordinatesLb.setText("Coordinates(X,Y): " + x + "," + y);

            discoveredLb.setVisible(true);
            discoveredLb.setText("Discovered: " + p.getDiscovered());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlayerInfoPanel = new javax.swing.JPanel();
        titleLb = new javax.swing.JLabel();
        creditsLb = new javax.swing.JLabel();
        coordinatesLB = new javax.swing.JLabel();
        cargoLevelLb = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        weaponLb = new javax.swing.JLabel();
        iconLb1 = new javax.swing.JLabel();
        iconLb2 = new javax.swing.JLabel();
        iconLb3 = new javax.swing.JLabel();
        board = new javax.swing.JPanel();
        AdvanceStateBtn = new javax.swing.JButton();
        spaceshipLabel = new javax.swing.JLabel();
        PlanetPanel = new javax.swing.JPanel();
        planetNameLb = new javax.swing.JLabel();
        plantTypeLb = new javax.swing.JLabel();
        res1Lb = new javax.swing.JLabel();
        res2Lb = new javax.swing.JLabel();
        coordinatesLb = new javax.swing.JLabel();
        discoveredLb = new javax.swing.JLabel();
        buyBtn2 = new javax.swing.JButton();
        buyBtn1 = new javax.swing.JButton();
        resLabel2 = new javax.swing.JLabel();
        resLabel1 = new javax.swing.JLabel();
        buyIconLb = new javax.swing.JLabel();
        sellIconLb = new javax.swing.JLabel();
        resLb1 = new javax.swing.JLabel();
        resLb2 = new javax.swing.JLabel();
        sellBtn1 = new javax.swing.JButton();
        sellBtn2 = new javax.swing.JButton();
        resLb3 = new javax.swing.JLabel();
        sellBtn3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        unlockBuyBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        StateLabel = new javax.swing.JLabel();
        upgradeWeaponBtn = new javax.swing.JButton();
        upgradeCargoBtn = new javax.swing.JButton();
        Menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Milky Way Express");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        titleLb.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        titleLb.setForeground(new java.awt.Color(24, 25, 224));
        titleLb.setText("Player Information");

        creditsLb.setText("Credits");

        coordinatesLB.setText("Coordinates (X, Y)");

        cargoLevelLb.setText("Cargo Level");

        jLabel6.setText("Resource 1");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setText("Resource 2");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel8.setText("Resource 3");
        jLabel8.setToolTipText("");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        weaponLb.setText("Weapon Level");
        weaponLb.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout PlayerInfoPanelLayout = new javax.swing.GroupLayout(PlayerInfoPanel);
        PlayerInfoPanel.setLayout(PlayerInfoPanelLayout);
        PlayerInfoPanelLayout.setHorizontalGroup(
            PlayerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlayerInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PlayerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlayerInfoPanelLayout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(titleLb)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PlayerInfoPanelLayout.createSequentialGroup()
                        .addGroup(PlayerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(weaponLb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coordinatesLB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cargoLevelLb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(creditsLb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                        .addGroup(PlayerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PlayerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconLb1)
                            .addComponent(iconLb2)
                            .addComponent(iconLb3))
                        .addGap(107, 107, 107))))
        );
        PlayerInfoPanelLayout.setVerticalGroup(
            PlayerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlayerInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PlayerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlayerInfoPanelLayout.createSequentialGroup()
                        .addComponent(creditsLb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coordinatesLB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cargoLevelLb))
                    .addGroup(PlayerInfoPanelLayout.createSequentialGroup()
                        .addGroup(PlayerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(iconLb1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PlayerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(iconLb2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PlayerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(iconLb3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(weaponLb)
                .addContainerGap())
        );

        javax.swing.GroupLayout boardLayout = new javax.swing.GroupLayout(board);
        board.setLayout(boardLayout);
        boardLayout.setHorizontalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        boardLayout.setVerticalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        AdvanceStateBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        AdvanceStateBtn.setText("Next State");
        AdvanceStateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdvanceStateBtnActionPerformed(evt);
            }
        });

        spaceshipLabel.setText("jLabel10");

        PlanetPanel.setToolTipText("Planet Information");
        PlanetPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PlanetPanel.setName("Planet Information"); // NOI18N

        planetNameLb.setText("jLabel10");

        plantTypeLb.setText("jLabel11");

        res1Lb.setText("jLabel12");

        res2Lb.setText("jLabel13");

        coordinatesLb.setText("jLabel14");

        discoveredLb.setText("jLabel15");

        buyBtn2.setText("jButton2");
        buyBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyBtn2ActionPerformed(evt);
            }
        });

        buyBtn1.setText("jButton1");
        buyBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyBtn1ActionPerformed(evt);
            }
        });

        resLabel2.setText("jLabel5");

        resLabel1.setText("jLabel4");

        buyIconLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MilkyWayExpress/Frontend/Assets/buy.png"))); // NOI18N

        sellIconLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MilkyWayExpress/Frontend/Assets/sell.png"))); // NOI18N

        resLb1.setText("jLabel16");

        resLb2.setText("jLabel17");

        sellBtn1.setText("jButton1");
        sellBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellBtn1ActionPerformed(evt);
            }
        });

        sellBtn2.setText("jButton2");
        sellBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellBtn2ActionPerformed(evt);
            }
        });

        resLb3.setText("jLabel10");

        sellBtn3.setText("jButton3");
        sellBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellBtn3ActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        unlockBuyBtn.setText("Unlock Buy");
        unlockBuyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unlockBuyBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PlanetPanelLayout = new javax.swing.GroupLayout(PlanetPanel);
        PlanetPanel.setLayout(PlanetPanelLayout);
        PlanetPanelLayout.setHorizontalGroup(
            PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlanetPanelLayout.createSequentialGroup()
                .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlanetPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(planetNameLb)
                            .addComponent(discoveredLb)
                            .addComponent(plantTypeLb)
                            .addComponent(res1Lb)
                            .addComponent(res2Lb)
                            .addComponent(coordinatesLb)))
                    .addComponent(jButton1))
                .addGap(99, 99, 99)
                .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlanetPanelLayout.createSequentialGroup()
                        .addComponent(unlockBuyBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PlanetPanelLayout.createSequentialGroup()
                        .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resLabel1)
                            .addComponent(buyIconLb)
                            .addComponent(resLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buyBtn1)
                            .addComponent(buyBtn2))
                        .addGap(52, 52, 52)
                        .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PlanetPanelLayout.createSequentialGroup()
                                .addComponent(resLb3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sellBtn3))
                            .addGroup(PlanetPanelLayout.createSequentialGroup()
                                .addComponent(resLb2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sellBtn2))
                            .addComponent(sellIconLb)
                            .addGroup(PlanetPanelLayout.createSequentialGroup()
                                .addComponent(resLb1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sellBtn1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PlanetPanelLayout.setVerticalGroup(
            PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlanetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlanetPanelLayout.createSequentialGroup()
                        .addComponent(planetNameLb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plantTypeLb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(res1Lb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(res2Lb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coordinatesLb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discoveredLb))
                    .addGroup(PlanetPanelLayout.createSequentialGroup()
                        .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PlanetPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(resLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(buyBtn1)))
                            .addComponent(buyIconLb)
                            .addGroup(PlanetPanelLayout.createSequentialGroup()
                                .addComponent(sellIconLb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(resLb1)
                                    .addComponent(sellBtn1)
                                    .addComponent(jLabel1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(resLabel2)
                                .addComponent(buyBtn2)
                                .addComponent(jLabel10))
                            .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(resLb2)
                                .addComponent(jLabel3)
                                .addComponent(sellBtn2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resLb3)
                            .addComponent(jLabel4)
                            .addComponent(sellBtn3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PlanetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(unlockBuyBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        StateLabel.setFont(new java.awt.Font("Ubuntu Medium", 1, 24)); // NOI18N
        StateLabel.setForeground(new java.awt.Color(41, 63, 226));
        StateLabel.setText("jLabel16");

        upgradeWeaponBtn.setText("Upgrade Weapon");
        upgradeWeaponBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upgradeWeaponBtnActionPerformed(evt);
            }
        });

        upgradeCargoBtn.setText("Upgrade Cargo");
        upgradeCargoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upgradeCargoBtnActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem6.setText("Main Menu");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("New Game");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Save Game");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        Menu.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem4.setText("About");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Scores");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        Menu.add(jMenu2);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PlayerInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdvanceStateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(75, 75, 75))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PlanetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(upgradeCargoBtn)
                            .addComponent(upgradeWeaponBtn)
                            .addComponent(spaceshipLabel))
                        .addContainerGap(134, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PlayerInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(StateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdvanceStateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(board, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spaceshipLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upgradeWeaponBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upgradeCargoBtn))
                    .addComponent(PlanetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        PlanetPanel.getAccessibleContext().setAccessibleName("Planet Information");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showGameInfo(GameModel g, JLabel credits, JLabel coordinates, JLabel cargolevel, JLabel res1, JLabel res2, JLabel res3, JLabel weaponlevel)
    {
        credits.setText("Credits - " + g.Player().Spaceship().Coins().getCount()); 
        coordinates.setText("Coordinates(X, Y) - " + g.Player().Spaceship().Coordinates().getX() +", " + g.Player().Spaceship().Coordinates().getY());
        cargolevel.setText("Cargo Level - " + g.Player().Spaceship().Cargo().getLevel());
        res1.setText("Resource 1 -");
        res2.setText("Resource 2 -");
        if(g.Player().Spaceship().Cargo().isUnlocked())
            res3.setText(" Resource 3 -");
        else
            res3.setText(" Resource 3 - Locked");
        weaponlevel.setText(" Weapon Level - " + g.Player().Spaceship().Weapon().getLevel());
        
        switch(g.Player().Spaceship().Cargo().getResource01().getResourceType())
        {
            case EMPTY:
                try {
                    Image img = ImageIO.read(getClass().getResource("Assets/white_cube.gif"));
                    iconLb1.setIcon(new ImageIcon(img));
                    setEnabled(true);
                } catch (IOException ex) {}
                break;
            case FOOD:
                try {
                    Image img = ImageIO.read(getClass().getResource("Assets/yellow_cube.png"));
                    iconLb1.setIcon(new ImageIcon(img));
                    setEnabled(true);
                } catch (IOException ex) {}
                break;
            case MEDICAL:
                try {
                    Image img = ImageIO.read(getClass().getResource("Assets/red_cube.png"));
                    iconLb1.setIcon(new ImageIcon(img));
                    setEnabled(true);
                } catch (IOException ex) {}
                break;
            case WATER:
                try {
                    Image img = ImageIO.read(getClass().getResource("Assets/blue_cube.png"));
                    iconLb1.setIcon(new ImageIcon(img));
                    setEnabled(true);
                } catch (IOException ex) {}
                break;
            case ILLEGAL:
                try {
                    Image img = ImageIO.read(getClass().getResource("Assets/black_cube.png"));
                    iconLb1.setIcon(new ImageIcon(img));
                    setEnabled(true);
                } catch (IOException ex) {}
                break;
        }
        
        switch(g.Player().Spaceship().Cargo().getResource02().getResourceType())
        {
            case EMPTY:
                try {
                    Image img = ImageIO.read(getClass().getResource("Assets/white_cube.gif"));
                    iconLb2.setIcon(new ImageIcon(img));
                    setEnabled(true);
                } catch (IOException ex) {}
                break;
            case FOOD:
                try {
                    Image img = ImageIO.read(getClass().getResource("Assets/yellow_cube.png"));
                    iconLb2.setIcon(new ImageIcon(img));
                    setEnabled(true);
                } catch (IOException ex) {}
                break;
            case MEDICAL:
                try {
                    Image img = ImageIO.read(getClass().getResource("Assets/red_cube.png"));
                    iconLb2.setIcon(new ImageIcon(img));
                    setEnabled(true);
                } catch (IOException ex) {}
                break;
            case WATER:
                try {
                    Image img = ImageIO.read(getClass().getResource("Assets/blue_cube.png"));
                    iconLb2.setIcon(new ImageIcon(img));
                    setEnabled(true);
                } catch (IOException ex) {}
                break;
            case ILLEGAL:
                try {
                    Image img = ImageIO.read(getClass().getResource("Assets/black_cube.png"));
                    iconLb2.setIcon(new ImageIcon(img));
                    setEnabled(true);
                } catch (IOException ex) {}
                break;
        }
        
        if(g.Player().Spaceship().Cargo().isUnlocked())
            switch(g.Player().Spaceship().Cargo().getResource03().getResourceType())
            {
                case EMPTY:
                    try {
                        Image img = ImageIO.read(getClass().getResource("Assets/white_cube.gif"));
                        iconLb3.setIcon(new ImageIcon(img));
                        setEnabled(true);
                    } catch (IOException ex) {}
                    break;
                case FOOD:
                    try {
                        Image img = ImageIO.read(getClass().getResource("Assets/yellow_cube.png"));
                        iconLb3.setIcon(new ImageIcon(img));
                        setEnabled(true);
                    } catch (IOException ex) {}
                    break;
                case MEDICAL:
                    try {
                        Image img = ImageIO.read(getClass().getResource("Assets/red_cube.png"));
                        iconLb3.setIcon(new ImageIcon(img));
                        setEnabled(true);
                    } catch (IOException ex) {}
                    break;
                case WATER:
                    try {
                        Image img = ImageIO.read(getClass().getResource("Assets/blue_cube.png"));
                        iconLb3.setIcon(new ImageIcon(img));
                        setEnabled(true);
                    } catch (IOException ex) {}
                    break;
                case ILLEGAL:
                    try {
                        Image img = ImageIO.read(getClass().getResource("Assets/black_cube.png"));
                        iconLb3.setIcon(new ImageIcon(img));
                        setEnabled(true);
                    } catch (IOException ex) {}
                    break;
            }
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(game.Player() == null)
        {   //New GameModel
            game.startGame();
        }     
        showGameInfo(game, creditsLb, coordinatesLB,
                cargoLevelLb, jLabel6, jLabel7, jLabel8, weaponLb);
    }//GEN-LAST:event_formWindowActivated
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String saveName = JOptionPane.showInputDialog(this, "Insert file name:", "Save Game");
        saveName = saveName.concat(".mwe");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveName));
            oos.writeObject(game);
            oos.close();
            JOptionPane.showMessageDialog(this, "Game saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void AdvanceStateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdvanceStateBtnActionPerformed
        String ObjButtons[] = {"Yes","No"};
        
        switch(StateLabel.getText())
        {
            case "STATE: Explore":
                if(game.Finished())
                    if(game.won())
                    {
                        int PromptResult = JOptionPane.showOptionDialog(this,
                        "Congratulations! You successfully explored and the milky way galaxy and payed the loan of 10 credits.\n\nRounds:" + game.getRound() + "\nFinal Score: " + (game.Player().Spaceship().Coins().getCount() - 10) + "\n\nDo you want to save the score?",
                        "Victory",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                        ObjButtons,ObjButtons[0]);
                        
                        if(PromptResult == 0)
                        {
                            try {
                                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Score.txt", true)));
                                
                                String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
                                
                                out.println(date + " - " + (game.Player().Spaceship().Coins().getCount() - 10) + " - " + game.getRound());
                                out.flush();
                                out.close();
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.exit(0);
                        }
                        else
                            System.exit(0);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,
                        "Game Over! You successfully explored and the milky way galaxy but couldn't pay the loan of 10 credits.\n\nRounds:" + game.getRound() + "\nFinal Score: " + (game.Player().Spaceship().Coins().getCount() - 10),
                        "Defeat",
                        JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                game.explore();
                break;
            case "STATE: ReplenishMarkets":
                game.fillMarkets();
                if(game.attackActive)
                {
                    JOptionPane.showMessageDialog(this,
                    "A pirate attack is incoming! They have " + game.PirateAttack().getAttackPower() + " attack and you have " + game.Player().Spaceship().Weapon().getLevel() + " attack.",
                    "Pirate Attack",
                    JOptionPane.WARNING_MESSAGE);
                    
                    switch(game.resolvePirateAttack())
                    {
                        case 0:
                            JOptionPane.showMessageDialog(this,
                            "The pirates were defeated!",
                            "Victory",
                            JOptionPane.INFORMATION_MESSAGE);
                            break;
                            
                        case 1:
                            JOptionPane.showMessageDialog(this,
                            "The pirates won. You lost " + (game.PirateAttack().getAttackPower() - game.Player().Spaceship().Weapon().getLevel()) + " credits to pay the ransom!",
                            "Defeat",
                            JOptionPane.INFORMATION_MESSAGE);
                            break;
                    }
                }
                break;
            case "STATE: Trade":
                game.trade();
                showGameInfo(game, creditsLb, coordinatesLB,
                cargoLevelLb, jLabel6, jLabel7, jLabel8, weaponLb);
                hideTradeOptions();
                break;
            case "STATE: GameOver":
                int PromptResult = JOptionPane.showOptionDialog(null,
                "You lost all your credits and didn't explore the galaxy! Try again?", "Game Over",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                ObjButtons,ObjButtons[0]);
            
                if(PromptResult ==0)
                {
                    game = null;
                    RenderEngine.openForm(this, new MainMenu());
                }
                else
                {
                    System.exit(0);
                }
                break;
        }
    }//GEN-LAST:event_AdvanceStateBtnActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
            if(AdvanceStateBtn.isEnabled())
                AdvanceStateBtn.doClick();
    }//GEN-LAST:event_formKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        RenderEngine.openForm(this, new MainMenu());
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(null, 
            "Are you sure you want to exit?", "Milky Way Express", 
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
            ObjButtons,ObjButtons[1]);
        if(PromptResult==0)
        {
          System.exit(0);          
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void buyBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyBtn2ActionPerformed

        Planet planet = (Planet)((JButton)evt.getSource()).getClientProperty("PlanetInfo");
        
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(null,
            "Are you sure you want to buy?", "Milky Way Express",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
            ObjButtons,ObjButtons[1]);
        if(PromptResult==0)
        {
            switch(game.buyResource(planet, 2))
            {
                case -1:
                    JOptionPane.showMessageDialog(this, "Not enough cargo space, please upgrade!");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(this, "Not enough credits!");
                    break;
                case 1:
                    buyBtn2.setEnabled(false);
                    JOptionPane.showMessageDialog(this, "Success!");
                    break;
            }
        }
    }//GEN-LAST:event_buyBtn2ActionPerformed

    private void buyBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyBtn1ActionPerformed
        
        Planet planet = (Planet)((JButton)evt.getSource()).getClientProperty("PlanetInfo");
        
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(null,
            "Are you sure you want to buy?", "Milky Way Express",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
            ObjButtons,ObjButtons[1]);
        if(PromptResult==0)
        {
            switch(game.buyResource(planet, 1))
            {
                case -1:
                    JOptionPane.showMessageDialog(this, "Not enough cargo space, please upgrade!");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(this, "Not enough credits!");
                    break;
                case 1:
                    buyBtn1.setEnabled(false);
                    JOptionPane.showMessageDialog(this, "Success!");
                    break;
            }
        }
    }//GEN-LAST:event_buyBtn1ActionPerformed

    private void sellBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellBtn1ActionPerformed
        Planet planet = (Planet)((JButton)evt.getSource()).getClientProperty("PlanetInfo");
        
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(null,
            "Are you sure you want to sell?", "Milky Way Express",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
            ObjButtons,ObjButtons[1]);
        if(PromptResult==0)
        {
            switch(game.sellResource(planet, game.Player().Spaceship().Cargo().getResource01(), 1))
            {
                case -1:
                    JOptionPane.showMessageDialog(this, "That cargo space is locked!");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(this, "Can't sell that resource to that planet!");
                    break;
                case 1:
                    sellBtn1.setEnabled(false);
                    JOptionPane.showMessageDialog(this, "Success!");
                    break;
            }
        }
    }//GEN-LAST:event_sellBtn1ActionPerformed

    private void sellBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellBtn2ActionPerformed
        Planet planet = (Planet)((JButton)evt.getSource()).getClientProperty("PlanetInfo");
        
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(null,
            "Are you sure you want to sell?", "Milky Way Express",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
            ObjButtons,ObjButtons[1]);
        if(PromptResult==0)
        {
            switch(game.sellResource(planet, game.Player().Spaceship().Cargo().getResource02(), 2))
            {
                case -1:
                    JOptionPane.showMessageDialog(this, "That cargo space is locked!");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(this, "Can't sell that resource to that planet!");
                    break;
                case 1:
                    sellBtn2.setEnabled(false);
                    JOptionPane.showMessageDialog(this, "Success!");
                    break;
            }
        }
    }//GEN-LAST:event_sellBtn2ActionPerformed

    private void sellBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellBtn3ActionPerformed
        Planet planet = (Planet)((JButton)evt.getSource()).getClientProperty("PlanetInfo");
        
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(null,
            "Are you sure you want to sell?", "Milky Way Express",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
            ObjButtons,ObjButtons[1]);
        if(PromptResult==0)
        {
            switch(game.sellResource(planet, game.Player().Spaceship().Cargo().getResource03(), 3))
            {
                case -1:
                    JOptionPane.showMessageDialog(this, "That cargo space is locked!");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(this, "Can't sell that resource to that planet!");
                    break;
                case 1:
                    sellBtn3.setEnabled(false);
                    JOptionPane.showMessageDialog(this, "Success!");
                    break;
            }
        }
    }//GEN-LAST:event_sellBtn3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        game.Player().Spaceship().Coins().setCount(game.Player().Spaceship().Coins().getCount() + 5); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void unlockBuyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unlockBuyBtnActionPerformed
        sellBtn1.setEnabled(false);
        sellBtn2.setEnabled(false);
        sellBtn3.setEnabled(false);
        buyBtn1.setEnabled(true);
        buyBtn2.setEnabled(true);
        unlockBuyBtn.setEnabled(false);
    }//GEN-LAST:event_unlockBuyBtnActionPerformed

    private void upgradeWeaponBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upgradeWeaponBtnActionPerformed
        if(game.isTrading())
        {
            String ObjButtons[] = {"Yes","No"};
            int PromptResult = JOptionPane.showOptionDialog(null,
                "Are you sure you want to buy weapon upgrade for " + game.Player().Spaceship().Weapon().getLevel() + " credits ?", "Milky Way Express",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                ObjButtons,ObjButtons[1]);
            if(PromptResult==0)
            {
                switch(game.Player().Spaceship().upgradeWeapon())
                {
                   case -1:
                       JOptionPane.showMessageDialog(this, "Already at max level!");
                       break;
                   case 0:
                       JOptionPane.showMessageDialog(this, "Not enough credits!");
                       break;
                   case 1:
                       JOptionPane.showMessageDialog(this, "Success!");
                       if(game.Player().Spaceship().Weapon().getLevel() == 5)
                           upgradeWeaponBtn.setEnabled(false);
                       break;
                }
            }
        }
        else
            JOptionPane.showMessageDialog(this, "You have to be in trade state to upgrade spaceship!");
    }//GEN-LAST:event_upgradeWeaponBtnActionPerformed

    private void upgradeCargoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upgradeCargoBtnActionPerformed
        if(game.isTrading())
        {
            String ObjButtons[] = {"Yes","No"};
            int PromptResult = JOptionPane.showOptionDialog(null,
                "Are you sure you want to buy cargo upgrade for " + game.Player().Spaceship().Cargo().getLevel() + " credits ?", "Milky Way Express",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                ObjButtons,ObjButtons[1]);
            if(PromptResult==0)
            {
                switch(game.Player().Spaceship().upgradeCargo())
                {
                   case -1:
                       JOptionPane.showMessageDialog(this, "Already at max level!");
                       break;
                   case 0:
                       JOptionPane.showMessageDialog(this, "Not enough credits!");
                       break;
                   case 1:
                       JOptionPane.showMessageDialog(this, "Success!");
                       upgradeCargoBtn.setEnabled(false);
                       break;
                }
            }
        }
        else
            JOptionPane.showMessageDialog(this, "You have to be in trade state to upgrade spaceship!");
    }//GEN-LAST:event_upgradeCargoBtnActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ArrayList<String> info = new ArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader("Score.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                info.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String finaltext = "Date - Score - Rounds\n\n";
        for(int i=0;i<info.size();i++)
        {
            finaltext += info.get(i) + "\n";
        }

        JOptionPane.showMessageDialog(this, finaltext, "Scores", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JOptionPane.showMessageDialog(this, 
                "You start the game with a credit of $10 and your aim is to earn enough money throughout the game to pay back this loan when the game ends.\n" +
                "You will take turns moving your Spaceship on cards laid out as a chart of the Milky Way Galaxy, discovering new Planets as you go.\nAvailable goods will vary from turn to turn, so buy low and sell high while the market is friendly to you.\nBut if luck abandons you, you may be driven to Bankruptcy by greedy Pirates and zealous Customs controls (if you dare to smuggle any illegal goods).\n" +
                "The game ends when you turn over the last unexplored card on the Galactic Chart, or when you run out of money.\n\n" +
                "Developed by: Nuno Silva & Daniel Ferreira @ ISEC'15", 
                "About", 
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        RenderEngine.openForm(this, new MainMenu());
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * @param args the command line arguments
     * @param g
     */
    public static void main(String args[], GameModel g) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameView(g).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdvanceStateBtn;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JPanel PlanetPanel;
    private javax.swing.JPanel PlayerInfoPanel;
    private javax.swing.JLabel StateLabel;
    private javax.swing.JPanel board;
    public javax.swing.JButton buyBtn1;
    public javax.swing.JButton buyBtn2;
    public javax.swing.JLabel buyIconLb;
    private javax.swing.JLabel cargoLevelLb;
    private javax.swing.JLabel coordinatesLB;
    private javax.swing.JLabel coordinatesLb;
    private javax.swing.JLabel creditsLb;
    private javax.swing.JLabel discoveredLb;
    private javax.swing.JLabel iconLb1;
    private javax.swing.JLabel iconLb2;
    private javax.swing.JLabel iconLb3;
    private javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JLabel planetNameLb;
    private javax.swing.JLabel plantTypeLb;
    private javax.swing.JLabel res1Lb;
    private javax.swing.JLabel res2Lb;
    public javax.swing.JLabel resLabel1;
    public javax.swing.JLabel resLabel2;
    public javax.swing.JLabel resLb1;
    public javax.swing.JLabel resLb2;
    public javax.swing.JLabel resLb3;
    public javax.swing.JButton sellBtn1;
    public javax.swing.JButton sellBtn2;
    public javax.swing.JButton sellBtn3;
    public javax.swing.JLabel sellIconLb;
    private javax.swing.JLabel spaceshipLabel;
    private javax.swing.JLabel titleLb;
    public javax.swing.JButton unlockBuyBtn;
    private javax.swing.JButton upgradeCargoBtn;
    private javax.swing.JButton upgradeWeaponBtn;
    private javax.swing.JLabel weaponLb;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        
        if("STATE: Trade".equals(StateLabel.getText()))
            AdvanceStateBtn.setEnabled(false);
        else
            AdvanceStateBtn.setEnabled(true);
        
        if("STATE: GameOver".equals(StateLabel.getText()))
        {
            String ObjButtons[] = {"Yes","No"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                "You lost all your credits and didn't explore the galaxy! Try again?", "Game Over",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                ObjButtons,ObjButtons[0]);
            
                if(PromptResult ==0)
                {
                    game = null;
                    RenderEngine.openForm(this, new MainMenu());
                }
                else
                {
                    System.exit(0);
                }
        }
        
        showGameInfo(game, creditsLb, coordinatesLB,
                cargoLevelLb, jLabel6, jLabel7, jLabel8, weaponLb);
        StateLabel.setText("STATE: " + game.getState().getClass().getSimpleName());
        repaint();
    }
}
