/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import miinaharava.logiikka.PelinKulku;

/**
 *
 * Luokka tarjoaa toiminnat tulosten tallentamiseen ja niiden hakemisen
 * käyttöön.
 */
public class TiedostonKasittelija {

    ArrayList<String> lista;
    String tiedostoPolku;
    private String parasAika;

    public TiedostonKasittelija() {

        this.lista = new ArrayList<String>();
        tiedostoPolku = "tulokset.txt";
        lueTiedosto();
        this.parasAika = "";

    }

    /**
     * Metodi lukee File tulokset tiedoston ArrayList listaksi.
     */
    public ArrayList lueTiedosto() {
        File tulokset = new File(tiedostoPolku);
        if (!tulokset.exists()) {
            return lista;
        }

        Scanner lukija = null;

        try {
            lukija = new Scanner(tulokset);
        } catch (Exception e) {
        }

        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            lista.add(rivi);
        }
        lukija.close();
        return lista;
    }

    /**
     * Metodi korvaa lista:lle syötteen mukaisen merkkijonon kohta merkkijonon
     * tilalle.
     *
     */
    public void korvaaTulos(String tulos) {
        String[] koko = tulos.split("=");
        String[] osat = koko[0].split(",");
        for (int i = 0; i < lista.size(); i++) {
            String kohta = lista.get(i);
            if (kohta.startsWith(koko[0] + "=")) {
                lista.remove(i);
                break;
            }

        }
        lista.add(tulos);
        kirjoitaTuloksetTiedostoon();

    }

    /**
     * Metodi kirjoittaa ArrayList lista:n tiedostomuotoon.
     *
     */
    private void kirjoitaTuloksetTiedostoon() {
        FileWriter kirjoittaja = null;
        try {
            File tulokset = new File(tiedostoPolku);
            kirjoittaja = new FileWriter(tulokset);
            for (int i = 0; i < lista.size(); i++) {
                kirjoittaja.write(lista.get(i) + "\n");
            }
            kirjoittaja.close();
        } catch (IOException ex) {
        }
    }

    /**
     * Metodi hakee paremman tuloksen ja palauttaa sen.
     */
    public String haeParempiTulos(String tulos) {
        etsiParempiTulos(tulos);
        return parasAika;

    }

    /**
     * Metodi vertaa lista:lla olevaa tuloksen osan arvon ja palauttaa
     * muuttujaan pienemmän osan omaavan.
     *
     * @param tulos
     *
     */
    private void etsiParempiTulos(String tulos) {
        String[] jaettuTulos = jaaTulos(tulos);
        String[] aika = jaaRuudukkoKoordinaatteihin(jaettuTulos[1]);
        for (int i = 0; i < lista.size(); i++) {
            String kohta = lista.get(i);
            if (kohta.startsWith(jaettuTulos[0] + "=")) {
                String[] koko = jaaTulos(kohta);
                if (Integer.parseInt(koko[1]) < Integer.parseInt(aika[1])) {
                    parasAika = koko[1];
                } else {
                    parasAika = aika[1];
                }
            }

        }

    }

    /**
     * Metodi jakaa merkkijonon kohdasta =.
     *
     * @param tulos
     * @return
     */
    private String[] jaaTulos(String tulos) {
        return tulos.split("=");

    }

    /**
     * Metodi jakaa merkkijonon kohdasta ,.
     *
     * @param tulos
     * @return
     */
    private String[] jaaRuudukkoKoordinaatteihin(String tulos) {
        return tulos.split(",");

    }
}
