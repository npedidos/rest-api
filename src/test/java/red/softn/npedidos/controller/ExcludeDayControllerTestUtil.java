package red.softn.npedidos.controller;

import com.google.gson.Gson;
import lombok.Getter;
import red.softn.npedidos.ControllerTestUtil;
import red.softn.npedidos.request.ExcludeDayRequest;
import red.softn.npedidos.response.ExcludeDayResponse;

@Getter
public class ExcludeDayControllerTestUtil extends ControllerTestUtil<ExcludeDayRequest, ExcludeDayResponse, Integer> {
    
    public ExcludeDayControllerTestUtil(Gson gson) {
        super(gson);
    }
    
    @Override
    protected Init<ExcludeDayRequest, ExcludeDayResponse, Integer> init() {
        var request = new ExcludeDayRequest();
        var response = new ExcludeDayResponse();
        
        request.setId(fakeRandomInteger());
        request.setDateExclude(fakeDateFutureDays());
        response.setId(request.getId());
        response.setDateExclude(request.getDateExclude());
        
        return Init.of(request, response, request.getId());
    }
    
}
