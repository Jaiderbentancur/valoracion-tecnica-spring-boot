package com.example.demo.application.ports.out;

import com.example.demo.domain.models.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface IMoviePortOut {
    Movie create(Movie movie);

    Movie findByTitle(String title);

    Page<Movie> findAll(Pageable pageable);
}
