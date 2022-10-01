package red.softn.npedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.ExcludeDay;

import java.time.LocalDate;

@Repository
public interface ExcludeDayRepository extends JpaRepository<ExcludeDay, Integer> {
    
    boolean existsByDateExclude(LocalDate dateExclude);
    
}
