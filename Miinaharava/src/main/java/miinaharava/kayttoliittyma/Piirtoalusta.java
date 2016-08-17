package miinaharava.kayttoliittyma;

import java.awt.Graphics;
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
        g.drawString("M", 20 * x, 20 * y);

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
        String luku = "" + tila;
        g.drawString(luku, 20 * x, 20 * y);
    }

    /**
     * Metodi piirtää avaamattoman ruudun avaamattomana.
     *
     * @param g
     * @param y
     * @param x
     */
    private void piirraAvaamaton(Graphics g, int y, int x) {
        g.drawRect(x * 20, 20 * y, 20, 20);
    }

}
