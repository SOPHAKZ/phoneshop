package phone.shop.mapper;

import phone.shop.dto.ModelDTO;
import phone.shop.model.Model;
import phone.shop.service.BrandService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses = BrandService.class)
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    @Mapping(target = "brand",source = "brandId")
    Model toModelEntity(ModelDTO dto);

    @Mapping(target = "brandId",source = "brand.id")
    ModelDTO toModelDTO(Model entity);


}
