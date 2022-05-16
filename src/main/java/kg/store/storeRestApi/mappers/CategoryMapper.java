package kg.store.storeRestApi.mappers;
import kg.store.storeRestApi.models.dto.CategoryDto;
import kg.store.storeRestApi.models.entities.Categories;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    default Categories toEntity(CategoryDto dto) {
        Categories category = new Categories();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }

    default CategoryDto toDto(Categories entity) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(entity.getId());
        categoryDto.setName(entity.getName());
        return categoryDto;
    }

    List<Categories> toEntities(List<CategoryDto> dtos);

    default List<CategoryDto> toDtos(List<Categories> entities) {
        return entities.stream().map(x->{
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(x.getId());
            categoryDto.setName(x.getName());
            return categoryDto;
        }).collect(Collectors.toList());
    }
}
