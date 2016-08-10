/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alaakkon
 */
public class PeliTest {
    
    Peli peli;
    private int y;
    private int x;
    
    public PeliTest() {
        peli = new Peli(3, 4);
        this.y = 0;
        this.x = 0;
        
    }
    
    public void apumetodi(int haettava) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (peli.haeLauta().haePelilauta()[i][j].haeTila() == haettava) {
                    this.y = i;
                    this.x = j;
                }
            }
        }
    }
    
    @Test
    public void huomaakoMiinan() {
        
        apumetodi(9);
        assertTrue(peli.onMiina(this.y, this.x));
    }
    
    @Test
    public void avaakoNormaalinRuudun() {
        apumetodi(1);
        peli.avaaNormaaliRuutu(y, x);
        assertTrue(peli.haeLauta().haePelilauta()[y][x].onAuki());
    }
     @Test
    public void avaakoViereisetNollat() {
        apumetodi(0);
       peli.avaaKaikkiViereisetNollat(y, x);
        assertTrue(peli.haeLauta().haePelilauta()[y][x].onAuki());
      
    }
}
