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
 * @author alaakkon
 */
public class TiedostonKasittelija {

    //   PelinKulku peli;
    ArrayList<String> lista;
    //  PeliPaneeli pp;

    String tiedostoPolku;

    public TiedostonKasittelija() {

        //  this.peli = peli;
        this.lista = new ArrayList<String>();
        //this.pp = pp;
        tiedostoPolku = "src/main/resources/tulokset.txt";
        lueTiedosto();

    }

    public ArrayList lueTiedosto() {
        File tulokset = new File("src/main/resources/tulokset.txt");
        Scanner lukija = null;

        try {
            lukija = new Scanner(tulokset);
        } catch (Exception e) {
            // System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            //  return; // poistutaan metodista
        }
        String tallennettu = "";
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            lista.add(rivi);
//            String[] puolitus = rivi.split("=");
//            String[] koko = puolitus[0].split(",");

//            if ((koko[0].equals(peli.haeLauta().haeRuutuTaulukko().length) && koko[1].equals(peli.haeLauta().haeRuutuTaulukko().length[0]) || koko[0].equals(peli.haeLauta().haeRuutuTaulukko().length[0]) && koko[1].equals(peli.haeLauta().haeRuutuTaulukko().length)) && Integer.parseInt(koko[1]) < Integer.parseInt(pp.tuomio.getText())) {
//                tallennettu = "" + peli.haeLauta().haeRuutuTaulukko().length + "," + peli.haeLauta().haeRuutuTaulukko()[0].length + "=" + peli.siirtoja();
        }
        lukija.close();
        return lista;
    }

    public void korvaaTulos(String tulos) {
        String[] koko = tulos.split("=");
        String[] osat = koko[0].split(",");
        for (int i = 0; i < lista.size(); i++) {
            String kohta = lista.get(i);
            String[] koko2 = kohta.split("=");
            String[] osat2 = koko2[0].split(",");
            if ((osat[0].equals(osat2[0]) && (osat[1].equals(osat2[1]) || osat[0].equals(osat2[1]) && osat[1].equals(osat2[0]))) && (Integer.parseInt(koko[1]) < Integer.parseInt(koko2[1]))) {
                lista.add(i, tulos);
            }
        }
        kirjoitaTuloksetTiedostoon();

    }

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

    public String haeParasTulos(String tulos) {
        String palautus="";
        String[] koko = tulos.split("=");
        String[] osat = koko[0].split(",");
        for (int i = 0; i < lista.size(); i++) {
            String kohta = lista.get(i);
            String[] koko2 = kohta.split("=");
            String[] osat2 = koko2[0].split(",");
            if ((osat[0].equals(osat2[0]) && (osat[1].equals(osat2[1]) || osat[0].equals(osat2[1]) && osat[1].equals(osat2[0]))) && (Integer.parseInt(koko[1]) < Integer.parseInt(koko2[1]))) {
                palautus= kohta;
                System.out.println(kohta);
            } else {
                palautus= tulos;
                System.out.println("pyh"+tulos);
            }
        }
return palautus;
    }
}
