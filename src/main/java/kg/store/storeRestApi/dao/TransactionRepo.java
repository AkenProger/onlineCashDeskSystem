package kg.store.storeRestApi.dao;
import kg.store.storeRestApi.models.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transactions, Long> {
}
