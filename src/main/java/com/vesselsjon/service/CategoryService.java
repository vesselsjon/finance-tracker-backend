package com.vesselsjon.service;

import com.vesselsjon.dto.CategoryDTO;
import com.vesselsjon.entity.Category;
import com.vesselsjon.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category addCategory(CategoryDTO dto) {
        Category category = Category.builder()
                .name(dto.getName())
                .budgetLimit(dto.getBudgetLimit())
                .description(dto.getDescription())
                .build();

        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
