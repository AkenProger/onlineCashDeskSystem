package kg.store.storeRestApi.mappers;
import kg.store.storeRestApi.models.dto.ClientDto;
import kg.store.storeRestApi.models.entities.Clients;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    default Clients toEntity(ClientDto dto) {
        Clients client = new Clients();
        client.setId(dto.getId());
        client.setName(dto.getName());
        return client;
    }

    default ClientDto toDto(Clients entity) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(entity.getId());
        clientDto.setName(entity.getName());
        return clientDto;
    }

    List<Clients> toEntities(List<ClientDto> dtos);

    default List<ClientDto> toDtos(List<Clients> entities) {
        return entities.stream().map(x->{
            ClientDto clientDto = new ClientDto();
            clientDto.setId(x.getId());
            clientDto.setName(x.getName());
            return clientDto;
        }).collect(Collectors.toList());
    }
}
