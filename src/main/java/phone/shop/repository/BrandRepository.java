package phone.shop.repository;

import org.springframework.data.jpa.repository.Query;
import phone.shop.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Long>, JpaSpecificationExecutor<Brand> {

    @Query(value = "select b from Brand b where b.active = :true")
    List<Brand> findByActive();
}
