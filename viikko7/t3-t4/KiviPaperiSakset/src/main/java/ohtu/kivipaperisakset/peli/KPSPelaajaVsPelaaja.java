package ohtu.kivipaperisakset.peli;


public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {
    
    
    @Override
    protected String toisenSiirto() {
        System.out.println("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }
    
}