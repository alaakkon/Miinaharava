/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runko;

/**
 *
 * @author anna
 */
public class Ruutu {

    private boolean status;
    private int tila;

    public Ruutu(int y, int x) {
        this.status = false;
        this.tila = -1;
   
    }

    public boolean haeStatus(int y, int x) {
        return status;
    }

    public int haeTila(int y, int x) {
        return tila;
    }

    public void muutaTila(int y, int x, int muutos) {
       this.tila = muutos;

    }
}
