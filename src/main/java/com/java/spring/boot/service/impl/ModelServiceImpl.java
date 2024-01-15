package com.java.spring.boot.service.impl;

import com.java.spring.boot.exception.ResourceNotFoundResponse;
import com.java.spring.boot.model.Model;
import com.java.spring.boot.repository.ModelRepository;
import com.java.spring.boot.service.BrandService;
import com.java.spring.boot.service.ModelService;
import com.java.spring.boot.spec.ModelFilter;
import com.java.spring.boot.spec.ModelSpec;
import com.java.spring.boot.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    private final BrandService brandService;

    @Override
    public Model save(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model getById(int id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundResponse("Model",id));
    }

    @Override
    public Page<Model> getModels(Map<String, String> params) {
        Pageable pageable = PageUtils.getPageable(params);

        ModelFilter modelFilter = new ModelFilter();
        if(params.containsKey("modelId")){
            modelFilter.setModelId(MapUtils.getInteger(params,"modelId"));
        }
        if(params.containsKey("modelName")){
            modelFilter.setModelName(MapUtils.getString(params,"modelName"));
        }
        if(params.containsKey("brandId")){
            modelFilter.setBrandId(MapUtils.getInteger(params,"brandId"));
        }
        if(params.containsKey("brandName")){
            modelFilter.setBrandName(MapUtils.getString(params,"brandName"));
        }
        ModelSpec modelSpec = new ModelSpec(modelFilter);

        Page<Model> modelPage = modelRepository.findAll(modelSpec,pageable);
        return modelPage;
    }


//    @Override
//    public Page<Model> getModels(Map<String, String> params) {
//
//        Pageable pageable = PageUtils.getPageable(params);
//
//        ModelFilter modelFilter = new ModelFilter();
//        if(params.containsKey("modelId")){
//            modelFilter.setModelId(MapUtils.getInteger(params,"modelId"));
//        }
//        if(params.containsKey("modelName")){
//            modelFilter.setModelName(MapUtils.getString(params,"modelName"));
//        }
//        if(params.containsKey("brandId")){
//            modelFilter.setBrandId(MapUtils.getInteger(params,"brandId"));
//        }
//        if(params.containsKey("brandName")){
//            modelFilter.setBrandName(MapUtils.getString(params,"brandName"));
//        }
//        ModelSpec modelSpec = new ModelSpec(modelFilter);
//
//        Page<Model> data = modelRepository.findAll(modelSpec,pageable);
//
//        return data;
//    }
}
