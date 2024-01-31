package phone.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phone.shop.dto.ProductOrderDTO;
import phone.shop.dto.SaleDTO;
import phone.shop.model.Sale;
import phone.shop.repository.SaleDetailsRepository;
import phone.shop.repository.SaleRepository;
import phone.shop.service.ProductService;
import phone.shop.service.SellService;

import java.util.List;

@Service@RequiredArgsConstructor
public class SellServiceImpl implements SellService {

    private final SaleRepository saleRepository;
    private final SaleDetailsRepository detailsRepository;
    private final ProductService productService;
    @Override
    public void sell(SaleDTO dto) {

        // validate stock
        List<ProductOrderDTO> productOrders = dto.getProducts();
        for(ProductOrderDTO orderDTO : productOrders){
            productService.hasAvailableUnit(orderDTO.getProductId(),orderDTO.getUnit());
        }
        // save sale

        Sale sale

        // save sale detail
        // update product stock
    }
}
