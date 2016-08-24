package miinaharava.logiikka;

import miinaharava.logiikka.Lauta;

/**
 *
 * Luokka tarjoaa Miinaharava pelin pelin kulkemisen toiminnat.
 */
public class PelinKulku {

    private Lauta lauta;

    public PelinKulku(int korkeus, int leveys) {
        this.lauta = new Lauta(korkeus, leveys);
        lauta.alustaLauta();
    }

    /**
     * Metodi hakee Lauta luokan pelilaudan.
     */
    public Lauta haeLauta() {
        return lauta;
    }

    /**
     * Metodi tarkistaa sisältääkö annettujen parametrien sisältämä ruutu
     * miinan.
     *
     * @param y korkeuden koordinaatti
     * @param x leveyden koordinaatti
     *
     */
    public boolean onMiina(int y, int x) {
        if (lauta.haeRuutuTaulukko()[y][x].haeTila() == 9) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi toimittaa käyttäjän syötteen mukaisen pelinkulun.
     *
     * @param y korkeuden koordinaatti
     * @param x leveyden koordinaatti
     */
    public void pelaa(int y, int x) {
        if (onMiina(y, x)) {
            avaaRuutu(y, x);
        } else if (lauta.haeRuutuTaulukko()[y][x].haeTila() != 0) {
            avaaRuutu(y, x);
        } else {
            avaaNolla(y, x);
        }
    }

    /**
     * Metodi avaa syötteen mukaisen ruudun.
     *
     * @param y korkeuden koordinaatti
     * @param x leveyden koordinaatti
     */
    public void avaaRuutu(int y, int x) {

        lauta.haeRuutuTaulukko()[y][x].muutaAvoimuus(true);
    }

    /**
     * Metodi avaa ruudun, joka ei ole kosketuksissa miinoja sisältäviin
     * ruutuihin, sekä kaikki ruudun kosketuksissa olevat ruudut ja näitä
     * seuraavat ruudut,jotka eivät myöskään ole kosketuksissa miinoja
     * sisältäviin ruutuihin.
     *
     * @param y korkeuden koordinaatti
     * @param x leveyden koordinaatti
     */
    public void avaaNolla(int y, int x) {
        lauta.haeRuutuTaulukko()[y][x].muutaAvoimuus(true);
        avaaKaikkiViereisetNollat(y, x);
    }

    /**
     * Avataan kaikki ruudut, jotka ovat tyhjiä ja kosketuksissa arvattuun,
     * tyhjään ruutuun.
     *
     * @param b korkeuden koordinaatti
     * @param a leveyden koordinaatti
     */
    public void avaaKaikkiViereisetNollat(int b, int a) {
        int xAlku = Math.max(a - 1, 0);
        int xLoppu = Math.min(a + 1, lauta.haeRuutuTaulukko()[0].length - 1);
        int yAlku = Math.max(b - 1, 0);
        int yLoppu = Math.min(b + 1, lauta.haeRuutuTaulukko().length - 1);
        for (int i = yAlku; i <= yLoppu; i++) {
            for (int j = xAlku; j <= xLoppu; j++) {
                if (lauta.haeRuutuTaulukko()[i][j].haeTila() == 0 && !lauta.haeRuutuTaulukko()[i][j].onAuki()) {
                    avaaNolla(i, j);
                }
            }
        }

    }

    //poistetaan myöhemmin
//    public int annaSuurempiLuku(int a, int b) {
//        if (a >= b) {
//            return a;
//        }
//        return b;
//    }
//
//    public int annaPienempiLuku(int a, int b) {
//        if (a <= b) {
//            return a;
//        }
//        return b;
//    }
//    public void tulostaStatus() {
//        lauta.tulostaTilat();
//    }
//
//    public void tulostaTilat() {
//        lauta.tulostaStatus();
//    }
}
