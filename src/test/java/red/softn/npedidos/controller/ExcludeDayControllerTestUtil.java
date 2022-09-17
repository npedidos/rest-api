package red.softn.npedidos.controller;

import com.google.gson.Gson;
import lombok.Getter;
import net.datafaker.Faker;
import red.softn.npedidos.request.ExcludeDayRequest;
import red.softn.npedidos.response.ExcludeDayResponse;

import java.util.Arrays;
import java.util.List;

@Getter
public class ExcludeDayControllerTestUtil extends AControllerTestUtil<ExcludeDayRequest, ExcludeDayResponse, Integer> {
    
    public ExcludeDayControllerTestUtil(Faker faker, Gson gson) {
        super(faker, gson);
    }
    
    @Override
    protected List<Object> initRequestResponse() {
        var request = new ExcludeDayRequest();
        var response = new ExcludeDayResponse();
        
        request.setId(getRandomInteger());
        request.setDateExclude(getDateFutureDays());
        response.setId(request.getId());
        response.setDateExclude(request.getDateExclude());
        
        return Arrays.asList(request, response, request.getId());
    }
    
}
