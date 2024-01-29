package phone.shop.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductDTO2 {
    private Long id;
    private String name;
    private Integer modelId;
    private Long colorId;
    private BigDecimal importPrice;
    private BigDecimal salePrice;
    private Integer availableUnit;
    private String imagePath;
}
