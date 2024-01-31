package phone.shop.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaleDTO {
    private List<ProductOrderDTO> products;
    private LocalDateTime soldDate;
}
