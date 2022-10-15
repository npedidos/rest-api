package red.softn.npedidos.service;

import red.softn.npedidos.CrudServiceTestUtil;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.entity.Order;
import red.softn.npedidos.request.OrderRequest;
import red.softn.npedidos.response.OrderResponse;

public class OrderServiceTestUtil extends CrudServiceTestUtil<OrderRequest, OrderResponse, Order, Integer> {
    
    public OrderServiceTestUtil() {
        super();
    }
    
    @Override
    public Init<OrderRequest, OrderResponse, Order, Integer> init() {
        
        var request = new OrderRequest();
        var response = new OrderResponse();
        var entity = new Order();
        var entitySaveResult = new Order();
        
        entity.setId(TestUtil.fakeRandomInteger());
        entity.setDateOrder(TestUtil.fakeDateFutureDaysTime());
        entitySaveResult.setId(entity.getId());
        entitySaveResult.setDateOrder(entity.getDateOrder());
        response.setId(entity.getId());
        response.setDateOrder(entity.getDateOrder());
        request.setId(entity.getId());
        request.setDateOrder(entity.getDateOrder());
        
        return Init.of(request, response, entity, entitySaveResult, entity.getId());
    }
    
}
