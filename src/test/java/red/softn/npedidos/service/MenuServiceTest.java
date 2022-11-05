package red.softn.npedidos.service;

import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import red.softn.npedidos.CrudServiceTest;
import red.softn.npedidos.entity.Menu;
import red.softn.npedidos.repository.MenuRepository;
import red.softn.npedidos.request.menus.MenuRequest;
import red.softn.npedidos.response.MenuResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Getter
class MenuServiceTest extends CrudServiceTest<MenuRequest, MenuResponse, Menu, Integer, MenuServiceTestUtil> {
    
    @InjectMocks
    private MenuService service;
    
    @Mock
    private MenuRepository repository;
    
    @Test
    @Override
    public void testSave() {
        var request = getCrudServiceTestUtil().getRequest();
        var expected = getCrudServiceTestUtil().getResponse();
        var entity = getCrudServiceTestUtil().getEntity();
        var entitySaveResult = getCrudServiceTestUtil().getEntitySaveResult();
        
        entity.setId(null);
        
        when(getRepository().save(eq(entity))).thenReturn(entitySaveResult);
        when(getGsonUtil().convertTo(eq(entitySaveResult), eq(MenuResponse.class))).thenReturn(expected);
        
        var actual = getService().save(request);
        
        assertEquals(expected, actual);
    }
    
}
