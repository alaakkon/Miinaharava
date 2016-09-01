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
 * @author anna
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

    @Override
    public void actionPerformed(ActionEvent e) {
        int korkeusLukuna = Integer.parseInt(korkeus.getText());
        int leveysLukuna = Integer.parseInt(leveys.getText());

        k.luoPelipaneeli(korkeusLukuna, leveysLukuna);
        // System.out.println(Integer.parseInt(korkeus.getText()) + "," + Integer.parseInt(leveys.getText()));
    }
}
