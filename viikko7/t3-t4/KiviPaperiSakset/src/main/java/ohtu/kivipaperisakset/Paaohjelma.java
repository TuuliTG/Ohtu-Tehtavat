package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.peli.KiviPaperiSakset;
import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KiviPaperiSakset kaksinpeli = KiviPaperiSakset.luoKaksinpeli();
                kaksinpeli.pelaa();
            } else if (vastaus.endsWith("b")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KiviPaperiSakset yksinpeli = KiviPaperiSakset.luoYksinpeli();
                yksinpeli.pelaa();
            } else if (vastaus.endsWith("c")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KiviPaperiSakset pahaYksinpeli = KiviPaperiSakset.luoPahaYksinpeli();
                pahaYksinpeli.pelaa();
            } else {
                break;
            }

        }

    }
}
