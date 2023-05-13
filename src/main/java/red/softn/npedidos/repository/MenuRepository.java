package red.softn.npedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.Menu;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>, JpaSpecificationExecutor<Menu> {
    
    Optional<Menu> findFirstByDateLessThanAndDateBetweenOrderByDateDesc(LocalDate currentDate, LocalDate fistLocalDateOfWeek, LocalDate lastLocalDateOfWeek);
    
    Optional<Menu> findFirstByDateGreaterThanAndDateBetweenOrderByDate(LocalDate currentDate, LocalDate fistLocalDateOfWeek, LocalDate lastLocalDateOfWeek);
    
    Optional<Menu> findFirstByDateGreaterThanOrderByDate(LocalDate date);
    
    Optional<Menu> findFirstByDateLessThanOrderByDateDesc(LocalDate date);
    
    Optional<Menu> findFirstByDateLessThanEqualOrderByDateDesc(LocalDate date);
    
    Optional<List<Menu>> findAllByDateBetween(LocalDate startDate, LocalDate endDate);
    
}
