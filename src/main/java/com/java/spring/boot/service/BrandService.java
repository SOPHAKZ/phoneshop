package com.java.spring.boot.service;

import com.java.spring.boot.dto.BrandDTO;
import com.java.spring.boot.model.Brand;

import java.util.List;

public interface BrandService {

    Brand save(Brand brand);

    Brand getById(int id);
    Brand update(int id, Brand source);
    void deleted(int id);

    List<Brand> getBrands();
}
