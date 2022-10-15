package red.softn.npedidos.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Profile("runner")
@RequiredArgsConstructor
public class ApplicationRunnerImpl implements ApplicationRunner {
    
    private final ActionsRun actionsRun;
    
    private final ApplicationContext applicationContext;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        Set<String> optionNames = args.getOptionNames();
        
        if (nonOptionArgs == null) {
            throw new IllegalArgumentException("No se han especificado argumentos.");
        }
        
        nonOptionArgs.forEach(value -> {
            switch (value) {
                case "db:seed" -> this.actionsRun.dbSeed();
                case "db:fresh" -> {
                    boolean seed = optionNames.contains("seed");
                    this.actionsRun.dbFresh(seed);
                }
                default -> throw new IllegalStateException(String.format("El argumento %s no es valido.", value));
            }
            
            SpringApplication.exit(this.applicationContext);
        });
    }
    
}
