package kg.store.storeRestApi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transactions_product")
public class TransactionProduct {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transactions transactions;
    @ManyToOne
    @JoinColumn(name = "join_column")
    private Product product;
    private double price;
    private int productCount;
}
