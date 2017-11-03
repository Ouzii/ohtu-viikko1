/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author oce
 */

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
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
    public void testSearch() {
        Player eiOle = stats.search("Keko");
        assertEquals(null, eiOle);
        
        Player on = stats.search("Kurri");
        assertEquals("EDM", on.getTeam());
    }
    
    @Test
    public void testTeam() {
        List tiimi = stats.team("EDM");
        assertEquals(3, tiimi.size());
        
        List eiOle = stats.team("RANDOM");
        assertEquals(0, eiOle.size());
    }
    
    @Test
    public void testTopScorers() {
        List top3 = stats.topScorers(2);
        assertEquals(3, top3.size());
    }
}
