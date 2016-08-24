package miinaharava.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import miinaharava.logiikka.PelinKulku;
import miinaharava.logiikka.Ruutu;

/**
 * Luokassa piirretään Miinaharavan pelilauta
 *
 */
public class Piirtoalusta extends JPanel {

    private PelinKulku peli;

    public Piirtoalusta(PelinKulku peli) {
        this.peli = peli;
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
   String nimi="miina";
        try {
            Image kuva=KuvanLataaminen.haeKuva(nimi);
            g.drawImage(kuva, x, y, null);
        } catch (IOException ex) {
            g.setColor(Color.red);
            g.drawRect(x*20, y*20, 20,20);
        }
   
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
        String nimi;
        if (tila == 1) {
            nimi = "yksi";
        } else if (tila == 2) {
            nimi = "kaksi";
        } else if (tila == 3) {
            nimi = "kolme";
        } else if (tila == 4) {
            nimi = "nelja";
        } else if (tila == 5) {
            nimi = "viisi";
        } else if (tila == 6) {
            nimi = "kuusi";
        } else if (tila == 7) {
            nimi = "seiska";
        } else {
            nimi = "kasi";
        }
        try {
            Image kuva=KuvanLataaminen.haeKuva(nimi);
            g.drawImage(kuva, x*20, y*20, null);
        } catch (IOException ex) {
            g.setColor(Color.yellow);
            g.drawRect(x*20, y*20, 20,20);
        }
    }

    /**
     * Metodi piirtää avaamattoman ruudun avaamattomana.
     *
     * @param g
     * @param y
     * @param x
     */
    private void piirraAvaamaton(Graphics g, int y, int x) {
        try {
            String avaamaton = "avaamaton";
            Image kuva = KuvanLataaminen.haeKuva(avaamaton);
            g.drawImage(kuva, x * 20, y * 20, null);
        } catch (Exception e) {
            g.setColor(Color.red);
            g.drawRect(x * 20, 20 * y, 20, 20);
        }

        //g.fillRect(x * 20, 20 * y, 20, 20);
        // g.drawRect(x * 20, 20 * y, 20, 20);
    }

}
