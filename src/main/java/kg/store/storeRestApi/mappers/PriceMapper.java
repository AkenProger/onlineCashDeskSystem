package kg.store.storeRestApi.mappers;

import kg.store.storeRestApi.models.dto.CategoryDto;
import kg.store.storeRestApi.models.dto.PriceDto;
import kg.store.storeRestApi.models.entities.Prices;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
    Prices toEntity(PriceDto dto);
    PriceDto toDto(Prices entity);

    List<PriceDto> toDtos(List<Prices> prices);


}
