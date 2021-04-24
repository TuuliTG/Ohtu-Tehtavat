/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;


/**
 *
 * @author tgtuuli
 */
public class QueryBuilder {
    Matcher m;

    public QueryBuilder() {
        m = new All();
    }
    
    public QueryBuilder playsIn(String team) {
        this.m = new And(this.m, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.m = new And(this.m, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.m = new And(this.m, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.m = new Or(matchers);
        return this;
    }
    
    public Matcher build() {
        Matcher matcher = m;
        m = new All();
        return matcher;
        
        
    }
}
