package kg.store.storeRestApi.models.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PriceDto {
    private Long id;
    private double price;
    private ProductDto product;
    private LocalDate startDate;
    private LocalDate endDate;
}
