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

import MilkyWayExpress.Backend.Game;
import MilkyWayExpress.Backend.Planets.Planet;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author woozlinux
 */
public class TradeForm extends javax.swing.JFrame {
    Game game;
    Planet planet;
    JFrame gameForm;
        
    /**
     * Creates new form TradeForm
     * @param previous
     * @param g
     * @param p
     */
    public TradeForm(JFrame previous, Game g, Planet p)
    {
        game = g;
        planet = p;
        gameForm = previous;  
        
        initComponents(); 
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MilkyWayExpress/Frontend/Assets/buy.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MilkyWayExpress/Frontend/Assets/sell.png"))); // NOI18N

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        RenderEngine.openForm(this, gameForm);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     * @param previous
     * @param g
     * @param p
     */
    public static void main(String args[],JFrame previous, Game g, Planet p) {
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
