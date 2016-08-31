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
public class PelinKulkuTest {

    PelinKulku peli;
    private int y;
    private int x;

    public PelinKulkuTest() {
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
    }

    @Test
    public void pelaakoOikein() {
        apumetodi(1);
        peli.pelaa(this.y, this.x, 3);
        assertTrue(peli.haeLauta().haeRuutuTaulukko()[y][x].haeLiputusTila());
        assertFalse(peli.haeLauta().haeRuutuTaulukko()[y][x].onAuki());
        apumetodi(9);
        peli.pelaa(this.y, this.x, 1);
        assertTrue(peli.onMiina(this.y, this.x));
        assertTrue(peli.haeLauta().haeRuutuTaulukko()[y][x].onAuki());
        apumetodi(0);
        peli.pelaa(this.y, this.x, 1);
        assertTrue(peli.haeLauta().haeRuutuTaulukko()[this.y][this.x].onAuki());
        assertEquals(peli.haeLauta().haeRuutuTaulukko()[this.y][this.x].haeTila(), 0);
        apumetodi(1);
        peli.pelaa(this.y, this.x, 1);
        assertTrue(peli.haeLauta().haeRuutuTaulukko()[this.y][this.x].onAuki());

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

    @Test
    public void laskeekoAvaamattomat() {

        assertEquals(12, peli.laskeAvaamattomat());
        peli.haeLauta().haeRuutuTaulukko()[0][0].muutaAvoimuus(true);
        assertEquals(11, peli.laskeAvaamattomat());

    }

    @Test
    public void lopettaakoPelin() {
        peli.lopetaPeli();
        assertFalse(peli.onkoPeliKaynnissa());
    }

    @Test
    public void toimiikoOnkoPeliKaynnissa() {
        assertTrue(peli.onkoPeliKaynnissa());
    }

    @Test
    public void laskeekoSiirrotOikein() {
        assertEquals(0, peli.siirtoja());
        peli.pelaa(0, 0, 1);
        assertEquals(1, peli.siirtoja());

    }

    @Test
    public void tarkistaakoPelinLoppumisenMiinaanOsuttua() {
        apumetodi(9);
        peli.pelaa(y, x, 1);
        assertFalse(peli.onkoPeliKaynnissa());
    }

    @Test
    public void tarkistaakoPelinLoppumisen() {
        apumetodi(0);
        peli.pelaa(y, x, 1);
        assertTrue(peli.onkoPeliKaynnissa());
    }
}
