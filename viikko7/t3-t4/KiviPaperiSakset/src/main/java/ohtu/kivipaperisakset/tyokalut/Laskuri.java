/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset.tyokalut;

/**
 *
 * @author tgtuuli
 */
public class Laskuri {
    private String[] taulukko;
    private int k,p,s = 0;
    
    
    public Laskuri(String[] taulukko) {
        this.taulukko = taulukko;
    }
    
    public void laske(String viimeisinSiirto, int siirtoja) {
        for(int i = 0; i < siirtoja - 1; i++) {
          if(viimeisinSiirto.equals(taulukko[i])) {
            String seuraava = taulukko[i+1];

            if("k".equals(seuraava)) {
              k++;
            }
            else if("p".equals(seuraava)) {
              p++;
            }
            else {
              s++;
            }        
          }
    }
    }

    public int getK() {
        return k;
    }

    public int getS() {
        return s;
    }

    public int getP() {
        return p;
    }
    
    
    
    
}
