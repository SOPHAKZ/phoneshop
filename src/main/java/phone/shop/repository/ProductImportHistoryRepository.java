package phone.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phone.shop.model.ProductImportHistory;

public interface ProductImportHistoryRepository extends JpaRepository<ProductImportHistory,Long> {
}
