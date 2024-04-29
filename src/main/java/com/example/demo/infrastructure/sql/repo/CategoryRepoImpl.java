package com.example.demo.infrastructure.sql.repo;

import com.example.demo.application.ports.out.ICategoryPortOut;
import com.example.demo.domain.models.Category;
import com.example.demo.domain.models.Movie;
import com.example.demo.infrastructure.exceptions.NoDataExists;
import com.example.demo.infrastructure.sql.JPA.CategoryJpaRepository;
import com.example.demo.infrastructure.sql.mappers.CategoryMapper;
import com.example.demo.infrastructure.sql.mappers.MovieMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CategoryRepoImpl implements ICategoryPortOut {
    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryMapper categoryMapper;
    private final MovieMapper movieMapper;

    @Override
    public boolean existsByName(String categoryName) {
        return categoryJpaRepository.existsByName(categoryName);
    }

    @Override
    public Category findByName(String categoryName) {
        return categoryJpaRepository.findByName(categoryName)
                .map(categoryE -> {
                    Category mappedCategory = categoryMapper.map(categoryE);
                    List<Movie> mappedMovies = categoryE.getMovieEList()
                            .stream()
                            .map(movieE -> movieMapper.map(movieE, categoryMapper.map(movieE.getCategoryE())))
                            .toList();
                    mappedCategory.setMovieList(mappedMovies);
                    return mappedCategory;
                })
                .orElseThrow(() -> new NoDataExists("no existe la categoría -> " + categoryName));
    }
}
