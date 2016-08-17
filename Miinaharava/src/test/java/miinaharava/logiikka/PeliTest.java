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

    PelinKulku peli;
    private int y;
    private int x;

    public PeliTest() {
        peli = new PelinKulku(3, 4);
        this.y = 0;
        this.x = 0;

    }

    public void apumetodi(int haettava) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (peli.haeLauta().haeRuutuTaulukko()[i][j].haeTila() == haettava) {
                    this.y = i;
                    this.x = j;
                }
            }
        }
    }@Test
    public void pelaakoOikein(){
        apumetodi(9);
    }

    @Test
    public void huomaakoMiinan() {

        apumetodi(9);
        assertTrue(peli.onMiina(this.y, this.x));
        peli.haeLauta().haeRuutuTaulukko()[0][0].muutaTila(0);
        assertFalse(peli.onMiina(0, 0));

    }

    @Test
    public void avaakoNormaalinRuudun() {
        apumetodi(1);
        peli.avaaRuutu(y, x);
        assertTrue(peli.haeLauta().haeRuutuTaulukko()[y][x].onAuki());
    }

    @Test
    public void avaakoViereisetNollat() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                peli.haeLauta().haeRuutuTaulukko()[i][j].muutaTila(0);
                peli.haeLauta().haeRuutuTaulukko()[i][j].muutaAvoimuus(false);
            }
        }
        peli.haeLauta().haeRuutuTaulukko()[1][1].muutaTila(9);
        peli.avaaKaikkiViereisetNollat(0, 3);
        assertEquals(peli.haeLauta().haeRuutuTaulukko()[0][3].haeTila(), 0);
        assertEquals(peli.haeLauta().haeRuutuTaulukko()[1][3].haeTila(), 0);
        assertEquals(peli.haeLauta().haeRuutuTaulukko()[2][3].haeTila(), 0);
    }

    @Test
    public void avaakoNollat() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                peli.haeLauta().haeRuutuTaulukko()[i][j].muutaTila(0);
                peli.haeLauta().haeRuutuTaulukko()[i][j].muutaAvoimuus(false);
            }
        }
        peli.haeLauta().haeRuutuTaulukko()[1][1].muutaTila(9);
        peli.avaaKaikkiViereisetNollat(0, 3);

        assertTrue(peli.haeLauta().haeRuutuTaulukko()[0][3].onAuki());
        assertTrue(peli.haeLauta().haeRuutuTaulukko()[1][3].onAuki());
        assertTrue(peli.haeLauta().haeRuutuTaulukko()[2][3].onAuki());
    }
}
