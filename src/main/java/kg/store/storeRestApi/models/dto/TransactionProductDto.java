package kg.store.storeRestApi.models.dto;

import lombok.Data;

@Data
public class TransactionProductDto {
    private Long id;
    private TransactionDto transaction;
    private ProductDto product;
    private double price;
    private int productCount;
}
