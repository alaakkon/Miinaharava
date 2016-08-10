package miinaharava.logiikka;

import miinaharava.logiikka.Lauta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anna
 */
public class Peli {

    private Lauta lauta;
    private Ruutu ruutu;

    public Peli(int korkeus, int leveys) {
        this.lauta = new Lauta(korkeus, leveys);
        lauta.alustaLauta();

    }public Lauta haeLauta(){
        return lauta;
    }

    public boolean onMiina(int y, int x) {
        if (lauta.haePelilauta()[y][x].haeTila() == 9) {
            return true;
        } else {
            return false;
        }
    }

    public void pelaa(int y, int x) {
        if (onMiina(y, x)) {
            System.out.println("Hävisit!!!");
        } else if (lauta.haePelilauta()[y][x].haeTila() != 0) {
            avaaNormaaliRuutu(y, x);
        } else {
            avaaNolla(y, x);
        }

    }

    public void avaaNormaaliRuutu(int y, int x) {
        lauta.haePelilauta()[y][x].muutaAvoimuus(true);
    }

    public void avaaNolla(int y, int x) {
        lauta.haePelilauta()[y][x].muutaAvoimuus(true);
        avaaKaikkiViereisetNollat(y, x);
    }

    /**
     * 
     * @param b 
     * @param a
     */
    public void avaaKaikkiViereisetNollat(int b, int a) {
        int xAlku = Math.max(a - 1, 0);
        int xLoppu = Math.min(a + 1, lauta.haePelilauta()[0].length - 1);
        int yAlku = Math.max(b - 1, 0);
        int yLoppu = Math.min(b + 1, lauta.haePelilauta().length  - 1);
        for (int i = yAlku; i <= yLoppu; i++) {
            for (int j = xAlku; j <= xLoppu; j++) {
                if (lauta.haePelilauta()[i][j].haeTila() == 0 && !lauta.haePelilauta()[i][j].onAuki()) {
                    avaaNolla(i, j);
                }
            }
        }

    }

    //poistetaan myöhemmin
    public int annaSuurempiLuku(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    public int annaPienempiLuku(int a, int b) {
        if (a <= b) {
            return a;
        }
        return b;
    }

    public void tulostaStatus() {
        lauta.tulostaTilat();
    }

    public void tulostaTilat() {
        lauta.tulostaStatus();
    }

}
