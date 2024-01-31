package phone.shop.service;

import org.springframework.data.domain.Page;
import phone.shop.dto.PageDTO;
import phone.shop.dto.PriceDTO;
import phone.shop.dto.ProductDisplayDTO;
import phone.shop.dto.ProductImportDTO;
import phone.shop.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ProductService {
    Product saveProduct(ProductImportDTO importDTO);
    Product getProductById(Long id);
    Product setPrice(Long id, BigDecimal price);
    Page<Product> getProducts(Map<String,String> param);
    List<ProductDisplayDTO> toProductDisplayDTO(List<Product> products);
    boolean hasAvailableUnit(Long productId,Integer orderUnit);
    boolean hasSetSalePrice(Long productId);
}
