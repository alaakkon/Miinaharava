package miinaharava.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 */
public class PeliPaneeli implements Runnable {

    JFrame kehys;
    JFrame alku;
    Piirtoalusta piirtoalusta;
    JTextField tuomio ;

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
        kehys.add(luoTuomioRuutu(), BorderLayout.SOUTH);
        kehys.pack();
        kehys.setVisible(true);
    }

    private JPanel luoTuomioRuutu() {
        JPanel paneeli = new JPanel();
        tuomio = new JTextField("Tähän tuomio");
        
        paneeli.add(tuomio);
        

        return paneeli;

    }
}
