package com.example.demo.infrastructure.sql.JPA;

import com.example.demo.infrastructure.sql.entity.CategoryE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryE, Integer> {
    boolean existsByName(String categoryName);
    Optional<CategoryE> findByName(String categoryName);
}
