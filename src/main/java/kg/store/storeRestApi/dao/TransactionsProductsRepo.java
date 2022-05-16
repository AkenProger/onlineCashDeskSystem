package kg.store.storeRestApi.dao;
import kg.store.storeRestApi.models.entities.TransactionProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsProductsRepo extends JpaRepository<TransactionProduct, Long> {
}
