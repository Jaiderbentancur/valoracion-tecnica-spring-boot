package com.example.demo.infrastructure.web.rest;

import com.example.demo.application.ports.in.IMoviePortIn;
import com.example.demo.infrastructure.web.rest.dto.HttpResponse;
import com.example.demo.infrastructure.web.rest.dto.MovieDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final IMoviePortIn iMoviePortIn;

    @PostMapping("create")
    public ResponseEntity<HttpResponse> createMovie(@RequestBody @Valid MovieDto movieDto){
        HttpResponse responseData = HttpResponse
                .builder()
                .data(iMoviePortIn.create(movieDto))
                .message("Película creada exitosamente")
                .status(HttpStatus.OK.toString())
                .build();
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("get/{title}")
    public ResponseEntity<HttpResponse> findMovie(@PathVariable String title){
        HttpResponse responseData = HttpResponse
                .builder()
                .data(iMoviePortIn.findByTitle(title))
                .message("Película encontrada exitosamente")
                .status(HttpStatus.OK.toString())
                .build();
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("get/{page}/{size}")
    public ResponseEntity<HttpResponse> findMoviePageable(@PathVariable int page, @PathVariable int size){
        HttpResponse responseData = HttpResponse
                .builder()
                .data(iMoviePortIn.findAll(PageRequest.of(page,size)))
                .message("Película creada exitosamente")
                .status(HttpStatus.OK.toString())
                .build();
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
