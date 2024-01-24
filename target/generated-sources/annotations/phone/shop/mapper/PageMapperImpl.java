package phone.shop.mapper;

import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import phone.shop.dto.PageDTO;
import phone.shop.dto.PaginationDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-24T10:17:14+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class PageMapperImpl implements PageMapper {

    @Override
    public PageDTO toDTO(Page<?> page) {
        if ( page == null ) {
            return null;
        }

        PageDTO pageDTO = new PageDTO();

        pageDTO.setPagination( paginationDTO(page) );
        pageDTO.setData( page.getContent() );

        return pageDTO;
    }

    @Override
    public PaginationDTO paginationDTO(Page<?> page) {
        if ( page == null ) {
            return null;
        }

        PaginationDTO paginationDTO = new PaginationDTO();

        paginationDTO.setNumberOfElements( page.getNumberOfElements() );
        paginationDTO.setSize( page.getSize() );
        paginationDTO.setTotalElements( page.getTotalElements() );
        paginationDTO.setEmpty( page.isEmpty() );
        paginationDTO.setFirst( page.isFirst() );
        paginationDTO.setLast( page.isLast() );

        return paginationDTO;
    }
}
