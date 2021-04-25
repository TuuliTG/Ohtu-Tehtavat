
package ohtu.kivipaperisakset;

// "Muistava tekoäly"

public class TekoalyParannettu implements Tekoaly {
  private String[] muisti;
  private int vapaaMuistiIndeksi;

  public TekoalyParannettu(int muistinKoko) {
    muisti = new String[muistinKoko];
    vapaaMuistiIndeksi = 0;
  }
  
    @Override
  public void asetaSiirto(String siirto) {
    // jos muisti täyttyy, unohdetaan viimeinen alkio
    if(vapaaMuistiIndeksi == muisti.length) {
      for(int i = 1; i < muisti.length; i++) {
        muisti[i-1] = muisti[i];
      }
      
      vapaaMuistiIndeksi--;
    }
    
    muisti[vapaaMuistiIndeksi] = siirto;    
    vapaaMuistiIndeksi++;
  }

  
    @Override
  public String annaSiirto() {
    if(vapaaMuistiIndeksi == 0 || vapaaMuistiIndeksi == 1) {
      return "k";
    }
    
    String viimeisinSiirto = muisti[vapaaMuistiIndeksi - 1];
    Laskuri laskuri= new Laskuri(muisti);
    laskuri.laske(viimeisinSiirto, vapaaMuistiIndeksi);
    
    int k = laskuri.getK();
    int p = laskuri.getP();
    int s = laskuri.getS();
    return annaVastaus(k, p, s);
    
    
    // Tehokkaampiakin tapoja löytyy, mutta niistä lisää 
    // Johdatus Tekoälyyn kurssilla!
  }
  
  private String annaVastaus(int k, int p, int s) {
    // Tehdään siirron valinta esimerkiksi seuraavasti;
    // - jos kiviä eniten, annetaan aina paperi
    // - jos papereita eniten, annetaan aina sakset
    // muulloin annetaan aina kivi
    if(k > p && k > s) {
      return "p";
    }
    else if (p > k && p > s) {
      return "s";
    }
    else {
      return "k";
    }
  }
}