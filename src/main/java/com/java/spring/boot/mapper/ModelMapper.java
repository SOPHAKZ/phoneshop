package com.java.spring.boot.mapper;

import com.java.spring.boot.dto.ModelDTO;
import com.java.spring.boot.model.Brand;
import com.java.spring.boot.model.Model;
import com.java.spring.boot.service.BrandService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses = BrandService.class)
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    @Mapping(target = "brand",source = "dto.brandId")
    Model toModelEntity(ModelDTO dto);

    @Mapping(target = "brandId",source = "brand.id")
    ModelDTO toModelDTO(Model entity);


}
