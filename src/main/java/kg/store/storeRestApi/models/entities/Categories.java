package kg.store.storeRestApi.models.entities;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name = "categories")
public class Categories {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
