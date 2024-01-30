package phone.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import phone.shop.dto.ProductDisplayDTO;
import phone.shop.dto.ProductRequestDTO;
import phone.shop.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "model.id",source = "dto.modelId")
    @Mapping(target = "color.id",source = "dto.colorId")
    Product toEntity(ProductRequestDTO dto);

    @Mapping(target = "modelId",source = "model.id")
    @Mapping(target = "colorId",source = "color.id")
    ProductRequestDTO toDTO(Product entity);

    @Mapping(source = "model.name", target = "model")
    @Mapping(source = "color.name", target = "color")
    ProductDisplayDTO productDisplayDTO(Product product);
}
