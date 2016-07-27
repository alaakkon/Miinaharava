package miinaharava.logiikka;

import miinaharava.logiikka.LaudanLuominen;

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

    public Peli() {

//    private int[][] peli;
//    private int[][] pelilauta;
//    private int[][] tarkistus;
//    LaudanLuominen l;
//    int korkeus;
//    int leveys;
//
//    public Peli(int korkeus, int leveys) {
//        this.l = new LaudanLuominen(korkeus, leveys);
//        this.peli = l.luoLauta();
//        this.korkeus = korkeus;
//        this.leveys = leveys;
//        this.pelilauta = new int[korkeus][leveys];
//        this.tarkistus = new int[korkeus][leveys];
//        taytetaanLauta(pelilauta);
//        taytetaanLauta(tarkistus);
//    }
//
//    public int[][] taytetaanLauta(int[][] lauta) {
//        for (int i = 0; i < korkeus; i++) {
//            for (int j = 0; j < leveys; j++) {
//                pelilauta[i][j] = 8;
//            }
//        }
//        return pelilauta;
//    }
//
//    public void pelaa(int y, int x) {
//        tulosta();
//        System.out.println("");
//        boolean onko = onkoMiina(y, x);
//        if (onko == false) {// tähän joku luuppi
//            tyhjanVieressa(y, x);
//        //    tyhjaKulma(y, x);
//        } else {
//            System.out.println("Hävisit!!!");
//        }
//        tulosta();
//    }
//
//    public boolean onkoMiina(int y, int x) {
//        if (peli[y][x] == 9) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public int[][] tyhjanVieressa(int y, int x) {
//
//        if (peli[y][x] == 0) {
//            pelilauta[y][x] = 0;
//
//            for (int j = y + 1; j <= korkeus; j++) {//alas
//                if (peli[j][x] == 0) {
//                    pelilauta[j][x] = 0;
//                } else {
//                    break;
//                }
//            }
//            for (int j = y - 1; j >= 0; j--) {//ylös
//                if (peli[j][x] == 0) {
//                    pelilauta[j][x] = 0;
//                } else {
//                    break;
//                }
//            }
//            for (int j = x + 1; j <= leveys; j++) {//oikea
//                if (peli[y][j] == 0) {
//                    pelilauta[y][j] = 0;
//                } else {
//                    break;
//                }
//            }
//            for (int j = x - 1; j >= 0; j--) {//vasen
//                if (peli[y][j] == 0) {
//                    pelilauta[y][j] = 0;
//                } else {
//                    break;
//                }
//            }
//
//        } else {
//            pelilauta[y][x] = peli[y][x];
//
//        }
//
//        return pelilauta;
//
//    }
//
////    public int[][] tyhjaKulma(int y, int x) { //Nytm katkaisee suorituksen ,jos osuu oikeaan...luuppi?
////        if (y < korkeus && x < leveys && peli[y + 1][x + 1] == 0) {//oikea alakulma
////            pelilauta[y + 1][x + 1] = 0;
////            tyhjanVieressa(y + 1, x + 1);
////
////        }
////        if (y > 0 && x > 0 && peli[y - 1][x - 1] == 0) {// vasen yläkulma
////            pelilauta[y - 1][x - 1] = 0;
////            tyhjanVieressa(y - 1, x - 1);
////
////        }
////        if (y > 0 && x < leveys && peli[y - 1][x + 1] == 0) {// oikea yläkulma
////            pelilauta[y - 1][x + 1] = 0;
////            tyhjanVieressa(y - 1, x + 1);
////
////        }
////        if (y < korkeus && x > 0 && peli[y + 1][x - 1] == 0) {// vasen alakulma
////            pelilauta[y + 1][x - 1] = 0;
////            tyhjanVieressa(y + 1, x - 1);
////
////        }
////        return pelilauta;
////    }
//
//    public void tulosta() {
//        for (int i = 0; i < korkeus; i++) {
//            for (int j = 0; j < leveys; j++) {
//                System.out.print(peli[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println();
//        for (int k = 0; k < korkeus; k++) {
//            for (int l = 0; l < leveys; l++) {
//                System.out.print(pelilauta[k][l] + " ");
//            }
//            System.out.println();
//        }
    }

}
