package phone.shop.service.impl;

import phone.shop.exception.ResourceNotFoundResponse;
import phone.shop.model.Model;
import phone.shop.repository.ModelRepository;
import phone.shop.service.BrandService;
import phone.shop.service.ModelService;
import phone.shop.spec.ModelFilter;
import phone.shop.spec.ModelSpec;
import phone.shop.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

//    private final BrandService brandService;

    @Override
    public Model save(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model getById(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundResponse("Model",id));
    }

    @Override
    public Page<Model> getModels(Map<String, String> params) {
        Pageable pageable = PageUtils.getPageable(params);

        ModelFilter modelFilter = new ModelFilter();
        if(params.containsKey("modelId")){
            modelFilter.setModelId(MapUtils.getLong(params,"modelId"));
        }
        if(params.containsKey("modelName")){
            modelFilter.setModelName(MapUtils.getString(params,"modelName"));
        }
        if(params.containsKey("brandId")){
            modelFilter.setBrandId(MapUtils.getLong(params,"brandId"));
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
