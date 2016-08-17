package miinaharava.logiikka;

/**
 * Luokassa käsitellään pelilaudan sisältämien ruutujen yksittäisiä
 * ominaisuuksia.
 */
public class Ruutu {

    private boolean avoimuus;
    private int tila;

    public Ruutu() {
        this.avoimuus = false;
        this.tila = 0;
    }

    /**
     * Metodi tarkistaa, onko kyseinen Ruutu jo avattu eli "pelattu" .
     */
    public boolean onAuki() {
        return avoimuus;
    }

    /**
     * Metodi hakee kyseisen ruudun tilan, jolla tarkoitetaan sitä, että onko
     * ruudussa miina tai kuinka moneen miinoja sisältäviin ruutuihin ruutu on
     * kosketuksissa..
     */
    public int haeTila() {
        return tila;
    }

    /**
     * Metodi muuttaa tilan syötteen mukaiseksi.
     *
     * @param muutos
     */
    public void muutaTila(int muutos) {
        this.tila = muutos;
    }

    /**
     * Metodi muuttaa ruudun avoimuuden eli pelaamattoman ruudun pelatuksi.
     *
     * @param muutos
     */
    public void muutaAvoimuus(boolean muutos) {
        this.avoimuus = muutos;
    }
}
