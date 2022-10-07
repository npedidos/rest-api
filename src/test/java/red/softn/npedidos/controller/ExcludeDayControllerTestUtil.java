package red.softn.npedidos.controller;

import com.google.gson.Gson;
import lombok.Getter;
import net.datafaker.Faker;
import red.softn.npedidos.request.ExcludeDayRequest;
import red.softn.npedidos.response.ExcludeDayResponse;

@Getter
public class ExcludeDayControllerTestUtil extends ControllerTestUtil<ExcludeDayRequest, ExcludeDayResponse, Integer> {
    
    public ExcludeDayControllerTestUtil(Faker faker, Gson gson) {
        super(faker, gson);
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
