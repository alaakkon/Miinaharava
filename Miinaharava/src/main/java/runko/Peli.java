package runko;

import runko.LaudanLuominen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anna
 */
public class Peli {

    private int[][] peli;
    private int[][] pelilauta;
    LaudanLuominen l;
    int korkeus;
    int leveys;

    public Peli(int korkeus, int leveys) {
        this.l = new LaudanLuominen(korkeus, leveys);
        this.peli = l.luoLauta();
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.pelilauta = new int[korkeus][leveys];
        taytetaanLauta();
    }

    public int[][] taytetaanLauta() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                pelilauta[i][j] = 8;
            }
        }
        return pelilauta;
    }

    public void pelaa(int y, int x) {

        boolean onko = onkoMiina(y, x);
        //   System.out.println(onko+" ja "+peli[y][x]);
        if (onko == false) {

            tyhjanVieressa(y, x);
            tulosta();
        } else {
            System.out.println("Hävisit!!!");
        }
    }

    public boolean onkoMiina(int y, int x) {
        if (peli[y][x] == 9) {
            return true;
        } else {
            return false;
        }
    }

    public int[][] tyhjanVieressa(int y, int x) {
        if (peli[y][x] == 0) {
            pelilauta[y][x] = 0;

            for (int j = y + 1; j <= korkeus; j++) {
                if (peli[j][x] == 0) {
                    pelilauta[j][x] = 0;
                } else {
                    break;
                }
            }
            for (int j = y - 1; j >= 0; j--) {
                if (peli[j][x] == 0) {
                    pelilauta[j][x] = 0;
                } else {
                    break;
                }
            }
            for (int j = x + 1; j <= leveys; j++) {
                if (peli[y][j] == 0) {
                    pelilauta[y][j] = 0;
                } else {
                    break;
                }
            }
            for (int j = x - 1; j >= 0; j--) {
                if (peli[y][j] == 0) {
                    pelilauta[y][j] = 0;
                } else {
                    break;
                }
            }
//            if (y < korkeus && x < leveys && peli[y + 1][x + 1] == 0) {
//                
//                tyhjanVieressa(y + 1, x + 1);
//
//                // tähän kulmat
//                //eka tarkistetaan kulma, sitten reunat, taas kulma
//            }
//            if (y >0 && x >0 && peli[y - 1][x - 1] == 0) {
//                tyhjanVieressa(y - 1, x - 1);
//
//                // tähän kulmat
//                //eka tarkistetaan kulma, sitten reunat, taas kulma
//           }
//if (y >0 && x < leveys && peli[y + 1][x + 1] == 0) {
//                
//                tyhjanVieressa(y - 1, x + 1);
//
//                // tähän kulmat
//                //eka tarkistetaan kulma, sitten reunat, taas kulma
//            }
//            if (y <korkeus && x >0 && peli[y - 1][x - 1] == 0) {
//                tyhjanVieressa(y + 1, x - 1);
//
//                // tähän kulmat
//                //eka tarkistetaan kulma, sitten reunat, taas kulma
//            }
        } else {
            pelilauta[y][x] = peli[y][x];

        }
        return pelilauta;

    }

    public void tulosta() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                System.out.print(peli[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println();
        for (int k = 0; k < korkeus; k++) {
            for (int l = 0; l < leveys; l++) {
                System.out.print(pelilauta[k][l] + " ");
            }
            System.out.println();
        }

    }

}
