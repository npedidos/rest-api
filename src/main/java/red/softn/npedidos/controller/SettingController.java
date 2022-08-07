package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.request.SettingRequest;
import red.softn.npedidos.response.SettingResponse;
import red.softn.npedidos.service.SettingService;

@RestController
@RequestMapping("/setting")
@RequiredArgsConstructor
@Getter
public class SettingController extends CrudController<SettingRequest, SettingResponse, Integer> {
    
    private final SettingService service;
    
}
