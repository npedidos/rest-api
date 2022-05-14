package red.softn.npedidos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import red.softn.npedidos.service.CrudService;

public abstract class CrudController<T, ID> extends AbstractController {
    
    public abstract CrudService<T, ID> getService();
    
    @GetMapping
    public ResponseEntity<?> findAll() {
        return getResponse(() -> getService().findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable ID id) {
        return getResponse(() -> getService().findById(id));
    }
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody T typeDish) {
        return getResponse(() -> getService().save(typeDish));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody T typeDish) {
        return getResponse(() -> getService().update(id, typeDish));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ID id) {
        return getResponse(() -> getService().delete(id));
    }
}
