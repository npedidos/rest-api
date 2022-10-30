package red.softn.npedidos.controller;

import com.google.gson.Gson;
import red.softn.npedidos.ControllerTestUtil;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.request.SettingRequest;
import red.softn.npedidos.response.SettingResponse;

public class SettingControllerTestUtil extends ControllerTestUtil<SettingRequest, SettingResponse, Integer> {
    
    public SettingControllerTestUtil(Gson gson) {
        super(gson);
    }
    
    @Override
    protected Init<SettingRequest, SettingResponse, Integer> init() {
        var request = new SettingRequest();
        var response = new SettingResponse();
        
        request.setId(TestUtil.fakeRandomInteger());
        request.setDescription(TestUtil.fakeRandomWord());
        request.setValue(TestUtil.fakeRandomWord());
        request.setKeyName(TestUtil.fakeRandomWord());
        response.setId(request.getId());
        response.setDescription(request.getDescription());
        response.setValue(request.getValue());
        response.setKeyName(request.getKeyName());
        
        return Init.of(request, response, request.getId());
    }
    
}
