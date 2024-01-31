package phone.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phone.shop.model.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long> {
}
