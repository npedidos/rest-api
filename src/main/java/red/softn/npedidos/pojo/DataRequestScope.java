package red.softn.npedidos.pojo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import red.softn.npedidos.configuration.AppProperties;
import red.softn.npedidos.request.PagingAndSortingRequest;

import java.util.Locale;

@RequestScope
@Component
@RequiredArgsConstructor
@Getter
@Setter
public class DataRequestScope {
    
    private Pageable pageable;
    
    private PagingAndSortingRequest pagingAndSortingRequest;
    
    private final AppProperties appProperties;
    
    private final LocaleResolver localeResolver;
    
    public Pageable getPageable() {
        if (this.pageable == null) {
            this.pageable = PageRequest.of(0, this.appProperties.getPageableSize());
        }
        
        return pageable;
    }
    
    public Locale getDefaultLocale() {
        return ((AcceptHeaderLocaleResolver) this.localeResolver).getDefaultLocale();
    }
    
}
