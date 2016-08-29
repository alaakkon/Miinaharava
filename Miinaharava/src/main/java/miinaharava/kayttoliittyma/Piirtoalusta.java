package miinaharava.kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import miinaharava.logiikka.PelinKulku;
import miinaharava.logiikka.Ruutu;

/**
 * Luokassa piirretään Miinaharavan pelilauta
 *
 */
public class Piirtoalusta extends JPanel implements MouseListener {

    private PelinKulku peli;
    private int kerroin;
    private int kerroin2;
    private int x;
    private int y;
    private boolean onkoLippu;
    //  private Graphics g;

    /**
     *
     * @param peli
     */
    public Piirtoalusta(PelinKulku peli) {
        this.peli = peli;
        this.kerroin = 20;
        this.kerroin2 = 54;
        this.onkoLippu = false;

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

        try {
            String nimi = "miina";
            Image kuva = KuvanLataaminen.haeKuva(nimi);
            g.drawImage(kuva, x * kerroin, y * kerroin, null);
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
            g.drawImage(kuva, x * kerroin, y * kerroin, null);
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

        // piirraLauta(g);
        //  paintComponent(g);
        System.out.println("x=" + x + ",y=" + y);
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

}
