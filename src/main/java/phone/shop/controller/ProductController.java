package phone.shop.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import phone.shop.dto.PageDTO;
import phone.shop.dto.PriceDTO;
import phone.shop.dto.ProductDisplayDTO;
import phone.shop.dto.ProductImportDTO;
import phone.shop.mapper.PageMapper;
import phone.shop.mapper.ProductMapper;
import phone.shop.model.Product;
import phone.shop.service.ProductService;


import java.util.Map;

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

    @PutMapping("/setPrice/{productId}")
    public ResponseEntity<ProductDisplayDTO> setPrice(@PathVariable long productId, @RequestBody PriceDTO priceDTO){
        Product product = productService.setPrice(productId, priceDTO.getSalePrice());
        return ResponseEntity.ok().body(productMapper.productDisplayDTO(product));
    }

    @GetMapping("/id={id}")
    public ResponseEntity<ProductDisplayDTO> getProductById(@PathVariable long id){
        Product product = productService.getProductById(id);
        ProductDisplayDTO displayDTO = productMapper.productDisplayDTO(product);
        return ResponseEntity.ok(displayDTO);
    }
    @GetMapping("/")
    public ResponseEntity<?> listProducts(@RequestParam Map<String,String> params){
        Page<Product> productPage = productService.getProducts(params);

        PageDTO pageDTO = PageMapper.INSTANCE.toDTO(productPage);
        pageDTO.setData(productService.toProductDisplayDTO(productPage.getContent()));

        return ResponseEntity.ok(pageDTO);
    }


}
