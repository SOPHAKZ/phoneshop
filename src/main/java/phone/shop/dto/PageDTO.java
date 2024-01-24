package phone.shop.dto;

import lombok.Data;

import java.util.List;
@Data
public class PageDTO {
    private List<?> data;
    private PaginationDTO pagination;
}
