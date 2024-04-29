package com.example.demo.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Category {
    private int categoryId;
    private String name;
    private List<Movie> movieList;
}
