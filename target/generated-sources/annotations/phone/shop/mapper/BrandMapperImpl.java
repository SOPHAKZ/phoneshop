package phone.shop.mapper;

import javax.annotation.processing.Generated;
import phone.shop.dto.BrandDTO;
import phone.shop.model.Brand;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T13:55:00+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand toEntity(BrandDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setId( dto.getId() );
        brand.setName( dto.getName() );

        return brand;
    }

    @Override
    public BrandDTO toDTO(Brand entity) {
        if ( entity == null ) {
            return null;
        }

        BrandDTO brandDTO = new BrandDTO();

        brandDTO.setId( entity.getId() );
        brandDTO.setName( entity.getName() );

        return brandDTO;
    }

    @Override
    public void update(Brand target, Brand source) {
        if ( source == null ) {
            return;
        }

        target.setId( source.getId() );
        target.setName( source.getName() );
        target.setActive( source.getActive() );
    }
}
