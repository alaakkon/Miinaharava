package miinaharava.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import miinaharava.logiikka.Ruutu;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anna
 */
public class RuutuTest {

    private Ruutu ruutu;

    public RuutuTest() {
        this.ruutu = new Ruutu();
    }

    @Test
    public void hakeekoTilanOikein() {
        int luku = ruutu.haeTila();
        assertEquals(luku, 0);
    }

    @Test
    public void hakeekoStauksenOikein() {
        assertFalse(ruutu.onAuki());
    }

    @Test
    public void muuttaakoTilanOikein() {

        ruutu.muutaTila(3);
        assertEquals(3, ruutu.haeTila());
    }

    @Test
    public void muuttaakoStatuksenOikein() {

        ruutu.muutaAvoimuus(true);
        assertEquals(true, ruutu.onAuki());
    }

    @Test
    public void hakeekoLiputuksenOikein() {
        assertFalse(ruutu.haeLiputusTila());
    }

    @Test
    public void muuttaakoLiputuksenOikein() {
        ruutu.muutaLiputus();
        assertTrue(ruutu.haeLiputusTila());
        ruutu.muutaLiputus();
        assertFalse(ruutu.haeLiputusTila());
    }
}
