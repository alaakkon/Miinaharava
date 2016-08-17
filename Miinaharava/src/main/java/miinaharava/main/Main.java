package miinaharava.main;


import miinaharava.kayttoLiittyma.PeliPaneeli;
import miinaharava.logiikka.Lauta;
import miinaharava.logiikka.Peli;
import miinaharava.kayttoLiittyma.Piirtoalusta;


public class Main {

    public static void main(String[] args) {
       Peli peli= new Peli(5,6);
       peli.pelaa(2, 2);
       Piirtoalusta pa = new Piirtoalusta(peli);
       
       PeliPaneeli p = new PeliPaneeli(pa);
       p.run();
      
    }
}
