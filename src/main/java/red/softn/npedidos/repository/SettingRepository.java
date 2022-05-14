package red.softn.npedidos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.Setting;

@Repository
public interface SettingRepository extends CrudRepository<Setting, Integer> {}
