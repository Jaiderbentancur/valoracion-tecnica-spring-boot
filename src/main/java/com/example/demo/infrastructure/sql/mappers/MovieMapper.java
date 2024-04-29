package com.example.demo.infrastructure.sql.mappers;

import com.example.demo.domain.models.Category;
import com.example.demo.domain.models.Movie;
import com.example.demo.infrastructure.sql.entity.CategoryE;
import com.example.demo.infrastructure.sql.entity.MovieE;
import com.example.demo.infrastructure.web.rest.dto.MovieDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MovieMapper {
    public Movie map(MovieE movieE, Category category){
        return Movie.builder()
                .id(movieE.getId())
                .title(movieE.getTitle())
                .description(movieE.getDescription())
                .duration(movieE.getDuration())
                .score(movieE.getScore())
                .category(category)
                .build();
    }

    public MovieE map(Movie movie, CategoryE categoryE){
        return MovieE.builder()
                .title(movie.getTitle())
                .description(movie.getDescription())
                .duration(movie.getDuration())
                .score(movie.getScore())
                .categoryE(categoryE)
                .build();
    }

    public Movie map(MovieDto movieDto, Category category){
        return Movie.builder()
                .title(movieDto.getTitle())
                .description(movieDto.getDescription())
                .duration(movieDto.getDuration())
                .score(movieDto.getScore())
                .category(category)
                .build();
    }
}
