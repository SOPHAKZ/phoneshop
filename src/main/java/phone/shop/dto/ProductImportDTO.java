package phone.shop.dto;

import lombok.Data;

@Data
public class ProductImportDTO {

    private ProductRequestDTO product;
    private ImportDTO importDetail;
}
