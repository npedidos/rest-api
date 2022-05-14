package red.softn.npedidos.controller;

import org.springframework.http.ResponseEntity;

import java.util.function.Supplier;

public abstract class AbstractController {
    
    protected ResponseEntity<?> getResponse(Supplier<?> supplier) {
        return getBaseResponse(() -> ResponseEntity.ok(supplier.get()));
    }
    
    protected ResponseEntity<?> getResponse(Runnable runnable) {
        return getBaseResponse(() -> {
            runnable.run();
            return ResponseEntity.ok()
                                 .build();
        });
    }
    
    protected ResponseEntity<?> getBaseResponse(Supplier<ResponseEntity<?>> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .header("Error", e.getMessage())
                                 .build();
        }
    }
}
