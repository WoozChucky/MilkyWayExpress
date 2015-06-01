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
import MilkyWayExpress.Backend.Coordinate;
import MilkyWayExpress.Backend.Game;
import MilkyWayExpress.Backend.Planets.Planet;
import MilkyWayExpress.Backend.Player.Player;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Observable;
import java.util.Observer;
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
public final class GameForm extends javax.swing.JFrame implements Observer {

    public final Game game;
    private final String pName;
    private Component[] comps;
    
    /**
     * Creates new form GameForm
     * @param g
     * @param s
     */
    public GameForm(Game g, String s) {
        initComponents();
        game = g;
        game.addObserver(this);
        pName = s;
        prepareComponents();
    }

    public void prepareComponents()
    {
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        
        try {
            Image img = ImageIO.read(getClass().getResource("Assets/spaceship.jpg"));
            spaceshipLabel.setText("");
            spaceshipLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {}
        
        board.setLayout(new GridLayout(7, 9));
         for(int i=0;i<= Constants.ROWS;i++)
                for(int j=0; j<= Constants.COLS; j++)
                    board.add(new PlanetBtn(this, game, j, i));

        jLabel16.setText("STATE: " + game.getState().getClass().getSimpleName());
    }
    
    public void displayPlanetInfo(Planet p, int x, int y)
    {
        jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        
        jLabel10.setVisible(true);
        jLabel10.setText("Name: " + p.getPlanetName());
        
        jLabel11.setVisible(true);
        jLabel11.setText("Type: " + p.getPlanetType().toString());
        
        jLabel12.setVisible(true);
        if(p.getResource01() != null)
            jLabel12.setText("Resource 1: " + p.getResource01().getClass().getSimpleName());
        else
            jLabel12.setText("Resource 1: Empty");
        
        jLabel13.setVisible(true);
        if(p.getResource02() != null)
            jLabel13.setText("Resource 2: " + p.getResource02().getClass().getSimpleName());
        else
            jLabel13.setText("Resource 2: Empty");
        
        jLabel14.setVisible(true);
        jLabel14.setText("Coordinates(X,Y): " + x + "," + y);
        
        jLabel15.setVisible(true);
        jLabel15.setText("Discovered: " + p.getDiscovered());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        board = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        spaceshipLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Milky Way Express");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Player Information");

        jLabel2.setText("Name:");

        jLabel3.setText("Credits");

        jLabel4.setText("Coordinates (X, Y)");

        jLabel5.setText("Cargo Level");

        jLabel6.setText("Resource 1");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setText("Resource 2");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel8.setText("Resource 3");
        jLabel8.setToolTipText("");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel9.setText("Weapon Level");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel9))
                        .addGap(149, 149, 149))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
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

        jButton1.setText("Next State");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        spaceshipLabel.setText("jLabel10");

        jPanel2.setToolTipText("Planet Information");
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setName("Planet Information"); // NOI18N

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel16.setText("jLabel16");

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Save Game");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 67, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spaceshipLabel))
                    .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(board, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spaceshipLabel)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Planet Information");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showGameInfo(Game g, JLabel name, JLabel credits, JLabel coordinates, JLabel cargolevel, JLabel res1, JLabel res2, JLabel res3, JLabel weaponlevel)
    {
        name.setText("Name - " + g.Player().getName());
        credits.setText("Credits - " + g.Player().Spaceship().Coins().getCount()); 
        coordinates.setText("Coordinates(X, Y) - " + g.Player().Spaceship().Coordinates().getX() +", " + g.Player().Spaceship().Coordinates().getY());
        cargolevel.setText("Cargo Level - " + g.Player().Spaceship().Cargo().getLevel());
        res1.setText("Resource 1 - " + g.Player().Spaceship().Cargo().getResource01().getName());
        res2.setText("Resource 2 - " + g.Player().Spaceship().Cargo().getResource02().getName());
        if(g.Player().Spaceship().Cargo().isUnlocked())
            res3.setText(" Resource 3 - " + g.Player().Spaceship().Cargo().getResource03().getName());
        else
            res3.setText(" Resource 3 - Locked");
        weaponlevel.setText(" Weapon Level - " + g.Player().Spaceship().Weapon().getLevel());
        

    }
    
    private void displaySpaceship()
    {
        comps = board.getComponents();
        
        for (Component comp : comps) {
            if (comp instanceof PlanetBtn) {
                PlanetBtn temp = (PlanetBtn) comp;
                
                if(temp.X == game.Player().Spaceship().Coordinates().getX() && temp.Y == game.Player().Spaceship().Coordinates().getY())
                {
                    //JOptionPane.showMessageDialog(this, "X = " + temp.x + " - Y = " + temp.y, "Coordinates", JOptionPane.WARNING_MESSAGE);
                    temp.setText("*");
                    return;
                }
            }
        }
    }
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(game.Player() == null)
        {   //New Game
            game.startGame(pName);
        }     
        showGameInfo(game, jLabel2, jLabel3, jLabel4,
                jLabel5, jLabel6, jLabel7, jLabel8, jLabel9);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        switch(jLabel16.getText())
        {
            case "STATE: Explore":
                game.explore();
                break;
            case "STATE: ReplenishMarkets":
                game.fillMarkets();
                break;
            case "STATE: Trade":
                game.trade();
                break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     * @param g
     * @param s
     */
    public static void main(String args[], Game g, String s) {
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
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameForm(g, s).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel board;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel spaceshipLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        
        showGameInfo(game, jLabel2, jLabel3, jLabel4,
                jLabel5, jLabel6, jLabel7, jLabel8, jLabel9);
        jLabel16.setText("STATE: " + game.getState().getClass().getSimpleName());
        repaint();
    }
}

class PlanetBtn extends JButton 
{
    Game game;
    GameForm frm;
    int X, Y;
    
    public PlanetBtn(GameForm f, Game g, int x, int y)
    {
        frm = f;
        game = g;
        this.X = x;
        this.Y = y;

        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                f.displayPlanetInfo(game.Galaxy().getGrid()[Y][X], X, Y);

                if(frm.game.canMove())
                    frm.game.move(new Coordinate(X, Y));
            }
        });

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        switch(game.Galaxy().getGrid()[Y][X].getPlanetType()){
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
//            if(game.Player().Spaceship().Coordinates().getX() == x && game.Player().Spaceship().Coordinates().getY() == y)
//                setText("caralho");
    }
}
