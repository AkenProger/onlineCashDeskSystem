package kg.store.storeRestApi.dao;

import kg.store.storeRestApi.models.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Prices, Long> {
    @Query(value = "SELECT * FROM prices p WHERE p.products_id = ?1 and CURRENT_TIMESTAMP BETWEEN p.start_date and p.end_date",nativeQuery = true)
    Prices findPriceByProductIdAndCurrentPriceBetweenSysdate(Long id);
}
