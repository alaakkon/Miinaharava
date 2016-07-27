package runko;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alaakkon
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * @author anna
 */
public class LaudanLuominen {

    private int leveys;
    private int korkeus;
    Ruutu ruutu;
    private Ruutu[][] pelilauta;
    private ArrayList<Integer> lista;
    private int y;
    private int x;

    public LaudanLuominen(int korkeus, int leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.pelilauta = new Ruutu[korkeus][leveys];
        this.lista = new ArrayList<Integer>();
        ruutu = new Ruutu(y, x);
    }

    public Ruutu[][] haePelilauta() {
        return pelilauta;

    }

    public Ruutu[][] alustaLauta() {
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                pelilauta[y][x] = new Ruutu(y, x);
            }
        }
        return pelilauta;
    }

    public void arvoMiinatLaudalle() {
        int koko = leveys * korkeus;
        int rivi = 0;
        int sarake = 0;
        int luku = 0;
        for (int i = 0; i < koko; i++) {
            lista.add(i);
        }
        Collections.shuffle(lista);
        {
        }
        double k = 0.15 * koko;
        int miinoja = intValue(k);

        for (int i = 0; i < miinoja; i++) {
            luku = lista.get(i);
            rivi = luku / leveys;
            sarake = luku % leveys;
            // pelilauta[rivi][sarake].muutaTila(rivi, sarake, 9);
            pelilauta[rivi][sarake].muutaTila(rivi, sarake, 9);
        }
    }

    public void tulostaTilat() {
        for (int y = 0; y < 5; y++) {
            System.out.println("");
            for (int x = 0; x < 5; x++) {
                System.out.print(pelilauta[y][x].haeTila(y, x));
            }
        }
    }

    public void tulostaStatus() {
        for (int y = 0; y < 5; y++) {
            System.out.println("");
            for (int x = 0; x < 5; x++) {

                System.out.print(pelilauta[y][x].haeStatus(y, x));
            }
        }
    }

    public void merkitseVierustat() {
        int luku = 0;
        for (int a = 0; a < korkeus - 1; a++) {
            for (int b = 0; b < leveys - 1; b++) {
                if (pelilauta[a][b].haeTila(a, b) == 9) {
                    int x_alku = Math.max(a - 1, 0);
                    int x_loppu = Math.min(a + 1, leveys - 1);
                    int y_alku = Math.max(b - 1, 0);
                    int y_loppu = Math.min(b + 1, korkeus - 1);

                    for (int i = y_alku; y < y_loppu; y++) {
                        for (int j = x_alku; j < x_loppu; x++) {
                            pelilauta[i][j].muutaTila(i, j, 0);
//                            if (pelilauta[i][j].haeTila(i, j) == -1) {
//                                pelilauta[i][j].muutaTila(i, j, 0);
//                            } else if (pelilauta[i][j].haeTila(i, j) == 9) {
//
//                            } else {
//                                pelilauta[i][j].muutaTila(i, j, pelilauta[i][j].haeTila(i, j) + 1);
//                            }
//                        }
//                    }

                        }
                    }
                }
            }
        }
    }
}
//    private int leveys;
//    private int korkeus;
//    private String vaikeustaso;
//    //  private String pelilauta;
//    private List<Integer> lauta2;
//    private int peli[][];
//    private Random arpoja;
//    private int[][] pel;
//
//    public LaudanLuominen(int korkeus, int leveys) {
//        this.leveys = leveys;
//        this.korkeus = korkeus;
//        this.vaikeustaso = vaikeustaso;
//        this.peli = new int[korkeus][leveys];
//        this.lauta2 = new ArrayList<Integer>();
//        this.pel = new int[korkeus + 2][leveys + 2];
//    }
//
////    public LaudanLuominen() {
////        this.leveys = leveys;
////        this.korkeus = leveys;
////        this.vaikeustaso = vaikeustaso;
////        this.peli = new int[korkeus][leveys];
////        this.lauta2 = new ArrayList<Integer>();
////    }
//    public int[][] luoLauta() {
//
//        arvoMiinatLaudalle();
//        merkitseVierustat();
//        return peli;
//    }
//
//    public int[][] arvoMiinatLaudalle() {
//
//        int koko = leveys * korkeus;
//        int rivi = 0;
//        int sarake = 0;
//        int luku = 0;
//        for (int i = 0; i < koko; i++) {
//            lauta2.add(i);
//
//        }
//        Collections.shuffle(lauta2);
//
//        double k = 0.15 * koko;
//        int miinoja = intValue(k);
//
//        for (int i = 0; i < miinoja; i++) {
//            luku = lauta2.get(i);
//            rivi = luku / leveys;
//            sarake = luku % leveys;
//
//            peli[rivi][sarake] = 9;
//        }
//        return peli;
//    }
//
//    public int[][] merkitseVierustat() {
//
//        for (int q = 0; q < korkeus; q++) {
//            for (int w = 0; w < leveys - 1; w++) {
//                if (peli[q][w] == 9) {
//                    if (peli[q][w + 1] != 9) {
//                        peli[q][w + 1] = peli[q][w + 1] + 1;
//                    }
//                }
//            }
//        }
//        for (int q = 1; q < korkeus; q++) {
//            for (int w = 0; w < leveys; w++) {
//                if (peli[q][w] == 9) {
//                    if (peli[q - 1][w] != 9) {
//                        peli[q - 1][w] = peli[q - 1][w] + 1;
//                    }
//                }
//            }
//        }
//        for (int q = 0; q < korkeus; q++) {
//            for (int w = 0; w < leveys - 1; w++) {
//                if (peli[q][w + 1] == 9) {
//                    if (peli[q][w] != 9) {
//                        peli[q][w] = peli[q][w] + 1;
//                    }
//                }
//            }
//        }
//
//        for (int q = 0; q < korkeus - 1; q++) {
//            for (int w = 0; w < leveys; w++) {
//                if (peli[q][w] == 9) {
//                    if (peli[q + 1][w] != 9) {
//                        peli[q + 1][w] = peli[q + 1][w] + 1;
//                    }
//                }
//            }
//        }
//        for (int q = 1; q < korkeus; q++) {
//            for (int w = 1; w < leveys; w++) {
//                if (peli[q][w] == 9) {
//                    if (peli[q - 1][w - 1] != 9) {
//                        peli[q - 1][w - 1] = peli[q - 1][w - 1] + 1;
//                    }
//                }
//            }
//        }
//
//        for (int q = 1; q < korkeus; q++) {
//            for (int w = 0; w < leveys - 1; w++) {
//                if (peli[q][w] == 9) {
//                    if (peli[q - 1][w + 1] != 9) {
//                        peli[q - 1][w + 1] = peli[q - 1][w + 1] + 1;
//                    }
//                }
//            }
//        }
//        for (int q = 0; q < korkeus - 1; q++) {
//            for (int w = 1; w < leveys; w++) {
//                if (peli[q][w] == 9) {
//                    if (peli[q + 1][w - 1] != 9) {
//                        peli[q + 1][w - 1] = peli[q + 1][w - 1] + 1;
//                    }
//                }
//            }
//        }
//        for (int q = 0; q < korkeus - 1; q++) {
//            for (int w = 0; w < leveys - 1; w++) {
//                if (peli[q][w] == 9) {
//                    if (peli[q + 1][w + 1] != 9) {
//                        peli[q + 1][w + 1] = peli[q + 1][w + 1] + 1;
//                    }
//                }
//            }
//        }
//
//        return peli;
//
//    }
//
//    public int[][] haePelilauta() {
//        return peli;
//    }
//
//    public void tulosta() {
//        for (int i = 0; i < peli.length; i++) {
//            for (int j = 0; j < peli[0].length; j++) {
//                System.out.print(peli[i][j] + " ");
//            }
//            System.out.println();
//            System.out.println("");
//        }
//    }

