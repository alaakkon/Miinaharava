/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoLiittyma;

import java.awt.Graphics;
import javax.swing.JPanel;
import miinaharava.logiikka.Peli;
import miinaharava.logiikka.Ruutu;

/**
 *
 * @author vipohjol
 */
public class Piirtoalusta extends JPanel {

    private Peli peli;

    public Piirtoalusta(Peli peli) {
        this.peli = peli;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirraLauta(g);
    }

    private void piirraLauta(Graphics g) {
        Ruutu[][] ruudut = peli.haeLauta().haePelilauta();
        for (int i = 0; i < ruudut.length; i++) {
            for (int j = 0; j < ruudut[0].length; j++) {
                piirraRuutu(g, i, j);
            }
        }
    }

    private void piirraRuutu(Graphics g, int y, int x) {
        if (peli.haeLauta().haePelilauta()[y][x].onAuki()) {
            if (peli.haeLauta().haePelilauta()[y][x].haeTila() == 9) {
                piirraMiina(g, y, x);
            } else {
                piirraTila(g, y, x, peli.haeLauta().haePelilauta()[y][x].haeTila());
            }
        } else {
            piirraAvaamaton(g, y, x);
        }
    }

    private void piirraMiina(Graphics g, int y, int x) {
        g.drawString("M", 20*x, 20*y);

    }

    private void piirraTila(Graphics g, int y, int x, int tila) {
        String luku = "" + tila;
        g.drawString(luku, 20*x, 20*y);
    }

    private void piirraAvaamaton(Graphics g, int y, int x) {
       g.drawRect(x*20, 20*y, 20, 20);
    }

}
