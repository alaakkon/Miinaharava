package miinaharava.logiikka;

/**
 *
 * Luokka tarjoaa Miinaharava pelin pelin kulkemisen toiminnat.
 */
public class PelinKulku {

    private Lauta lauta;
    private boolean peliKaynnissa;
    private int siirtoja;
    private int korkeus;
    private int leveys;

    public PelinKulku(int korkeus, int leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        tarkistaParametrit(korkeus, leveys);
        this.lauta = new Lauta(this.korkeus, this.leveys);
        lauta.alustaLauta();
        this.peliKaynnissa = true;

    }

    /**
     * Metodi hakee Lauta luokan pelilaudan.
     */
    public Lauta haeLauta() {
        return lauta;
    }

    /**
     * Metodi laskee ja palauttaa avaamattomien ruutujen lukumäärän
     *
     */
    public int laskeAvaamattomat() {
        int luku = 0;
        for (int i = 0; i < lauta.haeRuutuTaulukko().length; i++) {
            for (int j = 0; j < lauta.haeRuutuTaulukko()[0].length; j++) {
                if (!lauta.haeRuutuTaulukko()[i][j].onAuki()) {
                    luku++;
                }
            }
        }
        return luku;
    }

    /**
     * Metodilla voidaan tarkistaa onko peli käynnissä vai loppunut.
     *
     * @return boolean peliKaynnissa
     */
    public boolean onkoPeliKaynnissa() {
        return peliKaynnissa;
    }

    /**
     * Metodi muuttaa muuttujan peliKaynnissa falseksi. Peli päättyy.
     */
    public void lopetaPeli() {
        peliKaynnissa = false;
    }

    /**
     * Metodi laskee käytettyjen arvausten lukumäärän.
     */
    public int siirtoja() {
        return this.siirtoja;
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
            peliKaynnissa = false;
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
    public void pelaa(int y, int x, int komento) {
        if (komento == 1) {
            if (onMiina(y, x)) {
                avaaRuutu(y, x);
                peliKaynnissa = false;
            } else if (lauta.haeRuutuTaulukko()[y][x].haeTila() != 0) {
                avaaRuutu(y, x);

            } else {
                avaaNolla(y, x);

            }
        } else if (komento == 3) {
            lauta.haeRuutuTaulukko()[y][x].muutaLiputus();

        }
//        System.out.println(laskeAvaamattomat());
//        System.out.println(lauta.montakoMiinaa());
        tarkistaPelinVoittaminen();
        siirtoja++;

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

//    }// tämä kusee
    private void tarkistaPelinVoittaminen() {
    int miinoja=lauta.montakoMiinaa();
    int avaamattomat= laskeAvaamattomat();
       if(avaamattomat==miinoja){
           this.peliKaynnissa=false;
       }
    }

    /**
     * Metodi tarkastaa ovatko syötteen parametrit sopivat ja muutta ne, jos
     * näin ei ole.
     *
     * @param korkeus
     * @param leveys
     */
    private void tarkistaParametrit(int korkeus, int leveys) {
        if (korkeus < 2 || korkeus > 30) {
            this.korkeus = 30;
        }
        if (leveys < 2 || leveys > 30) {
            this.leveys = 30;
        }
    }
}
