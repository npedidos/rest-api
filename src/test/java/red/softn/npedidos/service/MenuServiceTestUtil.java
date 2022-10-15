package red.softn.npedidos.service;

import red.softn.npedidos.CrudServiceTestUtil;
import red.softn.npedidos.entity.Menu;
import red.softn.npedidos.request.MenuRequest;
import red.softn.npedidos.response.MenuResponse;

class MenuServiceTestUtil extends CrudServiceTestUtil<MenuRequest, MenuResponse, Menu, Integer> {
    
    public MenuServiceTestUtil() {
        super();
    }
    
    @Override
    public Init<MenuRequest, MenuResponse, Menu, Integer> init() {
        var request = new MenuRequest();
        var response = new MenuResponse();
        var entity = new Menu();
        var entitySaveResult = new Menu();
        
        entity.setId(fakeRandomInteger());
        entity.setDate(fakeDateFutureDays());
        entitySaveResult.setId(entity.getId());
        entitySaveResult.setDate(entity.getDate());
        response.setId(entity.getId());
        response.setDate(entity.getDate());
        request.setId(entity.getId());
        request.setDate(entity.getDate());
        
        return Init.of(request, response, entity, entitySaveResult, entity.getId());
    }
    
}
