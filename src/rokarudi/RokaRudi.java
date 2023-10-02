package rokarudi;

import java.util.Scanner;

public class RokaRudi {

    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        feladat();
    }

    private static void feladat() {
        String tomb[] = feltoltes();
        kiiras(tomb);
        bekeres();
    }

    private static String[] feltoltes() {
        String tomb[] = new String[24];
        String jelek[] = {"SZ", "M", "T", "L"};
        String szamok[] = {"K", "ÁSZ", "X", "IX", "VIII"};

        int index = 1;
        for (int i = 0; i < jelek.length; i++) {
            for (int j = 0; j < szamok.length; j++) {
                tomb[index++] = jelek[i] + " " + szamok[j];
            }
        }
        return tomb;
    }

    private static void kiiras(String tomb[]) {
        for (int i = 1; i < tomb.length; i++) {
            System.out.printf(tomb[i] + ", ");
            if (i % 3 == 0) {
                System.out.println(" ");
            }
        }
    }

    private static void bekeres() {
        boolean jo = true;
        do {
            System.out.println("Kérek egy számot: [1-3]");
            int szam = sc.nextInt();
            if(szam > 1 || szam < 4){
                jo = false;
            }
        } while (jo == false);
    }

}
