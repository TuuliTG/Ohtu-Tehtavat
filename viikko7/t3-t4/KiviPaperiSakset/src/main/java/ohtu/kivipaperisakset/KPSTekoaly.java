package ohtu.kivipaperisakset;

public class KPSTekoaly extends KiviPaperiSakset {
    private Tekoaly tekoaly = new YksinkertainenTekoaly();
    
    @Override
    protected String toisenSiirto() {
        
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }
}