package phone.shop.service;

import phone.shop.dto.ProductImportDTO;
import phone.shop.model.Product;

public interface ProductService {
    Product saveProduct(ProductImportDTO importDTO);
}
