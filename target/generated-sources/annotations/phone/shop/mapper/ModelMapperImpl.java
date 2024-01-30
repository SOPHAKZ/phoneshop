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
    date = "2024-01-29T13:55:00+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
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
            model.setBrand( brandService.getById( dto.getBrandId().longValue() ) );
        }
        model.setId( dto.getId() );
        model.setName( dto.getName() );
        model.setYearMade( dto.getYearMade() );

        return model;
    }

    @Override
    public ModelDTO toModelDTO(Model entity) {
        if ( entity == null ) {
            return null;
        }

        ModelDTO modelDTO = new ModelDTO();

        Long id = entityBrandId( entity );
        if ( id != null ) {
            modelDTO.setBrandId( id.intValue() );
        }
        modelDTO.setId( entity.getId() );
        modelDTO.setName( entity.getName() );
        modelDTO.setYearMade( entity.getYearMade() );

        return modelDTO;
    }

    private Long entityBrandId(Model model) {
        if ( model == null ) {
            return null;
        }
        Brand brand = model.getBrand();
        if ( brand == null ) {
            return null;
        }
        Long id = brand.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
