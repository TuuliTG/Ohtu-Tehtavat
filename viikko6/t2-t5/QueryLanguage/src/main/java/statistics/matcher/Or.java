/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author tgtuuli
 */
public class Or implements Matcher {
    private Matcher[] matchers;

    public Or(Matcher... matchers) {
        this.matchers = matchers;
    }
    
    
    @Override
    public boolean matches(Player p) {
        //System.out.println("matchers:");
        
        for (Matcher m : matchers) {
          //  System.out.println(m.getName());
            if (m.matches(p)) {
                return true;
            }
        }
        return false;
    }
    
    
}
