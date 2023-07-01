package red.softn.npedidos.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import red.softn.npedidos.pojo.DataRequestScope;
import red.softn.npedidos.request.PagingAndSortingRequest;
import red.softn.npedidos.utils.gson.GsonUtil;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class PagingAndSortingRequestInterceptor implements HandlerInterceptor {
    
    private final DataRequestScope dataRequestScope;
    
    private final GsonUtil gsonUtil;
    
    private final AppProperties appProperties;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String filter = request.getParameter("f");
        
        if (HttpMethod.GET.matches(request.getMethod()) && StringUtils.isNotBlank(filter)) {
            setPageable(filter);
        }
        
        return true;
    }
    
    private void setPageable(String filter) {
        byte[] decode = Base64.getDecoder()
                              .decode(filter);
        String json = new String(decode, StandardCharsets.UTF_8);
        PagingAndSortingRequest pagingAndSortRequest = this.gsonUtil.fromJsonTo(json, PagingAndSortingRequest.class);
        var paging = updateRequestAndGetPaging(pagingAndSortRequest);
        var orderList = getOrders(pagingAndSortRequest.getSorting());
        var pageRequest = PageRequest.of(paging.getPage(), paging.getSize(), Sort.by(orderList));
        
        this.dataRequestScope.setPageable(pageRequest);
        this.dataRequestScope.setPagingAndSortingRequest(pagingAndSortRequest);
    }
    
    private PagingAndSortingRequest.Paging updateRequestAndGetPaging(PagingAndSortingRequest pagingAndSortingRequest) {
        PagingAndSortingRequest.Paging paging = pagingAndSortingRequest.getPaging();
        
        paging.setPage(Math.max(paging.getPage(), 0));
        paging.setSize(paging.getSize() <= 0 ? this.appProperties.getPageableSize() : paging.getSize());
        
        return paging;
    }
    
    private List<Sort.Order> getOrders(List<PagingAndSortingRequest.Sorting> sorting) {
        if (sorting == null || sorting.isEmpty()) {
            return Collections.emptyList();
        }
        
        return sorting.stream()
                      .map(value -> new Sort.Order(value.getDirection(), value.getProperty()))
                      .toList();
    }
    
}
