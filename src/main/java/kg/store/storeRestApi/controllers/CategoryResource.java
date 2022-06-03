package kg.store.storeRestApi.controllers;

import io.swagger.annotations.ApiOperation;
import kg.store.storeRestApi.models.dto.CategoryDto;
import kg.store.storeRestApi.services.CategoryService;
import kg.store.storeRestApi.models.RestResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryResource {
    private final CategoryService categoryService;

    @PostMapping("/create")
    public RestResponse creatCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.save(categoryDto);
        return category != null ?
                new RestResponse(200, "Категория создана!", category) :
                new RestResponse(400, "Не успешно!", null);
    }

    @PostMapping("/update")
    public RestResponse updateCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto categoryToUpdate = categoryService.update(categoryDto);
        return categoryToUpdate != null ?
                new RestResponse(200, "Категория изменена", categoryToUpdate) :
                new RestResponse(400, "Не успешное изменения", null);
    }

    @GetMapping(value = "/findById/{id}")
    public RestResponse findCategoryById(@PathVariable Long id) {
        CategoryDto categoryToUpdate = categoryService.findById(id);
        return categoryToUpdate != null ? new RestResponse(200, "Найдено", categoryToUpdate) :
                new RestResponse(400, "Не найдено!", null);
    }

    @GetMapping("/findAll")
    public RestResponse getAllCategories() {
        return new RestResponse(200, "Все категории", categoryService.findAll());
    }
}
