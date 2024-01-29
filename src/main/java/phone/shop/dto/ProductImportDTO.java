package phone.shop.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProductImportDTO {

    private ProductDTO product;
    private ImportDTO importDetail;
}
