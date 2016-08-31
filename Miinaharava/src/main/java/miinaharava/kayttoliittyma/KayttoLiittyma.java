/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import miinaharava.logiikka.PelinKulku;

/**
 *
 * @author alaakkon
 */
public class KayttoLiittyma {

    private PeliPaneeli peliPaneeli;
    private AlkuPaneeli alkuPaneeli;
    private PelinKulku peli;
    private AlkuPaneelinKuuntelija apk;


    public KayttoLiittyma() {

        luoAlkupaneeli();
       
    }

    private void luoAlkupaneeli() {
        alkuPaneeli = new AlkuPaneeli(this);
        alkuPaneeli.run();
        //   luoPelipaneeli();
    }

//    private void kaynnistaPeli() {
//        luoPelipaneeli();
//
//    }
    public void luoPelipaneeli(int korkeus, int leveys) {
        // peli = apk.haePeli();
        // peli = new PelinKulku(peli.haeLauta().haeRuutuTaulukko().length, peli.haeLauta().haeRuutuTaulukko()[0].length);
        Piirtoalusta p = new Piirtoalusta(new PelinKulku(korkeus, leveys), peliPaneeli);
        peliPaneeli = new PeliPaneeli(new PelinKulku(korkeus, leveys));
        // peliPaneeli.run();
    }

}
