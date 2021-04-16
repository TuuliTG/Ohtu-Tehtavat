
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm = 0;   // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        ljono = new int[KAPASITEETTI];
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        this.kasvatuskoko = OLETUSKASVATUS;

    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetin pitää olla positiivinen");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kasvatuskoon pitää olla positiivinen");//heitin vaan jotain :D
        }
        ljono = new int[kapasiteetti];
        
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        
        if (kuuluu(luku)) {
            return false;
        }
        if (alkioidenLkm == ljono.length) {
            kasvata();
        }
        
        ljono[alkioidenLkm] = luku;
        alkioidenLkm++;
        return true;
        
    }
    
    private void kasvata() {
        int[] taulukkoAlkup = new int[ljono.length];
        kopioiTaulukko(ljono, taulukkoAlkup);


        ljono = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(taulukkoAlkup, ljono);
    }

    public boolean kuuluu(int luku) {
        
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        
        return false;
       
    }

    public boolean poista(int luku) {
        
        int kohta = lukuLoytyyKohdasta(luku);
        if(kohta == -1) {
            return false;
        }
        
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            ljono[j] = ljono[j + 1];
        }
        alkioidenLkm--;
        return true;
    }
    
    private int lukuLoytyyKohdasta(int luku) {
        
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return i;
                
            }
        }
        return -1;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + ljono[0] + "}";
        } else {
            String jono = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                jono += ljono[i];
                jono += ", ";
            }
            jono += ljono[alkioidenLkm - 1];
            jono += "}";
            return jono;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
 
        return z;
    }
        
}
