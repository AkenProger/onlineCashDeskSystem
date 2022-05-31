package kg.store.storeRestApi.exceptions.services;
import kg.store.storeRestApi.models.dto.PriceDto;

public interface PriceService extends BaseCrudService<PriceDto, Long>{
    PriceDto findPriceByProductIdAndCurrentPriceBetweenSysdate(Long id);
}
