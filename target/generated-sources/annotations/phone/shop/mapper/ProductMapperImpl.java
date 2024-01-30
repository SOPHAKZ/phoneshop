package phone.shop.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import phone.shop.dto.ProductDisplayDTO;
import phone.shop.dto.ProductRequestDTO;
import phone.shop.model.Color;
import phone.shop.model.Model;
import phone.shop.model.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-30T15:07:16+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setModel( productRequestDTOToModel( dto ) );
        product.setColor( productRequestDTOToColor( dto ) );
        product.setName( dto.getName() );

        return product;
    }

    @Override
    public ProductRequestDTO toDTO(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductRequestDTO productRequestDTO = new ProductRequestDTO();

        productRequestDTO.setModelId( entityModelId( entity ) );
        productRequestDTO.setColorId( entityColorId( entity ) );
        productRequestDTO.setName( entity.getName() );

        return productRequestDTO;
    }

    @Override
    public ProductDisplayDTO productDisplayDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDisplayDTO productDisplayDTO = new ProductDisplayDTO();

        productDisplayDTO.setModel( productModelName( product ) );
        productDisplayDTO.setColor( productColorName( product ) );
        if ( product.getId() != null ) {
            productDisplayDTO.setId( product.getId() );
        }
        productDisplayDTO.setName( product.getName() );
        productDisplayDTO.setSalePrice( product.getSalePrice() );
        productDisplayDTO.setImagePath( product.getImagePath() );

        return productDisplayDTO;
    }

    protected Model productRequestDTOToModel(ProductRequestDTO productRequestDTO) {
        if ( productRequestDTO == null ) {
            return null;
        }

        Model model = new Model();

        model.setId( productRequestDTO.getModelId() );

        return model;
    }

    protected Color productRequestDTOToColor(ProductRequestDTO productRequestDTO) {
        if ( productRequestDTO == null ) {
            return null;
        }

        Color color = new Color();

        color.setId( productRequestDTO.getColorId() );

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

    private String productModelName(Product product) {
        if ( product == null ) {
            return null;
        }
        Model model = product.getModel();
        if ( model == null ) {
            return null;
        }
        String name = model.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String productColorName(Product product) {
        if ( product == null ) {
            return null;
        }
        Color color = product.getColor();
        if ( color == null ) {
            return null;
        }
        String name = color.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
