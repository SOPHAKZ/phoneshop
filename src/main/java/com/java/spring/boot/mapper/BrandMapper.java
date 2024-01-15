package com.java.spring.boot.mapper;

import com.java.spring.boot.dto.BrandDTO;
import com.java.spring.boot.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    Brand toEntity(BrandDTO dto);

    BrandDTO toDTO(Brand entity);

    void update(@MappingTarget Brand target, Brand source);
}
