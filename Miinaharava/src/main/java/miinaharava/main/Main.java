package miinaharava.main;




import java.net.URL;
import miinaharava.kayttoliittyma.PeliPaneeli;
import miinaharava.kayttoliittyma.Piirtoalusta;
import miinaharava.logiikka.Lauta;
import miinaharava.logiikka.PelinKulku;

public class Main {

    public static void main(String[] args) {

        PelinKulku peli = new PelinKulku(5, 6);
//        peli.pelaa(2, 2);
//        peli.pelaa(3,4);
        Piirtoalusta pa = new Piirtoalusta(peli);

        PeliPaneeli p = new PeliPaneeli(pa);
        p.run();
        


//       PelinKulku peli= new PelinKulku(5,6);
//       peli.pelaa(2, 2);
//    Piirtoalusta pa= new Piirtoalusta(peli);
//       
//       PeliPaneeli p = new PeliPaneeli(pa);
//       peli.haeLauta().tulostaTilat();
//       p.run();

    }
}
