package kg.store.storeRestApi.mappers;

import kg.store.storeRestApi.models.dto.ProductDto;
import kg.store.storeRestApi.models.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    default Product toEntity(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setId(dto.getId());
        product.setCategories(CategoryMapper.INSTANCE.toEntity(dto.getCategory()));
        return product;
    }

    default ProductDto toDto(Product entity) {
        ProductDto product = new ProductDto();
        product.setName(entity.getName());
        product.setId(entity.getId());
        product.setCategory(CategoryMapper.INSTANCE.toDto(entity.getCategories()));
        return product;
    }

    List<Product> toEntities(List<ProductDto> dtos);

    default List<ProductDto> toDtos(List<Product> entities) {
        return entities.stream().map(x->{
            ProductDto product = new ProductDto();
            product.setName(x.getName());
            product.setId(x.getId());
            product.setCategory(CategoryMapper.INSTANCE.toDto(x.getCategories()));
            return product;
        }).collect(Collectors.toList());
    }
}
