package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.Menu;
import red.softn.npedidos.repository.MenuRepository;
import red.softn.npedidos.request.MenuRequest;
import red.softn.npedidos.response.MenuResponse;

@Service
@RequiredArgsConstructor
@Getter
public class MenuService extends CrudService<MenuRequest, MenuResponse, Menu, Integer> {
    
    private final MenuRepository repository;
    
}
