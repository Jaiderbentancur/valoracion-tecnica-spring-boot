package com.example.demo.application.services;

import com.example.demo.application.ports.in.IMoviePortIn;
import com.example.demo.application.ports.out.ICategoryPortOut;
import com.example.demo.application.ports.out.IMoviePortOut;
import com.example.demo.domain.models.Category;
import com.example.demo.domain.models.Movie;
import com.example.demo.infrastructure.sql.mappers.MovieMapper;
import com.example.demo.infrastructure.web.rest.dto.MovieDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService implements IMoviePortIn {
    private final IMoviePortOut moviePortOut;
    private final ICategoryPortOut categoryPortOut;
    private final MovieMapper movieMapper;

    @Override
    public Movie create(MovieDto movieDto) {
        Category category = categoryPortOut.findByName(movieDto.getCategoryName());
        Movie mappedMovie = movieMapper.map(movieDto, category);
        return moviePortOut.create(mappedMovie);
    }

    @Override
    public Movie findByTitle(String title) {
        return moviePortOut.findByTitle(title);
    }

    @Override
    public Page<Movie> findAll(Pageable pageable) {
        if (pageable.getPageNumber() == 0)
            throw new IllegalArgumentException("El número de la página es invalida");
        if (pageable.getPageSize() == 0)
            throw new IllegalArgumentException("El tamaño de la página es invalida");

        return moviePortOut.findAll(pageable);
    }
}
