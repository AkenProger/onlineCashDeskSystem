package kg.store.storeRestApi.exceptions.services.impl;

import kg.store.storeRestApi.dao.ProductRepo;
import kg.store.storeRestApi.exceptions.ProductException;
import kg.store.storeRestApi.exceptions.services.ProductService;
import kg.store.storeRestApi.mappers.ProductMapper;
import kg.store.storeRestApi.models.dto.ProductDto;
import kg.store.storeRestApi.exceptions.services.CategoryService;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper = ProductMapper.INSTANCE;
    private final ProductRepo productRepo;
    private CategoryService categoryService;

    public ProductServiceImpl(ProductRepo productRepo, CategoryService categoryService) {
        this.productRepo = productRepo;
        this.categoryService = categoryService;
    }

    private final Logger logger = Logger.getLogger(ProductServiceImpl.class);


    @Override
    public ProductDto save(ProductDto productDto) {
        productDto.setCategory(categoryService.findById(productDto.getId()));
        return productMapper.toDto(productRepo.save(productMapper.toEntity(productDto)));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        if (productRepo.existsById(productDto.getId())) {
            throw  new ProductException("Не найднен товар с id {}");
        }
        logger.info("Обновился товар по productDto{}");
        return productMapper.toDto(productRepo.save(productMapper.toEntity(productDto)));
    }

    @Override
    public ProductDto findById(Long id) {
        logger.info("Входящий id d{}");
        return productMapper.toDto(productRepo.findById(id).orElseThrow(()-> new ProductException("Не найден товар с id {}")));
    }

    @Override
    public List<ProductDto> findAll() {
        return productMapper.toDtos(productRepo.findAll());
    }
}
