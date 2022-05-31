package kg.store.storeRestApi.controllers;

import kg.store.storeRestApi.services.CategoryService;
import kg.store.storeRestApi.models.RestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    private final CategoryService categoryService;
    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public RestResponse getAllCategories() {
        return new RestResponse(200, "success", categoryService.findAll());
    }
}
