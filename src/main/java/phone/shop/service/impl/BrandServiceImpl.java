package phone.shop.service.impl;


import phone.shop.exception.ResourceNotFoundResponse;
import phone.shop.model.Brand;

import phone.shop.repository.BrandRepository;
import phone.shop.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(int id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundResponse("Brand",id));
    }

    @Override
    public Brand update(int id, Brand source) {
        Brand targent = getById(id);
//        source.setId(id);
        //BrandMapper.INSTANCE.update(targent,source);
        BeanUtils.copyProperties(source,targent,"id");
        return brandRepository.save(targent);
    }

    @Override
    public void deleted(int id) {
        Brand brand = getById(id);
        brandRepository.delete(brand);
        log.info("brand with id = %d is deleted".formatted(id));
    }

    @Override
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }
}
