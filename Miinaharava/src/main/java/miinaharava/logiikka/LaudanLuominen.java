package miinaharava.logiikka;

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

    public Ruutu[][] luoLauta(int korkeus, int leveys) {
        alustaLauta();
        arvoMiinatLaudalle();
        merkitseVierustat();
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
            pelilauta[rivi][sarake].muutaTila(9);
        }
    }

    public void tulostaTilat() {
        for (int y = 0; y < 5; y++) {
            System.out.println("");
            for (int x = 0; x < 5; x++) {
                System.out.print(pelilauta[y][x].haeTila());
            }
        }
    }

    public void tulostaStatus() {
        for (int y = 0; y < 5; y++) {
            System.out.println("");
            for (int x = 0; x < 5; x++) {

                System.out.print(pelilauta[y][x].haeStatus());
            }
        }
    }

    public void merkitseVierustat() {

        for (int a = 0; a < korkeus; a++) {
            for (int b = 0; b < leveys; b++) {
                if (pelilauta[a][b].haeTila() == 9) {
                    int x_alku = Math.max(b - 1, 0);
                    int x_loppu = Math.min(b + 1, leveys - 1);
                    int y_alku = Math.max(a - 1, 0);
                    int y_loppu = Math.min(a + 1, korkeus - 1);

                    for (int i = y_alku; i <= y_loppu; i++) {
                        for (int j = x_alku; j <= x_loppu; j++) {
                            if (pelilauta[i][j].haeTila() != 9) {
                                int l = pelilauta[i][j].haeTila();
                                pelilauta[i][j].muutaTila(l + 1);
                            }
                        }
                    }
                }
            }
        }
    }
}
