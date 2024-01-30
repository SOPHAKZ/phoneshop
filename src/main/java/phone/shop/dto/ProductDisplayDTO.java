package phone.shop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDisplayDTO {
    private long id;
    private String name;
    private String model;
    private String color;
    private BigDecimal salePrice;
    private String imagePath;
}
