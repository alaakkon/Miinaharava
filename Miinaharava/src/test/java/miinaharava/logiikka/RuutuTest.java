package miinaharava.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import miinaharava.logiikka.Ruutu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anna
 */
public class RuutuTest {

    private Ruutu ruutu;

    public RuutuTest() {
        this.ruutu = new Ruutu(5, 5);
    }

    @Test
    public void hakeekoTilanOikein() {
        assertEquals(ruutu.haeTila(),0);
    }
    
}
