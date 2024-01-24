package phone.shop.service;

import phone.shop.model.Brand;

import java.util.List;

public interface BrandService {

    Brand save(Brand brand);

    Brand getById(int id);
    Brand update(int id, Brand source);
    void deleted(int id);

    List<Brand> getBrands();
}
