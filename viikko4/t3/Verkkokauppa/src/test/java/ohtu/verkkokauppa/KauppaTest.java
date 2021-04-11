/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;


/**
 *
 * @author tgtuuli
 */
public class KauppaTest {
    
    
    private Pankki pankki;
    private Kauppa k;
    private Varasto varasto;
    private Viitegeneraattori viite;
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);

        viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2,"leipä", 3));
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3,"kokis",7));
        
        k = new Kauppa(varasto, pankki, viite);
    }
    
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }
    
    @Test
    public void ostoksenPaatyttyaMetodiaTilisiirtoOnKutsuttuOikeillaParametreilla() {
                     
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455",5);   
    }
    
    @Test
    public void kahdenEriTuotteenOstaminenOnnistuu() {             

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        
        k.tilimaksu("anna", "23421");
        
        verify(pankki).tilisiirto("anna", 42, "23421", "33333-44455",8);
    }
    
    @Test
    public void kahdenSamanTuotteenOstaminenOnnistuu() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("anna", "12345");
        verify(pankki).tilisiirto("anna", 42, "12345", "33333-44455", 10);
    }
    
    @Test
    public void tuoteJotaEiOleVarastostaEiMaksa() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(3);
        k.tilimaksu("anna", "12345");
        verify(pankki).tilisiirto("anna", 42, "12345", "33333-44455", 5);    
    }
    
    
}
