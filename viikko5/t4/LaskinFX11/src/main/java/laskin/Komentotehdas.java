/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import java.util.HashMap;
import javafx.scene.control.Button;
import java.util.ArrayDeque;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

/**
 *
 * @author tgtuuli
 */
public class Komentotehdas {
    

    public Komentotehdas() {
        
    }

    public Komento hae(String operaatio) {
        return komennot.getOrDefault(operaatio, tuntematon);
    }
}
