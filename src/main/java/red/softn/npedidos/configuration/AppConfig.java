package red.softn.npedidos.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import red.softn.npedidos.pojo.DataRequestScope;
import red.softn.npedidos.utils.gson.GsonUtil;

@Configuration
@RequiredArgsConstructor
public class AppConfig implements WebMvcConfigurer {
    
    private final ServerProperties serverProperties;
    
    private final AppProperties appProperties;
    
    private final DataRequestScope dataRequestScope;
    
    private final GsonUtil gsonUtil;
    
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(appProperties.getPathPrefix(), HandlerTypePredicate.forAnnotation(RestController.class));
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PagingAndSortingRequestInterceptor(this.dataRequestScope, this.gsonUtil, this.appProperties));
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
        var license = new License().name(appProperties.getAppLicensesName())
                                   .url(appProperties.getAppLicensesUrl());
        var info = new Info().title(appProperties.getAppName())
                             .description(appProperties.getAppDescription())
                             .version(appProperties.getAppVersion())
                             .license(license);
        
        return new OpenAPI().info(info);
    }
    
}
