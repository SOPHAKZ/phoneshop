package phone.shop.spec;

import phone.shop.model.Brand;
import phone.shop.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@SuppressWarnings("serial")
public class ModelSpec implements Specification<Model> {

    private final ModelFilter modelFilter;

    @Override
    public Predicate toPredicate(Root<Model> model, CriteriaQuery<?> query, CriteriaBuilder cb) {

        List<Predicate> predicates = new ArrayList<>();

        Join<Model, Brand> brand = model.join("brand");

        if(modelFilter.getModelId() != null){
            predicates.add(model.get("id").in(modelFilter.getModelId()));
        }
//        if(modelFilter.getModelName() != null){
//            predicates.add(cb.like(model.get(Model_.NAME), "%" + modelFilter.getModelName() + "%"));
//
//        }
//        if(modelFilter.getBrandId() != null){
//            predicates.add(brand.get(Brand_.ID).in(modelFilter.getBrandId()));
//        }
//        if(modelFilter.getBrandName() != null){
//            predicates.add(cb.like(brand.get(Brand_.NAME), "%" + modelFilter.getBrandName() + "%"));
//        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
