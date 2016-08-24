/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharava.kayttoliittyma;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * Luokka lataa kuvan tiedostosta pelin käyttöön.
 */
public class KuvanLataaminen {

    public KuvanLataaminen() {
    }

    /**
     * Lataa käyttäjän haluaman kuvan tiedostosta
     *
     * @param kuvanNimi
     * @return
     */
    public static Image haeKuva(String kuvanNimi) {
        URL url = KuvanLataaminen.class.getClassLoader().getResource(kuvanNimi + ".png");
        BufferedImage kuva = null;
        try {
            kuva = ImageIO.read(url);
            return kuva;
        } catch (IOException ex) {

        }
        return kuva;
    }
}
