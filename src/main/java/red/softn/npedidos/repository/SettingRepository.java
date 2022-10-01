package red.softn.npedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.Setting;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Integer> {}
