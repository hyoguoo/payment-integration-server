package study.paymentintegrationserver.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import study.paymentintegrationserver.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Lock(LockModeType.OPTIMISTIC)
    @Query("select p from Product p where p.id = :productId")
    Product findByIdOptimistic(Long productId);
}
