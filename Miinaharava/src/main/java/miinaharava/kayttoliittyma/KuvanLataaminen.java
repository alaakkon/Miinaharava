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
import javax.imageio.ImageIO;


/**
 *
 * @author alaakkon
 */
public class KuvanLataaminen {

    public KuvanLataaminen() {
    }

    public static Image haeKuva(String kuvanNimi) throws IOException  {
        URL url = KuvanLataaminen.class.getClassLoader().getResource(kuvanNimi + ".png");
        BufferedImage kuva=ImageIO.read(url);
        return kuva;
    }
}

