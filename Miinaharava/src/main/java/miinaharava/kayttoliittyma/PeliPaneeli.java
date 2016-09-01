package miinaharava.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import miinaharava.logiikka.PelinKulku;

/**
 * Luokka luo pelipaneelin, pelialustan miinaharavalle.
 */
public class PeliPaneeli implements Runnable {

    JFrame kehys;
    JFrame alku;
    Piirtoalusta piirtoalusta;
    JTextArea tuomio;
    private PelinKulku pelinkulku;
    FileWriter tulokset;
    KellonKuuntelija k;
    JTextField kello;

    public PeliPaneeli(PelinKulku pelinKulku) {
        this.piirtoalusta = new Piirtoalusta(pelinKulku, this);
        this.pelinkulku = pelinKulku;

        run();

    }

    /**
     * Metodi alustaa peligrafiikan.
     */
    @Override
    public void run() {
        kehys = new JFrame("Miinaharava");
        kehys.setPreferredSize(new Dimension(1000, 1000));
        kehys.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit();

    }

    /**
     * Metodi luo graafisen ilmentymän osaset.
     */
    private void luoKomponentit() {
        piirtoalusta.addMouseListener(piirtoalusta);
        kehys.getContentPane().add(piirtoalusta);
        kehys.add(luoAjastin(), BorderLayout.NORTH);
        kehys.add(luoTuomioRuutu(), BorderLayout.SOUTH);
        kehys.pack();
        kehys.setVisible(true);
    }

    /**
     * Metodi luo paneelille "luukun", jossa tietoa.
     */
    private JPanel luoTuomioRuutu() {
        JPanel paneeli = new JPanel();
        tuomio = new JTextArea("Voit aloittaa..");
        paneeli.add(tuomio);
        return paneeli;

    }
/**
 * Metodi luo paneelille ajastimen.
 */
    private JPanel luoAjastin() {
        JPanel paneeli = new JPanel();
        kello = new JTextField("00:00");
        this.k = new KellonKuuntelija(kello, pelinkulku);
        paneeli.add(kello);

        return paneeli;

    }
}
