package com.example.demo.application.ports.in;

import com.example.demo.domain.models.Movie;
import com.example.demo.infrastructure.web.rest.dto.MovieDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface IMoviePortIn {
    Movie create(MovieDto movieDto);
    Movie findByTitle(String title);

    Page<Movie> findAll(Pageable pageable);
}
