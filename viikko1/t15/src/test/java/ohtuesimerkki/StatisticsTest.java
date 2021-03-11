/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author tgtuuli
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
     
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void nimiLoytyy() {
        Player p = stats.search("Semenko");
        assertEquals("Semenko", p.getName());
        assertEquals("EDM", p.getTeam());
    }
    
    @Test
    public void hakuPalauttaaNullJosNimeaEiLoydy() {
        assertNull(stats.search("semenko"));
    }
    
    @Test
    public void listTeamPlayersAntaaOikeanMaaran() {
        assertEquals(3, stats.team("EDM").size());
    }
    
    @Test
    public void topScorersAntaaOikeanMaaran() {
        assertEquals(4, stats.topScorers(3).size());
    }
    
}
