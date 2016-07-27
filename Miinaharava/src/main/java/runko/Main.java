package runko;

public class Main {

    public static void main(String[] args) {

        LaudanLuominen peli = new LaudanLuominen(5, 5);
        peli.alustaLauta();
        peli.arvoMiinatLaudalle();
        peli.tulostaTilat();
        peli.merkitseVierustat();
        peli.tulostaTilat();
//        Ruutu[][] lauta = peli.haePelilauta();
//
//        for (int y = 0; y < 5; y++) {
//            System.out.println("");
//            for (int x = 0; x < 5; x++) {
//                System.out.print(peli.ruutu.heeTila(x, y));
//            }
//        }
    }
}
