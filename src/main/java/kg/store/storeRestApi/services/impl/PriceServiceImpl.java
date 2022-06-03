package kg.store.storeRestApi.services.impl;

import kg.store.storeRestApi.dao.PriceRepo;
import kg.store.storeRestApi.exceptions.PriceException;
import kg.store.storeRestApi.mappers.PriceMapper;
import kg.store.storeRestApi.models.dto.PriceDto;
import kg.store.storeRestApi.services.PriceService;
import org.springframework.stereotype.Service;

import java.awt.print.PrinterException;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    private final PriceRepo priceRepo;

    private final PriceMapper priceMapper = PriceMapper.INSTANCE;

    public PriceServiceImpl(PriceRepo priceRepo) {
        this.priceRepo = priceRepo;
    }

    @Override
    public PriceDto save(PriceDto priceDto) {
        return priceMapper.toDto(priceRepo.save(priceMapper.toEntity(priceDto)));
    }

    @Override
    public PriceDto update(PriceDto priceDto) {
        if (!priceRepo.existsById(priceDto.getId())) {
            throw new PriceException("Не найдена цена для этого товара!");
        }
        return priceMapper.toDto(priceRepo.save(priceMapper.toEntity(priceDto)));
    }

    @Override
    public PriceDto findById(Long id) {
        return priceMapper.toDto(priceRepo.findById(id).orElseThrow(() -> new PriceException("Не найдена цена с этой ID")));
    }

    @Override
    public List<PriceDto> findAll() {
        return priceMapper.toDtos(priceRepo.findAll());
    }
}
