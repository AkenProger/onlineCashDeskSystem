package kg.store.storeRestApi.mappers;
import kg.store.storeRestApi.models.dto.TransactionDto;
import kg.store.storeRestApi.models.entities.Transactions;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    default Transactions toEntity(TransactionDto dto) {
        Transactions transaction = new Transactions();
        transaction.setId(dto.getId());
        transaction.setClients(ClientMapper.INSTANCE.toEntity(dto.getClientDto()));
        transaction.setTotalPrice(dto.getTotalPrice());
        transaction.setTransactStatus(dto.getTransactStatus());
        transaction.setStartDate(dto.getStartDate());
        transaction.setEndDate(dto.getEndDate());
        transaction.setTotalPrice(dto.getTotalPrice());
        return transaction;
    }

    default TransactionDto toDto(Transactions entity) {
        TransactionDto transaction = new TransactionDto();
        transaction.setId(entity.getId());
        transaction.setClientDto(ClientMapper.INSTANCE.toDto(entity.getClients()));
        transaction.setTotalPrice(entity.getTotalPrice());
        transaction.setTransactStatus(entity.getTransactStatus());
        transaction.setStartDate(entity.getStartDate());
        transaction.setEndDate(entity.getEndDate());
        return transaction;
    }

    List<Transactions> toEntities(List<TransactionDto> dtos);

    default List<TransactionDto> toDtos(List<Transactions> entities) {
        return entities.stream().map(x->{
            TransactionDto transaction = new TransactionDto();
            transaction.setId(x.getId());
            transaction.setClientDto(ClientMapper.INSTANCE.toDto(x.getClients()));
            transaction.setTotalPrice(x.getTotalPrice());
            transaction.setTransactStatus(x.getTransactStatus());
            transaction.setStartDate(x.getStartDate());
            transaction.setEndDate(x.getEndDate());
            return transaction;
        }).collect(Collectors.toList());
    }
}
