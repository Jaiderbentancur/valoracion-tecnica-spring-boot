package com.example.demo.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Movie {
    private int id;
    private String title;
    private String description;
    private int duration;
    private int score;
    private Category category;
}
