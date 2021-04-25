package ohtu.kivipaperisakset.peli;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa

import ohtu.kivipaperisakset.tekoaly.Tekoaly;
import ohtu.kivipaperisakset.tekoaly.TekoalyParannettu;

// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {
    
    private final Tekoaly tekoaly = new TekoalyParannettu(20);
    
    @Override
    protected String toisenSiirto() {
        
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}
