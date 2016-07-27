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

    private boolean status;
    private int tila;

    public Ruutu(int y, int x) {
        this.status = false;
        this.tila = 0;
   
    }

    public boolean haeStatus() {
        return status;
    }

    public int haeTila() {
        return tila;
    }

    public void muutaTila( int muutos) {
       this.tila = muutos;

    }
}
