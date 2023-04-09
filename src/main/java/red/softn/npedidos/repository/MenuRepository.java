package red.softn.npedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.Menu;
import red.softn.npedidos.repository.projection.PreviousAndNextMenuDTO;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>, JpaSpecificationExecutor<Menu> {
    
    @Query(value = """
        SELECT previousMenuId, nextMenuId
        FROM (SELECT id,
                     LAG(id) OVER (ORDER BY date)  AS previousMenuId,
                     LEAD(id) OVER (ORDER BY date) AS nextMenuId
              FROM menus
              WHERE date BETWEEN :fistLocalDateOfWeek AND :lastLocalDateOfWeek
              ORDER BY date) menu_next_pre
        WHERE id = :menuId
        """, nativeQuery = true)
    Optional<PreviousAndNextMenuDTO> findPreviousAndNextDate(Integer menuId, LocalDate fistLocalDateOfWeek, LocalDate lastLocalDateOfWeek);
    
    @Query(value = """
        SELECT previousMenuId, nextMenuId
        FROM (SELECT id AS previousMenuId
              FROM menus
              WHERE date < :fistLocalDateOfWeek
              ORDER BY date DESC
              LIMIT 1) menu_pre
                 JOIN (SELECT id AS nextMenuId
                       FROM menus
                       WHERE date > :lastLocalDateOfWeek
                       ORDER BY date
                       LIMIT 1) menu_next
        """, nativeQuery = true)
    Optional<PreviousAndNextMenuDTO> findPreviousAndNextWeek(LocalDate fistLocalDateOfWeek, LocalDate lastLocalDateOfWeek);
    
}
