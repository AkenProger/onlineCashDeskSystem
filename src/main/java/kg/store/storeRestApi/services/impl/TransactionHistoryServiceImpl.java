package kg.store.storeRestApi.services.impl;

import kg.store.storeRestApi.dao.TransactionHistoryRepo;
import kg.store.storeRestApi.exceptions.HistoryException;
import kg.store.storeRestApi.mappers.TransactionHistoryMapper;
import kg.store.storeRestApi.models.dto.TransactionHistoryDto;
import kg.store.storeRestApi.services.TransactionHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionHistoryServiceImpl implements TransactionHistoryService {
    private final TransactionHistoryRepo historyRepo;
    private final TransactionHistoryMapper transactionHistoryMapper = TransactionHistoryMapper.TRANSACTION_HISTORY_MAPPER;

    @Override
    public TransactionHistoryDto save(TransactionHistoryDto transactionHistoryDto) {
        return transactionHistoryMapper.toDto(historyRepo.save(transactionHistoryMapper.toEntity(transactionHistoryDto)));
    }

    @Override
    public TransactionHistoryDto update(TransactionHistoryDto transactionHistoryDto) {
        if (!historyRepo.existsById(transactionHistoryDto.getId())) {
            throw new HistoryException("История не найдена по этой id!");
        }
        return transactionHistoryMapper.toDto(historyRepo.save(transactionHistoryMapper.toEntity(transactionHistoryDto)));
    }

    @Override
    public TransactionHistoryDto findById(Long id) {
        return transactionHistoryMapper.toDto(historyRepo.findById(id).orElseThrow(() ->
                new HistoryException("Не найдена история по этой ID")));
    }

    @Override
    public List<TransactionHistoryDto> findAll() {
        return transactionHistoryMapper.toDtos(historyRepo.findAll());
    }
}
