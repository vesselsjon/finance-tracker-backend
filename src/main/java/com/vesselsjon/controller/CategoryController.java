package com.vesselsjon.controller;

import com.vesselsjon.dto.CategoryDTO;
import com.vesselsjon.entity.Category;
import com.vesselsjon.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getCategory() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category addCategory(@RequestBody @Valid CategoryDTO dto) {
        return categoryService.addCategory(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
