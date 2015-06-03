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

import MilkyWayExpress.Backend.GameModel;
import MilkyWayExpress.Backend.Planets.Planet;
import MilkyWayExpress.Backend.Planets.PlanetType;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author woozlinux
 */
public class TradeForm extends javax.swing.JFrame {
    GameModel game;
    Planet planet;
    JFrame gameForm;
        
    /**
     * Creates new form TradeForm
     * @param previous
     * @param g
     * @param p
     */
    public TradeForm(JFrame previous, GameModel g, Planet p)
    {
        game = g;
        planet = p;
        gameForm = previous;  
        
        initComponents(); 
        
        jLabel6.setText("Credits: " + game.Player().Spaceship().Coins().getCount());
        
        switch(planet.getPlanetType())
        {
            case NONPIRATE:
                switch(planet.getPlanetName())
                {
                    case "Gethen":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/gethen_big.png"));
                            jLabel3.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;
                    case "Kiber":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/kiber_big.png"));
                            jLabel3.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;
                    case "Arrakis":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/arrakis_big.png"));
                            jLabel3.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;
                    case "Lamarckia":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/lamarckia_big.png"));
                            jLabel3.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;
                    case "Tiamat":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/tiamat_big.png"));
                            jLabel3.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;
                    case "Reverie":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/reverie_big.png"));
                            jLabel3.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;

                }
                break;
            case PIRATE:
                switch(planet.getPlanetName())
                {
                    case "Asperta":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/asperta_big.png"));
                            jLabel3.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;
                    case "Striterax":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/striterax_big.png"));
                            jLabel3.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;
                    case "Whirl":
                        try {
                            Image img = ImageIO.read(getClass().getResource("Assets/whirl_big.png"));
                            jLabel3.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {}
                    break;
                }
                break;        
        }
        
        if (planet.getPlanetType() == PlanetType.NONPIRATE) {
            jLabel4.setText("Resource 1: " + planet.getResource01().getName());
            jLabel5.setText("Resource 2: " + planet.getResource02().getName());
            
            switch(planet.getResource01().getResourceType())
            {
                case WATER:
                    jButton1.setText("Buy for " + planet.getWaterCost() + " coins");
                    break;
                case FOOD:
                    jButton1.setText("Buy for " + planet.getFoodCost() + " coins");
                case MEDICAL:
                    jButton1.setText("Buy for " + planet.getMedicalCost() + " coins");
            }
            switch(planet.getResource02().getResourceType())
            {
                case WATER:
                    jButton2.setText("Buy for " + planet.getWaterCost() + " coins");
                    break;
                case FOOD:
                    jButton2.setText("Buy for " + planet.getFoodCost() + " coins");
                case MEDICAL:
                    jButton2.setText("Buy for " + planet.getMedicalCost() + " coins");
            }
            
            
        } else if (planet.getPlanetType() == PlanetType.PIRATE) {
            jLabel4.setText("Resource 1: " + planet.getResource01().getName());
            jLabel5.setVisible(false);
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

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MilkyWayExpress/Frontend/Assets/buy.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MilkyWayExpress/Frontend/Assets/sell.png"))); // NOI18N

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(255, 255, 255))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jButton2))
                        .addGap(0, 253, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        game.trade();
        RenderEngine.openForm(this, gameForm);
    }//GEN-LAST:event_formWindowClosing

    //Buy ResourceType 1
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(null, 
            "Are you sure you want to buy?", "Milky Way Express", 
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
            ObjButtons,ObjButtons[1]);
        if(PromptResult==0)
        {
            switch(planet.getResource01().getResourceType())
            {
                case WATER:           
                    if(game.Player().canBuy(planet.getWaterCost()))
                        game.Player().Buy(planet.getWaterCost(), planet.getResource01());
                    else
                        JOptionPane.showMessageDialog(this, "Not enough credits!");
                    break;
                case FOOD:           
                    if(game.Player().canBuy(planet.getFoodCost()))
                        game.Player().Buy(planet.getFoodCost(), planet.getResource01());
                    else
                        JOptionPane.showMessageDialog(this, "Not enough credits!");
                    break;
                case MEDICAL:           
                    if(game.Player().canBuy(planet.getMedicalCost()))
                        game.Player().Buy(planet.getMedicalCost(), planet.getResource01());
                    else
                        JOptionPane.showMessageDialog(this, "Not enough credits!");
                    break;
            }
            jLabel6.setText("Credits: " + game.Player().Spaceship().Coins().getCount());
            System.out.println("Display bought resource");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //Buy ResourceType 2
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     * @param previous
     * @param g
     * @param p
     */
    public static void main(String args[],JFrame previous, GameModel g, Planet p) {
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
            java.util.logging.Logger.getLogger(TradeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TradeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TradeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TradeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TradeForm(previous, g, p).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
