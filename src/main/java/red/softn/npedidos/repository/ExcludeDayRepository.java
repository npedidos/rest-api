package red.softn.npedidos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.ExcludeDay;

import java.time.LocalDate;

@Repository
public interface ExcludeDayRepository extends CrudRepository<ExcludeDay, Integer> {
    
    boolean existsByDateExclude(LocalDate dateExclude);
    
}
