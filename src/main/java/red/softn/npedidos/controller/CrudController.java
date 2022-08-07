package red.softn.npedidos.controller;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import red.softn.npedidos.exception.InternalServerErrorException;
import red.softn.npedidos.pojo.ErrorDetails;
import red.softn.npedidos.service.CrudServiceI;

import java.lang.reflect.Field;
import java.net.URI;

public abstract class CrudController<E, R, ID> {
    
    public abstract CrudServiceI<E, R, ID> getService();
    
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(getService().findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable ID id) {
        return ResponseEntity.ok(getService().findById(id));
    }
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody E typeDish) {
        R save = getService().save(typeDish);
        Object valueId = getValueId(save);
        
        //TODO: ver ejemplos para el create uri.
        
        return ResponseEntity.created(getUri(valueId))
                             .body(save);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E typeDish) {
        return ResponseEntity.ok(getService().update(id, typeDish));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ID id) {
        getService().delete(id);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
    private URI getUri(Object valueId) {
        RequestMapping requestMapping = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
        String[] path = requestMapping.path();
        
        return URI.create(String.format("%s/%s", path[0], valueId));
    }
    
    private Object getValueId(R save) {
        Field field = ReflectionUtils.findField(save.getClass(), "id");
        Object fieldId;
        
        try {
            ReflectionUtils.makeAccessible(field);
            fieldId = ReflectionUtils.getField(field, save);
        } catch (Exception ex) {
            throw new InternalServerErrorException(new ErrorDetails("Error al obtener el id del objeto."));
        }
        
        return fieldId;
    }
    
}
