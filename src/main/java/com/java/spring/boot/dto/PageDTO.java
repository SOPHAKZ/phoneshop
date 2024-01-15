package com.java.spring.boot.dto;

import lombok.Data;

import java.util.List;
@Data
public class PageDTO {
    private List<?> data;
    private PaginationDTO pagination;
}
