/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoLiittyma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author alaakkon
 */
public class PeliPaneeli implements Runnable {
    
    JFrame kehys;
    Piirtoalusta piirtoalusta;
    
    public PeliPaneeli(Piirtoalusta piirtoalusta) {
        this.piirtoalusta = piirtoalusta;
    }

   
    @Override
    public void run() {
        kehys = new JFrame("Otsikko");
        kehys.setPreferredSize(new Dimension(1200, 1000));
        kehys.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit();
        
    }
    
    private void luoKomponentit() {
        kehys.getContentPane().add(piirtoalusta);
        kehys.pack();
        kehys.setVisible(true);
      
    }
    
}
