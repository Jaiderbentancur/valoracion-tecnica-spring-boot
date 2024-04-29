package com.example.demo.application.ports.out;

import com.example.demo.domain.models.Category;

public interface ICategoryPortOut {
    boolean existsByName(String categoryName);
    Category findByName(String categoryName);
}
