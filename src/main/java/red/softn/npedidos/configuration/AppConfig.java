package red.softn.npedidos.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
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
        
        SecurityScheme securityScheme = new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                                            .scheme("bearer")
                                                            .bearerFormat("JWT");
        Components components = new Components().addSecuritySchemes("bearer-key", securityScheme);
        
        return new OpenAPI().info(info)
                            .components(components);
    }
    
    @Bean
    public OpenApiCustomizer customerGlobalHeaderOpenApiCustomizer() {
        return openApi -> openApi.getPaths()
                                 .values()
                                 .stream()
                                 .flatMap(pathItem -> pathItem.readOperations()
                                                              .stream())
                                 .forEach(operation -> operation.addSecurityItem(new SecurityRequirement().addList("bearer-key")));
    }
    
    @Bean
    public LocaleResolver localeResolver() {
        var acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        
        acceptHeaderLocaleResolver.setSupportedLocales(this.appProperties.getSupportedLocales());
        acceptHeaderLocaleResolver.setDefaultLocale(this.appProperties.getDefaultLocale());
        
        return acceptHeaderLocaleResolver;
    }
    
}
