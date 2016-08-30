/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author alaakkon
 */
public class AlkuPaneeli implements Runnable {

    JFrame alku;
    private int luku;
    private int leveys;

    public AlkuPaneeli() {
        this.luku = luku;
        this.leveys = leveys;
    }

    @Override
    public void run() {
        JPanel pan = luoValikko();
        alku = new JFrame();
        alku.add(pan);
        alku.pack();
        alku.setVisible(true);

    }

    private JPanel luoValikko() {
        JPanel paneeli = new JPanel(new GridLayout(3, 3));
        JTextField korkeus = new JTextField();
        JTextField leveys = new JTextField();
        paneeli.add(new JLabel("Ruudukon korkeus: ( min 1) "));
        paneeli.add(korkeus);
        paneeli.add(new JLabel("Ruudukon leveys: (min (7)"));
        paneeli.add(leveys);
        paneeli.add(new JButton("Aloita peli"));

        // tapahtumankuuntelija
        return paneeli;
    }

    void talleta() {
        this.luku = luku;
    }
}
