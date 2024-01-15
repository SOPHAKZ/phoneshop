package com.java.spring.boot.controller;


import com.java.spring.boot.dto.BrandDTO;
import com.java.spring.boot.mapper.BrandMapper;
import com.java.spring.boot.model.Brand;
import com.java.spring.boot.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/brand")
@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/save")
    public ResponseEntity<Brand> create(@RequestBody BrandDTO brandDTO){
        Brand brand = BrandMapper.INSTANCE.toEntity(brandDTO);
        brand = brandService.save(brand);
        return ResponseEntity.ok(brand);    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        return ResponseEntity.ok(brandService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody Brand source){
        return ResponseEntity.ok(brandService.update(id,source));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<BrandDTO> listBrand = brandService.getBrands()
                .stream()
                .map(b -> BrandMapper.INSTANCE.toDTO(b))
                .toList();
        return ResponseEntity.ok(listBrand);
    }

}
