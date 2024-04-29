package com.example.demo.infrastructure.sql.repo;

import com.example.demo.application.ports.out.IMoviePortOut;
import com.example.demo.domain.models.Movie;
import com.example.demo.infrastructure.exceptions.NoDataExists;
import com.example.demo.infrastructure.sql.JPA.MovieJpaRepository;
import com.example.demo.infrastructure.sql.entity.MovieE;
import com.example.demo.infrastructure.sql.mappers.CategoryMapper;
import com.example.demo.infrastructure.sql.mappers.MovieMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class MovieRepoImpl implements IMoviePortOut {
    private final MovieJpaRepository movieJpaRepository;
    private final MovieMapper movieMapper;
    private final CategoryMapper categoryMapper;

    @Override
    public Movie create(Movie movie) {
        MovieE mapToEntity = movieMapper.map(movie, categoryMapper.map(movie.getCategory()));
        return movieMapper.map(movieJpaRepository.save(mapToEntity), movie.getCategory());
    }

    @Override
    public Movie findByTitle(String title) {
        return movieJpaRepository.findByTitle(title)
                .map(movieE -> movieMapper.map(movieE, categoryMapper.map(movieE.getCategoryE())))
                .orElseThrow(() -> new NoDataExists("no existe una película por el nombre -> " + title));
    }

    @Override
    public Page<Movie> findAll(Pageable pageable) {
        return movieJpaRepository.findAll(pageable)
                .map(movieE -> movieMapper.map(movieE, categoryMapper.map(movieE.getCategoryE())));
    }
}

