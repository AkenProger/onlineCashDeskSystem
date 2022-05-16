package kg.store.storeRestApi.models.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private CategoryDto category;
}
