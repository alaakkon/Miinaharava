package miinaharava.kayttoliittyma;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 */
public class PeliPaneeli implements Runnable {

    JFrame kehys;
    JFrame alku;
    Piirtoalusta piirtoalusta;

    public PeliPaneeli(Piirtoalusta piirtoalusta) {
        this.piirtoalusta = piirtoalusta;

    }

    /**
     * Metodi alustaa peligrafiikan.
     */
    @Override
    public void run() {
        kehys = new JFrame("Miinaharava");
        kehys.setPreferredSize(new Dimension(600, 600));
        kehys.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit();

    }

    /**
     * Metodi luo graafisen ilmentymän osaset.
     */
    private void luoKomponentit() {
        kehys.getContentPane().add(piirtoalusta);
        kehys.addMouseListener(piirtoalusta);
        kehys.pack();
        kehys.setVisible(true);

    }
}

