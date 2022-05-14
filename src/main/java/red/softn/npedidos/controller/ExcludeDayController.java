package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.entity.ExcludeDay;
import red.softn.npedidos.service.ExcludeDayService;

@RestController
@RequestMapping("/exclude-day")
@RequiredArgsConstructor
@Getter
public class ExcludeDayController extends CrudController<ExcludeDay, Integer> {
    
    private final ExcludeDayService service;
    
}
