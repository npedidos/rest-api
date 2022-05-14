package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.Setting;
import red.softn.npedidos.repository.SettingRepository;

@Service
@RequiredArgsConstructor
@Getter
public class SettingService extends CrudService<Setting, Integer> {
    
    private final SettingRepository repository;
    
}
