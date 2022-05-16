package kg.store.storeRestApi.models.entities;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name = "clients")
public class Clients {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String accountNum;
}
