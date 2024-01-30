package phone.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import phone.shop.dto.ProductDTO;
import phone.shop.dto.ProductDTO2;
import phone.shop.dto.ProductImportDTO;
import phone.shop.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "model.id",source = "dto.modelId")
    @Mapping(target = "color.id",source = "dto.colorId")
    Product toEntity(ProductDTO dto);

    @Mapping(target = "modelId",source = "model.id")
    @Mapping(target = "colorId",source = "color.id")
    ProductDTO2 toDTO(Product entity);
}
