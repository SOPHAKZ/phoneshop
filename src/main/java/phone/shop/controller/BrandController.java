package phone.shop.controller;


import phone.shop.dto.BrandDTO;
import phone.shop.mapper.BrandMapper;
import phone.shop.model.Brand;
import phone.shop.service.BrandService;
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
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(brandService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody Brand source){
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id){
        brandService.deleted(id);
        return ResponseEntity.ok().body(String.format("Brand %s have been deleted", id));

    }

}
