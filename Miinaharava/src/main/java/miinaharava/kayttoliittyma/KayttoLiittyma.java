/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

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
        alkuPaneeli = new AlkuPaneeli();
        
        luoAlkupaneeli();
         kaynnistaPeli();
    }

    private void luoAlkupaneeli() {
        alkuPaneeli.run();
      //  kaynnistaPeli();
    }

    private void kaynnistaPeli() {
        luoPelipaneeli();

    }

    private void lopetaPeli() {

    }

    private void luoPelipaneeli() {
        peli = alkuPaneeli.haePeli();
       // peli = new PelinKulku(peli.haeLauta().haeRuutuTaulukko().length, peli.haeLauta().haeRuutuTaulukko()[0].length);
        Piirtoalusta p = new Piirtoalusta(peli);
        peliPaneeli = new PeliPaneeli(p);
        peliPaneeli.run();
    }
}
