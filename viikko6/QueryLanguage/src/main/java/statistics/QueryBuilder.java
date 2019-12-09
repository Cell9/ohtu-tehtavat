package statistics;

import statistics.matcher.*;
import java.util.Stack;
/**
 *
 * @author Markus
 */
public class QueryBuilder {
    
    private Stack pino;
    
    public QueryBuilder(){
        this.pino = new Stack();
    }
    
    public QueryBuilder hasAtLeast(int value, String fieldName) {
        
        this.pino.push(new HasAtLeast(value, fieldName));
        return this;
        
    }    

    public QueryBuilder hasFewerThan(int value, String fieldName) {
        
        this.pino.push(new HasFewerThan(value, fieldName));
        return this;
        
    }    
    
    public QueryBuilder playsIn(String team) {
        
        this.pino.push(new PlaysIn(team));
        return this;
        
    }    

    public QueryBuilder oneOf(Matcher... matchers) {
        
        this.pino.push(new Or(matchers));
        return this;
        
    }
    
    
    public Matcher build() {
        Matcher[] matchers = new Matcher[pino.size()];
        for (int i = 0; i < matchers.length; i++) {
            matchers[i] = (Matcher) pino.pop();
        }
        return new And(matchers);
    }    
    
}
