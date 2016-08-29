package miinaharava.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Luokka on Miinaharava pelin graafinen käyttöliittymä
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
        JPanel pan =luoValikko();
        alku=new JFrame();
        alku.add(pan);
        alku.pack();
        alku.setVisible(true);
        
//        kehys = new JFrame("Miinaharava");
//        kehys.setPreferredSize(new Dimension(1200, 1000));
//        kehys.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        luoKomponentit();

    }

    /**
     * Metodi luo graafisen ilmentymän osaset.
     */
    private void luoKomponentit() {
        kehys.getContentPane().add(piirtoalusta);
        kehys.addMouseListener(piirtoalusta);

      //  kehys.add(luoValikko(), BorderLayout.SOUTH);
        kehys.pack();
        kehys.setVisible(true);

    }

    private JPanel luoValikko() {
         JPanel paneeli = new JPanel(new GridLayout(3, 3));
        paneeli.add(new JLabel("Ruudukon korkeus: ( min 1) "));
        paneeli.add(new JTextField());
        paneeli.add(new JLabel("Ruudukon leveys: (min (7)"));
        paneeli.add(new JTextField());
        paneeli.add(new JButton("Aloita peli"));
        
        // tapahtumankuuntelija
   
        return paneeli;

//
//    container.add(nimiTeksti);
//    container.add(nimiKentta);
//    container.add(hetuTeksti);
//    container.add(hetuKentta);
//    container.add(new JLabel(""));
//    container.add(lisaaNappi);
    }
}
