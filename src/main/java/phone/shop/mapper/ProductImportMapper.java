package phone.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import phone.shop.dto.ImportDTO;
import phone.shop.model.Product;
import phone.shop.model.ProductImportHistory;

@Mapper
public interface ProductImportMapper {

    ProductImportMapper INSTANCE = Mappers.getMapper(ProductImportMapper.class);

    @Mapping(target = "product",source = "product")
    @Mapping(target = "id",ignore = true)
    ProductImportHistory toEntity(ImportDTO dto, Product product);

}
