package kg.store.storeRestApi.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionHistoryDto {
    private Long id;
    private double moneyPaid;
    private TransactionDto transaction;
    private double excess;
    private double debt;
    private LocalDateTime addDate;
}
