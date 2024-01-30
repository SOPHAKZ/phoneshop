package phone.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import phone.shop.dto.ProductDTO;
import phone.shop.dto.ProductImportDTO;
import phone.shop.mapper.ProductMapper;
import phone.shop.model.Product;
import phone.shop.service.ProductService;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductImportDTO dto){

        return ResponseEntity.ok().body(productMapper.toDTO(productService.saveProduct(dto)));
    }
}
