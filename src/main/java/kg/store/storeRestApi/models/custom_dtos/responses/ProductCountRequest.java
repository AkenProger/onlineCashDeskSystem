package kg.store.storeRestApi.models.custom_dtos.responses;

import lombok.Data;

@Data
public class ProductCountRequest {
    private Long productId;
    private int count;
}
