package phone.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import phone.shop.dto.ProductOrderDTO;
import phone.shop.dto.SaleDTO;
import phone.shop.model.Sale;
import phone.shop.model.SaleDetail;
import phone.shop.service.ProductService;

import java.math.BigDecimal;

@Mapper(componentModel = "spring",uses = {ProductService.class})
public interface SaleMapper {

    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);

    Sale toSale(SaleDTO dto);

    @Mapping(target = "sale",source = "sale")
    @Mapping(target = "product",source = dto.productId)
    SaleDetail toSaleDetail(ProductOrderDTO dto, Sale sale, BigDecimal price);
}
