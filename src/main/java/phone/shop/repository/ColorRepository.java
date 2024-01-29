package phone.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phone.shop.model.Color;

public interface ColorRepository extends JpaRepository<Color,Long> {
}
