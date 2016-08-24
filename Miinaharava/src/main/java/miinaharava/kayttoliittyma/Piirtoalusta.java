package miinaharava.kayttoliittyma;

import java.awt.Color;
<<<<<<< HEAD
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
=======
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> ae739d7cc8a81acefd3854ac379ba375e4cafff7
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import miinaharava.logiikka.PelinKulku;
import miinaharava.logiikka.Ruutu;

/**
 * Luokassa piirretään Miinaharavan pelilauta
 *
 */
public class Piirtoalusta extends JPanel {

    private PelinKulku peli;
    private int kerroin;
    private int kerroin2;

    public Piirtoalusta(PelinKulku peli) {
        this.peli = peli;
        this.kerroin = 40;
        this.kerroin2 = 54;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        piirraLauta(g);
    }

    /**
     * Metodi piirtää pelilaudan jokaisen ruudun pelitilanteen mukaisessa
     * tilanteessa.
     *
     * @param g
     */
    private void piirraLauta(Graphics g) {
        Ruutu[][] ruudut = peli.haeLauta().haeRuutuTaulukko();
        for (int i = 0; i < ruudut.length; i++) {
            for (int j = 0; j < ruudut[0].length; j++) {
                piirraRuutu(g, i, j);
            }
        }
    }

    /**
     * Metodi valitsee ruudun piirroksen pelin tilanteen mukaisesti.
     *
     * @param g
     * @param y korkeuden koordinaatti
     * @param x leveyden koordinaatti
     */
    private void piirraRuutu(Graphics g, int y, int x) {
        super.setBackground(Color.white);
        if (peli.haeLauta().haeRuutuTaulukko()[y][x].onAuki()) {
            if (peli.haeLauta().haeRuutuTaulukko()[y][x].haeTila() == 9) {
                piirraMiina(g, y, x);
            } else {
                piirraTila(g, y, x, peli.haeLauta().haeRuutuTaulukko()[y][x].haeTila());
            }
        } else {
            piirraAvaamaton(g, y, x);
        }
    }

    /**
     * Metodi piirtää miinan syötteen mukaiseen ruutuun.
     *
     * @param g
     * @param y korkeuden koordinaatti
     * @param x leveyden koordinaatti
     */
    private void piirraMiina(Graphics g, int y, int x) {
<<<<<<< HEAD

        g.fillOval(kerroin2 * x, kerroin2 * y, kerroin2, kerroin2);
        g.drawString("M", kerroin2 * x, kerroin2 * y);

=======
        try {
            String nimi = "miina";
            Image kuva = KuvanLataaminen.haeKuva(nimi);
            g.drawImage(kuva, x * 20, y * 20, null);
        } catch (Exception e) {
            g.setColor(Color.red);
            g.drawRect(x * 20, 20 * y, 20, 20);
        }
>>>>>>> ae739d7cc8a81acefd3854ac379ba375e4cafff7
    }

    /**
     * Metodi piirtää ruudun tilan eli ruudun koskettamien miinoja sisältävien
     * ruutujen lukumäärän syötteen mukaiseen ruutuun.
     *
     * @param g
     * @param y
     * @param x
     * @param tila
     */
    private void piirraTila(Graphics g, int y, int x, int tila) {
<<<<<<< HEAD
        String luku = "" + tila;
        g.setColor(Color.red);
        g.drawString(luku, kerroin * x, kerroin * y);
      g.setClip (x * kerroin, kerroin * y, kerroin, kerroin);
=======
        if (tila == 0) {
            g.setColor(Color.GRAY);
            g.drawRect(x * 20, y * 20, 20, 20);
        } else {
            String nimi = "" + tila;
            Image kuva = KuvanLataaminen.haeKuva(nimi);
            g.drawImage(kuva, x * 20, y * 20, null);
        }
>>>>>>> ae739d7cc8a81acefd3854ac379ba375e4cafff7
    }

    /**
     * Metodi piirtää avaamattoman ruudun avaamattomana.
     *
     * @param g
     * @param y
     * @param x
     */
    private void piirraAvaamaton(Graphics g, int y, int x) {
<<<<<<< HEAD
        g.drawRect(x * kerroin, kerroin * y, kerroin, kerroin);
=======
        try {
            String avaamaton = "avaamaton";
            Image kuva = KuvanLataaminen.haeKuva(avaamaton);
            g.drawImage(kuva, x * 20, y * 20, null);
        } catch (Exception e) {
            g.setColor(Color.red);
            g.drawRect(x * 20, 20 * y, 20, 20);
        }
>>>>>>> ae739d7cc8a81acefd3854ac379ba375e4cafff7
    }

}
