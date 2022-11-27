package red.softn.npedidos.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import red.softn.npedidos.utils.message.MessageUtil;

import java.util.List;
import java.util.Set;

@Component
@Profile("runner")
@RequiredArgsConstructor
public class ApplicationRunnerImpl implements ApplicationRunner {
    
    private final ActionsRun actionsRun;
    
    private final ApplicationContext applicationContext;
    
    private final MessageUtil messageUtil;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        Set<String> optionNames = args.getOptionNames();
        
        if (nonOptionArgs == null) {
            throw new IllegalArgumentException(this.messageUtil.getMessage("error.no-arguments-specified"));
        }
        
        nonOptionArgs.forEach(value -> {
            switch (value) {
                case "db:seed" -> this.actionsRun.dbSeed();
                case "db:fresh" -> {
                    boolean seed = optionNames.contains("seed");
                    this.actionsRun.dbFresh(seed);
                }
                default ->
                    throw new IllegalStateException(this.messageUtil.getMessage("error.argument-x-not-valid", value));
            }
            
            SpringApplication.exit(this.applicationContext);
        });
    }
    
}
