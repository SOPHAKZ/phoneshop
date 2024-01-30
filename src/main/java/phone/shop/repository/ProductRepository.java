package phone.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phone.shop.model.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("select p from Product p where p.model.id = ?1 and p.color.id = ?2")
    Optional<Product> findByModelIdAndColorId(Long modelId, Long colorId);
}
