package runko;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import runko.LaudanLuominen;
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
public class LaudanLuominenTest {

    private LaudanLuominen l;
    private LaudanLuominen l1;
    private LaudanLuominen l2;
    private LaudanLuominen l3;

    private int[][] lauta;
    private int[][] laut;
    private int[][] lau;
    private int x;
    private int y;

    public LaudanLuominenTest() {
        l = new LaudanLuominen(5, 5);
        l1 = new LaudanLuominen(8, 8);
        l2 = new LaudanLuominen(1, 7);
        l3 = new LaudanLuominen(4, 4);
        lauta = new int[4][4];
        laut = new int[8][8];
        lau = new int[1][7];
        y = 0;
        x = 0;
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @Test
    public void luokoPelilaudan() {
        int[][] la = new int[4][5];
        int korkeus = la.length;
        int leveys = la[1].length;
        LaudanLuominen testi = new LaudanLuominen(4, 5);
        int[][] test = testi.luoLauta();
        assertEquals(korkeus, test.length);
        assertEquals(leveys, test[1].length);
    }

    @Test
    public void arpookoOikeanMaaranMiinoja() {
        l1.arvoMiinatLaudalle();
        int miinojal = 64 * 15 / 100;
        l2.arvoMiinatLaudalle();
        int miinojal2 = 7 * 15 / 100;

        assertEquals(miinojal, apuLaskuri(l1.haePelilauta()));
        assertEquals(miinojal2, apuLaskuri(l2.haePelilauta()));
    }

    public int apuLaskuri(int[][] taulukko) {
        int kpl = 0;
        for (int i = 0; i < taulukko.length; i++) {
            for (int j = 0; j < taulukko[0].length; j++) {
                if (taulukko[i][j] == 9) {
                    kpl++;
                }
            }
        }
        return kpl;
    }

//    @Test
//    public void merkitseekoVierustanOikeinOikealle() {
//        l1.arvoMiinatLaudalle();
//        l1.merkitseVierustat();
//        lauta = l1.haePelilauta();
//        boolean onko = onkoMerkitty(lauta, y, x);
//        assertTrue(onko);
//
//    }

    public void etsiMiina(int[][] taulukko) {
        int y = 0;
        int x = 0;
        double luku = 0;
        for (int i = 1; i < taulukko.length - 1; i++) {
            for (int j = 0; j < taulukko[0].length - 1; j++) {
                if (taulukko[i][j] == 9) {
                    y = i;
                    x = j;
                    break;
                }
            }
        }
    }

    public boolean onkoMerkitty(int[][] taulukko, int y, int x) {
        if (taulukko[y][x] == 0) {
            return false;
        } else {
            return true;
        }
    }
}
