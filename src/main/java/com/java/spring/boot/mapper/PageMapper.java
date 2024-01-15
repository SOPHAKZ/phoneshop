package com.java.spring.boot.mapper;

import com.java.spring.boot.dto.PageDTO;
import com.java.spring.boot.dto.PaginationDTO;
import org.hibernate.annotations.Target;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface PageMapper {


    PageMapper INSTANCE = Mappers.getMapper(PageMapper.class);


    @Mapping(target = "pagination",expression = "java(paginationDTO(page))")
    @Mapping(target = "data",expression = "java(page.getContent())")
    PageDTO toDTO(Page<?> page);

    PaginationDTO paginationDTO(Page<?> page);

//    PageMapper INSTANCE = Mappers.getMapper(PageMapper.class);
//
//    @Mapping(target = "paginationDTO", expression = "java(toPaginationDTO(page))")
//    @Mapping(target = "data", expression = "java(page.getContent())")
//    PageDTO toDTO(Page<?> page);
//
//    PaginationDTO toPaginationDTO(Page<?> page);
}
