package com.example.demo.infrastructure.sql.mappers;

import com.example.demo.domain.models.Category;
import com.example.demo.domain.models.Movie;
import com.example.demo.infrastructure.sql.entity.CategoryE;
import com.example.demo.infrastructure.sql.entity.MovieE;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CategoryMapper {

    public Category map(CategoryE categoryE){
        return Category
                .builder()
                .categoryId(categoryE.getCategoryId())
                .name(categoryE.getName())
                .build();
    }

    public CategoryE map(Category category){
        return CategoryE
                .builder()
                .categoryId(category.getCategoryId())
                .name(category.getName())
                .build();
    }
}
