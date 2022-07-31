package red.softn.npedidos.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Profile("runner")
@RequiredArgsConstructor
public class ApplicationRunnerImpl implements ApplicationRunner {
    
    private final ActionsRun actionsRun;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        Set<String> optionNames = args.getOptionNames();
        
        if (nonOptionArgs == null) {
            System.exit(0);
        }
        
        nonOptionArgs.forEach(value -> {
            switch (value) {
                case "db:seed" -> this.actionsRun.dbSeed();
                case "db:fresh" -> {
                    boolean seed = optionNames.contains("seed");
                    this.actionsRun.dbFresh(seed);
                }
            }
            
            System.exit(0);
        });
    }
    
}
