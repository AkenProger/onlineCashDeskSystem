package kg.store.storeRestApi.services;
import kg.store.storeRestApi.models.custom_dtos.ProductCountRequest;
import kg.store.storeRestApi.models.custom_dtos.TransactionResponse;
import kg.store.storeRestApi.models.custom_dtos.TransactionResponseWithDebt;
import kg.store.storeRestApi.models.dto.TransactionDto;

import java.util.List;

public interface TransactionService extends BaseCrudService<TransactionDto, Long>{
    double priceCounter(int count, double price);
    TransactionResponse doTransaction(List<ProductCountRequest> productsList, Long id);
    TransactionResponseWithDebt pay(Long transaction_id, double money);
}
