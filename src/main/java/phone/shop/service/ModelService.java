package phone.shop.service;

import phone.shop.model.Model;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface ModelService {

    Model save(Model model);
    Model getById(Long id);
//    Page<Model> getModels(Map<String,String> params);

    Page<Model> getModels(Map<String,String> params);
}
