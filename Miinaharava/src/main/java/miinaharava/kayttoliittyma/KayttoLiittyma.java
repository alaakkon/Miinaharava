/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

/**
 *
 * @author alaakkon
 */
public class KayttoLiittyma {
    
    private PeliPaneeli peli;
    private AlkuPaneeli alkuPaneeli;

    public KayttoLiittyma() {
        luoAlkupaneeli();
    }

    private void luoAlkupaneeli() {
        alkuPaneeli.run();
    }
    
    private void kaynnistaPeli() {
        luoPelipaneeli();
        peli.run();
    }
    
    private void lopetaPeli() {
        
    }

    private void luoPelipaneeli() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
