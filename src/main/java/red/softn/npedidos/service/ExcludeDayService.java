package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.ExcludeDay;
import red.softn.npedidos.repository.ExcludeDayRepository;
import red.softn.npedidos.request.ExcludeDayRequest;
import red.softn.npedidos.response.ExcludeDayResponse;

@Service
@RequiredArgsConstructor
@Getter
public class ExcludeDayService extends CrudService<ExcludeDayRequest, ExcludeDayResponse, ExcludeDay, Integer> {
    
    private final ExcludeDayRepository repository;
    
}
