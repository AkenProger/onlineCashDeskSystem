package kg.store.storeRestApi.services.impl;

import kg.store.storeRestApi.dao.TransactionsProductsRepo;
import kg.store.storeRestApi.exceptions.TransactionProductException;
import kg.store.storeRestApi.mappers.TransactionProductMapper;
import kg.store.storeRestApi.models.dto.TransactionProductDto;
import kg.store.storeRestApi.services.TransactionProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionProductServiceImpl implements TransactionProductService {
    private final TransactionProductMapper transactionProductMapper = TransactionProductMapper.INSTANCE;
    private final TransactionsProductsRepo transactionsProductsRepo;

    @Override
    public TransactionProductDto save(TransactionProductDto transactionProductDto) {
        return transactionProductMapper.toDto(transactionsProductsRepo.save(transactionProductMapper.toEntity(transactionProductDto)));
    }

    @Override
    public TransactionProductDto update(TransactionProductDto transactionProductDto) {
        if (!transactionsProductsRepo.existsById(transactionProductDto.getId())) {
            throw new TransactionProductException("Не найдена транзакция по этой id!");
        }
        return transactionProductMapper.toDto(transactionsProductsRepo.save(transactionProductMapper.toEntity(transactionProductDto)));
    }

    @Override
    public TransactionProductDto findById(Long id) {
        return transactionProductMapper.toDto(transactionsProductsRepo.findById(id)
                .orElseThrow(() -> new TransactionProductException("Не найдена транзакция по этой id !")));
    }

    @Override
    public List<TransactionProductDto> findAll() {
        return transactionProductMapper.toDtos(transactionsProductsRepo.findAll());
    }
}
