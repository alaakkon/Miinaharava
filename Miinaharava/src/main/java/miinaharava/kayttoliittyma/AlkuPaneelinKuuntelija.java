/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author anna
 */
public class AlkuPaneelinKuuntelija implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
    AlkuPaneeli a=new AlkuPaneeli();
    a.talleta();
    }
    
}
