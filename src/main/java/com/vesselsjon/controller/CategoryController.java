package com.vesselsjon.controller;

import com.vesselsjon.dto.CategoryDTO;
import com.vesselsjon.entity.Category;
import com.vesselsjon.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getCategory() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category addCategory(@RequestBody CategoryDTO dto) {
        return categoryService.addCategory(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
