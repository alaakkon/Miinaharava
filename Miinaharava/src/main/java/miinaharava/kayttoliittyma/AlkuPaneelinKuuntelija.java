/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
//import miinaharava.logiikka.PelinKulku;

/**
 *
 * Luokka on alkupaneeli luokan tapahtumien kuuntelija
 */
public class AlkuPaneelinKuuntelija implements ActionListener {

    private JTextField korkeus;
    private JTextField leveys;
    //  private PelinKulku peli;
    private PeliPaneeli pp;
    private KayttoLiittyma k;

    public AlkuPaneelinKuuntelija(KayttoLiittyma k, JTextField korkeus, JTextField leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.k = k;
    }

    /**
     * Metodi toimii hiirtä painettaessa ja luo pelipaneelin.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String syote1 = korkeus.getText();
        String syote2 = leveys.getText();
        int korkeusLukuna;
        int leveysLukuna;
        try {
            korkeusLukuna = Integer.parseInt(korkeus.getText());
            leveysLukuna = Integer.parseInt(leveys.getText());
        } catch (Exception eu) {
            korkeusLukuna = 30;
            leveysLukuna = 30;
        }

        k.luoPelipaneeli(korkeusLukuna, leveysLukuna);
    }
}
