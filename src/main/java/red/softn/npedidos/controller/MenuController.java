package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.request.MenuRequest;
import red.softn.npedidos.response.MenuResponse;
import red.softn.npedidos.service.MenuService;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
@Getter
public class MenuController extends CrudController<MenuRequest, MenuResponse, Integer> {
    
    private final MenuService service;
    
}
