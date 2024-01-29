package phone.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phone.shop.dto.ProductImportDTO;
import phone.shop.mapper.ProductImportMapper;
import phone.shop.mapper.ProductMapper;
import phone.shop.model.Product;
import phone.shop.model.ProductImportHistory;
import phone.shop.repository.ProductImportHistoryRepository;
import phone.shop.repository.ProductRepository;
import phone.shop.service.ProductService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductImportHistoryRepository productImportHistoryRepository;
    private final ProductMapper productMapper;

    @Override
    public Product saveProduct(ProductImportDTO dto) {

        Long model = dto.getProduct().getModelId();
        Long color = dto.getProduct().getColorId();
//
        Optional<Product> existingProduct = productRepository.findByModelIdAndColorId(model, color);
        Product product = null;
        if(existingProduct.isPresent()){

            product = existingProduct.get();

            Integer availableUnit = product.getAvailableUnit();
            Integer importUnit = dto.getImportDetail().getImportUnit();

            product.setAvailableUnit(availableUnit + importUnit);


            return null;
        }else {
            product = productMapper.toEntity(dto.getProduct());
            product.setAvailableUnit(dto.getImportDetail().getImportUnit());
        }

        product = productRepository.save(product);

        ProductImportHistory importHistory = ProductImportMapper.INSTANCE.toEntity(dto.getImportDetail(), product);

        productImportHistoryRepository.save(importHistory);

        return product;
    }
}
