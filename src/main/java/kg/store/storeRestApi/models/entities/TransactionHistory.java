package kg.store.storeRestApi.models.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "transaction_history")
public class TransactionHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double moneyPaid;
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transactions transactions;
    private double excess;
    private double debt;
    @CreationTimestamp
    private LocalDate addDate;

}
