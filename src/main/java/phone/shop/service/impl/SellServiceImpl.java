package phone.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phone.shop.dto.ProductOrderDTO;
import phone.shop.dto.SaleDTO;
import phone.shop.mapper.SaleMapper;
import phone.shop.model.Product;
import phone.shop.model.Sale;
import phone.shop.model.SaleDetail;
import phone.shop.repository.ProductRepository;
import phone.shop.repository.SaleDetailsRepository;
import phone.shop.repository.SaleRepository;
import phone.shop.service.ProductService;
import phone.shop.service.SellService;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service@RequiredArgsConstructor
public class SellServiceImpl implements SellService {

    private final SaleRepository saleRepository;
    private final SaleDetailsRepository detailsRepository;
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final SaleMapper saleMapper;
    @Override
    public void sell(SaleDTO dto) {

        // validate stock
        List<ProductOrderDTO> productOrders = dto.getProducts();

        for(ProductOrderDTO orderDTO : productOrders){
            productService.hasAvailableUnit(orderDTO.getProductId(),orderDTO.getUnit());
            productService.hasSetSalePrice(orderDTO.getProductId());
        }

        // get order product from db

        List<Long> productIds = productOrders.stream()
                .map(ProductOrderDTO::getProductId)
                .collect(Collectors.toList());

        // Map to get Product Price
        Map<Long, Product> productMap = productRepository.findAll()
                .stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));
        /**
         * use Function identity to  map PRODUCT::PRODUCT
         * */
        // Save Sale

        Sale sale = saleMapper.toSale(dto);
        saleRepository.save(sale);

        // save sale detail
        for(ProductOrderDTO orderDTO : productOrders){
            Product product = productMap.get(orderDTO.getProductId());
            SaleDetail saleDetail = saleMapper.toSaleDetail(orderDTO,sale,product.getSalePrice());

            detailsRepository.save(saleDetail);

            // update stock

            product.setAvailableUnit(product.getAvailableUnit() - orderDTO.getUnit());
            productRepository.save(product);
        }

    }
}
