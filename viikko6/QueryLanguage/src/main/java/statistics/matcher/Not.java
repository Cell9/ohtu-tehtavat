package statistics.matcher;

import statistics.Player;

/**
 *
 * @author Markus
 */
public class Not implements Matcher{
    
    private Matcher[] matchers;
    
    public Not(Matcher ... matches){
        this.matchers = matchers;
    }
    
    @Override
    public boolean matches(Player p) {
        
        for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {
                return false;
            }
        }

        return true;
    
    }
}
