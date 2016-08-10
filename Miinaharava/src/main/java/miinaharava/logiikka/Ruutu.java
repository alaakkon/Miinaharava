/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.logiikka;

/**
 *
 * @author anna
 */
public class Ruutu {

    private boolean avoimuus;
    private int tila;

    public Ruutu() {
        this.avoimuus = false;
        this.tila = 0;

    }

    public boolean onAuki() {
        return avoimuus;
    }

    public int haeTila() {
        return tila;
    }

    public void muutaTila(int muutos) {
        this.tila = muutos;
    }

    public void muutaAvoimuus(boolean muutos) {
        this.avoimuus = muutos;
    }
}
