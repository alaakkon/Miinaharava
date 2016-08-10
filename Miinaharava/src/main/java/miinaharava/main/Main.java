package miinaharava.main;


import miinaharava.logiikka.Lauta;
import miinaharava.logiikka.Peli;


public class Main {

    public static void main(String[] args) {
        Lauta peli = new Lauta(5, 5);
        Peli p= new Peli(7,4);
        p.tulostaStatus();
        System.out.println("");
        p.pelaa(1, 1);
  
        p.tulostaTilat();
        int[][] l={{1,1},{2,2},{3,3}};
//        System.out.println("korkeus ="+l.length);
    }
}
