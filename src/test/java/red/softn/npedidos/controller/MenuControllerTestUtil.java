package red.softn.npedidos.controller;

import com.google.gson.Gson;
import red.softn.npedidos.ControllerTestUtil;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.request.menus.MenuRequest;
import red.softn.npedidos.response.MenuResponse;

public class MenuControllerTestUtil extends ControllerTestUtil<MenuRequest, MenuResponse, Integer> {
    
    public MenuControllerTestUtil(Gson gson) {
        super(gson);
    }
    
    @Override
    protected Init<MenuRequest, MenuResponse, Integer> init() {
        var request = new MenuRequest();
        var response = new MenuResponse();
        
        request.setId(TestUtil.fakeRandomInteger());
        request.setDate(TestUtil.fakeDateFutureDays());
        response.setId(request.getId());
        response.setDate(request.getDate());
        
        return Init.of(request, response, request.getId());
    }
    
}
