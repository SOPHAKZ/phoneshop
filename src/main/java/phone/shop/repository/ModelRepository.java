package phone.shop.repository;

import phone.shop.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ModelRepository extends JpaRepository<Model,Integer>, JpaSpecificationExecutor<Model> {
}
