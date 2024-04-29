package com.example.demo.infrastructure.sql.JPA;

import com.example.demo.infrastructure.sql.entity.MovieE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieJpaRepository extends JpaRepository<MovieE, Integer> {
    Optional<MovieE> findByTitle(String title);
}
