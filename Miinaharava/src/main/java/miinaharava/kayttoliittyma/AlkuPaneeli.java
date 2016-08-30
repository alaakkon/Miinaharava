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
import miinaharava.logiikka.PelinKulku;

/**
 *
 * @author alaakkon
 */
public class AlkuPaneeli implements Runnable {

    JFrame alku;
    JButton nappi;
    private int luku;
    private int leveys;
    private PelinKulku pelinKulku;
    private AlkuPaneelinKuuntelija alkuPaneelinKuuntelija;
   

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
      nappi = new JButton("Aloita peli");
        paneeli.add(new JLabel("Ruudukon korkeus: ( min 1) "));
        paneeli.add(korkeus);
        paneeli.add(new JLabel("Ruudukon leveys: (min (7)"));
        paneeli.add(leveys);
        paneeli.add(nappi);
        alkuPaneelinKuuntelija = new AlkuPaneelinKuuntelija(korkeus, leveys);
        nappi.addActionListener(alkuPaneelinKuuntelija);
        return paneeli;
    }

//    public PelinKulku haePeli() {
//        return alkuPaneelinKuuntelija.haePeli();
//    }

}
