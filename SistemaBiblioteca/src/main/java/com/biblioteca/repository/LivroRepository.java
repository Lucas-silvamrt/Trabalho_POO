package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<biblioteca.Livro, Long> {}
