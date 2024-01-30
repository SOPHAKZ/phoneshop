package phone.shop.service;

import phone.shop.model.Brand;

import java.util.List;

public interface BrandService {

    Brand save(Brand brand);

    Brand getById(Long id);
    Brand update(Long id, Brand source);
    void deleted(Long id);

    List<Brand> getBrands();
}
