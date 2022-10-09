package red.softn.npedidos.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class AppConfig implements WebMvcConfigurer {
    
    private final ServerProperties serverProperties;
    
    @Value("${app.http.path.prefix:}")
    private String pathPrefix;
    
    @Value("${app.name:}")
    private String appName;
    
    @Value("${app.description:}")
    private String appDescription;
    
    @Value("${app.version:0}")
    private String appVersion;
    
    @Value("${app.licenses.name:}")
    private String appLicensesName;
    
    @Value("${app.licenses.url:}")
    private String appLicensesUrl;
    
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(pathPrefix, HandlerTypePredicate.forAnnotation(RestController.class));
    }
    
    @Bean
    public ErrorProperties errorProperties() {
        return this.serverProperties.getError();
    }
    
    @Bean
    public Faker faker() {
        return new Faker();
    }
    
    @Bean
    public OpenAPI openAPI() {
        var license = new License().name(appLicensesName)
                                   .url(appLicensesUrl);
        var info = new Info().title(appName)
                             .description(appDescription)
                             .version(appVersion)
                             .license(license);
        
        return new OpenAPI().info(info);
    }
    
}
