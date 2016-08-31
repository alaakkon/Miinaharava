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

    public TiedostonKasittelija() {

        this.lista = new ArrayList<String>();
        tiedostoPolku = "tulokset.txt";
        lueTiedosto();

    }

    /**
     * Metodi lukee File tulokset tiedoston ArrayList listaksi
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
                kirjoittaja.write(lista.get(i));
            }
            kirjoittaja.close();
        } catch (IOException ex) {
        }
    }

    /**
     * Metodi vertaa lista:lla olevaa tuloksen osan arvon ja palauttaa pienemmän
     * osan omaavan.
     *
     */
    public String haeParempiTulos(String tulos) {

        String[] koko = tulos.split("=");
        String[] osa = koko[0].split(",");
        for (int i = 0; i < lista.size(); i++) {
            String kohta = lista.get(i);
            if (kohta.startsWith(koko[0] + "=")) {
                String[] osa2 = kohta.split("=");
                if (Integer.parseInt(koko[1]) < Integer.parseInt(osa2[1])) {
                    return koko[1];
                } else {
                    return osa2[1];
                }
            }

        }
        return koko[1];
    }
}
