package phone.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import phone.shop.dto.ProductDisplayDTO;
import phone.shop.dto.ProductImportDTO;
import phone.shop.exception.ResourceNotFoundResponse;
import phone.shop.mapper.ProductImportMapper;
import phone.shop.mapper.ProductMapper;
import phone.shop.model.Color;
import phone.shop.model.Model;
import phone.shop.model.Product;
import phone.shop.model.ProductImportHistory;
import phone.shop.repository.ColorRepository;
import phone.shop.repository.ModelRepository;
import phone.shop.repository.ProductImportHistoryRepository;
import phone.shop.repository.ProductRepository;
import phone.shop.service.ProductService;
import phone.shop.spec.ProductSpec;
import phone.shop.util.PageUtils;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductImportHistoryRepository productImportHistoryRepository;
    private final ProductMapper productMapper;
    private final ColorRepository colorRepository;
    private final ModelRepository modelRepository;

    @Override
    public Product saveProduct(ProductImportDTO dto) {

        Long model = dto.getProduct().getModelId();
        Long color = dto.getProduct().getColorId();
//
        Optional<Product> existingProduct = productRepository.findByModelIdAndColorId(model, color);
        Product product = null;
        if (existingProduct.isPresent()) {

            product = existingProduct.get();

            Integer availableUnit = product.getAvailableUnit();
            Integer importUnit = dto.getImportDetail().getImportUnit();

            product.setAvailableUnit(availableUnit + importUnit);


            return null;
        } else {
            product = productMapper.toEntity(dto.getProduct());
            product.setAvailableUnit(dto.getImportDetail().getImportUnit());

        }

        product = productRepository.save(product);

        ProductImportHistory importHistory = ProductImportMapper.INSTANCE.toEntity(dto.getImportDetail(), product);

        productImportHistoryRepository.save(importHistory);

        return product;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundResponse("Product", id));
    }

    @Override
    public Product setPrice(Long id, BigDecimal price) {
        Product product = getProductById(id);
        product.setSalePrice(price);
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getProducts(Map<String, String> param) {
        Pageable pageable = PageUtils.getPageable(param);
        return (Page<Product>) productRepository.findAll(new ProductSpec(),pageable);
    }

    @Override
    public List<ProductDisplayDTO> toProductDisplayDTO(List<Product> products) {
        List<ProductDisplayDTO> displayDTOS = new ArrayList<>();

        List<Long> modelIds = products.stream().map(m ->m.getModel().getId()).toList();
        List<Long> colorIds = products.stream().map(c -> c.getColor().getId()).toList();

        List<Model> models = modelRepository.findAllById(modelIds);
        List<Color> colors = colorRepository.findAllById(colorIds);

        // Map to get name

        Map<Long,String> modelMap = models.stream().collect(Collectors.toMap(Model::getId,Model::getName));

        Map<Long,String> colorMap = colors.stream().collect(Collectors.toMap(Color::getId,Color::getName));

        for(Product product : products){
            ProductDisplayDTO dto = new ProductDisplayDTO();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setImagePath(product.getImagePath());
            dto.setSalePrice(product.getSalePrice());
            dto.setModel(modelMap.get(product.getModel().getId()));
            dto.setColor(colorMap.get(product.getColor().getId()));

            displayDTOS.add(dto);

        }
        return displayDTOS;
    }
}
