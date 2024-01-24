package phone.shop.mapper;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phone.shop.dto.ModelDTO;
import phone.shop.model.Brand;
import phone.shop.model.Model;
import phone.shop.service.BrandService;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-24T10:45:43+0700",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class ModelMapperImpl implements ModelMapper {

    @Autowired
    private BrandService brandService;

    @Override
    public Model toModelEntity(ModelDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Model model = new Model();

        if ( dto.getBrandId() != null ) {
            model.setBrand( brandService.getById( dto.getBrandId().intValue() ) );
        }
        if ( dto.getId() != null ) {
            model.setId( dto.getId() );
        }
        model.setName( dto.getName() );

        return model;
    }

    @Override
    public ModelDTO toModelDTO(Model entity) {
        if ( entity == null ) {
            return null;
        }

        ModelDTO modelDTO = new ModelDTO();

        modelDTO.setBrandId( entityBrandId( entity ) );
        modelDTO.setId( entity.getId() );
        modelDTO.setName( entity.getName() );

        return modelDTO;
    }

    private Integer entityBrandId(Model model) {
        if ( model == null ) {
            return null;
        }
        Brand brand = model.getBrand();
        if ( brand == null ) {
            return null;
        }
        Integer id = brand.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
