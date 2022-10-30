package red.softn.npedidos.controller;

import com.google.gson.Gson;
import lombok.Getter;
import red.softn.npedidos.ControllerTestUtil;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.request.orders.OrderRequest;
import red.softn.npedidos.response.OrderResponse;

@Getter
public class OrderControllerTestUtil extends ControllerTestUtil<OrderRequest, OrderResponse, Integer> {
    
    public OrderControllerTestUtil(Gson gson) {
        super(gson);
    }
    
    @Override
    protected Init<OrderRequest, OrderResponse, Integer> init() {
        var request = new OrderRequest();
        var response = new OrderResponse();
        request.setId(TestUtil.fakeRandomInteger());
        request.setDateOrder(TestUtil.fakeDateFutureDaysTime());
        response.setId(request.getId());
        response.setDateOrder(request.getDateOrder());
        
        return Init.of(request, response, request.getId());
    }
    
}
