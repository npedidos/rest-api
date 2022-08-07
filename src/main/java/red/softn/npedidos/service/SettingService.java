package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.Setting;
import red.softn.npedidos.repository.SettingRepository;
import red.softn.npedidos.request.SettingRequest;
import red.softn.npedidos.response.SettingResponse;

@Service
@RequiredArgsConstructor
@Getter
public class SettingService extends CrudService<SettingRequest, SettingResponse, Setting, Integer> {
    
    private final SettingRepository repository;
    
}
