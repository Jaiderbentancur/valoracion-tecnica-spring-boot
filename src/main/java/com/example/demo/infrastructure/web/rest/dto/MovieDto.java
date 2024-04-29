package com.example.demo.infrastructure.web.rest.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieDto {
    @NotBlank(message = "el titulo no puede estar vacío")
    @Size(min = 1, message = "el titulo debe de ser mayor a 1 caracteres")
    @Size(max = 100, message = "el titulo debe de ser menor a 100 caracteres}")
    private String title;

    @Size(min = 1, message = "la descripción debe de ser mayor a 1 caracteres")
    @Size(max = 200, message = "la descripción debe de ser menor a 200 caracteres}")
    private String description;

    @NotNull(message = "la duración no puede estar vacía")
    private int duration;

    @Max(value = 5)
    @Min(value = 1)
    private int score;

    @NotBlank(message = "la categoría es requerida")
    private String categoryName;
}
