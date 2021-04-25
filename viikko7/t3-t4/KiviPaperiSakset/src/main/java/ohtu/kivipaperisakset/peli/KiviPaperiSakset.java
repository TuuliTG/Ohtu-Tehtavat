/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset.peli;

import java.util.Scanner;
import ohtu.kivipaperisakset.tekoaly.Tuomari;

/**
 *
 * @author tgtuuli
 */
public abstract class KiviPaperiSakset {
    
    public static final Scanner scanner = new Scanner(System.in);
    public String ekanSiirto;
    
    public static KiviPaperiSakset luoKaksinpeli() {
        return new KPSPelaajaVsPelaaja();
    }
    
    public static KiviPaperiSakset luoYksinpeli() {
        return new KPSTekoaly();
    }
    
    public static KiviPaperiSakset luoPahaYksinpeli() {
        return new KPSParempiTekoaly();
    }
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        ekanSiirto = ensimmaisenSiirto();
        String tokanSiirto = toisenSiirto();
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
            ekanSiirto = ensimmaisenSiirto();
            tokanSiirto = toisenSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    protected String ensimmaisenSiirto() {
        System.out.println("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }
    
    abstract protected String toisenSiirto();
    
    protected boolean onkoOkSiirto(String siirto) {
       return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
}
