package rokarudi;

import java.util.Scanner;

public class RokaRudi {

    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        feladat();
    }

    private static void feladat() {
        String tomb[] = feltoltes();
        for (int i = 0; i < 3; i++) {
            kiiras(tomb);
            int szam = bekeres();
            kever(tomb, szam);
        }
        ezVolt(tomb);
    }

    private static String[] feltoltes() {
        String tomb[] = new String[22];
        String jelek[] = {"SZ", "M", "T", "L"};
        String szamok[] = {"K", "N", "ÁSZ", "X", "IX", "VIII"};

        int index = 1;
        for (int i = 0; i < jelek.length; i++) {
            for (int j = 0; j < szamok.length & index <= 21; j++) {
                tomb[index++] = jelek[i] + "_" + szamok[j];
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
        System.out.println(" ");
    }

    private static int bekeres() {
        boolean jo = true;
        int szam;
        do {
            System.out.println("Kérek egy számot: [1-3]");
            szam = sc.nextInt();
            if (szam > 0 & szam < 4) {
                jo = true;
            } else {
                jo = false;
            }
        } while (jo == false);

        return szam;
    }

    private static String[] kever(String tomb[], int szam) {
        String ujTomb[] = new String[tomb.length];
        if (szam == 1) {
            for (int i = 1; i < 7; i++) {
                ujTomb[i] = tomb[20 - (i - 1) * 3];
                ujTomb[i + 7] = tomb[19 - (i - 1) * 3];
                ujTomb[i + 14] = tomb[21 - (i - 1) * 3];
            }
        }
        if (szam == 2) {
            for (int i = 1; i < 7; i++) {
                ujTomb[i] = tomb[19 - (i - 1) * 3];
                ujTomb[i + 7] = tomb[20 - (i - 1) * 3];
                ujTomb[i + 14] = tomb[21 - (i - 1) * 3];
            }
        }
        if (szam == 3) {
            for (int i = 1; i < 7; i++) {
                ujTomb[i] = tomb[21 - (i - 1) * 3];
                ujTomb[i + 7] = tomb[19 - (i - 1) * 3];
                ujTomb[i + 14] = tomb[20 - (i - 1) * 3];
            }
        }
        for (int i = 1; i < tomb.length; i++) {
            tomb[i] = ujTomb[i];
        }
        return ujTomb;
    }

    private static void ezVolt(String tomb[]) {
        System.out.println("A gondolt lap: " + tomb[11]);
    }

}
