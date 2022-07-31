package red.softn.npedidos.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActionsRun {
    
    private final DatabaseSeeder databaseSeeder;
    
    public void dbSeed() {
        this.databaseSeeder.db();
    }
    
    public void dbFresh(boolean seed) {
        this.databaseSeeder.fresh();
        
        if (seed) {
            dbSeed();
        }
    }
    
}
