package red.softn.npedidos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.Ordering;

@Repository
public interface OrderingRepository extends CrudRepository<Ordering, Integer> {}
