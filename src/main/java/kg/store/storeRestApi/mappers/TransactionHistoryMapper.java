package kg.store.storeRestApi.mappers;

import kg.store.storeRestApi.models.dto.PriceDto;
import kg.store.storeRestApi.models.dto.TransactionDto;
import kg.store.storeRestApi.models.dto.TransactionHistoryDto;
import kg.store.storeRestApi.models.entities.Prices;
import kg.store.storeRestApi.models.entities.TransactionHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransactionHistoryMapper {
    TransactionHistoryMapper TRANSACTION_HISTORY_MAPPER = Mappers.getMapper(TransactionHistoryMapper.class);

    TransactionHistory toEntity(TransactionHistoryDto transactionHistoryDto);
    TransactionHistoryDto toDto(TransactionHistory transactionHistory);

    List<TransactionHistoryDto> toDtos(List<TransactionHistory> transactionHistories);
}
