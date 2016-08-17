package miinaharava.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Luokka on Miinaharava pelin graafinen käyttöliittymä
 */
public class PeliPaneeli implements Runnable {

    JFrame kehys;
    Piirtoalusta piirtoalusta;

    public PeliPaneeli(Piirtoalusta piirtoalusta) {
        this.piirtoalusta = piirtoalusta;
    }

    /**
     * Metodi alustaa peligrafiikan.
     */
    @Override
    public void run() {
        kehys = new JFrame("Otsikko");
        kehys.setPreferredSize(new Dimension(1200, 1000));
        kehys.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit();

    }

    /**
     * Metodi luo graafisen ilmentymän osaset.
     */
    private void luoKomponentit() {
        kehys.getContentPane().add(piirtoalusta);
        kehys.pack();
        kehys.setVisible(true);

    }
}
