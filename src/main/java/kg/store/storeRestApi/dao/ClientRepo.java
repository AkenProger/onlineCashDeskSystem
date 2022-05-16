package kg.store.storeRestApi.dao;

import kg.store.storeRestApi.models.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Clients, Long> {
}
