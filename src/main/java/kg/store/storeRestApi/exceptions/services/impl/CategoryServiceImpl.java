package kg.store.storeRestApi.exceptions.services.impl;

import kg.store.storeRestApi.dao.CategoryRepo;
import kg.store.storeRestApi.exceptions.CategoriesException;
import kg.store.storeRestApi.exceptions.services.CategoryService;
import kg.store.storeRestApi.mappers.CategoryMapper;
import kg.store.storeRestApi.models.dto.CategoryDto;
import lombok.AllArgsConstructor;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    private final Logger logger = Logger.getLogger(CategoryServiceImpl.class);
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        logger.info("Сохранено categoryDto{} новая категория");
        return categoryMapper.toDto(categoryRepo.save(categoryMapper.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        if (categoryRepo.existsById(categoryDto.getId())) {
            throw new CategoriesException("Категория не найдена!");
        }
        logger.info("Изменена категория");
        return categoryMapper.toDto(categoryRepo.save(categoryMapper.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(Long id) {
        return categoryMapper.toDto(categoryRepo.findById(id)
                .orElseThrow(() -> new CategoriesException("Не найден катеория с id {}")));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryMapper.toDtos(categoryRepo.findAll());
    }
}
