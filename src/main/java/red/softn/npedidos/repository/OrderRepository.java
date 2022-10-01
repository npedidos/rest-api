package red.softn.npedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {}
