/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.Timer;
import miinaharava.logiikka.PelinKulku;

/**
 *
 * @author alaakkon
 */
public class KellonKuuntelija implements ActionListener {

    private PelinKulku peli;
    private Timer ajastin;
    private JTextField alue;
    private int aika;

    public KellonKuuntelija(JTextField alue, PelinKulku peli) {
        ajastin = new Timer(1000, this);
        this.alue = alue;
        ajastin.start();
        this.aika = 0;
        this.peli = peli;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        aika = aika + 1;
//        alue.setText("" + aika);
        //}
        if (peli.onkoPeliKaynnissa()) {
            aika = aika + 1;
            alue.setText("" + aika);
        } else {
            aika = aika;
            alue.setText("" + aika);
            ajastin.stop();
        }
    }
}
