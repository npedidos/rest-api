package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.entity.Setting;
import red.softn.npedidos.service.SettingService;

@RestController
@RequestMapping("/setting")
@RequiredArgsConstructor
@Getter
public class SettingController extends CrudController<Setting, Integer> {
    
    private final SettingService service;
    
}
