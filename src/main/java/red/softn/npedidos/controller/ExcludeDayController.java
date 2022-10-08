package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.request.ExcludeDayRequest;
import red.softn.npedidos.response.ExcludeDayResponse;
import red.softn.npedidos.service.ExcludeDayService;

@RestController
@RequestMapping("/exclude-days")
@RequiredArgsConstructor
@Getter
public class ExcludeDayController extends CrudController<ExcludeDayRequest, ExcludeDayResponse, Integer> {
    
    private final ExcludeDayService service;
    
}
