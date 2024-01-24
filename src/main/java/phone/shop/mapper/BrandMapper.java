package phone.shop.mapper;

import phone.shop.dto.BrandDTO;
import phone.shop.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    Brand toEntity(BrandDTO dto);

    BrandDTO toDTO(Brand entity);

    void update(@MappingTarget Brand target, Brand source);
}
