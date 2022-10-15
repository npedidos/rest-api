package red.softn.npedidos.service;

import lombok.Getter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import red.softn.npedidos.CrudServiceTest;
import red.softn.npedidos.entity.Menu;
import red.softn.npedidos.repository.MenuRepository;
import red.softn.npedidos.request.MenuRequest;
import red.softn.npedidos.response.MenuResponse;

@ExtendWith(MockitoExtension.class)
@Getter
class MenuServiceTest extends CrudServiceTest<MenuRequest, MenuResponse, Menu, Integer, MenuServiceTestUtil> {
    
    @InjectMocks
    private MenuService service;
    
    @Mock
    private MenuRepository repository;
    
}
