package miinaharava.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import miinaharava.logiikka.LaudanLuominen;
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
        l = new LaudanLuominen(10,10);
        l1 = new LaudanLuominen(8, 8);
        l2 = new LaudanLuominen(1, 7);
        l3 = new LaudanLuominen(7, 1);
        this.y = 0;
        this.x = 0;
    }

//    @Test
//    public void luokoOikeanKorkuisenPelilaudan() {
//        int[][] la = new int[4][5];
//        int korkeus = la.length;
//        int leveys = la[1].length;
//        LaudanLuominen testi = new LaudanLuominen(4, 5);
//        int[][] test = testi.luoLauta();
//        assertEquals(korkeus, test.length);
//
//    }
//
//    @Test
//    public void luokoOikeanLevysenPelilaudan() {
//        int[][] la = new int[4][5];
//        int korkeus = la.length;
//        int leveys = la[1].length;
//        LaudanLuominen testi = new LaudanLuominen(4, 5);
//        int[][] test = testi.luoLauta();
//
//        assertEquals(leveys, test[1].length);
//    }
//
//    @Test
//    public void arpookoOikeanMaaranMiinoja() {
//        l1.arvoMiinatLaudalle();
//        int miinojal = 64 * 15 / 100;
//        l2.arvoMiinatLaudalle();
//        int miinojal2 = 7 * 15 / 100;
//
//        assertEquals(miinojal, apuLaskuri(l1.haePelilauta()));
//        assertEquals(miinojal2, apuLaskuri(l2.haePelilauta()));
//    }
//
//    public int apuLaskuri(int[][] taulukko) {
//        int kpl = 0;
//        for (int i = 0; i < taulukko.length; i++) {
//            for (int j = 0; j < taulukko[0].length; j++) {
//                if (taulukko[i][j] == 9) {
//                    kpl++;
//                }
//            }
//        }
//        return kpl;
//    }
//
//    public void apumetodiEtsiMiina(int[][] taulukko) {
//        for (int i = 1; i < 9; i++) {
//            for (int j = 1; j < 9; j++) {
//                if (taulukko[i][j] == 9) {
//                    y = i;
//                    x = j;
//                    break;
//                }
//            }
//
//        }
//    }
//
//    
//
//    public boolean apumetodiOnkoMerkitty(int[][] taulukko, int y, int x) {
//        if (taulukko[y][x] == 0) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    @Test
//    public void merkitseekoVierustanOikeinOikealle() {
//        l.arvoMiinatLaudalle();
//        l.merkitseVierustat();
//        int[][] pl = l.haePelilauta();
//        apumetodiEtsiMiina(pl);
//
//        assertTrue(apumetodiOnkoMerkitty(pl, y, x + 1));
//    }
//
//    @Test
//    public void merkitseekoVierustanOikeinVasemmalle() {
//
//        l.arvoMiinatLaudalle();
//       l.merkitseVierustat();
//        int[][] pl = l.haePelilauta();
//        
//       
//        
//        apumetodiEtsiMiina(pl);
//
//        assertTrue(apumetodiOnkoMerkitty(pl, y, x - 1));
//    }
//
//    @Test
//    public void merkitseekoVierustanOikeinYlos() {
//        l.arvoMiinatLaudalle();
//        l.merkitseVierustat();
//        int[][] pl = l.haePelilauta();
//        apumetodiEtsiMiina(pl);
//
//        assertTrue(apumetodiOnkoMerkitty(pl, this.y-1, this.x));
//    }
//
//    @Test
//    public void merkitseekoVierustanOikeinAlas() {
//        l.arvoMiinatLaudalle();
//        l.merkitseVierustat();
//        int[][] pl = l.haePelilauta();
//        apumetodiEtsiMiina(pl);
//
//        assertTrue(apumetodiOnkoMerkitty(pl, this.y+1, this.x));
//    }
//
//    @Test
//    public void merkitseekoVierustanOikeinVasemmalleYlos() {
//        l.arvoMiinatLaudalle();
//        l.merkitseVierustat();
//        int[][] pl = l.haePelilauta();
//        apumetodiEtsiMiina(pl);
//
//        assertTrue(apumetodiOnkoMerkitty(pl, y - 1, x - 1));
//    }
//
//    @Test
//    public void merkitseekoVierustanOikeinOikealleYlos() {
//        l.arvoMiinatLaudalle();
//        l.merkitseVierustat();
//        int[][] pl = l.haePelilauta();
//        apumetodiEtsiMiina(pl);
//
//        assertTrue(apumetodiOnkoMerkitty(pl, y - 1, x + 1));
//    }
//
//    @Test
//    public void merkitseekoVierustanOikeinVasemmalleAlas() {
//        l.arvoMiinatLaudalle();
//        l.merkitseVierustat();
//        int[][] pl = l.haePelilauta();
//        apumetodiEtsiMiina(pl);
//
//        assertTrue(apumetodiOnkoMerkitty(pl, y + 1, x - 1));
//    }
//
//    @Test
//    public void merkitseekoVierustanOikeinOikealleAlas() {
//        l.arvoMiinatLaudalle();
//        l.merkitseVierustat();
//        int[][] pl = l.haePelilauta();
//        apumetodiEtsiMiina(pl);
//
//        assertTrue(apumetodiOnkoMerkitty(pl, y + 1, x + 1));
//    }
}
