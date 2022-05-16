package kg.store.storeRestApi.mappers;
import kg.store.storeRestApi.models.dto.TransactionProductDto;
import kg.store.storeRestApi.models.entities.TransactionProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface TransactionProductMapper {
    TransactionProductMapper INSTANCE = Mappers.getMapper(TransactionProductMapper.class);

    default TransactionProduct toEntity(TransactionProductDto dto) {
        TransactionProduct transactionProduct = new TransactionProduct();
        transactionProduct.setProduct(ProductMapper.INSTANCE.toEntity(dto.getProduct()));
        transactionProduct.setId(dto.getId());
        transactionProduct.setTransactions(TransactionMapper.INSTANCE.toEntity(dto.getTransaction()));
        transactionProduct.setPrice(dto.getPrice());
        transactionProduct.setProductCount(dto.getProductCount());
        return transactionProduct;
    }

    default TransactionProductDto toDto(TransactionProduct entity) {
        TransactionProductDto transactionProduct = new TransactionProductDto();
        transactionProduct.setProduct(ProductMapper.INSTANCE.toDto(entity.getProduct()));
        transactionProduct.setId(entity.getId());
        transactionProduct.setTransaction(TransactionMapper.INSTANCE.toDto(entity.getTransactions()));
        transactionProduct.setPrice(entity.getPrice());
        transactionProduct.setProductCount(entity.getProductCount());
        return transactionProduct;
    }

    List<TransactionProduct> toEntities(List<TransactionProductDto> dtos);

    default List<TransactionProductDto> toDtos(List<TransactionProduct> entities) {
        return entities.stream().map(x->{
            TransactionProductDto transactionProduct = new TransactionProductDto();
            transactionProduct.setProduct(ProductMapper.INSTANCE.toDto(x.getProduct()));
            transactionProduct.setId(x.getId());
            transactionProduct.setTransaction(TransactionMapper.INSTANCE.toDto(x.getTransactions()));
            transactionProduct.setPrice(x.getPrice());
            transactionProduct.setProductCount(x.getProductCount());
            return transactionProduct;
        }).collect(Collectors.toList());
    }
}
