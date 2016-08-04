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
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * @author anna
 */
public class LaudanLuominen {

    private int leveys;
    private int korkeus;
    private Ruutu[][] pelilauta;
    private ArrayList<Integer> lista;

    public LaudanLuominen(int korkeus, int leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.pelilauta = new Ruutu[korkeus][leveys];
        this.lista = new ArrayList<Integer>();
    }

    public Ruutu[][] haePelilauta() {
        return pelilauta;
    }

    public void luoLauta(int korkeus, int leveys) {
        alustaLauta();
        arvoMiinatLaudalle();
        merkitseVierustat();
    }

    public void alustaLauta() {
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                pelilauta[y][x] = new Ruutu();
            }
        }
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
        int miinoja = this.korkeus * this.leveys / 20;

        for (int i = 0; i < miinoja; i++) {
            luku = lista.get(i);
            rivi = luku / leveys;
            sarake = luku % leveys;
            pelilauta[rivi][sarake].muutaTila(9);
        }
    }

    public void tulostaTilat() {
        for (int y = 0; y < this.korkeus; y++) {
            System.out.println("");
            for (int x = 0; x < this.leveys; x++) {
                System.out.print(pelilauta[y][x].haeTila());
            }
        }
    }

    public void tulostaStatus() {
        for (int y = 0; y < this.korkeus; y++) {
            System.out.println("");
            for (int x = 0; x < this.leveys; x++) {

                if (pelilauta[y][x].onAuki() == true) {
                    System.out.print(pelilauta[y][x].haeTila());
                } else {
                    System.out.print("X");
                }
            }
        }
    }

    public void merkitseVierustat() {

        for (int a = 0; a < korkeus; a++) {
            for (int b = 0; b < leveys; b++) {
                if (pelilauta[a][b].haeTila() == 9) {
                    merkitse(a, b);
                }
            }
        }
    }

    public void merkitse(int a, int b) {
        int xAlku = Math.max(b - 1, 0);
        int xLoppu = Math.min(b + 1, leveys - 1);
        int yAlku = Math.max(a - 1, 0);
        int yLoppu = Math.min(a + 1, korkeus - 1);

        for (int i = yAlku; i <= yLoppu; i++) {
            for (int j = xAlku; j <= xLoppu; j++) {
                if (pelilauta[i][j].haeTila() != 9) {
                    int l = pelilauta[i][j].haeTila();
                    pelilauta[i][j].muutaTila(l + 1);

                }
            }
        }
    }
}
