package miinaharava.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 * Luokassa luodaan pelilauta käyttäjän määräämän koon mukaisesti pelia varten.
 */
public class Lauta {

    private int leveys;
    private int korkeus;
    private Ruutu[][] pelilauta;
    private ArrayList<Integer> arvontaLista;

    public Lauta(int korkeus, int leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.pelilauta = new Ruutu[korkeus][leveys];

    }

    /**
     * Metodi hakee kaksiuloitteisen taulukon, pelilaudan.
     */
    public Ruutu[][] haeRuutuTaulukko() {
        return pelilauta;
    }

    /**
     * Metodi Muodostaa pelilaudan peliä varten.
     */
    public void alustaLauta() {
        luoRuudut();
        arvoMiinatLaudalle();
        merkitseVierustat();
        // tulostaTilat();
    }

    /**
     * Metodi alustaa pelilaudan luomalla kaksiuloiteeseen taulukkon jokaiseen
     * muuttujaan Ruutu-olion.
     */
    public void luoRuudut() {
        for (int y = 0; y < pelilauta.length; y++) {
            for (int x = 0; x < pelilauta[0].length; x++) {
                pelilauta[y][x] = new Ruutu();
            }
        }
    }

    /**
     * Metodi luo pelilaudalle miinat.
     */
    public void arvoMiinatLaudalle() {
        this.arvontaLista = new ArrayList<Integer>();
        int koko = pelilauta[0].length * pelilauta.length;
        int rivi = 0;
        int sarake = 0;
        int luku = 0;
        for (int i = 0; i < koko; i++) {
            arvontaLista.add(i);
        }
        Collections.shuffle(arvontaLista);
        int miinoja = montakoMiinaa();
        if (miinoja == 0) {
            miinoja = 1;
        }

        for (int i = 0; i < miinoja; i++) {
            luku = arvontaLista.get(i);
            rivi = luku / pelilauta[0].length;
            sarake = luku % pelilauta[0].length;
            pelilauta[rivi][sarake].muutaTila(9);
        }

    }

    /**
     * Metodi merkitsee miinoja sisältävien ruutuihin kyseisen ruutuun
     * kosketuksissa olevien miinojen lukumäärän.
     */
    public void merkitseVierustat() {

        for (int a = 0; a < pelilauta.length; a++) {
            for (int b = 0; b < pelilauta[0].length; b++) {
                if (pelilauta[a][b].haeTila() == 9) {
                    merkitse(a, b);
                }
            }
        }
    }

    public void merkitse(int a, int b) {
        int xAlku = Math.max(b - 1, 0);
        int xLoppu = Math.min(b + 1, pelilauta[0].length - 1);
        int yAlku = Math.max(a - 1, 0);
        int yLoppu = Math.min(a + 1, pelilauta.length - 1);

        for (int i = yAlku; i <= yLoppu; i++) {
            for (int j = xAlku; j <= xLoppu; j++) {
                if (pelilauta[i][j].haeTila() != 9) {
                    int l = pelilauta[i][j].haeTila();
                    pelilauta[i][j].muutaTila(l + 1);

                }
            }
        }
    }

    public int montakoMiinaa() {
        return (pelilauta.length * pelilauta[0].length * 15) / 100;
    }

}
