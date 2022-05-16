package kg.store.storeRestApi.models.dto;
import kg.store.storeRestApi.models.entities.TransactStatus;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionDto {
    private Long id;
    private double totalPrice;
    private TransactStatus  transactStatus;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private ClientDto clientDto;
}
