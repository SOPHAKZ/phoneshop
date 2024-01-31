package phone.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phone.shop.model.SaleDetail;

public interface SaleDetailsRepository extends JpaRepository<SaleDetail, Long> {
}
