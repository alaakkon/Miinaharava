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
    private KayttoLiittyma k;

    public AlkuPaneeli(KayttoLiittyma k) {
        this.k = k;
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
        JTextField ruudukonKorkeus = new JTextField();
        JTextField ruudukonleveys = new JTextField();
        nappi = new JButton("Aloita peli");
        paneeli.add(new JLabel("Ruudukon korkeus: "));
        paneeli.add(ruudukonKorkeus);
        paneeli.add(new JLabel("Ruudukon leveys: "));
        paneeli.add(ruudukonleveys);
        paneeli.add(nappi);
        alkuPaneelinKuuntelija = new AlkuPaneelinKuuntelija(k, ruudukonKorkeus, ruudukonleveys);
        nappi.addActionListener(alkuPaneelinKuuntelija);
        return paneeli;
    }

}
