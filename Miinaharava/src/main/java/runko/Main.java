package runko;

public class Main {

    public static void main(String[] args) {

        int x = 0;
        int y = 0;
        LaudanLuominen l = new LaudanLuominen(5, 5);
        l.arvoMiinatLaudalle();
        l.merkitseVierustat();
        int[][] peli = l.haePelilauta();

        l.tulosta();
        for (int i = 1; i < 4; i++) {
            System.out.println("");

            for (int j = 1; j < 4; j++) {
                System.out.print(peli[i][j]);
            }
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (peli[i][j] == 9) {
                    y = i;
                    x = j;
                    break;

                }
            }

        }
        System.out.println("");
        System.out.println(y + "," + x);

        if (peli[y][x] == 0) {
            System.out.println("ei");
        } else {
            System.out.println("juu");
        }
    }
}
