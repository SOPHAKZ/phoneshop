package phone.shop.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import phone.shop.dto.ProductDTO;
import phone.shop.dto.ProductDTO2;
import phone.shop.model.Color;
import phone.shop.model.Model;
import phone.shop.model.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T13:56:52+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setModel( productDTOToModel( dto ) );
        product.setColor( productDTOToColor( dto ) );
        product.setName( dto.getName() );

        return product;
    }

    @Override
    public ProductDTO2 toDTO(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDTO2 productDTO2 = new ProductDTO2();

        Long id = entityModelId( entity );
        if ( id != null ) {
            productDTO2.setModelId( id.intValue() );
        }
        productDTO2.setColorId( entityColorId( entity ) );
        productDTO2.setId( entity.getId() );
        productDTO2.setName( entity.getName() );
        productDTO2.setSalePrice( entity.getSalePrice() );
        productDTO2.setAvailableUnit( entity.getAvailableUnit() );
        productDTO2.setImagePath( entity.getImagePath() );

        return productDTO2;
    }

    protected Model productDTOToModel(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Model model = new Model();

        model.setId( productDTO.getModelId() );

        return model;
    }

    protected Color productDTOToColor(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Color color = new Color();

        color.setId( productDTO.getColorId() );

        return color;
    }

    private Long entityModelId(Product product) {
        if ( product == null ) {
            return null;
        }
        Model model = product.getModel();
        if ( model == null ) {
            return null;
        }
        Long id = model.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityColorId(Product product) {
        if ( product == null ) {
            return null;
        }
        Color color = product.getColor();
        if ( color == null ) {
            return null;
        }
        Long id = color.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
