package miinaharava.main;

import miinaharava.logiikka.LaudanLuominen;
import miinaharava.logiikka.Peli;

public class Main {

    public static void main(String[] args) {
        Peli peli = new Peli(8, 8);
        peli.pelaa(1, 1);
        peli.tulostaStatus();
        System.out.println("");
        peli.tulostaTilat();
    }
}
