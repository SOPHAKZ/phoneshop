package phone.shop.mapper;

import javax.annotation.processing.Generated;
import phone.shop.dto.ImportDTO;
import phone.shop.model.Product;
import phone.shop.model.ProductImportHistory;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T13:55:00+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class ProductImportMapperImpl implements ProductImportMapper {

    @Override
    public ProductImportHistory toEntity(ImportDTO dto, Product product) {
        if ( dto == null && product == null ) {
            return null;
        }

        ProductImportHistory productImportHistory = new ProductImportHistory();

        if ( dto != null ) {
            productImportHistory.setDateImport( dto.getDateImport() );
            productImportHistory.setPricePerUnit( dto.getPricePerUnit() );
            productImportHistory.setImportUnit( dto.getImportUnit() );
        }
        productImportHistory.setProduct( product );

        return productImportHistory;
    }
}
