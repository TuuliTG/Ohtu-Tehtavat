/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author tgtuuli
 */
public abstract class KiviPaperiSakset {
    
    public static final Scanner scanner = new Scanner(System.in);
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        String ekanSiirto = ensimmaisenSiirto();
             
        System.out.println("Toisen pelaajan siirto: ");
        String tokanSiirto = toisenSiirto();
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
            ekanSiirto = ensimmaisenSiirto();
            System.out.println("Toisen pelaajan siirto: ");
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
