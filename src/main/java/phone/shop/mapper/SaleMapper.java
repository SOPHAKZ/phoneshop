package phone.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import phone.shop.dto.SaleDTO;
import phone.shop.model.Sale;
import phone.shop.model.SaleDetail;
import phone.shop.service.ProductService;

@Mapper(componentModel = "spring",uses = {ProductService.class})
public interface SaleMapper {

    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);

    Sale toSale(SaleDTO dto);

    SaleDetail toSaleDetail(SaleDTO dto,Sale sale);
}
