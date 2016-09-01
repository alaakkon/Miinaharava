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
 * Luokka on miinaharava pelin käyttöliittymä.
 */
public class KayttoLiittyma {

    private PeliPaneeli peliPaneeli;
    private AlkuPaneeli alkuPaneeli;


    public KayttoLiittyma() {
        luoAlkupaneeli();

    }
   /**
    * Metodi luo alkupaneelin.
    */ 
    private void luoAlkupaneeli() {
        alkuPaneeli = new AlkuPaneeli(this);
        alkuPaneeli.run();
       
    }
/**
 * Metodi luo pelipaneelin.
 * @param korkeus
 * @param leveys 
 */
    public void luoPelipaneeli(int korkeus, int leveys) {
        Piirtoalusta p = new Piirtoalusta(new PelinKulku(korkeus, leveys), peliPaneeli);
        peliPaneeli = new PeliPaneeli(new PelinKulku(korkeus, leveys));

    }

}
