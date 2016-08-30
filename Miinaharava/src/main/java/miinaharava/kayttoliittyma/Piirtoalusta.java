package miinaharava.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import miinaharava.logiikka.PelinKulku;
import miinaharava.logiikka.Ruutu;

/**
 * Luokassa piirretään Miinaharavan pelilauta
 *
 */
public class Piirtoalusta extends JPanel implements MouseListener {

    private PelinKulku peli;
    private int kerroin;
    private int x;
    private int y;
    private Ruutu[][] ruudut;

    /**
     *
     * @param peli
     */
    public Piirtoalusta(PelinKulku peli) {
        this.peli = peli;
        this.kerroin = 20;
        this.ruudut = peli.haeLauta().haeRuutuTaulukko();

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

        super.setBackground(Color.LIGHT_GRAY);

        if (peli.haeLauta().haeRuutuTaulukko()[y][x].onAuki()) {
            if (peli.haeLauta().haeRuutuTaulukko()[y][x].haeTila() == 9) {
                piirraMiina(g, y, x);
                peli.lopetaPeli();
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
    private void piirraLoppu(Graphics g, int y, int x) {
        this.y = 0;
        this.x = 0;

        for (int i = 0; i < ruudut.length; i++) {
            for (int j = 0; j < ruudut[0].length; j++) {
                ruudut[i][j].muutaAvoimuus(true);

            }
        }
        repaint();

    }

    private void piirraMiina(Graphics g, int y, int x) {

        try {
            String nimi = "miina";
            Image kuva = KuvanLataaminen.haeKuva(nimi);
            g.drawImage(kuva, x * kerroin, y * kerroin, null);
            piirraLoppu(g, x, y);
        } catch (Exception e) {
            g.setColor(Color.red);
            g.drawRect(x * kerroin, kerroin * y, kerroin, kerroin);
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

        if (tila == 0) {
            g.setColor(Color.GRAY);
            g.drawRect(x * kerroin, y * kerroin, kerroin, kerroin);
        } else {
            String nimi = "" + tila;
            Image kuva = KuvanLataaminen.haeKuva(nimi);
            g.setColor(Color.gray);
            g.drawRect(x * kerroin, y * kerroin, kerroin, kerroin);
            g.drawImage(kuva, x * kerroin, y * kerroin, null);
        }
        if (vielaArvattavia() < 1) {
            piirraLoppu(g, y, x);
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
        if (peli.haeLauta().haeRuutuTaulukko()[y][x].haeLiputusTila() == true) {
            piirraLippu(g, y, x);
        } else {
            try {
                String avaamaton = "avaamaton";
                Image kuva = KuvanLataaminen.haeKuva(avaamaton);
                g.drawImage(kuva, x * kerroin, y * kerroin, null);
            } catch (Exception e) {
                g.setColor(Color.red);
                g.drawRect(x * kerroin, kerroin * y, kerroin, kerroin);
            }
        }

    }

    private void piirraLippu(Graphics g, int y, int x) {
        try {
            String lippu = "lippu";
            System.out.println("lippu");
            Image kuva = KuvanLataaminen.haeKuva(lippu);
            g.drawImage(kuva, x * kerroin, y * kerroin, null);

        } catch (Exception e) {
            g.setColor(Color.cyan);
            g.drawRect(x * kerroin, kerroin * y, kerroin, kerroin);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.x = e.getX() / kerroin;
        this.y = e.getY() / kerroin;
        peli.pelaa(y, x, e.getButton());
        repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("");
    }

    private int vielaArvattavia() {
        int montakoAuki = 0;
        int laskuri = 0;
        for (int i = 0; i < peli.haeLauta().haeRuutuTaulukko().length; i++) {
            for (int j = 0; j < peli.haeLauta().haeRuutuTaulukko()[0].length; j++) {
                if (peli.haeLauta().haeRuutuTaulukko()[i][j].onAuki()) {
                    montakoAuki++;
                } else {

                }
                laskuri++;
            }
        }
        System.out.println((laskuri - montakoAuki) - peli.haeLauta().montakoMiinaa());
        return (laskuri - montakoAuki) - peli.haeLauta().montakoMiinaa();
    }
}
