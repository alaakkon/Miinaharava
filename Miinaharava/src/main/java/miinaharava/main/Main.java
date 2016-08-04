package miinaharava.main;

<<<<<<< HEAD

import miinaharava.logiikka.LaudanLuominen;
=======
import miinaharava.logiikka.LaudanLuominen;
import miinaharava.logiikka.Peli;
>>>>>>> 443e5d9f94e5588d94c8a21ea0956eb6bc38fa22

public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD

        LaudanLuominen peli = new LaudanLuominen(5, 5);
 //       peli.alustaLauta();
//        peli.arvoMiinatLaudalle();
//        peli.tulostaTilat();
//        System.out.println("");
//        peli.merkitseVierustat();
//        peli.tulostaTilat();
//        Ruutu[][] lauta = peli.haePelilauta();
//
//        for (int y = 0; y < 5; y++) {
//            System.out.println("");
//            for (int x = 0; x < 5; x++) {
//                System.out.print(peli.ruutu.heeTila(x, y));
//            }
//        }
=======
        Peli peli = new Peli(8, 8);
        peli.pelaa(1, 1);
        peli.tulostaStatus();
        System.out.println("");
        peli.tulostaTilat();
>>>>>>> 443e5d9f94e5588d94c8a21ea0956eb6bc38fa22
    }
}
