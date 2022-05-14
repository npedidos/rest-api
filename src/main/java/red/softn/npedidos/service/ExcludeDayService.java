package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.ExcludeDay;
import red.softn.npedidos.repository.ExcludeDayRepository;

@Service
@RequiredArgsConstructor
@Getter
public class ExcludeDayService extends CrudService<ExcludeDay, Integer> {
    
    private final ExcludeDayRepository repository;
    
}
