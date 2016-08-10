package miinaharava.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import miinaharava.logiikka.Lauta;
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

    private Lauta l;
    private Lauta l1;
    private Lauta l2;
    private Lauta l3;
//
 //  private Ruutu[][] lauta;
//    private int[][] laut;
//    private int[][] lau;
    private int x;
    private int y;

    public LaudanLuominenTest() {
        l = new Lauta(10, 9);
        l1 = new Lauta(8, 8);
        l2 = new Lauta(1, 7);
        l3 = new Lauta(7, 1);
        //lauta= new Ruutu[0][0];
        this.y = 0;
        this.x = 0;
    }

    @Test
    public void luokoOikeanKorkuisenPelilaudan() {

        l.luoRuudut();
        assertEquals(l.haePelilauta().length, 10);
    }

    @Test
    public void luokoOikeanLevysenPelilaudan() {

        l.luoRuudut();
        assertEquals(l.haePelilauta()[0].length, 9);
    }

    @Test
    public void arpookoOikeanMaaranMiinoja() {
//        int luku = 0;
//        int luku2 = 13;
//        l.alustaLauta();
//        l.arvoMiinatLaudalle();
//        for (int i = 0; i < l.haePelilauta().length; i++) {
//            for (int j = 0; j < l.haePelilauta()[0].length; j++) {
//                if (l.haePelilauta()[i][j].haeTila() == 9) {
//                    luku++;
//                }
//            }
//        }
//        assertEquals(luku2, luku);
    } @Test
    public void alustaakoOikeinPelilaudan() {
        int luku = 0;
        l.luoRuudut();
        for (int i = 0; i < l.haePelilauta().length; i++) {
            for (int j = 0; j < l.haePelilauta()[0].length; j++) {
                if (l.haePelilauta()[i][j].haeTila() == 0 && l.haePelilauta()[i][j].onAuki() == false) {
                    luku++;
                }
            }
        }
        assertEquals(luku, 90);

    }
 @Test
    public void merkitseekoVierustanAlasOikein() {
    
        l1.luoRuudut();
        l1.haePelilauta()[1][1].muutaTila(9);
        l1.merkitseVierustat();
        assertEquals(l1.haePelilauta()[2][1].haeTila(),1);

    }
     @Test
    public void merkitseekoVierustanOikealleOikein() {
    
        l1.luoRuudut();
        l1.haePelilauta()[1][1].muutaTila(9);
        l1.merkitseVierustat();
        assertEquals(l1.haePelilauta()[1][2].haeTila(),1);

    } @Test
    public void merkitseekoVierustanYlosOikein() {
    
        l1.luoRuudut();
        l1.haePelilauta()[1][1].muutaTila(9);
        l1.merkitseVierustat();
        assertEquals(l1.haePelilauta()[0][1].haeTila(),1);

    } @Test
    public void merkitseekoVierustanVasemmalleOikein() {
    
        l1.luoRuudut();
        l1.haePelilauta()[1][1].muutaTila(9);
        l1.merkitseVierustat();
        assertEquals(l1.haePelilauta()[1][0].haeTila(),1);

    } @Test
    public void merkitseekoVierustanKoilliseenOikein() {
    
        l1.luoRuudut();
        l1.haePelilauta()[1][1].muutaTila(9);
        l1.merkitseVierustat();
        assertEquals(l1.haePelilauta()[0][2].haeTila(),1);

    } @Test
    public void merkitseekoVierustanKaakkoonOikein() {
    
        l1.luoRuudut();
        l1.haePelilauta()[1][1].muutaTila(9);
        l1.merkitseVierustat();
        assertEquals(l1.haePelilauta()[2][2].haeTila(),1);

    } @Test
    public void merkitseekoVierustanLounaaseenOikein() {
    
        l1.luoRuudut();
        l1.haePelilauta()[1][1].muutaTila(9);
        l1.merkitseVierustat();
        assertEquals(l1.haePelilauta()[2][0].haeTila(),1);

    }@Test
    public void merkitseekoVierustanLuoteeseenOikein() {
    
        l1.luoRuudut();
        l1.haePelilauta()[1][1].muutaTila(9);
        l1.merkitseVierustat();
        assertEquals(l1.haePelilauta()[0][0].haeTila(),1);

    }
   
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
